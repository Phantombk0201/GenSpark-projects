package com.company;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ScorePanel extends JPanel {
    private String filePath = "src/resources/Highscore";
    private ArrayList<String> highscore = scoreBank();
    ScorePanel(){
        this.setPreferredSize(new Dimension(450,350));
    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        //setting up  background
        g2D.setPaint(new Color(252, 211, 89, 255));
        g2D.fillRect(0,0,550,50);
        g2D.setPaint(new Color(255, 255, 255, 255));
        g2D.fillRect(0,50,550,500);


        g2D.setFont(new Font("Times New Roman",Font.BOLD,23));
        g2D.setPaint(Color.black);
        //title
        g2D.drawString("________HIGHSCORE_________",50,40);
        //DISPLAY SCORE
        g2D.drawString(highscore.get(0),50,80);g2D.drawString(highscore.get(5),280,80);
        g2D.drawString(highscore.get(1),50,120);g2D.drawString(highscore.get(6),280,120);
        g2D.drawString(highscore.get(2),50,160);g2D.drawString(highscore.get(7),280,160);
        g2D.drawString(highscore.get(3),50,200);g2D.drawString(highscore.get(8),280,200);
        g2D.drawString(highscore.get(4),50,240); g2D.drawString(highscore.get(9),280,240);







    }
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


}
