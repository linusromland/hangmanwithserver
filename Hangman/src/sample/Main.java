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

    private static Stage primaryStage;
    public static Scene _defaultscene;
    public static String _keypress;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hangman");
        _defaultscene = new Scene(root, 1280, 720);
        primaryStage.setScene(_defaultscene);
        primaryStage.show();
    }
    public static String guess(){
        //Setup keylistener
        _defaultscene.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                _keypress = keyEvent.getCharacter();
                System.out.println(keyEvent.getCharacter());
            }
        });
        return _keypress;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
