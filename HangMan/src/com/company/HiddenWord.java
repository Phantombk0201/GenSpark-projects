package com.company;

import lombok.Setter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Locale;

@Getter
@Setter
public class HiddenWord {
    //setting the char length and dividing the word into individual characters
    private int charLength;
    private ArrayList<Character> word = new ArrayList<>();

    //testing if the word contain the leter
    public boolean guess(char guess){
        if(Character.isUpperCase(guess)){
            guess = Character.toLowerCase(guess);
        }
        boolean conLet = false;
        if(word.contains(guess)){
            conLet = true;
        }else{
           Main.setAttempt();
        }
        return conLet;
    }

    //setting the word and fill in blanks(called only when the word has be inputted)
    public HiddenWord(String word) {
        //putting the word in an arraylist
        word = word.toLowerCase();
        for(int i = 0;i<word.length();i++){
            this.word.add(word.charAt(i));
        }
        //setting the char length
        charLength = this.word.size();
        //calling fill out to fill out the array with blanks
        FillOutTheBlank blank = new FillOutTheBlank();
        blank.setBlank(word);
    }

    //getting the character to test if guess and the character are the same
    public Character getChar(int index){
        return word.get(index);
    }
    //test if the guess in the word
//    public boolean conLet(char guess){
//        boolean conLet = false;
//        if(word.contains(guess)){
//            conLet = true;
//        }
//        return conLet;
//    }
    public HiddenWord(){}
}
