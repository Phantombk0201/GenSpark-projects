package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HumansVSGoblins extends JFrame implements ActionListener {
    //creatting the land player and enemys;
    Land land = new Land();
    Human player= new Human(land);
    Goblin enemy1=new Goblin(land)
            ,enemy2=new Goblin(land)
            ,enemy3=new Goblin(land);
    //creating what will be displayed on the jframe
    MyWarPanel panel;
    JButton upBtn,doBtn,leBtn,riBtn,stBtn;
    //keeping score
    private int score = 0;

    private int moves = player.getMove();

    //makes it easier to move buttons
    private int x = 670;
    private int y = 325;

    HumansVSGoblins(){
        panel = new MyWarPanel(player,land,
                enemy1,enemy2,enemy3,"");
        player.setEnemyLocation(enemy1,enemy2,enemy3);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUpButton();
        setDownButton();
        setRightButton();
        setLeftButton();
        setStatusButton();

        this.add(panel);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = "";
        moves = moves -1;
        player.setEnemyLocation(enemy1,enemy2,enemy3);

        if(e.getSource()==upBtn){
            int moved = player.setyCoord(player.getyCoord()-1);
            player.setFacing('W');

            if(moved == -1){
                message = "\"The Hero may not move that far!!!\"";
            }
            if(moved == 1){
                message = "\"The Hero attack the goblin!!\"";
                player.attack(enemy1);
            }
            if(moved == 2){
                message = "\"The Hero attack the goblin!!\"";
                player.attack(enemy2);
            }
            if(moved == 3){
                message = "\"The Hero attack the goblin!!\"";
                player.attack(enemy3);
            }
        }
        if(e.getSource()==doBtn){
            int moved = player.setyCoord(player.getyCoord()+1);
            player.setFacing('S');

            if(moved == -1){
                message = "\"The Hero may not move that far!!!\"";
            }
            if(moved == 1){
                message = "\"The Hero attack the goblin!!\"";
                player.attack(enemy1);
            }
            if(moved == 2){
                message = "\"The Hero attack the goblin!!\"";
                player.attack(enemy2);
            }
            if(moved == 3){
                message = "\"The Hero attack the goblin!!\"";
                player.attack(enemy3);
            }
        }
        if(e.getSource()==leBtn){
            int moved = player.setxCoord(player.getxCoord()-1);
            player.setFacing('A');

            if(moved == -1){
                message = "\"The Hero may not move that far!!!\"";
            }
            if(moved == 1){
                message = "\"The Hero attack the goblin!!\"";
                player.attack(enemy1);
            }
            if(moved == 2){
                message = "\"The Hero attack the goblin!!\"";
                player.attack(enemy2);
            }
            if(moved == 3){
                message = "\"The Hero attack the goblin!!\"";
                player.attack(enemy3);
            }
        }
        if(e.getSource()==riBtn){
            int moved = player.setxCoord(player.getxCoord()+1);
            player.setFacing('D');

            if(moved == -1){
                message = "\"The Hero may not move that far!!!\"";
            }
            if(moved == 1){
                message = "\"The Hero attack the goblin!!\"";
                player.attack(enemy1);
            }
            if(moved == 2){
                message = "\"The Hero attack the goblin!!\"";
                player.attack(enemy2);
            }
            if(moved == 3){
                message = "\"The Hero attack the goblin!!\"";
                player.attack(enemy3);
            }
        }

        if(e.getSource()==stBtn){
            moves++;
            new Status(player,enemy1,enemy2,enemy3);
        }

        System.out.println("moves left:"+moves);
        //move goblins
        if(moves ==0){
            moves = player.getMove();
            enemy1.move(player,land);
            enemy2.move(player,land);
            enemy3.move(player,land);
            message = "";
        }

        //lost
        if(player.getDeath()){
            if (enemy1.getDeath()){score = score +5;}
            if (enemy2.getDeath()){score = score +5;}
            if (enemy3.getDeath()){score = score +5;}

            int results = JOptionPane.showConfirmDialog(this,
                    "Your final score: " + score,
                    "Continue?",JOptionPane.YES_NO_OPTION);
            if(results == 1 ){System.exit(0);}
            else{
                player = new Human(land);
                enemy1 = new Goblin(land);
                enemy2 = new Goblin(land);
                enemy3 = new Goblin(land);
            }
        }

        //if goblin died
        if (enemy1.getDeath()){enemy1.setGMessage("The goblin has died!");}
        if (enemy2.getDeath()){enemy2.setGMessage("The goblin has died!");}
        if (enemy3.getDeath()){enemy3.setGMessage("The goblin has died!");}
        if(enemy1.getDeath()&&enemy2.getDeath()&&enemy3.getDeath()){
            score = score + 15;
            enemy1 = new Goblin(land);
            enemy2 = new Goblin(land);
            enemy3 = new Goblin(land);
        }

        //if enemy move out the map
        if(enemy1.getyCoordinate()<0||enemy1.getyCoordinate()>land.getLatitude()){enemy1.setyCoordinate(0);}
        if(enemy1.getxCoordinate()<0||enemy1.getxCoordinate()>land.getLongitude()){enemy1.setxCoordinate(0);}

        if(enemy2.getyCoordinate()<0||enemy2.getyCoordinate()>land.getLatitude()){enemy2.setyCoordinate(0);}
        if(enemy2.getxCoordinate()<0||enemy2.getxCoordinate()>land.getLongitude()){enemy2.setxCoordinate(0);}

        if(enemy3.getyCoordinate()<0||enemy3.getyCoordinate()>land.getLatitude()){enemy3.setyCoordinate(0);}
        if(enemy3.getxCoordinate()<0||enemy3.getxCoordinate()>land.getLongitude()){enemy3.setxCoordinate(0);}
        reDraw(message);
    }

    public void reDraw(String message){
        this.remove(panel);
        this.repaint();
        panel = new MyWarPanel(player,land,enemy1,
                enemy2,enemy3,message);
        this.add(panel);
        this.pack();
    }

    public void setUpButton(){
        upBtn = new JButton("^");
        upBtn.addActionListener(this);
        upBtn.setBounds(x,y+18,50,25);

        this.add(upBtn);
    }
    public void setDownButton(){
        doBtn = new JButton("v");
        doBtn.addActionListener(this);
        doBtn.setBounds(x,y+58,50,25);

        this.add(doBtn);
    }
    public void setLeftButton(){
        leBtn = new JButton("<");
        leBtn.addActionListener(this);
        leBtn.setBounds(x-50,y+38,50,25);

        this.add(leBtn);
    }
    public void setRightButton(){
        riBtn = new JButton(">");
        riBtn.addActionListener(this);
        riBtn.setBounds(x+50,y+38,50,25);

        this.add(riBtn);
    }

    public void setStatusButton(){
        stBtn = new JButton("Status");
        stBtn.addActionListener(this);
        stBtn.setBounds(x-15,y+90,80,40);

        this.add(stBtn);
    }
}
