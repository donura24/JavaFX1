package RadioButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Controller {

    @FXML
    private Label myLabel;
    @FXML
    private RadioButton myRadioButton1, myRadioButton2, myRadioButton3;
    @FXML

    Image myCarIcon1 = new Image("icons8-subaru-96.png");
    Image myCarIcon2 = new Image("icons8-toyota-96.png");
    Image myCarIcon3 = new Image("icons8-honda-96.png");


    @FXML
    ImageView myCarIcon = new ImageView(myCarIcon1);

    public void selected(ActionEvent event) {


        if (myRadioButton1.isSelected()) {
            myLabel.setText(myRadioButton1.getText());
            myCarIcon.setImage(myCarIcon1);
        } else if (myRadioButton2.isSelected()) {
            myLabel.setText(myRadioButton2.getText());
            myCarIcon.setImage(myCarIcon2);

        } else {
            myLabel.setText(myRadioButton3.getText());
            myCarIcon.setImage(myCarIcon3);

        }
    }
}
