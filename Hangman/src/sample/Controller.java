package sample;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    public ArrayList<String> _Words = new ArrayList<String>();
    public ArrayList<String> _language = new ArrayList<String>();
    public static String _secretword;
    @FXML
    private ComboBox lang;
    @FXML
    private GridPane primgrid;
    @FXML
    private Text title;
    @FXML
    public Text gamemodetitle;
    @FXML
    private Text dumdum;
    @FXML
    private GridPane gamemode;
    @FXML
    private GridPane primary;
    @FXML
    private Button textsingleplayer;
    @FXML
    private Button localmultiplayer;
    @FXML
    private Text online;
    @FXML
    private GridPane localmulti;
    @FXML
    private Text localmultititle;



    @FXML
    public void initialize() throws IOException {
        gamemode.setVisible(false);
        localmulti.setVisible(false);
        primgrid.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        primary.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        lang.getItems().addAll("Svenska", "English");
        title.setFont(Font.font(20));
        //backend.run();
    }

    public void gamemodescene(){
        gamemode.setVisible(true);
        gamemodetitle.setFont(Font.font(20));
        gamemodetitle.setText(_language.get(11));
        textsingleplayer.setText(_language.get(16));
        localmultiplayer.setText(_language.get(17));
        online.setText(_language.get(18));
    }
    public void localMultiplayer(){
        localmulti.setVisible(true);
        localmultititle.setText(_language.get(13));

    }
    public void singleplayer(){
        _secretword = backend.GenerateSecretWord(lang.getValue().toString());
        System.out.println(_secretword);
    }

    public void handleSubmitButtonAction3(ActionEvent actionEvent) {
        gamemode.setVisible(false);
        localMultiplayer();

    }

    public void handleSubmitButtonAction2(ActionEvent actionEvent) {
        gamemode.setVisible(false);
        singleplayer();
    }
    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) throws IOException {
        if (lang.getValue() != null) {
            primgrid.setVisible(false);
            _language = language.lang(lang.getValue().toString());
            _Words = backend.generatewordlist(lang.getValue().toString());
            gamemodescene();
        } else {
            dumdum.setText("You need to select language");
        }
    }

}