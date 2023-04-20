package Choice_Box;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label myLabel;
    @FXML
    private ChoiceBox<String> myChoiceBox;
    @FXML
    private ImageView myImageView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String[] brands = {"Apple", "Samsung", "Motorola"};
        myChoiceBox.getItems().setAll(brands);
        myChoiceBox.setOnAction(this::setLabel);
    }

    public void setLabel(ActionEvent event){
        String brand = myChoiceBox.getValue();
        myLabel.setText(brand);

        if (myChoiceBox.getValue().equals("Apple")) {
            Image appleImage = new Image("icons8-apple-logo-80.png");
            myImageView.setImage(appleImage);
        }
        else if (myChoiceBox.getValue().equals("Samsung")) {
            Image samsungImage = new Image("icons8-samsung-80.png");
            myImageView.setImage(samsungImage);
        }
        else {
            Image motorolaImage = new Image("icons8-motorola-80.png");
            myImageView.setImage(motorolaImage);
        }

    }
}
