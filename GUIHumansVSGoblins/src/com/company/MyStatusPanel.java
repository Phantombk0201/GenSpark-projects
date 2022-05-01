package com.company;

import javax.swing.*;
import java.awt.*;

public class MyStatusPanel extends JPanel {
    private String[] status;
    private int humanOrGoblin;
    MyStatusPanel(String status, int humanOrGoblin ){
        this.humanOrGoblin = humanOrGoblin;
        this.status = status.split(",");
        this.setPreferredSize(new Dimension(280,240));
    }
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        //setting background color;
        g2.setPaint(new Color(0, 52, 154));
        g2.fillRect(0,0,600,700);

        //draw status
        g2.setFont(new Font("Times New Roman",Font.BOLD,23));
        //setting the different colors for goblin and human
        if(humanOrGoblin == 0){g2.setPaint(new Color(255, 255, 102));}
        else if(humanOrGoblin ==1){g2.setPaint(new Color(255, 38, 93));}
        else if(humanOrGoblin ==2){g2.setPaint(new Color(128, 225, 255));}
        else if(humanOrGoblin ==3){g2.setPaint(new Color(0, 255, 0));}

        int space = 80;
        for (String m: status) {
            g2.drawString(m,65,space);
            space=space+25;
        }
    }
}
