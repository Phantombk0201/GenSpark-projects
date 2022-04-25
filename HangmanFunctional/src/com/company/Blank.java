package com.company;

import java.util.ArrayList;
import java.util.Locale;

public class Blank {

    private WordSelect word = new WordSelect();
    private ArrayList<String> blank1 = new ArrayList<>();
    private String strBlank = "";
    private int wrong;


    Blank() {
        wrong = 0;
        setStrBlank(0);
        getStrBlank(word.getSize());
         
    }
    //setts blank1 to string blank and returns strBlank
    public String getStrBlank(int count) {
        if (count > 0) {
            getStrBlank(--count);
            strBlank = strBlank + blank1.get(count);
        }
        return strBlank;
    }
    public String getStrBlank() {
        return strBlank;
    }
    public void clearStrBlank() {strBlank = "";}//to clear strblank so it does not duplicate
    //sets completely blank
    public void setStrBlank(int count) {
        if (count < word.getSize()) {
            setStrBlank(++count);
            blank1.add("__ ");}}
    public void setBlank(ArrayList<Integer> i, char c, int count) {
        if (count < i.size()) {
            blank1.set(i.get(count), String.valueOf(c).toUpperCase(Locale.ROOT) + " ");
            setBlank(i, c, ++count);
        }
    }//sets with new characters

    public int getWrong() {
        return wrong;
    }

    //checkes if the word cantians the characte r ifso returns it he index of the
    public ArrayList<Integer> contains(char c){
        ArrayList<Integer> index = new ArrayList<>();
        if(word.contains(c)){
            word.getIndex(index, c, 0);
            setBlank(index, c, 0);
            clearStrBlank();
            getStrBlank(word.getSize());
        }else{
            wrong++;
        }
        return index;
    }

}
