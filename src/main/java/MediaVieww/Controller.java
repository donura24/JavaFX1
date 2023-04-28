package MediaVieww;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;


public class Controller implements Initializable {

    @FXML
    private MediaView myMediaView;

    @FXML
    private Button myPlayButton, myPauseButton, myResetButton;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        file = new File("/home/teodor.penchev/IdeaProjects/JavaFX1/src/main/resources/Thirsty.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        myMediaView.setMediaPlayer(mediaPlayer);

    }

    public void playMedia(){

        mediaPlayer.play();
    }
    public void pauseMedia(){

        mediaPlayer.pause();
    }
    public void resetMedia(){
        if (mediaPlayer.getStatus() != MediaPlayer.Status.READY) mediaPlayer.seek(Duration.seconds(0.0));

    }
}
