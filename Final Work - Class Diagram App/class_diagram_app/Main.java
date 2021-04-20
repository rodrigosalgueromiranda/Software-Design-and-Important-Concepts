/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.class_diagram_app;

import java.awt.BorderLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Rodrigo.Salguero
 */
public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Class Diagram App");
        window.add(new Canvas(window),BorderLayout.CENTER);
        window.setSize(1500, 800);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
}
