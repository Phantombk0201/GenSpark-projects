package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Highscore {

    private String filePath = "src/resources/Highscore";


    Highscore(int score, String username){
        //set begining place and current highscore
        ArrayList<String> highscore = scoreBank();
        int place=10;

        //get new score place
        place = place(highscore,score,place);

        if(place<11){
            highscore= updateHighscore(place,username, score, highscore);
            highscore.remove(place+1);
            try{
                FileWriter writer = new FileWriter(filePath);
                writer.write(hToString(highscore,0,"")+"\n");

                writer.close();
            }catch (Exception e){
                System.out.println("File Not Found");
            }

        }




    }
    //getting the list of scores
    public ArrayList<String> scoreBank(){
        try{
            return new ArrayList<>(Files.readAllLines(Path
                    .of(filePath)));
        }catch (Exception e){
            ArrayList<String> err = new ArrayList<>();
            err.add("File Not Found");
            return err;
        }
    }

    //get player's place
    public int place(ArrayList<String>highscore, int score, int currentHolder){
        if(currentHolder>0) {
            String[] holder = highscore.get(currentHolder-1).split(":");
            //if player is greater
            if (Integer.parseInt(holder[1]) < score) {
                return place(highscore, score, --currentHolder);
            }else if (Integer.parseInt(holder[1])== score){
                return currentHolder+1;
            } else {
                return currentHolder;
            }
        }
        return currentHolder;
    }

    //updates the arrayplacement
    public ArrayList<String> updateHighscore(int place, String username, int score, ArrayList<String> highscore){
        place++;
        String entry= place+"." + username + ":" + score;

        if(place == 10){highscore.add(entry);}
        else{ highscore.add(place-1,entry);}

        return highscore = updateHighscore(place,highscore);
    }

    //updates the text of the placement
    public ArrayList<String> updateHighscore(int currentHolder, ArrayList<String> highscore){
        String[] holder = highscore.get(currentHolder).split("\\.");

        if(Integer.parseInt(holder[0])<10) {
            highscore = updateHighscore(currentHolder+1,highscore);
            highscore.remove(currentHolder+1);
            highscore.add(currentHolder+1,(Integer.parseInt(holder[0]) + 1)+"."+holder[1]);

        }
        return highscore;
    }


    //highscore to string
    public String hToString(ArrayList<String>highscore, int index, String str){
        if(index<highscore.size()){
            String tempStr = highscore.get(index)+"\n";
            index++;
            str=tempStr+hToString(highscore,index,str);
        }
        return str;
    }
}
