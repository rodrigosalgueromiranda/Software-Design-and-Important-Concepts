/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.class_diagram_app;

/**
 *
 * @author Rodrigo.Salguero
 */
public class Line implements Shape {
    protected int endPositionX; 
    protected int endPositionY;

    public Line(int endPositionX, int endPositionY) {
        this.endPositionX = endPositionX;
        this.endPositionY = endPositionY;
    }

    @Override
    public void Move(int newPositionX, int newPositionY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
