package sample;

import java.util.ArrayList;

public class language {

    /**
     * adds the words to arraylist in the correct language.
     *
     * @param input
     * @return
     */
    public static ArrayList lang(String input) {
        ArrayList<String> toReturn = new ArrayList<String>();

        if (input.equals("Svenska")) { //checks if the user wants swedish as the selected language
            toReturn.add("Vilken svårighetsgrad vill du ha?");
            toReturn.add("Skriv in hur många försök du vill ha"); //adds this line to the arraylist.
            toReturn.add("Vad är din gissning?");
            toReturn.add("Grattis, du hittade ordet!");
            toReturn.add("Du döda en person, och du ska du också dö! Hejdå!");
            toReturn.add("Det var inte ordet! Försök igen!");
            toReturn.add("Du hittade ett bokstav! ");
            toReturn.add("Max antalet gissngar satt till ");
            toReturn.add("Du har redan gissat ");
            toReturn.add("Dina gissnigar är slut. Du död!");
            toReturn.add(" liv kvar!");
            toReturn.add("Enspelarläge eller Flerspelarläge? ");
            toReturn.add("(1) Online eller (2) Lokal?");
            toReturn.add("Spelare 1, välj ord!");
            toReturn.add("Spelare 2, nu ska du gissa efter du valt hur många gissningar!");
            toReturn.add("Ordet är satt!");
            toReturn.add("Enspelarläge");
            toReturn.add("Lokal Flerspelarläge");
            toReturn.add("Online Flerspelarläge kommer snart!");
            toReturn.add("Välj ord");
            toReturn.add("Huvudmenyn");




        } else if (input.equals("English")) {
            toReturn.add("Choose difficulty!"); //1
            toReturn.add("Just type in how many tries you would like.");
            toReturn.add("Whats your guess?"); //3
            toReturn.add("Congratulations! You found the word!");
            toReturn.add("You killed a person and now you will die to. Bye!"); //5
            toReturn.add("That was not the word. Try Again!");
            toReturn.add("You found a letter!"); //6
            toReturn.add("The maxmimum number of guesses is set to ");
            toReturn.add("You have already guessed ");
            toReturn.add("Your guesses are up. You dead!");
            toReturn.add(" lifes left!");
            toReturn.add("Singleplayer or Multiplayer?");
            toReturn.add("(1) Online or (2) Local?");
            toReturn.add("Player 1, choose word!");
            toReturn.add("PLayer 2, now its your turn to guess after you have choosen how many tries you want!");
            toReturn.add("The word is set!");
            toReturn.add("Singleplayer");
            toReturn.add("Local Multiplayer");
            toReturn.add("Online Multiplayer coming soon!");
            toReturn.add("Set Word");
            toReturn.add("Main menu");





        }
        return toReturn;
    }
}
