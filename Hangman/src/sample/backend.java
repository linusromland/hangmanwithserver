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
     * @param Language
     */
    public static String GenerateSecretWord(String Language) {
        if (Language.equals("English")) {
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
        BufferedReader abc = new BufferedReader(new FileReader("src/sample/english.txt"));
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
        BufferedReader abc = new BufferedReader(new FileReader("src/sample/swedish.txt"));
        String s;
        while ((s = abc.readLine()) != null) {
            s = s.toUpperCase();
            _SwedishWords.add(s); //adds one line at the type from the text file
        }
        abc.close();
        return _SwedishWords;


    }

}
