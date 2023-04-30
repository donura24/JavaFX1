package MP3_Player;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.lang.invoke.VolatileCallSite;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements Initializable {

    @FXML
    private Pane myPane;

    @FXML
    private Label myLabel;

    @FXML
    private Button playButton, pauseButton, resetButton, previousButton, nextButton;

    @FXML
    private ComboBox<String> speedBox;

    @FXML
    private Slider volumeSlider;
    @FXML
    private ProgressBar songProgressBar;

    private Media media;
    private MediaPlayer mediaPlayer;
    private File directory;
    private File[] files;

    private ArrayList<File> songs;

    private int songNumber;
    private int[] speeds = {0, 25, 50, 75, 100, 125, 150, 175, 200};

    private Timer timer;
    private TimerTask timerTask;
    private boolean running;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        songs = new ArrayList<File>();
        directory = new File("/home/teodor.penchev/IdeaProjects/JavaFX1/src/main/java/music");

        files = directory.listFiles();

        if (files != null){
            for(File file : files){
                songs.add(file);
            }
        }
        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        myLabel.setText(songs.get(songNumber).getName());

        for (int i = 0; i < speeds.length; i++){
            speedBox.getItems().add(Integer.toString(speeds[i])+"%");
        }
    }

    public void playMedia(){

        mediaPlayer.play();
    }
    public void pauseMedia(){

        mediaPlayer.pause();
    }
    public void resetMedia(){

        mediaPlayer.seek(Duration.seconds(0));
    }
    public void previousMedia(){

        if (songNumber > 0){
            songNumber--;
            mediaPlayer.stop();

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            myLabel.setText(songs.get(songNumber).getName());
            playMedia();
        }
        else {
            songNumber = songs.size() -1;
            mediaPlayer.stop();

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            myLabel.setText(songs.get(songNumber).getName());
            playMedia();
        }
    }
    public void nextMedia(){

        if (songNumber < songs.size() -1){
            songNumber++;
            mediaPlayer.stop();

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            myLabel.setText(songs.get(songNumber).getName());
            playMedia();
        }
        else {
            songNumber = 0;
            mediaPlayer.stop();

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            myLabel.setText(songs.get(songNumber).getName());
            playMedia();
        }
    }
    public void changeSpeed(ActionEvent  event){


    }
    public void startTimer(){

    }
    public void endTimer(){

    }
}
