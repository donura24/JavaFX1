package Choice_Box;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label myLabel;
    @FXML
    private ChoiceBox<String> myChoiceBox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String[] brands = {"Apple", "Samsung", "Panasonic"};
        myChoiceBox.getItems().setAll(brands);
        myChoiceBox.setOnAction(this::setLabel);
    }

    public void setLabel(ActionEvent event){
        String brand = myChoiceBox.getValue();
        myLabel.setText(brand);
    }
}
