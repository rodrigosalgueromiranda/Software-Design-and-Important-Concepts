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
public class Association implements Component{
    private int positionX1, positionY1, positionX2, positionY2;
    private String name;

    public Association(int positionX1, int positionY1, int positionX2, int positionY2, String name) {
        this.positionX1 = positionX1;
        this.positionY1 = positionY1;
        this.positionX2 = positionX2;
        this.positionY2 = positionY2;
        this.name = name;
    }

    public void drawComponent(Graphics g){
        g.drawLine(positionX1, positionY1, positionX2, positionY2);
        if (positionX1 > positionX2 && positionY1 > positionY2) {
            g.drawString(name, positionX1 - Math.abs((positionX1 - positionX2)/2), positionY1 - Math.abs((positionY1 - positionY2)/2));
        }
        if (positionX1 < positionX2 && positionY1 < positionY2) {
            g.drawString(name, positionX2 - Math.abs((positionX1 - positionX2)/2), positionY2 - Math.abs((positionY1 - positionY2)/2));
        }
        if (positionX1 > positionX2 && positionY1 < positionY2) {
            g.drawString(name, positionX1 - Math.abs((positionX1 - positionX2)/2), positionY2 - Math.abs((positionY1 - positionY2)/2));
        }
        if (positionX1 < positionX2 && positionY1 > positionY2) {
            g.drawString(name, positionX2 - Math.abs((positionX1 - positionX2)/2), positionY1 - Math.abs((positionY1 - positionY2)/2));
        }
    }

    public int getPositionX1() {
        return positionX1;
    }

    public void setPositionX1(int positionX1) {
        this.positionX1 = positionX1;
    }

    public int getPositionY1() {
        return positionY1;
    }

    public void setPositionY1(int positionY1) {
        this.positionY1 = positionY1;
    }

    public int getPositionX2() {
        return positionX2;
    }

    public void setPositionX2(int positionX2) {
        this.positionX2 = positionX2;
    }

    public int getPositionY2() {
        return positionY2;
    }

    public void setPositionY2(int positionY2) {
        this.positionY2 = positionY2;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }    
}
