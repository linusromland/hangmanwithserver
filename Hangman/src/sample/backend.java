package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class backend {
    /**
     * Intiliazies some variables for use.
     */
    public static ArrayList<String>  _EnglishWords = new ArrayList<String> ();
    public static ArrayList<String>  _SwedishWords = new ArrayList<String> ();
    public static ArrayList<String>  _language = new ArrayList<String> (); //this is for multilingual support
    public static String lang;
    public static String _secretword;
    public static int _guess = 0;
    public static String _show[] = new String[999];
    public static int _maxguesses = 10;

    /**
     * This main method is temporary for me to test the code
     * out without having to create a graphical user interface
     * or have it run empty in the background. This will be removed later
     * once i start with the GUI.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        run();
    }

    /**
     * Where it calls other methods and takes input and sets language.
     * @throws IOException
     */
    public static void run() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose language...");
        System.out.println("1 for English");
        System.out.println("0 for Swedish");
        int temp = input.nextInt();
        if (temp == 1){     //sets the language
            lang = "eng";
            GenerateEnglishArray();
            GenerateSecretWord("eng");
            _language = language.lang("eng");
        }
        else if(temp == 0){
            lang = "swe";
            GenerateSwedishArray();
            GenerateSecretWord("swe");
            _language = language.lang("swe");

        }
        else{
            System.out.println("You dum dum!");
            System.out.println("Language set to default(English)...");
            lang = "eng";
            GenerateEnglishArray();
            GenerateSecretWord("eng");
            _language = language.lang("eng");

        }
        System.out.println(_language.get(0)); //sets difficulty
        System.out.println(_language.get(1));
        int ans = input.nextInt();
        _maxguesses = ans;
        System.out.println(_language.get(7) + ans);
        printlines(_secretword);
        while(true){ //guess loop
            for (int i = 0; i < _secretword.length(); i++) {
                System.out.print(_show[i]);
            }
            System.out.println(_language.get(2));
            String guess1 = input.next();
            if((Guess(guess1)).equals("Congrats")){ // if you won
                System.out.println(_language.get(4));
                break;
            }
            else if(Guess(guess1).equals("lose")){ //if you lost. aka the lifes are up
                System.out.println(_language.get(5));
                break;
            }
            else{
                System.out.println(Guess(guess1));
            }
        }
    }

    /**
     * generates the secret words if the correct language from the right libary of words.
     * @param Language
     */
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

    /**
     * imports the array of english words
     * @throws IOException
     */

    public static void GenerateEnglishArray() throws IOException {
        //English words from https://www.ef.com/wwen/english-resources/english-vocabulary/top-1000-words/
        BufferedReader abc = new BufferedReader(new FileReader("/Users/linusromland/GitHub/hangmanwithserver/Hangman/src/sample/english.txt"));
        String s;
        while((s=abc.readLine())!=null) {
            _EnglishWords.add(s);
        }
        abc.close();


    }
    /**
     * imports the array of swedish words
     * @throws IOException
     */
    public static void GenerateSwedishArray() throws IOException {
        //Swedish words from https://www.101languages.net/swedish/most-common-swedish-words/
        BufferedReader abc = new BufferedReader(new FileReader("/Users/linusromland/GitHub/hangmanwithserver/Hangman/src/sample/swedish.txt"));
        String s;
        while((s=abc.readLine())!=null) {
            _SwedishWords.add(s); //adds one line at the type from the text file
        }
        abc.close();


    }
        public static String toSmallLetters(String input){
        return input.toLowerCase();
    }

    /**
     * This is where it checks the guess and print the correct
     * @param guess
     * @return
     */
    public static String Guess(String guess){
        String returnstring = "";
        if(_guess < _maxguesses) { //checks if you have any lives left
            if (guess.length() > 1) { //checks if you guessed a word or char.
                if (guess.equals(_secretword)) { //checks if you got the word right
                   returnstring = "Congrats";
                }
                else{
                    returnstring = _language.get(5);
                }
            }
            else{
                if(_secretword.contains(guess)){ //checks if the word contains the letter
                    returnstring =_language.get(6);
                    for (int i = 0; i < _secretword.length(); i++) {
                        if(_secretword.charAt(i) == guess.charAt(0)){
                            _show[i] = guess.toUpperCase().charAt(0) + "  ";
                        }
                    }
                }
            }
        }
        else{
            returnstring = "lose";
        }
        _guess++;
        return returnstring;
    }

    //generates the line where you can see the how many letters and all of that.
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
