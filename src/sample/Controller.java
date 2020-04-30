package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Controller {
    public ArrayList<String> _Words = new ArrayList<String>();
    public ArrayList<String> _language = new ArrayList<String>();
    public String _secretword = "";
    public Boolean _localmultiplayer;
    public String[] _show = new String[999];
    public int _guesses;
    public int _maxguesses = 15;
    public String _guessletters = "";
    @FXML
    private GridPane guess;
    @FXML
    private GridPane bigtext;
    @FXML
    private GridPane localmulti;
    @FXML
    private GridPane gamemode;
    @FXML
    private GridPane primary;
    @FXML
    private GridPane primgrid;
    @FXML
    private Text guesstitle;
    @FXML
    private Text localmultititle;
    @FXML
    private Text guessLines;
    @FXML
    private Text online;
    @FXML
    private Text gamemodetitle;
    @FXML
    private Text dumdum;
    @FXML
    private Text responsguess;
    @FXML
    private Text bigtexten;
    @FXML
    private Button localmultisubmit;
    @FXML
    private Button textsingleplayer;
    @FXML
    private Button localmultiplayer;
    @FXML
    public ComboBox lang;
    @FXML
    public ComboBox packs;
    @FXML
    private TextField localmultitextfield;
    @FXML
    private TextField inputguess;

    public void initialize() throws IOException {
        resourcepack.loadDefaultPack(primary);
        setPacks();
        gamemode.setVisible(false);
        localmulti.setVisible(false);
        guess.setVisible(false);
        bigtext.setVisible(false);
        lang.getItems().addAll("Svenska", "English");
    }
    public void setPacks(){
        ArrayList<File> PacksArray = resourcepack.getPacks(); //Gets all packs from which folders exist

        //Loop through all packs
        for (File pack : PacksArray) {
            System.out.println(pack);
            packs.getItems().addAll(pack.getName());
        }
        packs.setValue(PacksArray.get(0).getName());
    }


    public void gamemodescene() {
        gamemode.setVisible(true);
        gamemodetitle.setFont(Font.font(20));
        gamemodetitle.setText(_language.get(11));
        textsingleplayer.setText(_language.get(16));
        localmultiplayer.setText(_language.get(17));
        online.setText(_language.get(18));
    }

    public void localMultiplayer() {
        localmultisubmit.setText(_language.get(19));
        localmulti.setVisible(true);
        localmultititle.setText(_language.get(13));

    }

    public void singleplayer() {
        _secretword = backend.GenerateSecretWord(lang.getValue().toString());
        System.out.println(_secretword);
    }

    public void gimmeguess() {
        guess.setVisible(true);
        _show = backend.printlines(_secretword);
        guessLines.setText(backend.stringarraytostring(_show));
        guesstitle.setText(_language.get(2));
    }

    public boolean Guess(String guess) {
        String returnstring = "";
        Boolean breakIt = false;
        String check = "";
        for (int i = 0; i < _secretword.length(); i++) {
            _show[i] += check;
        }
        System.out.println(check);

        if (_guesses < _maxguesses) { //checks if you have any lives left
            if (!_guessletters.contains(guess)) {
                if (guess.length() > 1) { //checks if you guessed a word or char.
                    if (guess.equals(_secretword)) { //checks if you got the word right
                        returnstring = "Congrats";
                    } else {
                        returnstring = _language.get(5);
                    }
                } else {
                    if (_secretword.contains(guess)) { //checks if the word contains the letter
                        returnstring = _language.get(6);
                        for (int i = 0; i < _secretword.length(); i++) {
                            if (_secretword.charAt(i) == guess.charAt(0)) {
                                _show[i] = guess.toUpperCase().charAt(0) + "  ";
                            }
                        }
                    }
                }
            } else {
                returnstring = "already";
            }
        } else {
            returnstring = "notries";
            System.out.println(8 + guess);
            _guesses--;
        }

        if (winCheck()) {
            System.out.println("worksssss");
            returnstring = "Congrats";

        }

        _guesses++;
        System.out.println(_maxguesses - _guesses + _language.get(10));
        _guessletters += guess;
        System.out.println(_guessletters);
        if (returnstring.equals("Congrats")) { // if you won
            responsguess.setText(_language.get(3));
            breakIt = true;
        } else if (returnstring.equals("already")) { //if you lost. aka the lifes are up
            responsguess.setText(_language.get(8));
        } else if (returnstring.equals("lose")) { //if you lost. aka the lifes are up
            responsguess.setText(_language.get(5));
            breakIt = true;
        } else if (returnstring.equals("notries")) { //if you lost. aka the lifes are up
            responsguess.setText(_language.get(9));
            breakIt = true;
        } else {
            responsguess.setText(returnstring);
        }
        guessLines.setText(backend.stringarraytostring(_show));
        return breakIt;
    }

    public boolean winCheck() {
        boolean win = true;
        for (int i = 0; i < _secretword.length(); i++) {
            if (_show[i].contains("_")) {
                win = false;
            }
        }
        return win;
    }

    public void handleSubmitButtonAction3(ActionEvent actionEvent) {
        gamemode.setVisible(false);
        localMultiplayer();
        _localmultiplayer = true;
    }

    public void handleSubmitButtonAction2(ActionEvent actionEvent) {
        gamemode.setVisible(false);
        singleplayer();
        _localmultiplayer = false;
        gimmeguess();
    }

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) throws IOException {
        if (lang.getValue() != null) {
            primgrid.setVisible(false);
            _language = language.lang(lang.getValue().toString());
            _Words = backend.generatewordlist(lang.getValue().toString());
            resourcepack.selectPack(packs.getValue().toString(), primary);
            gamemodescene();
        } else {
            dumdum.setText("You need to select a language!");
        }
    }

    public void handleSubmitButtonAction4(ActionEvent actionEvent) {
        _secretword = localmultitextfield.getText();
        localmulti.setVisible(false);
        gimmeguess();

    }

    public void bigguesss(String input) throws InterruptedException {
        if (input != null) {
            bigtext.setVisible(true);
            guess.setVisible(false);
            bigtexten.setFont(Font.font(200));
            bigtexten.setText(input);
            TimeUnit.SECONDS.sleep(1);
            bigtext.setVisible(false);
            guess.setVisible(true);
        }
    }

    public void handleSubmitButtonAction5(ActionEvent actionEvent) throws InterruptedException {
        Guess(inputguess.getText().toUpperCase());
        inputguess.clear();
    }
    public static synchronized void playSound(final String url) {
        new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            Main.class.getResourceAsStream("/path/to/sounds/" + url));
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
}