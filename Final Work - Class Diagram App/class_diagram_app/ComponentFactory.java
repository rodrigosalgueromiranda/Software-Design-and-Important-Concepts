/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.class_diagram_app;

import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 *
 * @author Rodrigo.Salguero
 */
public class ComponentFactory {
    public Component createComponent(String type, int positionX, int positionY, String name, Point point1, Point point2){
        switch (type) {
            case "Class":
                return new Class(positionX, positionY, name);
            case "Interface":
                return new Interface(positionX, positionY, name);
            case "Association":
                return new Association(point1.x, point1.y, point2.x, point2.y, name);
            default:
                throw new IllegalArgumentException (type);
        }
    }
}
