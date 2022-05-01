package com.company;

import javax.swing.*;
import java.awt.*;

public class MyWarPanel extends JPanel {
    Image image;
    private int[] landXY= new int[2],
            playerXY= new int[2], enemyXY=new int[2], enemy2XY=new int[2], enemy3XY=new int[2];
    private int height;
    private char pFace,e1Face,e2Face,e3Face;
    //giving the message if action was taken
    private String pMessage, g1Message, g2Message, g3Message;

    MyWarPanel(Human player,Land land,
               Goblin enemy1,Goblin enemy2,Goblin enemy3,
               String pMessage){
        this.pMessage = pMessage;
        g1Message = enemy1.getGMessage();
        g2Message = enemy2.getGMessage();
        g3Message = enemy3.getGMessage();
        //setting player enemys locations
        setLandXY(land);
        setPlayerLocation(player);
        setEnemy1Location(enemy1);
        setEnemy2Location(enemy2);
        setEnemy3Location(enemy3);

        this.setPreferredSize(new Dimension(820,600));
    }
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        //setting background color;
        g2.setPaint(new Color(110, 247, 110));
        g2.fillRect(0,0,820,700);
        //setting background color;
        g2.setPaint(new Color(88, 83, 83));
        g2.fillRect(600,0,220,300);

        //draw land
        drawLand(g2,25,25,0,0);

        //draw Messages
        g2.setFont(new Font("Times New Roman",Font.BOLD,23));
        g2.setPaint(Color.black);
        g2.drawString(pMessage,150,595);
        g2.setPaint(Color.green);

        gobUpdate(g2, 20,1);
        gobUpdate(g2, 100,2);
        gobUpdate(g2, 180,3);

//        g2.drawString("3."+gMessage,610,220);
    }
    public String getImage(int width){
        if (playerXY[1] == height && playerXY[0] == width) {
            return "src/resources/GrassP"+pFace+".jpg";
        }else if (enemyXY[1] == height && enemyXY[0]== width){
            return "src/resources/GrassG"+e1Face+".jpg";
        }else if (enemy2XY[1] == height && enemy2XY[0]== width){
            return "src/resources/GrassG"+e2Face+".jpg";
        }else if (enemy3XY[1] == height && enemy3XY[0]== width){
            return "src/resources/GrassG"+e3Face+".jpg";
        }
        return "src/resources/GrassOS.jpg";
    }
    //draw hieght
    public void drawLand(Graphics2D g,int x,int y,int heigth,int width){
        this.height = heigth;
        drawLand(g,x,y,width);
        if(heigth< landXY[1]){
            drawLand(g,25,y+50,++heigth,0);
        }
    }
    //draw width
    public void drawLand(Graphics2D g,int x,int y,int width){
        image = new ImageIcon((getImage(width))).getImage();
        g.drawImage(image,x,y,null);
        if(width< landXY[0]){
            drawLand(g,x+50,y,++width);
        }
    }

    public void setPlayerLocation(Human player){
        playerXY[0] = player.getxCoord();
        playerXY[1] = player.getyCoord();
        pFace = player.getFacing();
    }
    public void setEnemy1Location(Goblin enemy){
        enemyXY[0] = enemy.getxCoordinate();
        enemyXY[1] = enemy.getyCoordinate();
        e1Face = enemy.getFacing();

    }
    public void setEnemy2Location(Goblin enemy){
        enemy2XY[0] = enemy.getxCoordinate();
        enemy2XY[1] = enemy.getyCoordinate();
        e2Face = enemy.getFacing();}
    public void setEnemy3Location(Goblin enemy){
        enemy3XY[0] = enemy.getxCoordinate();
        enemy3XY[1] = enemy.getyCoordinate();
        e3Face = enemy.getFacing();}
    public void setLandXY(Land land){
        landXY[0] = land.getLongitude();
        landXY[1] = land.getLatitude();
    }

    public void gobUpdate(Graphics2D g, int y, int gobNum){
        //drawing the goblin updates
        String[] holder;
        //selecting which goblin to display
        if(gobNum == 1){ holder = g1Message.split(" ");}
        else if(gobNum == 2){ holder = g2Message.split(" ");}
        else{ holder = g3Message.split(" ");}

        int x = 610;
        String output= gobNum+".";
        for(int count = 0;count<3;count++){if(holder.length>count){output = output + " "+holder[count];}}
        g.drawString( output.trim(),x,y);
        output = "";
        //print second line
        for(int count = 3;count<7;count++){
            if(holder.length>count){output = output +holder[count]+ " ";}
        }
        g.drawString( output.trim(),x,y+30);
        output = "";
        //print third line
        for(int count = 7;count<10;count++){
            if(holder.length>count){output = output +holder[count]+ " ";}
        }
        g.drawString( output.trim(),x,y+60);
        output = "";
    }
}
