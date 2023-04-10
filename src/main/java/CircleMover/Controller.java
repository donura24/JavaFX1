package CircleMover;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Sphere;

public class Controller {

    @FXML
    private Circle circle;
    private double x;
    private double y;


    public void up(ActionEvent e){
        circle.setCenterY(y-=5);
    }
    public void down(ActionEvent e){

        circle.setCenterY(y+=5);
    }
    public void right(ActionEvent e){

        circle.setCenterX(x+=5);
    }
    public void left(ActionEvent e){

        circle.setCenterX(x-=5);
    }

}
