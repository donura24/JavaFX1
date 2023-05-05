package webBrowser;

import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
}
