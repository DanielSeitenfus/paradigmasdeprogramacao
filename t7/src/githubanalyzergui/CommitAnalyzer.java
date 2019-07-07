package githubanalyzergui;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class CommitAnalyzer extends javax.swing.JFrame {
    ArrayList<Commit> listaCommits;
    public CommitAnalyzer(ArrayList<Repositorio> listaRepositorios) {
        initComponents();
        listaCommits = new ArrayList<>();
        Thread thread = new Thread(() -> {
            try {
                buscaCommits();
                int contPalavras=0;
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                for(Commit commit : listaCommits){
                    model.addRow(new Object[]{commit.author,commit.message,commit.date});
                    contPalavras+=commit.message.length();
                }
                //jLQntCommits.setText("Quantidade de commits: "+listaCommits.size());
                //jLQntCommits.setText("Tamnho médio das mensagens: "+contPalavras/listaCommits.size());
                jLabel1.setText("");
            } catch (IOException ex) {
                Logger.getLogger(CommitAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        thread.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTRepositorios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Author", "Message", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Carregando dados...");

        jTRepositorios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Repositorio", "Quantidade de commits", "Tam. médio das mensagens"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTRepositorios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void buscaCommits() throws MalformedURLException, IOException {

        //String urlstr = "https://api.github.com/repos/google/gson/commits?page=2";
        String urlstr = "https://api.github.com/repos/google/gson/commits";
        /*
        if (args.length >= 1) {
            urlstr = args[0];
        }
         */
        int page=1;
        urlstr = "https://api.github.com/repos/DanielSeitenfus/paradigmasdeprogramacao/commits?page="+page;

        URL url = new URL(urlstr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        System.out.println("Response code: " + con.getResponseCode());

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        // Response header (includes pagination links)
        System.out.println(con.getHeaderFields().get("Link").get(0));

        // Parse a nested JSON response using Gson
        JsonParser parser = new JsonParser();
        JsonArray results = parser.parse(in.readLine()).getAsJsonArray();
        //System.out.println("Size: " + results.size());
        Gson gson = new GsonBuilder().create();
        
        for (JsonElement e : results) {
            String message=gson.toJson(e.getAsJsonObject().get("commit").getAsJsonObject().get("message"));
            String date=gson.toJson(e.getAsJsonObject().get("commit").getAsJsonObject().get("date"));
            String author=gson.toJson(e.getAsJsonObject().get("commit").getAsJsonObject().get("author"));
            System.out.println(message);
            Commit commit = new Commit(message, date, author);
            listaCommits.add(commit);
        }  
        in.close();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTRepositorios;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
