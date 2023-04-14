package UserLogin;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene1Controller {

    @FXML
    TextField textField;
    private Stage stage;
    private Scene scene;
    private Parent parent;
    @FXML
    private ProgressBar progressBar;

    public void login(ActionEvent event) throws IOException, InterruptedException {

        String username = textField.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
        parent = loader.load();

        Scene2Controller scene2Controller = loader.getController();
        scene2Controller.displayName(username);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(parent);

        Image im = new Image("Owl-Avatar-icon.png");
        ImageView imageView = new ImageView(im);
        imageView.setX(50);
        imageView.setY(100);


        ((Pane) parent).getChildren().add(imageView);

        stage.setScene(scene);
        stage.show();
    }

}
