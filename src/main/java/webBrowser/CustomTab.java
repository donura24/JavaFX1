package webBrowser;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;

public class CustomTab extends Tab {
    public CustomTab(String title){

        super(title);

        Button closeButton = new Button("x");
        closeButton.setOnAction(event -> {
            getTabPane().getTabs().remove(this);
        });

        HBox hbox = new HBox();
        hbox.getChildren().addAll(closeButton);
        hbox.setSpacing(5);

        // Set the HBox as the tab header
        setGraphic(hbox);
    }
    public void history(WebHistory webHistory, WebEngine webEngine){
        webHistory = webEngine.getHistory();
        ObservableList<WebHistory.Entry> entries = webHistory.getEntries();

        for (WebHistory.Entry entry : entries) {
            System.out.println(entry.getUrl() + " " + entry.getLastVisitedDate());
        }

    }

}
