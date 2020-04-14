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
    public static ArrayList<String>  _EnglishWords = new ArrayList<String> ();
    public static ArrayList<String>  _SwedishWords = new ArrayList<String> ();
    public static ArrayList<String>  _language = new ArrayList<String> (); //this is for multilingual support
    public static String _lang;
    public static String _secretword;
    public static int _guesses = 0;
    public static String _show[] = new String[999];
    public static int _maxguesses = 10;
    public static String _guessletters = "";
    public static Scanner _input = new Scanner(System.in);


    /**
     * This main method is temporary for me to test the code
     * out without having to create a graphical user interface
     * or have it run empty in the background. This will be removed later
     * once i start with the GUI.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        setup();
    }

    public static void setup() throws IOException {
        System.out.println("Choose what language you want.");
        System.out.println("(1) - English");
        System.out.println("(2) - Swedish");
        int temp = _input.nextInt();
        if (temp == 1){     //sets the language
            _lang = "eng";
            GenerateEnglishArray();
            _language = language.lang("eng");
        }
        else if(temp == 2){
            _lang = "swe";
            GenerateSwedishArray();
            _language = language.lang("swe");

        }
        else{
            System.out.println("You dum dum!");
            System.out.println("Language set to default(English)...");
            _lang = "eng";
            GenerateEnglishArray();
            _language = language.lang("eng");
            temp = 1;
    }
        System.out.println(_language.get(11));
        int temp2 = _input.nextInt();
        if(temp2 == 1){
            if(temp == 1){
                GenerateSecretWord("eng");
            }
            else {
                GenerateSecretWord("swe");
            }
            run();
        }
        else{
            System.out.println(_language.get(12));
            System.out.println("sorry only local haha f u");
            int temp3 = _input.nextInt();
            if (temp3 == 1){
                System.out.println("dont be stupppppid only local.. ");
            }
            else{
                System.out.println(_language.get(13));
                String temp4 = _input.nextLine();
                _secretword = temp4;
                for (int i = 0; i < 200; i++) {
                    System.out.println(" ");
                }
                System.out.println(_language.get(15));
                System.out.println(_language.get(14));
                run();
            }
        }


/**
 * Where it calls other methods and takes input and sets language.
 * @throws IOException
 */
    }
    public static void run() throws IOException {
        System.out.println(_language.get(0)); //sets difficulty
        System.out.println(_language.get(1));
        int ans = _input.nextInt();
        _maxguesses = ans;
        System.out.println(_language.get(7) + ans);
        printlines(_secretword);
        while(true){ //guess loop
            for (int i = 0; i < _secretword.length(); i++) {
                System.out.print(_show[i]);
            }
            System.out.println(_language.get(2));
            String guess1 = _input.next().toUpperCase();
            if(Guess(guess1)){
                break;
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
        BufferedReader abc = new BufferedReader(new FileReader("src/sample/english.txt"));
        String s;
        while((s=abc.readLine())!=null) {
            s = s.toUpperCase();
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
        BufferedReader abc = new BufferedReader(new FileReader("src/sample/swedish.txt"));
        String s;
        while((s=abc.readLine())!=null) {
            s = s.toUpperCase();
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
    public static boolean Guess(String guess){
        String returnstring = "";
        Boolean breakIt = false;
        String check ="";
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

        if(winCheck()) {
            System.out.println("worksssss");
            returnstring = "Congrats";

        }

        _guesses++;
        System.out.println(_maxguesses - _guesses + _language.get(10));
        _guessletters += guess;
        System.out.println(_guessletters);
        if(returnstring.equals("Congrats")){ // if you won
            System.out.println(_language.get(3));
            breakIt = true;
        }
        else if(returnstring.equals("already")){ //if you lost. aka the lifes are up
            System.out.println(_language.get(8));
        }
        else if(returnstring.equals("lose")){ //if you lost. aka the lifes are up
            System.out.println(_language.get(5));
            breakIt = true;
        }
        else if(returnstring.equals("notries")){ //if you lost. aka the lifes are up
            System.out.println(_language.get(9));
            breakIt = true;
        }
        else{
            System.out.println(returnstring);
        }
        return breakIt;
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

    public static boolean winCheck(){
        boolean win = true;
        for (int i = 0; i < _secretword.length(); i++) {
            if (_show[i].contains("_")){
                win = false;
            }
        }
        return win;
    }

}
