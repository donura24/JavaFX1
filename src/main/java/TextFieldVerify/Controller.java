package TextFieldVerify;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Label myLabel;
    @FXML
    private Button myButton;
    @FXML
    private TextField myTextField;

    int age;

    public void submit(ActionEvent event){

        try {
            age = Integer.parseInt(myTextField.getText());
        } catch (NumberFormatException e) {
            System.out.println(e);
        }


    }
}
