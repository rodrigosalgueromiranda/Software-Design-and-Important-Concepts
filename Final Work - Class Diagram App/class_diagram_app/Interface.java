/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.class_diagram_app;

import java.awt.Graphics;

/**
 *
 * @author Rodrigo.Salguero
 */
public class Interface implements Component{
    private int positionX, positionY;
    public static final int width = 100;
    public static final int height = 60;
    private String name;

    public Interface(int x, int y, String name) {
        this.positionX = x;
        this.positionY = y;
        this.name = name;
    }
    
    public void drawComponent(Graphics g){
        g.draw3DRect(this.positionX - width/2, this.positionY  - height/2, this.width, this.height,  true);
        g.drawString("<interface>", this.positionX - (("<interface>".length()/2) * 7) + 7, this.positionY - 7);
        g.drawString(this.name, this.positionX - ((this.name.length()/2) * 7), this.positionY + 10);
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
