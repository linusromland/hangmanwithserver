package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class backend {

    public static ArrayList<String>  _EnglishWords = new ArrayList<String> ();
    public static ArrayList<String>  _SwedishWords = new ArrayList<String> ();
    public static String lang;
    public static String _secretword;
    public static int _guess;
    public static String _show[] = new String[999];


    public static void main(String[] args) throws IOException {
        /*
            This main method is temporary for me to test the code
            out without having to create a graphical user interface
            or have it run empty in the background. This will be removed later
            once i start with the GUI.
         */
        run();
    }

    public static void run() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose lang...");
        System.out.println("1 for English");
        System.out.println("0 for Swedish");
        int temp = input.nextInt();
        if (temp == 1){
            lang = "eng";
            GenerateEnglishArray();
            GenerateSecretWord("eng");
        }
        else if(temp == 0){
            lang = "swe";
            GenerateSwedishArray();
            GenerateSecretWord("swe");
        }
        else{
            System.out.println("You dum dum!");
            System.out.println("Language set to default(English)...");

            lang = "eng";
            GenerateEnglishArray();
            GenerateSecretWord("eng");
        }
        printlines(_secretword);
        while(true){
            for (int i = 0; i < _secretword.length(); i++) {
                System.out.print(_show[i]);
            }
            System.out.println("\nwhats your guess?");
            String guess1 = input.next();
            if((Guess(guess1)).equals("Congrats")){
                System.out.println("Congrats you found the word");
                break;
            }
            else{
                System.out.println(Guess(guess1));
            }
        }
    }

    private static void GenerateSecretWord(String Language) {
        if(Language.equals("eng")){
            int high = _EnglishWords.size();
            int thenumber = new Random().nextInt(high) + 0;
            _secretword =  _EnglishWords.get(thenumber);
        }
        else{
            int high = _SwedishWords.size();
            int thenumber = new Random().nextInt(high) + 0;
            _secretword =  _SwedishWords.get(thenumber);
        }


    }

    public static void GenerateEnglishArray() throws IOException {
        //English words from https://www.ef.com/wwen/english-resources/english-vocabulary/top-1000-words/
        BufferedReader abc = new BufferedReader(new FileReader("/Users/linusromland/GitHub/hangmanwithserver/Hangman/src/sample/english.txt"));
        String s;
        while((s=abc.readLine())!=null) {
            _EnglishWords.add(s);
        }
        abc.close();


    }
    public static void GenerateSwedishArray() throws IOException {
        //Swedish words from https://www.101languages.net/swedish/most-common-swedish-words/
        BufferedReader abc = new BufferedReader(new FileReader("/Users/linusromland/GitHub/hangmanwithserver/Hangman/src/sample/swedish.txt"));
        String s;
        while((s=abc.readLine())!=null) {
            _SwedishWords.add(s);
        }
        abc.close();


    }
        public static String toSmallLetters(String input){
        return input.toLowerCase();
    }
    public static String Guess(String guess){
        String returnstring = "";
        if(_guess < 10) {
            if (guess.length() > 1) {
                if (guess.equals(_secretword)) {
                   returnstring = "Congrats";

                }
                else{
                    returnstring = "You got it wrong";
                }
            }
            else{
                if(_secretword.contains(guess)){
                    returnstring ="You found a letter!";
                    for (int i = 0; i < _secretword.length(); i++) {
                        if(_secretword.charAt(i) == guess.charAt(0)){
                            _show[i] = guess.toUpperCase().charAt(0) + "  ";
                        }
                    }
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
                _show[i] = "___ ";
            } else {
                _show[i] = "   ";
            }
        }
    }
}
