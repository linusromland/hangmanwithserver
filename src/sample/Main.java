package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;

public class Main extends Application {

    private HBox intro = new HBox();
    private HBox menu = new HBox();


    public void start(Stage primaryStage) throws Exception{
       setupIntro(primaryStage);
       setupMenu(primaryStage);
    }

    private void setupIntro(Stage primaryStage){
        String path = "src\\sample\\video.mp4";
        primaryStage.setScene(new Scene(intro, 275, 275));
        intro.getChildren().add(video(path, primaryStage));
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.show();

    }

    private void setupMenu(Stage primaryStage){

        Button disablefullscreen = new Button("no fullscreen");
        disablefullscreen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setFullScreen(false);
            }
        });
        menu.getChildren().add(disablefullscreen);

    }

    private MediaView video(String path, Stage primaryStage){
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaPlayer.setMute(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mediaView.setFitHeight(screenSize.getHeight());
        mediaView.setFitWidth(screenSize.getWidth());
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                primaryStage.setFullScreen(true);
                primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
                primaryStage.setScene(new Scene(menu, 275, 275));

            }
        });
        return mediaView;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
