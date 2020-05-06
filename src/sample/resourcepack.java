package sample;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class resourcepack {

    public static String selectedPack;

    /**
     * checks the resourcepack folder and also adds them to the combobox.
     * @return
     */
    public static ArrayList getPacks() {
        File[] packs = new File("src/sample/resourcepacks/").listFiles(); //Get all packs from packs folder

        ArrayList<File> out = new ArrayList<>();
        Collections.addAll(out, packs);
        return out;
    }

    /**
     * selects the resourcepack.
     * @param pack
     * @param main
     */
    public static void selectPack(String pack, GridPane main) {
        System.out.println("new pack selected: " + pack);

        selectedPack = pack;

        main.getStylesheets().clear();
        main.getStylesheets().add("sample/resourcepacks/" + pack + "/style.css");
    }

    /**
     * loads the default pack.
     * @param main
     */
    public static void loadDefaultPack(GridPane main) {
        main.getStylesheets().add("sample/resourcepacks/default/style.css");
    }

    /**
     * creats the sound dir for the sound files coresponding to the right resourcepack. 
     * @return
     */
    public static String soundircreate(){
        return "src/sample/resourcepacks/" + selectedPack + "/sounds/";
    }
}