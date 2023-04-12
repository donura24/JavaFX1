package SceneSwithing;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {

    private Scene scene;
    private Stage stage;
    private Parent root;

    public void switchToScene1(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        Image im = new Image("Dark-Wizard-1-icon.png");
        ImageView imageView = new ImageView(im);
        imageView.setX(50);
        imageView.setY(100);


        ((Pane) root).getChildren().add(imageView);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToScene2(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        Image im = new Image("Castle-Princess-icon.png");
        ImageView imageView = new ImageView(im);
        imageView.setX(50);
        imageView.setY(100);


        ((Pane) root).getChildren().add(imageView);
        stage.setScene(scene);
        stage.show();

    }
}
