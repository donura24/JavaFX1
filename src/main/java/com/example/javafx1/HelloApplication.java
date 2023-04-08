package com.example.javafx1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Group root = new Group();
        Scene scene = new Scene(root, Color.DARKSEAGREEN);
        Image icon = new Image("Mann-Mit-Der-Tarnjacke-Aurora-Monitor.32.png");
        Text text = new Text("Paradiseee!");

        text.setX(100);
        text.setY(100);
        text.setFont(Font.font("Ubuntu", 40));
        text.setFill(Color.AZURE);

        stage.getIcons().add(icon);
        stage.setTitle("First App!");
        stage.setWidth(400);
        stage.setHeight(400);
        //stage.setResizable(false);

        //stage.setFullScreen(true);
        //stage.setFullScreenExitHint("Press SPACE to exit FullScreen.");
        //stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("SPACE"));
        //stage.setX();
        //stage.setY();
        root.getChildren().add(text);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}