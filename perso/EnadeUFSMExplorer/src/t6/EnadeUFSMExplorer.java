/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t6;

import com.opencsv.CSVReaderHeaderAware;
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
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EnadeUFSMExplorer extends Application {

    String url = "https://docs.google.com/spreadsheets/d/e/2PACX-1vTO06Jdr3J1kPYoTPRkdUaq8XuslvSD5--FPMht-ilVBT1gExJXDPTiX0P3FsrxV5VKUZJrIUtH1wvN/pub?gid=0&single=true&output=csv";
    List<String[]> lista;

    @Override
    public void start(Stage primaryStage) {
        FlowPane flowPane = new FlowPane(Orientation.VERTICAL);
        FlowPane flowPaneFiltros = new FlowPane(Orientation.HORIZONTAL);
        flowPane.setAlignment(Pos.TOP_LEFT);
        flowPane.setAlignment(Pos.TOP_CENTER);
        flowPaneFiltros.setPadding(new Insets(10, 10, 10, 10));
        
        primaryStage.setScene(new Scene(flowPane));
        primaryStage.setHeight(590);
        primaryStage.setWidth(760);
        primaryStage.show();

        ObservableList<String> options
                = FXCollections.observableArrayList(
                        "Todos",
                        "2017",
                        "2014",
                        "2011",
                        "2008",
                        "2005"
                );
        final ComboBox ano = new ComboBox(options);
        ano.setPromptText("Ano");

        ObservableList<String> options2
                = FXCollections.observableArrayList(
                        "Todos",
                        "Geral",
                        "Específica"
                );
        final ComboBox prova = new ComboBox(options2);
        prova.setPromptText("Prova");

        ObservableList<String> options3
                = FXCollections.observableArrayList(
                        "Todos",
                        "Objetiva",
                        "Discursiva"
                );
        final ComboBox tipoQuestao = new ComboBox(options3);
        tipoQuestao.setPromptText("Tipo Questão");
        Button botaoFiltro = new Button("Filtrar");
        flowPaneFiltros.getChildren().addAll(ano, prova, tipoQuestao);
        Menu menu1 = new Menu("File");
        MenuItem menuItem[] = {
            new MenuItem("Reload"),
            new MenuItem("Source"),
            new MenuItem("Download files"),
            new MenuItem("Exit")};
        menu1.getItems().addAll(menuItem);
        Menu menu2 = new Menu("Help");
        MenuItem menuItemAbout = new MenuItem("About");
        menu2.getItems().add(menuItemAbout);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu1, menu2);

        //Table View
        Label label = new Label("EnadeUFSMExplorer");
        TableView table = new TableView();
        carregaTabela(table, false, null, null, null);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(label, table, menuBar);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        flowPane.getChildren().add(menuBar);
        flowPane.getChildren().addAll(flowPaneFiltros, botaoFiltro);
        flowPane.getChildren().add(vbox);
       

        //Eventos
        //Clique na linha da tabela
        table.setRowFactory(tv -> {
            TableRow<Questao> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                String dados[] = lista.get(table.getSelectionModel().getFocusedIndex());
                abreTelaInfos(primaryStage, new Questao(dados[1], dados[2], dados[3], dados[4], dados[5], dados[8], dados[9], dados[10], dados[11], dados[7], dados[13], dados[17]));
            });
            return row;
        });

        //MenusItem
        menuItem[0].setOnAction((ActionEvent event) -> { //Reload
            downloadTabela();
            carregaTabela(table, true, null, null, null);
        });
        menuItem[1].setOnAction((ActionEvent event) -> { //Source
            alteraUrl();
        });
        menuItem[2].setOnAction((ActionEvent event) -> { //Exit
            downloadFiles();
        });
        menuItem[3].setOnAction((ActionEvent event) -> { //Exit
            System.exit(0);
        });
        menuItemAbout.setOnAction(((event) -> { //About
            new Alert(Alert.AlertType.INFORMATION, "EnadeUFSMExplorer\nDesenvolvido por: Daniel Seitenfus").show();
        }));
        botaoFiltro.setOnAction((event) -> {
            carregaTabela(table, true, (String) ano.valueProperty().getValue(), (String) prova.valueProperty().getValue(), (String) tipoQuestao.valueProperty().getValue());
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void alteraUrl() {
        FlowPane flowPane = new FlowPane(Orientation.VERTICAL);
        Label label = new Label("URL para download da planílha: ");
        TextField tfUrl = new TextField(url);
        Button botao = new Button("Alterar");
        botao.setOnAction((event) -> {
            url = tfUrl.getText();
        });
        flowPane.getChildren().addAll(label, tfUrl, botao);
        Stage newWindow = new Stage();
        newWindow.setTitle("Redefinir URL de download");
        newWindow.setScene(new Scene(flowPane));
        newWindow.setHeight(140);
        newWindow.setWidth(200);
        newWindow.show();
    }

    private void abreTelaInfos(Stage primaryStage, Questao questao) {
        FlowPane flowPaneGeral = new FlowPane(Orientation.HORIZONTAL);
        flowPaneGeral.setPadding(new Insets(10,10,10,10));
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
            new Label(questao.getGabarito().getValue())
        };
        flowPane.getChildren().addAll(label);

        if (!questao.getUrlcop().equals("")) {
            File file = new File("./src/imagens/" + questao.getIdquestao().getValue() + questao.getAno().getValue() + ".jpg");
            if (!file.exists()) {
                InputStream in = null;
                try {
                    //se o arquivo não existir, faz o download
                    in = new URL(questao.getUrlcop()).openStream();
                    Files.copy(in, Paths.get(file.getPath()), StandardCopyOption.REPLACE_EXISTING);
                } catch (MalformedURLException ex) {
                    new Alert(Alert.AlertType.ERROR, "O download não pode ser realizado!").show();
                } catch (IOException ex) {
                    new Alert(Alert.AlertType.ERROR, "Algo não ocorreu bem!").show();
                } finally {
                    try {
                        in.close();
                    } catch (IOException ex) {
                        new Alert(Alert.AlertType.ERROR, "Algo não ocorreu bem!").show();
                    }
                }
            }
            Image image = null;
            try {
                image = new Image(new FileInputStream(file));
            } catch (FileNotFoundException ex) {
                new Alert(Alert.AlertType.ERROR, "A imagem não pode ser carregada!").show();
            }
            flowPaneGeral.getChildren().add(new ImageView(image));
        } else {
            flowPaneGeral.getChildren().add(new Label("Não há imagem."));
        }
        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                        new PieChart.Data("Acertos curso", Float.parseFloat(questao.getAcertoscurso().getValue().replace(',', '.'))),
                        new PieChart.Data("Acertos região", Float.parseFloat(questao.getAcertosregiao().getValue().replace(',', '.'))),
                        new PieChart.Data("Acertos Brasil", Float.parseFloat(questao.getAcertosbrasil().getValue().replace(',', '.'))),
                        new PieChart.Data("Acertos Dif. Curso-Brasil", Float.parseFloat(questao.getAcertosdif().getValue().replace(',', '.')))
                );
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Acertos");
        flowPane.getChildren().add(chart);
        Stage newWindow = new Stage();
        newWindow.setTitle("Informações");
        newWindow.setScene(new Scene(flowPaneGeral));
        newWindow.setHeight(500);
        newWindow.setWidth(800);

        newWindow.setX(primaryStage.getX() + 100);
        newWindow.setY(primaryStage.getY() + 50);

        newWindow.show();
    }

    private void carregaTabela(TableView table, boolean recarregar, String ano, String prova, String tipoQuestao) {
        if (recarregar) {
            table.getItems().clear();
            table.getColumns().clear();
        }
        TableColumn[] tableColumns = {
            new TableColumn("Ano"),
            new TableColumn("Prova"),
            new TableColumn("Tipo Questão"),
            new TableColumn("ID Questão"),
            new TableColumn("Objeto"),
            new TableColumn("Acertos Curso"),
            new TableColumn("Acertos Região"),
            new TableColumn("Acertos Brasil"),
            new TableColumn("Dif. (Curso-Brasil)"),};
        table.getColumns().addAll(Arrays.asList(tableColumns));

        File file = new File("./src/t6/enade.csv");
        if (!file.exists()) {
            downloadTabela();
        }
        try {
            this.lista = new CSVReaderHeaderAware(new FileReader(file)).readAll();
        } catch (FileNotFoundException ex) {
            new Alert(Alert.AlertType.ERROR, "O arquivo não pode ser carregado!").show();
        } catch (IOException ex) {
            new Alert(Alert.AlertType.ERROR, "Algo não ocorreu bem!").show();
        }
        ObservableList<Questao> data = FXCollections.observableArrayList();

        for (String[] dados : lista) {
            if ((dados[1].equals(ano) || ano == null || ano.equals("Todos")) && (dados[2].equals(prova) || prova == null || prova.equals("Todos")) && (dados[3].equals(tipoQuestao) || tipoQuestao == null || tipoQuestao.equals("Todos"))) {
                data.add(new Questao(dados[1], dados[2], dados[3], dados[4], dados[5], dados[8], dados[9], dados[10], dados[11]));
            }
        }

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

    private void downloadTabela() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION, "Baixando tabela...");
        alerta.show();
        try {
            InputStream in = new URL(url).openStream();
            String pathArquivo = "./src/t6/enade.csv";
            File file = new File(pathArquivo);
            if (file.exists()) {
                file.delete();
            }
            Files.copy(in, Paths.get(pathArquivo), StandardCopyOption.REPLACE_EXISTING);
        } catch (MalformedURLException ex) {
            new Alert(Alert.AlertType.ERROR, "Não foi possível encontrar URL!").show();
        } catch (IOException ex) {
            new Alert(Alert.AlertType.ERROR, "Algo não ocorreu bem!").show();
        }
        alerta.close();
    }
    
    private void downloadFiles(){
        Thread t = new Thread(() -> {
            int indice=14;
            for(String[] dados : lista){
                for(int i=0; i<4; i++){
                    String urlFile = dados[indice];
                    try {
                        System.out.println("Download... "+urlFile);
                        InputStream in = new URL(urlFile).openStream();
                        String pathArquivo = "./src/imagens/" + dados[4] + dados[1] +indice+ urlFile.substring(urlFile.length()-4);
                        File file = new File(pathArquivo);
                        if (file.exists()) {
                            file.delete();
                        }
                        Files.copy(in, Paths.get(pathArquivo), StandardCopyOption.REPLACE_EXISTING);
                    } catch (MalformedURLException ex) {
                        System.out.println(ex.getMessage());
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    indice++;
                }
                indice=14;
            }
            Alert alerta = new Alert(Alert.AlertType.INFORMATION, "Download completo!");
        });
        t.start();
    }
}
//14 15 16 17
