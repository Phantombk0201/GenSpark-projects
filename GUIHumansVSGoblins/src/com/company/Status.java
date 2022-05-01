package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Status extends JFrame implements ActionListener {
    MyStatusPanel panel;
    JButton huBtn,gobBtn1,gobBtn2,gobBtn3;
    JButton staBtn, armBtn, weaBtn;

    private String playStat,playWeap,playArm;
    private String ene1Stat,ene1Weap,ene1Arm,
            ene2Stat,ene2Weap,ene2Arm,
            ene3Stat, ene3Weap,ene3Arm;
    private String stat = playStat;

    //to select which character stats display and xy of the buttons
    private int humanOrGoblin = 0,statWeapArm = 0,x=60,y=20;

    Status(Human player, Goblin enemy1,Goblin enemy2,Goblin enemy3){
        //setting all the stats
        playStat = player.getStats(); playWeap = player.getWeapon().stats(); playArm = player.getArmor().stats();
        ene1Stat = enemy1.getStats(); ene1Weap = enemy1.getWeapon().stats(); ene1Arm = enemy1.getArmor().stats();
        ene2Stat = enemy2.getStats(); ene2Weap = enemy2.getWeapon().stats(); ene2Arm = enemy2.getArmor().stats();
        ene3Stat = enemy3.getStats(); ene3Weap = enemy3.getWeapon().stats(); ene3Arm = enemy3.getArmor().stats();


        panel = new MyStatusPanel(player.getStats(),0);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setHumanBtn();
        setGoblin1Btn();
        setGoblin2Btn();
        setGoblin3Btn();

        setStatusButton();
        setArmorButton();
        setWeaponButton();


        this.add(panel);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //to select which color the text will be
        if(e.getSource() == huBtn){
            huBtn.setEnabled(false);
            gobBtn1.setEnabled(true);
            gobBtn2.setEnabled(true);
            gobBtn3.setEnabled(true);
            humanOrGoblin = 0;}
        if(e.getSource() == gobBtn1){
            huBtn.setEnabled(true);
            gobBtn1.setEnabled(false);
            gobBtn2.setEnabled(true);
            gobBtn3.setEnabled(true);
            humanOrGoblin = 1;}
        if(e.getSource() == gobBtn2){
            huBtn.setEnabled(true);
            gobBtn1.setEnabled(true);
            gobBtn2.setEnabled(false);
            gobBtn3.setEnabled(true);
            humanOrGoblin = 2;}
        if(e.getSource() == gobBtn3){
            huBtn.setEnabled(true);
            gobBtn1.setEnabled(true);
            gobBtn2.setEnabled(true);
            gobBtn3.setEnabled(false);
            humanOrGoblin = 3;}

        //selecting which stats to print out
        if(e.getSource() == staBtn){
            staBtn.setEnabled(false);
            weaBtn.setEnabled(true);
            armBtn.setEnabled(true);
            statWeapArm = 0;}
        if(e.getSource() == armBtn){
            staBtn.setEnabled(true);
            weaBtn.setEnabled(true);
            armBtn.setEnabled(false);
            statWeapArm = 1;}
        if(e.getSource() == weaBtn){
            staBtn.setEnabled(true);
            weaBtn.setEnabled(false);
            armBtn.setEnabled(true);
            statWeapArm = 2;}

        //selecting what to print and redraw
        setStat();
        reDraw();

    }
    public void setHumanBtn() {
        huBtn = new JButton("H");
        huBtn.addActionListener(this);
        huBtn.setBounds(x,y,50,25);
        huBtn.setEnabled(false);
        this.add(huBtn);
    }
    public void setGoblin1Btn(){
        gobBtn1 = new JButton("G1");
        gobBtn1.addActionListener(this);
        gobBtn1.setBounds(x+51,y,50,25);

        this.add(gobBtn1);
    }
    public void setGoblin2Btn(){
        gobBtn2 = new JButton("G2");
        gobBtn2.addActionListener(this);
        gobBtn2.setBounds(x+102,y,50,25);

        this.add(gobBtn2);
    }
    public void setGoblin3Btn(){
        gobBtn3 = new JButton("G3");
        gobBtn3.addActionListener(this);
        gobBtn3.setBounds(x+153,y,50,25);

        this.add(gobBtn3);
    }

    public void setStatusButton() {

        staBtn = new JButton("S");
        staBtn.addActionListener(this);
        staBtn.setBounds(x-55,y+30,50,20);
        staBtn.setEnabled(false);
        this.add(staBtn);

    }
    public void setArmorButton() {
        armBtn = new JButton("A");
        armBtn.addActionListener(this);
        armBtn.setBounds(x-55,y+51,50,20);

        this.add(armBtn);
    }
    public void setWeaponButton() {
        weaBtn = new JButton("W");
        weaBtn.addActionListener(this);
        weaBtn.setBounds(x-55,y+72,50,20);

        this.add(weaBtn);
    }

    public void setStat(){
        if(humanOrGoblin == 1){
            if(statWeapArm == 1){stat = ene1Arm;}
            else if(statWeapArm ==2){stat = ene1Weap;}
            else{stat = ene1Stat;}
        }
        else if (humanOrGoblin == 2) {
            if (statWeapArm == 1) {stat = ene2Arm;}
            else if (statWeapArm == 2) {stat = ene2Weap;}
            else {stat = ene2Stat;}
        }else if(humanOrGoblin == 3) {
            if (statWeapArm == 1) {stat = ene3Arm;}
            else if (statWeapArm == 2) {stat = ene3Weap;}
            else {stat = ene3Stat;}
        }else{
            if(statWeapArm == 1){stat = playArm;}
            else if(statWeapArm ==2){stat = playWeap;}
            else{stat = playStat;}
        }
    }
    public void reDraw(){

        this.remove(panel);
        this.repaint();
        panel = new MyStatusPanel(stat, humanOrGoblin);
        this.add(panel);
        this.pack();
    }

}

