package UserLogin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        Scene scene1 = new Scene(root);
        Image im = new Image("Dark-Wizard-1-icon.png");
        ImageView imageView = new ImageView(im);
        imageView.setX(50);
        imageView.setY(100);


        ((Pane) root).getChildren().add(imageView);

        stage.setScene(scene1);
        stage.show();
    }
}
