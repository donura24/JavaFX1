package webBrowser;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private WebView webView;

    @FXML
    private TextField textField;
    @FXML
    ChoiceBox<String> choiceBox;

    @FXML
    TabPane tabPane;
    @FXML
    Tab tab;

    @FXML
    StackPane stackPane;
    @FXML
    Button newTabButton;
    private WebEngine webEngine;
    private WebHistory webHistory;

    private String homePage;

    private double webZoom;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        webEngine = webView.getEngine();
        homePage = "www.google.com";
        textField.setText(homePage);
        webZoom = 1.0;

        String[] links = {"www.youtube.com", "www.telegraf.com", "www.honda.com"};
        choiceBox.getItems().setAll(links);
        choiceBox.setOnAction(this::setLabel);

        selectURL();
    }

    public void newTab(){
        tab = new Tab("New Tab");



    }

    public void setLabel(ActionEvent event){
        String brand = choiceBox.getValue();
        textField.setText(brand);
        selectURL();

    }

    public void selectURL(){

        webEngine.load("http://"+textField.getText());
    }

    public void refreshPage(){
        webEngine.reload();
    }

    public void zoomIn(){
        webZoom+=0.25;
        webView.setZoom(webZoom);
    }
    public void zoomOut(){
        webZoom-=0.25;
        webView.setZoom(webZoom);
    }
    public void displayHistory(){

        webHistory = webEngine.getHistory();
        ObservableList<WebHistory.Entry> entries = webHistory.getEntries();

        for (WebHistory.Entry entry: entries){
            System.out.println(entry .getUrl()+" "+entry.getLastVisitedDate());
        }
    }

    public void goBack(){
        webHistory = webEngine.getHistory();
        ObservableList<WebHistory.Entry> entries = webHistory.getEntries();
        webHistory.go(-1);
        textField.setText(entries.get(webHistory.getCurrentIndex()).getUrl());
    }
    public void goForward(){
        webHistory = webEngine.getHistory();
        ObservableList<WebHistory.Entry> entries = webHistory.getEntries();
        webHistory.go(1);
        textField.setText(entries.get(webHistory.getCurrentIndex()).getUrl());

    }

    public void executeJS(){
        webEngine.executeScript("window.location = \"https://www.youtube.com\";");
    }
}

