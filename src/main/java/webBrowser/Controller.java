package webBrowser;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
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
    private TabPane tabPane;

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

    public void newTab() {
        String customTabName = textField.getText();
        CustomTab customTab = new CustomTab(customTabName);

        VBox vBox = new VBox();

        WebView webView = new WebView();
        TextField textField = new TextField();
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> goBack());
        Button forwardButton = new Button("Forward");
        forwardButton.setOnAction(event -> goForward());
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(event -> refreshPage());

        webEngine = webView.getEngine();
        homePage = "www.google.com";
        textField.setText(homePage);
        webZoom = 1.0;
        webEngine.load("http://" + textField.getText());

        textField.setOnAction(event -> {
            String url = textField.getText();
            if (!url.startsWith("http")){
                url = "http://"+url;
            }
            webEngine.load(url);
        });
        webEngine.locationProperty().addListener(((observableValue, s, t1) ->
                customTab.setText(textField.getText())));

        vBox.getChildren().addAll(textField, backButton, refreshButton, webView);

        VBox.setVgrow(webView, Priority.ALWAYS);
        webView.prefWidthProperty().bind(vBox.widthProperty());
        webView.prefHeightProperty().bind(vBox.heightProperty());

        customTab.setContent(vBox);

        tabPane.getTabs().add(customTab);

    }

    public void setLabel(ActionEvent event) {
        String brand = choiceBox.getValue();
        textField.setText(brand);
        selectURL();

    }

    public void selectURL() {

        webEngine.load("http://" + textField.getText());
    }

    public void refreshPage() {
        webEngine.reload();
    }

    public void zoomIn() {
        webZoom += 0.25;
        webView.setZoom(webZoom);
    }

    public void zoomOut() {
        webZoom -= 0.25;
        webView.setZoom(webZoom);
    }

    public void displayHistory() {

        webHistory = webEngine.getHistory();
        ObservableList<WebHistory.Entry> entries = webHistory.getEntries();

        for (WebHistory.Entry entry : entries) {
            System.out.println(entry.getUrl() + " " + entry.getLastVisitedDate());
        }
    }

    public void goBack() {
        webHistory = webEngine.getHistory();
        ObservableList<WebHistory.Entry> entries = webHistory.getEntries();
        webHistory.go(-1);
        textField.setText(entries.get(webHistory.getCurrentIndex()).getUrl());
    }

    public void goForward() {
        webHistory = webEngine.getHistory();
        ObservableList<WebHistory.Entry> entries = webHistory.getEntries();
        webHistory.go(1);
        textField.setText(entries.get(webHistory.getCurrentIndex()).getUrl());

    }

    public void executeJS() {
        webEngine.executeScript("window.location = \"https://www.youtube.com\";");
    }
}

