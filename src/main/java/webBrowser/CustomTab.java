package webBrowser;

import javafx.scene.control.Button;
import javafx.scene.control.Tab;

public class CustomTab extends Tab {
    public CustomTab(String title){

        super(title);

        Button closeButton = new Button("x");
        closeButton.setOnAction(event -> {
            getTabPane().getTabs().remove(this);
        });
    }
}
