package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class Controller {
    @FXML
    private Text actiontarget;

    @FXML
    private ComboBox res;



    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Works!");
    }

    @FXML
    public void initialize() throws IOException {
        res.getItems().addAll("800x600", "1280x720");
        backend.run();
    }



}