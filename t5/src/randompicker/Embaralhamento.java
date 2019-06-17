/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randompicker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author danie
 */
public class Embaralhamento {
    ArrayList<String> listaNomes;
    int i=0;
    public Embaralhamento() {
    }
    
    void random (String nomes) throws IOException{
        if(!nomes.equals("")){
            Embaralhamento e = new Embaralhamento();
            String[] vetNomes = nomes.split("\n");
            List lista =Arrays.asList(vetNomes);
            listaNomes = new ArrayList<>(lista);
        }
        
        if(listaNomes.size()<5){

      String urlstr = "https://www.random.org/lists/?mode=advanced";
      URL url = new URL(urlstr);
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("POST");
      con.setRequestProperty("User-Agent", "Mozilla/5.0");
      con.setDoOutput(true);
      
      String data="list="+listaNomes.get(0)+"%0D%0A";
      for(int i=1; i<listaNomes.size()-1; i++){
         data+=listaNomes.get(i)+"%0D%0A";
      }
      data+=listaNomes.get(listaNomes.size()-1)+"&format=plain&rnd=new";
      
      // Envia dados pela conexão aberta
      con.getOutputStream().write(data.getBytes("UTF-8"));
      System.out.println("Response code: " + con.getResponseCode());

      // Cria objeto que fará leitura da resposta pela conexão aberta
      BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));

        // Lê resposta, linha por linha
      String responseLine;
      int i=0;
      while ((responseLine = in.readLine()) != null) {
        listaNomes.set(i, responseLine);
        i++;
      }

      in.close();
        }else{
            Collections.shuffle(listaNomes);
        }
    }
    
    void leArquivo(File file) throws FileNotFoundException, IOException{
        listaNomes = new ArrayList<>();
        BufferedReader buff = new BufferedReader(new FileReader(file));
        String linha;
        while ((linha = buff.readLine()) != null) {
             listaNomes.add(linha);
        }
    }
    
    String next(){
        String nome=listaNomes.get(i);
        if(listaNomes.size()-1!=i){
            i++;
        }else{
            i=0;
        }
        return nome;
    }

    public ArrayList<String> getListaNomes() {
        return listaNomes;
    }

    public void setListaNomes(ArrayList<String> listaNomes) {
        this.listaNomes = listaNomes;
    }
    
    
}
