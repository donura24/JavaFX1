package RadioButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class Controller {

    @FXML
    private Label myLabel;
    @FXML
    private RadioButton myRadioButton1, myRadioButton2, myRadioButton3;

    public void selected(ActionEvent event){

        if (myRadioButton1.isSelected()){
            myLabel.setText(myRadioButton1.getText());
        } else if (myRadioButton2.isSelected()) {
            myLabel.setText(myRadioButton2.getText());
        }
        else myLabel.setText(myRadioButton3.getText());
    }
}
