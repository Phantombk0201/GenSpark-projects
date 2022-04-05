package com.company;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

@Getter
@Setter
public class Main {
    private static int attempt = 0;
    public static void main(String[] args) {
	// write your code here

        Scanner scan = new Scanner(System.in);
        //loop for multiple plays
        for (int r = 0;r<1;){
            try {


                //word has been chosen
                System.out.println("Player 1 please enter the word you would like to use.");
                String word = scan.next();

                //setting the hidden word
                HiddenWord sWord = new HiddenWord(word.toLowerCase());

                //setting the blank spaces
                FillOutTheBlank blank = new FillOutTheBlank();
                blank.setBlank(word);

                //loop for guessess
                guess(sWord, blank);

                System.out.println("Would you like to play again?(1 for yes or 0 for no)");
                int play= scan.nextInt();
                if(play == 0){
                    r++;
                }

            }catch (Exception e){
                System.out.println("The Error: " + e);
            }
        }
    }
    public static void guess(HiddenWord word, FillOutTheBlank blank){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n" +"\n" +"\n" +"\n" +"\n" +"\n" +"\n" +"\n" +"\n" +"\n" +"\n" +"\n" +"\n");
        do{
            //getting guess letter
            System.out.println("Player 2 please enter the letter you would like to guess");
            String guess = scan.next();
            if(guess.length() == 1){
                if(blank.guess(guess.toLowerCase().charAt(0))){//testing if the guess was already guess
                    if(word.guess(guess.toLowerCase().charAt(0))){//testing if the word contains the guess
                        for(int i = 0; i<word.getCharLength();i++){//replacing the blanks with letter
                            char cHolder = word.getChar(i);
                            if(cHolder == guess.charAt(0)){
                                blank.replaceBlank(guess.charAt(0),i);
                            }
                        }
                    }
                }
            }else{
                System.out.println("Please enter a single letter.");
            }
            new Hangman(attempt);
            blank.printBlank();
            if(blank.getCounter()==word.getCharLength()){
                System.out.println("CONGRATULATIONS!!! PLAYER 2 HAS WON.");
                break;
            }
        }while (attempt<6);
    }
    public static void setAttempt(){
        attempt++;
    }
}
