package LogoutWindow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AppController {

    @FXML
    private Button logoutButton;
    @FXML
    private AnchorPane scenePane;
    Stage stage;

    public void logout(ActionEvent event){

        stage = (Stage) scenePane.getScene().getWindow();
        System.out.println("okk");
        stage.close();
    }
}
