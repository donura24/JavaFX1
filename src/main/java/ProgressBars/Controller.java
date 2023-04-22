package ProgressBars;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ProgressBar myProgressBar;
    @FXML
    private Button myButton;
    @FXML
    private Label myLabel;

    double progress;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        myProgressBar.setStyle("-fx-accent: rgba(152,37,37,0.96);");
    }
    public void increaseProgress(){

        progress += 0.1;
        myProgressBar.setProgress(progress);
        myLabel.setText(String.valueOf((int) Math.round(myProgressBar.getProgress())));

    }
}
