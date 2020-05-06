package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class backend {
    /**
     * Intiliazies some variables for use.
     */
    public static ArrayList<String> _EnglishWords = new ArrayList<String>();
    public static ArrayList<String> _SwedishWords = new ArrayList<String>();
    public static String _secretword;


    /**
     * generates the secret words if the correct language from the right libary of words.
     *
     * @param Language
     */
    public static String GenerateSecretWord(String Language) {
        if (Language.equals("English")) { //checks what language and then generating the correct word.
            int high = _EnglishWords.size();
            int thenumber = new Random().nextInt(high) + 0;
            _secretword = _EnglishWords.get(thenumber);
        } else {
            int high = _SwedishWords.size();
            int thenumber = new Random().nextInt(high) + 0;
            _secretword = _SwedishWords.get(thenumber);
        }
        return _secretword;

    }

    /**
     * Simple method that checks the language and generates the correct array.
     * @param in
     * @return
     * @throws IOException
     */
    public static ArrayList<String> generatewordlist(String in) throws IOException {
        if (in.equals("Svenska")) {
            return GenerateSwedishArray();
        } else {
            return GenerateEnglishArray();
        }

    }

    /**
     * imports the array of english words
     *
     * @throws IOException
     */

    public static ArrayList<String> GenerateEnglishArray() throws IOException {
        //English words from https://www.ef.com/wwen/english-resources/english-vocabulary/top-1000-words/
        BufferedReader abc = new BufferedReader(new FileReader("src/sample/languages/english.txt"));
        String s;
        while ((s = abc.readLine()) != null) {
            s = s.toUpperCase();
            _EnglishWords.add(s);
        }
        abc.close();
        return _EnglishWords;

    }


    /**
     * imports the array of swedish words
     *
     * @throws IOException
     */
    public static ArrayList<String> GenerateSwedishArray() throws IOException {
        //Swedish words from https://www.101languages.net/swedish/most-common-swedish-words/
        BufferedReader abc = new BufferedReader(new FileReader("src/sample/languages/swedish.txt"));
        String s;
        while ((s = abc.readLine()) != null) {
            s = s.toUpperCase();
            _SwedishWords.add(s); //adds one line at the type from the text file
        }
        abc.close();
        return _SwedishWords;
    }

    //generates the line where you can see the how many letters and all of that.
    public static String[] printlines(String input) {
        String[] show = new String[999];
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                show[i] = "___ "; //prints __ or spaces.
            } else {
                show[i] = "   ";
            }
        }
        return show;
    }

    public static String stringarraytostring(String[] input) { //simple method that takes Array and creates it to a String.
        String output = "";
        for (int i = 0; i < _secretword.length(); i++) {
            output = output + input[i];
        }
        return output;
    }

}
