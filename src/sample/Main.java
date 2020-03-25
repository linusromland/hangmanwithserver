package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private HBox ress = new HBox();
    private HBox menu = new HBox();
    private int height = 600;
    private int width = 800;


    public void start(Stage primaryStage) throws Exception{
       setupMenu(primaryStage);
       setupRes(primaryStage);
    }

    private void setupRes(Stage primaryStage){

        primaryStage.setTitle("Hangman by Offlinus");
        primaryStage.setScene(new Scene(ress, 800, 600));
        primaryStage.show();

        ComboBox res = new ComboBox();
        res.getItems().addAll(
                "800x600",
                "1024x768",
                "1280x720"
        );
        Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setupIntro(primaryStage);
                primaryStage.setScene(new Scene(intro, 800, 600));
            }
        });
        ress.getChildren().add(res);
        ress.getChildren().add(submit);
    }

    private void setupIntro(Stage primaryStage){
        intro.getChildren().add(video("src\\sample\\video.mp4", primaryStage));
    }

    private void setupMenu(Stage primaryStage){

    }

    private MediaView video(String path, Stage primaryStage){
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaPlayer.setMute(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mediaView.setFitHeight(height);
        mediaView.setFitWidth(width);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                primaryStage.setScene(new Scene(menu, width, height));
            }
        });
        return mediaView;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
