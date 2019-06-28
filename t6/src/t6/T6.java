/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t6;

import com.opencsv.CSVReaderHeaderAware;
import com.sun.rowset.internal.Row;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.DataFormat.URL;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T6 extends Application {
    List<String[]> lista;
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        FlowPane flowPane = new FlowPane(Orientation.VERTICAL);
        flowPane.setAlignment(Pos.TOP_LEFT);

        primaryStage.setScene(new Scene(flowPane));
        primaryStage.show();
        
        Menu menu1 = new Menu("File");
        MenuItem menuItem[] = { 
            new MenuItem("Reload"),
            new MenuItem("Source"),
            new MenuItem("Exit")};
        menu1.getItems().addAll(menuItem);
        Menu menu2 = new Menu("Options");
        Menu menu3 = new Menu("Help");
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu1, menu2, menu3);
        
        //Table View
        Label label = new Label("TableView Example");
        TableView table = new TableView();
        carregaTabela(table);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(label, table, menuBar);
        flowPane.getChildren().add(menuBar);
        flowPane.getChildren().add(vbox);
       // primaryStage.setScene(new Scene(vbox,180,400));
        //primaryStage.show();
        
        //Eventos
        //Clique na linha da tabela
        table.setRowFactory(tv -> {
            TableRow<Questao> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                table.getSelectionModel().focus(14);
                String dados[] = lista.get(table.getSelectionModel().getFocusedIndex());
                try {
                    abreTelaInfos(primaryStage, new Questao(dados[1],dados[2],dados[3],dados[4],dados[5],dados[8],dados[9],dados[10],dados[11],dados[7],dados[13],dados[17])); 
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(T6.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(T6.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            return row ;
        });
        
        //MenusItem
        menuItem[0].setOnAction(new EventHandler<ActionEvent>() { //Reload
            @Override
            public void handle(ActionEvent event) {
                try {
                    downloadTabela(table);
                    carregaTabela(table);
                } catch (IOException ex) {
                    Logger.getLogger(T6.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        menuItem[1].setOnAction(new EventHandler<ActionEvent>() { //Source
            @Override
            public void handle(ActionEvent event) {
                System.out.println("cheguei");
            }
        });
        menuItem[2].setOnAction(new EventHandler<ActionEvent>() { //Exit
            @Override
            public void handle(ActionEvent event) {
                System.out.println("cheguei");
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
    
    private void abreTelaInfos(Stage primaryStage, Questao questao) throws FileNotFoundException, MalformedURLException, IOException {
        FlowPane flowPaneGeral = new FlowPane(Orientation.HORIZONTAL);
        FlowPane flowPane = new FlowPane(Orientation.VERTICAL); 
        flowPaneGeral.getChildren().add(flowPane);
        Label label[] = {
            new Label("Ano:"),
            new Label(questao.getAno().getValue()),
            new Label("Prova:"),
            new Label(questao.getProva().getValue()),
            new Label("Tipo Questão:"),
            new Label(questao.getTipoquestao().getValue()),
            new Label("Id Questão:"),
            new Label(questao.getIdquestao().getValue()),
            new Label("Objeto:"),
            new Label(questao.getObjeto().getValue()),
            new Label("Acertos Curso:"),
            new Label(questao.getAcertoscurso().getValue()),
            new Label("Acertos Região:"),
            new Label(questao.getAcertosregiao().getValue()),
            new Label("Acertos Brasil:"),
            new Label(questao.getAcertosbrasil().getValue()),
            new Label("Acertos Dif. (Curso-Brasil):"),
            new Label(questao.getAcertosdif().getValue()),
            new Label("Gabarito:"),
            new Label(questao.getGabarito().getValue()),
        };
        flowPane.getChildren().addAll(label);
  
        if(!questao.getUrlcop().equals("")){ 
            File file = new File("C:\\Users\\danie\\Desktop\\UFSM\\t6\\src\\imagens\\"+questao.getIdquestao().getValue()+questao.getAno().getValue()+".jpg");
            if(!file.exists()){ //se o arquivo não existir, faz o download
                InputStream in = new URL(questao.getUrlcop()).openStream();
                Files.copy(in, Paths.get(file.getPath()), StandardCopyOption.REPLACE_EXISTING);
            }
            
            Image image = new Image(new FileInputStream(file));
            flowPaneGeral.getChildren().add(new ImageView(image));
        }else{
            flowPaneGeral.getChildren().add(new Label("Não há imagem."));
        }
        
        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Informações");
        newWindow.setScene(new Scene(flowPaneGeral));

        // Set position of second window, related to primary window.
        newWindow.setX(primaryStage.getX() + 200);
        newWindow.setY(primaryStage.getY() + 100);

        newWindow.show();
    }
    
    private void carregaTabela(TableView table) throws FileNotFoundException, IOException{
        TableColumn[] tableColumns = {
            new TableColumn("Ano"),
            new TableColumn("Prova"),
            new TableColumn("Tipo Questão"),
            new TableColumn("ID Questão"),
            new TableColumn("Objeto"),
            new TableColumn("Acertos Curso"),
            new TableColumn("Acertos Região"),
            new TableColumn("Acertos Brasil"),
            new TableColumn("Dif. (Curso-Brasil)"),
        };
        table.getColumns().addAll(Arrays.asList(tableColumns));
        File file = new File("C:\\Users\\danie\\Desktop\\UFSM\\t6\\src\\t6\\enade.csv");
        if(!file.exists()){
            downloadTabela(table);
        }
        this.lista = new CSVReaderHeaderAware(new FileReader(file)).readAll();
        ObservableList<Questao> data= FXCollections.observableArrayList();
        for (String[] dados : lista) {
            data.add(new Questao(dados[1],dados[2],dados[3],dados[4],dados[5],dados[8],dados[9],dados[10],dados[11]));
        }
        //String ano, String prova, String tipoquestao, String idquestao, String objeto, String acertoscurso, String acertosregiao, String acertosbrasil, String acertosdif
        // curso,ano,prova,tipoquestao,idquestao,objeto,objetodetalhado,gabarito,acertoscurso,acertosregiao,acertosbrasil,acertosdif,texto,imagem,urlprova,urlsintese,urlcurso,urlcrop
        //  1    2    3      4          5         6          7            8         9           10             11              12     13     14       15      16       17        18
        tableColumns[0].setCellValueFactory(new PropertyValueFactory("ano"));
        tableColumns[1].setCellValueFactory(new PropertyValueFactory("prova"));
        tableColumns[2].setCellValueFactory(new PropertyValueFactory("tipoquestao"));
        tableColumns[3].setCellValueFactory(new PropertyValueFactory("idquestao"));
        tableColumns[4].setCellValueFactory(new PropertyValueFactory("objeto"));
        tableColumns[5].setCellValueFactory(new PropertyValueFactory("acertoscurso"));
        tableColumns[6].setCellValueFactory(new PropertyValueFactory("acertosregiao"));
        tableColumns[7].setCellValueFactory(new PropertyValueFactory("acertosbrasil"));
        tableColumns[8].setCellValueFactory(new PropertyValueFactory("acertosdif"));
        table.setItems(data);   
    }
    private void downloadTabela(TableView table) throws MalformedURLException, IOException{
        String url = "https://docs.google.com/spreadsheets/d/e/2PACX-1vTO06Jdr3J1kPYoTPRkdUaq8XuslvSD5--FPMht-ilVBT1gExJXDPTiX0P3FsrxV5VKUZJrIUtH1wvN/pub?gid=0&single=true&output=csv";
        InputStream in = new URL(url).openStream();
        String pathArquivo = "C:\\Users\\danie\\Desktop\\UFSM\\t6\\src\\t6\\enade.csv";
        File file = new File(pathArquivo);
        if(file.exists()){
            System.out.println("deletar");
            file.delete();
        }
        Files.copy(in, Paths.get(pathArquivo), StandardCopyOption.REPLACE_EXISTING);
    }
}