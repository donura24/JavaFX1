package com.example.javafx1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Group root = new Group();
        Scene scene = new Scene(root, Color.BISQUE);
        Image icon = new Image("Mann-Mit-Der-Tarnjacke-Aurora-Monitor.32.png");

        stage.getIcons().add(icon);
        stage.setTitle("First App!");
        stage.setWidth(400);
        stage.setHeight(400);
        //stage.setResizable(false);

        stage.setFullScreen(true);
        stage.setFullScreenExitHint("Press SPACE to exit FullScreen.");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("SPACE"));
        //stage.setX();
        //stage.setY();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}