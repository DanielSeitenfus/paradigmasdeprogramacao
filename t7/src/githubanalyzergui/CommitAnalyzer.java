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
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class CommitAnalyzer extends javax.swing.JFrame {
    ArrayList<Repositorio> listaRepositorios;
    public CommitAnalyzer(ArrayList<Repositorio> listaRepositorios) {
        this.listaRepositorios = listaRepositorios;
        initComponents();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Thread thread = new Thread(() -> {
            try {
                DefaultTableModel model = (DefaultTableModel) jTRepositorios.getModel();
                for(Repositorio repositorio : listaRepositorios){
                    buscaCommits(repositorio);
                    int contPalavras=0;
                    for(Commit commit : repositorio.getListaCommits()){
                        //model.addRow(new Object[]{commit.getAuthor(), commit.getMessage(), commit.getDate()});
                        contPalavras+=commit.getMessage().length();
                    }
                    model.addRow(new Object[]{repositorio.getName()+"/"+repositorio.getUrl(),""+repositorio.getListaCommits().size(),""+contPalavras/repositorio.getListaCommits().size()});;
                    jLabel1.setText("");
                }
                
            } catch (IOException ex) {
                Logger.getLogger(CommitAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        thread.start();
        
        jTRepositorios.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setNumRows(0);
            Repositorio repositorio = listaRepositorios.get(jTRepositorios.getSelectedRow());
            for(Commit commit : repositorio.getListaCommits()){
                model.addRow(new Object[]{commit.getAuthor(), commit.getMessage(), commit.getDate()});
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTRepositorios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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

        jLabel1.setText("Aguarde um momento... Os dados estão sendo carregados!");

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

        jLabel2.setText("Repositórios");

        jLabel3.setText("Commits");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void buscaCommits(Repositorio repositorio) throws MalformedURLException, IOException {
        int page=1;
        BufferedReader in;
        boolean busca;;
        do{
            String urlstr = repositorio.getUrl()+"/commits?page="+page;
            page++;
            URL url = new URL(urlstr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            System.out.println("Response code: " + con.getResponseCode());

            in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            // Response header (includes pagination links)
           System.out.println(con.getHeaderFields().get("Link").get(0));

            // Parse a nested JSON response using Gson
            JsonParser parser = new JsonParser();
            JsonArray results = parser.parse(in.readLine()).getAsJsonArray();
            //System.out.println("Size: " + results.size());
            Gson gson = new GsonBuilder().create();
            busca = false;
            for (JsonElement e : results) {
                busca=true;
                String message=gson.toJson(e.getAsJsonObject().get("commit").getAsJsonObject().get("message"));
                String date=gson.toJson(e.getAsJsonObject().get("commit").getAsJsonObject().get("author").getAsJsonObject().get("date"));
                String author=gson.toJson(e.getAsJsonObject().get("commit").getAsJsonObject().get("author").getAsJsonObject().get("name"));
                //System.out.println(message);
                Commit commit = new Commit(message, date, author);
                repositorio.getListaCommits().add(commit);
            }  
        }while(busca);
        in.close();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTRepositorios;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
