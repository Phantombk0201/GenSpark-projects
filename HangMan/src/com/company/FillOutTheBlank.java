package com.company;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;

@Getter
public class FillOutTheBlank {
    private ArrayList<Character> blank = new ArrayList<>();
    private HashSet<Character> guessed = new HashSet<>();
    private int counter = 0;

    public FillOutTheBlank(){}

    //setting the blanks for the guessing
    public void setBlank(String word){
        int charLength = word.length();
        for(int x = 0; x<charLength;x++){
            blank.add('_');
        }
        System.out.println(blank);
    }
    //testing if the guess is new
    public boolean guess(char guess){
        if(Character.isUpperCase(guess)){
            guess = Character.toLowerCase(guess);
        }
        boolean newGuess = false;
        if(guessed.contains(guess)){
            System.out.println("You have already guessed that letter");
        }else{
            guessed.add(guess);
            newGuess =true;
        }
        return newGuess;
    }
    //replace _ with the guess
    public void replaceBlank(char guess, int index){
            blank.remove(index);
            blank.add(index, guess);
            counter++;
    }
    //to print the word after each guess
    public void printBlank(){
        for(int i =  0;i<blank.size();i++){
            System.out.print(blank.get(i));
        }
        System.out.println("");
    }
}
