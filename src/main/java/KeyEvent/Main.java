package KeyEvent;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        Scene scene1 = new Scene(root);
        scene1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        controller.up();
                        break;
                    case DOWN:
                        controller.down();
                        break;
                    case LEFT:
                        controller.left();
                        break;
                    case RIGHT:
                        controller.right();
                        break;
                    default:
                        break;
                }


            }
        });

        stage.setScene(scene1);
        stage.show();
    }
}
