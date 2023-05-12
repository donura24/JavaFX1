package webBrowser;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.layout.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

import org.controlsfx.control.textfield.TextFields;

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
    private Tab firstTab;
    @FXML
    private HBox hBox;
    @FXML
    private Pane pane;
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
        choiceBox.setValue("Fav sites");
        choiceBox.setOnAction(this::setChoiceBoxURL);

        selectURL();
        webEngine.locationProperty().addListener(((observableValue, s, t1) ->
                firstTab.setText(textField.getText())));
    }

    public void newTab() {

        String customTabName = textField.getText();
        CustomTab customTab = new CustomTab(customTabName);

        pane = new Pane();

        hBox = new HBox();
        hBox.setLayoutX(0);
        hBox.setLayoutY(25);
        hBox.setPrefSize(580, 30);

        AtomicReference<WebHistory> webHistory1 = new AtomicReference<>(webEngine.getHistory());
        WebView webView = new WebView();
        webView.setLayoutX(0);
        webView.setLayoutY(50);
        TextField textField = new TextField();
        textField.prefWidthProperty().bind(pane.widthProperty());

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> goBack());
        Button forwardButton = new Button("Forward");
        forwardButton.setOnAction(event -> goForward());
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(event -> refreshPage());

        Button zoomInButton = new Button("Zoom +");
        zoomInButton.setOnAction(event -> zoomIn());
        Button zoomOutButton = new Button("Zoom -");
        zoomOutButton.setOnAction(event -> zoomOut());

        Button newTab = new Button("New tab");
        newTab.setOnAction(event -> newTab());
        Button history = new Button("History");
        history.setOnAction(event -> {
            webHistory1.set(webEngine.getHistory());
            ObservableList<WebHistory.Entry> entries = webHistory1.get().getEntries();

            for (WebHistory.Entry entry : entries) {
                System.out.println(entry.getUrl() + " " + entry.getLastVisitedDate());
            }
        });

        WebEngine tabWebEngine = webView.getEngine();
        homePage = "www.google.com";
        textField.setText(homePage);
        webZoom = 1.0;
        tabWebEngine.load("http://" + textField.getText());

        textField.setOnAction(event -> {
            String url = textField.getText();
            if (!url.startsWith("http")) {
                url = "http://" + url;
            }
            tabWebEngine.load(url);
        });
        tabWebEngine.locationProperty().addListener(((observableValue, s, t1) ->
                customTab.setText(textField.getText())));

        hBox.getChildren().addAll(backButton, refreshButton, zoomInButton, zoomOutButton, newTab, history);

        // HBox.setHgrow(webView, Priority.ALWAYS);
        webView.prefWidthProperty().bind(tabPane.widthProperty());
        webView.prefHeightProperty().bind(tabPane.heightProperty());

        ObservableList<WebHistory.Entry> entries = webHistory1.get().getEntries();
        String[] urls = new String[entries.size()];
        for (int i = 0; i < entries.size(); i++) {
            urls[i] = entries.get(i).getUrl();
            System.out.println(entries.get(i).getUrl());
        }

        TextFields.bindAutoCompletion(textField, urls);

        pane.getChildren().addAll(webView, textField, hBox);

        customTab.setContent(pane);

        tabPane.getTabs().add(customTab);

    }

    public void setChoiceBoxURL(ActionEvent event) {
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

