package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class backend {

    public static ArrayList<String>  _EnglishWords = new ArrayList<String> ();
    public static ArrayList<String>  _SwedishWords = new ArrayList<String> ();
    public static String _secretword;
    public static int _guess;
    public static String _show = "";

    public static void run() throws IOException {
        GenerateEnglishArray();
        GenerateSecretWord("eng");
        printlines(_secretword);
        System.out.println(_show);
        //GenerateSwedishArray();
    }

    private static void GenerateSecretWord(String Language) {
        if(Language.equals("eng")){
            int high = _EnglishWords.size();
            int thenumber = new Random().nextInt(high) + 0;
            _secretword =  _EnglishWords.get(thenumber);
            System.out.println(_secretword);
        }
        else{

        }
    }

    public static void GenerateEnglishArray() throws IOException {
        BufferedReader abc = new BufferedReader(new FileReader("/Users/linusromland/GitHub/Cloudremover-java/Hangman/src/sample/english.txt"));
        String s;
        while((s=abc.readLine())!=null) {
            _EnglishWords.add(s);
            System.out.println(s);
        }
        abc.close();


    }
    public static void GenerateSwedishArray() throws IOException {
        BufferedReader abc = new BufferedReader(new FileReader("/Users/linusromland/GitHub/Cloudremover-java/Hangman/src/sample/swedish.txt"));
        String s;
        while((s=abc.readLine())!=null) {
            _SwedishWords.add(s);
            System.out.println(s);
        }
        abc.close();


    }
        public static String toSmallLetters(String input){
        return input.toLowerCase();
    }
    public static String Guess(String Guess){
        String returnstring = "what";
        if(_guess < 10) {
            if (Guess.length() > 1) {
                if (Guess.equals(_secretword)) {
                   returnstring = "Congrats";
                }
                else{
                    returnstring = "You got it wrong";
                }
            }
            else{
                if(_secretword.contains(Guess)){
                    returnstring ="You found a word!";
                }
            }
        }
        else{
            returnstring = "Your out of lives!";
        }
        return returnstring;
    }
    public static void printlines(String input){
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                _show += "_ ";
            } else {
                _show += "  ";
            }
        }
    }
}
