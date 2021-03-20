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
public interface Shape {
    int startPositionX = 0; 
    int startPositionY = 0;

    void Move(int newPositionX, int newPositionY);
}