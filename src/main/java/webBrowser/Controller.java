package webBrowser;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
//

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


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
    private WebHistory webHistory1;
    private AutoCompletionBinding<String> autoCompletionBinding;
    private String[] urls11;

    private String homePage;

    private double webZoom = 1.0;
    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        webEngine = webView.getEngine();
        homePage = "www.google.com";
        textField.setText(homePage);
        // webZoom = 1.0;

        String[] links = {"www.youtube.com", "www.telegraf.com", "www.honda.com"};
        choiceBox.getItems().setAll(links);
        choiceBox.setValue("Fav sites");
        choiceBox.setOnAction(this::setChoiceBoxURL);

        selectURL();
        webEngine.locationProperty().addListener(((observableValue, s, t1) ->
                firstTab.setText(textField.getText())));
    }

    public void newTab() throws IOException {

        TextField textField = new TextField();

        String customTabName = textField.getText();
        CustomTab customTab = new CustomTab(customTabName);

        pane = new Pane();
        pane.requestFocus();

        hBox = new HBox();
        hBox.setLayoutX(0);
        hBox.setLayoutY(25);
        hBox.setPrefSize(580, 30);

        WebView webView = new WebView();
        WebEngine tabWebEngine = webView.getEngine();
        webHistory1 = tabWebEngine.getHistory();

        ObservableList<WebHistory.Entry> entries1 = webHistory1.getEntries();
        String[] urls = new String[entries1.size()];
        for (int i = 0; i < entries1.size(); i++) {
            urls[i] = entries1.get(i).getUrl();
        }

        webView.setLayoutX(0);
        webView.setLayoutY(50);

        KeyCodeCombination refreshKeyCode = new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN);
        KeyCodeCombination zoomInKeyCode = new KeyCodeCombination(KeyCode.EQUALS, KeyCombination.CONTROL_DOWN);
        KeyCodeCombination zoomOutKeyCode = new KeyCodeCombination(KeyCode.EQUALS, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN);

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> goBack(webHistory1, tabWebEngine, textField, customTab));
        Button forwardButton = new Button("Forward");
        forwardButton.setOnAction(event -> goForward(webHistory1, tabWebEngine, textField, customTab));
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(event -> refreshPage(tabWebEngine));
        pane.setOnKeyPressed(event -> {
            if (refreshKeyCode.match(event)) {
                event.consume();
                refreshPage(tabWebEngine);
                //hBox.requestFocus();
            } else if (zoomInKeyCode.match(event)) {
                event.consume();
                zoomIn(webView);
            } else if (zoomOutKeyCode.match(event)) {
                event.consume();
                zoomOut(webView);
            }
        });

        Button zoomInButton = new Button("Zoom +");
        zoomInButton.setOnAction(event -> zoomIn(webView));
        Button zoomOutButton = new Button("Zoom -");
        zoomOutButton.setOnAction(event -> zoomOut(webView));

        Button newTab = new Button("New tab");
        newTab.setOnAction(event -> {
            try {
                newTab();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        ChoiceBox<String> history = new ChoiceBox<>();
        history.setValue("History");
        history.setPrefWidth(120);

        history.setOnAction(event -> {
            String url = history.getValue();
            textField.setText(url);
            tabWebEngine.load(textField.getText());

        });

        homePage = "www.google.com";
        textField.setText(homePage);
        textField.prefWidthProperty().bind(pane.widthProperty());

        tabWebEngine.load("https://" + textField.getText());

        textField.setOnAction(event -> {
            String url = textField.getText();
            if (!url.startsWith("https")) {
                url = "https://" + url;
            }

            ObservableList<WebHistory.Entry> entries = webHistory1.getEntries();
            urls11 = new String[entries.size()];
            for (int i = 0; i < entries.size(); i++) {
                urls11[i] = entries.get(i).getUrl();
                history.getItems().setAll(urls11);
                try {
                    saveHistory(entries1,"src/main/resources/webBrowser/history.json");
                    //loadHistory("src/main/resources/webBrowser/history.json");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (urls11.length == 0) {
                System.out.println("No URLs found in the web history.");
            } else {
                System.out.println("URLs in the web history:");
                for (String urll : urls11) {
                    System.out.println(urll);
                }
            }
            autoCompletionBinding = TextFields.bindAutoCompletion(textField, urls11);

            tabWebEngine.load(url);
        });


// TODO: Trying to select and load CompletionTarget with ENTER;

//        autoCompletionBinding.setOnAutoCompleted(event -> {
//            String selectedURL = event.getCompletion();
//            tabWebEngine.load(selectedURL);
//
//        });
//
////            textField.textProperty().addListener(((observable, oldValue, newValue) -> {
////                autoCompletionBinding.getAutoCompletionPopup().getSuggestions().clear();
////                autoCompletionBinding.getAutoCompletionPopup().getSuggestions().addAll(urls11);
////            }));

        tabWebEngine.locationProperty().

                addListener(((observableValue, s, t1) ->
                        customTab.setText(textField.getText())));

        hBox.getChildren().

                addAll(backButton, forwardButton, refreshButton, zoomInButton, zoomOutButton, newTab, history);

        // HBox.setHgrow(webView, Priority.ALWAYS);
        webView.prefWidthProperty().

                bind(tabPane.widthProperty());
        webView.prefHeightProperty().

                bind(tabPane.heightProperty());


        pane.getChildren().

                addAll(webView, textField, hBox);

        customTab.setContent(pane);

        tabPane.getTabs().

                add(customTab);
        tabPane.getSelectionModel().

                select(customTab);
        customTab.getContent().

                requestFocus();

    }

    public void setChoiceBoxURL(ActionEvent event) {
        String brand = choiceBox.getValue();
        textField.setText(brand);
        selectURL();
    }

    public void selectURL() {
        webEngine.load("https://" + textField.getText());
    }

    public void refreshPage(WebEngine tabWebEngine) {
        tabWebEngine.reload();
    }

    public void zoomIn(WebView webView) {

        webZoom += 0.25;
        webView.setZoom(webZoom);
    }

    public void zoomOut(WebView webView) {
        webZoom -= 0.25;
        webView.setZoom(webZoom);
    }

//    public void displayHistory() {
//
//        webHistory = webEngine.getHistory();
//        ObservableList<WebHistory.Entry> entries = webHistory.getEntries();
//
//        for (WebHistory.Entry entry : entries) {
//            System.out.println(entry.getUrl() + " " + entry.getLastVisitedDate());
//        }
//
//    }

    //TODO: continue...here
    public void saveHistory(ObservableList<WebHistory.Entry> historyList, String filePath) throws IOException {

        //List<WebHistory> entries = loadHistory(filePath);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<WebHistory.Entry> entryList = loadHistory(filePath);
        entryList.addAll(historyList);

        String json = objectMapper.writeValueAsString(entryList);
        Files.writeString(Paths.get(filePath), json);
    }

    public List<WebHistory.Entry> loadHistory(String filePath) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        List<WebHistory.Entry> historyList = new ArrayList<>();

        String json = Files.readString(Paths.get(filePath));
        if (!json.isEmpty()) {
            historyList = objectMapper.readValue(json, new TypeReference<List<WebHistory.Entry>>() {});
        }

        return historyList;
    }

    public void goBack(WebHistory tabWebHistory, WebEngine webEngine1, TextField textField, CustomTab customTab) {
        tabWebHistory = webEngine1.getHistory();
        ObservableList<WebHistory.Entry> entries = tabWebHistory.getEntries();
        tabWebHistory.go(-1);
        textField.setText(entries.get(tabWebHistory.getCurrentIndex()).getUrl());
        customTab.setText(textField.getText());

    }

    public void goForward(WebHistory tabWebHistory, WebEngine webEngine1, TextField textField, CustomTab customTab) {
        tabWebHistory = webEngine1.getHistory();
        ObservableList<WebHistory.Entry> entries = tabWebHistory.getEntries();
        tabWebHistory.go(1);
        textField.setText(entries.get(tabWebHistory.getCurrentIndex()).getUrl());
        customTab.setText(textField.getText());
    }

    public void executeJS() {
        webEngine.executeScript("window.location = \"https://www.youtube.com\";");
    }
}

