package com.company;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class WordSelect {
    String selectedWord;
    WordSelect(){
        ArrayList<String> wordBank = wordBank();
        int size = wordBank.size();
        selectedWord = wordBank.get(ThreadLocalRandom.current().nextInt(0,size));
    }
    //getting the list of words
    public ArrayList<String> wordBank(){
        try{
            return new ArrayList<>(Files.readAllLines(Path
                    .of("src/resources/Word_Bank")));
        }catch (Exception e){
            ArrayList<String> err = new ArrayList<>();
            err.add("File not found.");
            return err;
        }
    }

    public int getSize(){return selectedWord.length();}
    public Boolean contains(char c){
        return selectedWord.contains(c+"");
    }
    public ArrayList<Integer> getIndex(ArrayList<Integer> index,char c,int count){
        if(count<getSize()){
            getIndex(index,c,++count);
            if(selectedWord.charAt(count-1)==c){
                index.add(count-1);
            }
        }
        return index;
    }
}
