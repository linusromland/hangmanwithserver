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

    public static ArrayList getPacks() {
        File[] packs = new File("src/sample/resourcepacks/").listFiles(); //Get all packs from packs folder

        ArrayList<File> out = new ArrayList<>();
        Collections.addAll(out, packs);
        return out;
    }

    public static void selectPack(String pack, GridPane main) {
        System.out.println("new pack selected: " + pack);

        selectedPack = pack;

        main.getStylesheets().clear();
        main.getStylesheets().add("sample/resourcepacks/" + pack + "/style.css");
    }

    public static void loadDefaultPack(GridPane main) {
        main.getStylesheets().add("sample/resourcepacks/default/style.css");
    }
}