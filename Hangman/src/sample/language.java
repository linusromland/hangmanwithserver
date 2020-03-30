package sample;

import java.util.ArrayList;

public class language {

    /**
     * adds the words to arraylist in the correct language.
     * @param input
     * @return
     */
    public static ArrayList lang(String input){
        ArrayList<String> toReturn = new ArrayList<String> ();

        if(input.equals("swe")){ //checks if the user wants swedish as the selected language
            toReturn.add("Vilken svårighetsgrad vill du ha?");
            toReturn.add("Skriv in hur många försök du vill ha"); //adds this line to the arraylist.
            toReturn.add("\nVad är din gissning?");
            toReturn.add("Grattis, du hittade ordet!");
            toReturn.add("Du döda en person, och du ska du också dö! Hejdå!");
            toReturn.add("Det var inte ordet! Försök igen!");
            toReturn.add("Du hittade ett bokstav! ");
            toReturn.add("Max antalet gissngar satt till ");
            toReturn.add("Du har redan gissat ");
        }
        else if(input.equals("eng")){
            toReturn.add("Choose difficulty!");
            toReturn.add("Just type in how many tries you would like.");
            toReturn.add("\nWhats your guess?");
            toReturn.add("Congratulations! You found the word!");
            toReturn.add("You killed a person and now you will die to. Bye!");
            toReturn.add("That was not the word. Try Again!");
            toReturn.add("You found a letter!");
            toReturn.add("The maxmimum number of guesses is set to ");
            toReturn.add("You have already guessed ");
        }
        return toReturn;
    }
}