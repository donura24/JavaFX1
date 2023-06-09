package Animations;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ImageView myImage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // translate
        /*
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(myImage);
        transition.setDuration(Duration.millis(1500));
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.setByX(250);
        transition.setByY(-150);
        transition.setAutoReverse(true);
        transition.play();
        */

        //rotate
        /*
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(myImage);
        rotate.setDuration(Duration.millis(1000));
        rotate.setCycleCount(RotateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(360);
        rotate.setAxis(Rotate.X_AXIS);
        rotate.play();

         */

        //fade
        /*
        FadeTransition fade = new FadeTransition();
        fade.setNode(myImage);
        fade.setDuration(Duration.millis(1000));
        fade.setCycleCount(FadeTransition.INDEFINITE);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
         */

        // scale
        /*
        ScaleTransition scale = new ScaleTransition();
        scale.setNode(myImage);
        scale.setDuration(Duration.millis(1000));
        scale.setCycleCount(ScaleTransition.INDEFINITE);
        scale.setInterpolator(Interpolator.LINEAR);
        scale.setByX(2.0);
        scale.setByY(2.0);
        scale.setAutoReverse(true);
        scale.play();

         */
    }
}
