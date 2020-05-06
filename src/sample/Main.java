package sample;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class Main extends Application {

    public static Scene _defaultscene;

    /*
    YOU NEED  Java11, OpenJFX11 (JavaFX), and a custom lib for the soundplayuer
    CHECK GITHUB FOR MORE INFORMATION!!!!!
     */

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hangman");
        _defaultscene = new Scene(root, 1280, 720);
        primaryStage.setScene(_defaultscene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
