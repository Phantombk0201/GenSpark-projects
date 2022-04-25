package com.company;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    Image image;
    private String pBlank=null;
    private String gMessage = "";
    private int pScore=0;

    MyPanel(int wrong,String blank, String message, int score){
        pBlank = blank;
        gMessage = message;
        pScore = score;
        image = new ImageIcon(getImageName(wrong)).getImage();
        this.setPreferredSize(new Dimension(550,600));
    }
    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        //setting up whit background
        g2D.setPaint(Color.white);
        g2D.fillRect(0,50,550,500);

        //drawing the hangman image
        g2D.drawImage(image,50,50,null);

        g2D.setFont(new Font("Times New Roman",Font.BOLD,23));
        g2D.setPaint(Color.black);
        g2D.drawString(pBlank,20,500);//g2D.drawLine(0,500,500,500);

        //if something is wrong with guess
        g2D.drawString(gMessage,30,545);

        //SET UP THE SCORE
        g2D.setFont(new Font("Times New Roman",Font.BOLD,30));
        g2D.drawString("SCORE",430,45);
        g2D.drawString(pScore+"",475,80);
    }
    public String getImageName(int wrong){
        return "src/Resources/Case"+wrong+".png";
    }
}
