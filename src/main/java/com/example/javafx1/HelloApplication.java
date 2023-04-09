package com.example.javafx1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Parent parent = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

        Group root = new Group();
        Scene scene = new Scene(root, Color.DARKSEAGREEN);
        Image icon = new Image("Mann-Mit-Der-Tarnjacke-Aurora-Monitor.32.png");

        Text text = new Text("Paradiseee!");
        text.setX(100);
        text.setY(100);
        text.setFont(Font.font("Ubuntu", 40));
        text.setFill(Color.AZURE);

        Line line = new Line();
        line.setStartX(0);
        line.setStartY(140);
        line.setEndX(400);
        line.setEndY(400);
        line.setStrokeWidth(10);
        line.setStroke(Color.DEEPPINK);
        line.setOpacity(0.5);
        //line.setRotate(45);

        Rectangle rectangle = new Rectangle();
        rectangle.setX(100);
        rectangle.setY(50);
        rectangle.setWidth(210);
        rectangle.setHeight(80);
        rectangle.setStrokeWidth(2);
        rectangle.setStroke(Color.BISQUE);
        rectangle.setFill(Color.DARKSLATEBLUE);

        Polygon polygon = new Polygon();
        polygon.getPoints().setAll(
                200.0,200.0,
                300.0, 300.0,
                200.0,300.0
                );
        polygon.setFill(Color.IVORY);
        polygon.setRotate(110);

        Circle circle = new Circle();
        circle.setCenterX(350);
        circle.setCenterY(300);
        circle.setRadius(50);
        circle.setFill(Color.VIOLET);

        Image image = new Image("Icondrawer-Globe-Globe-compass.128.png");
        ImageView imageView = new ImageView(image);
        imageView.setX(50);
        imageView.setY(150);

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

        root.getChildren().add(rectangle);
        root.getChildren().add(text);
        root.getChildren().add(line);
        root.getChildren().add(polygon);
        root.getChildren().add(circle);
        root.getChildren().add(imageView);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}