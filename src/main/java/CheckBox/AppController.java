package CheckBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AppController {

    @FXML
    private Label myLabel;
    @FXML
    private CheckBox myCheckBox;
    @FXML
    private ImageView myImageView;

    Image myImage1 = new Image("Light-Bulb-icon-OFF.png");
    Image myImage2 = new Image("Light-Bulb-Flat-icon-ON.png");

    public void change(ActionEvent event){

        if (myCheckBox.isSelected()){
            myLabel.setText("ON");
        }
        else {
            myLabel.setText("OFF");
        }
    }
}
