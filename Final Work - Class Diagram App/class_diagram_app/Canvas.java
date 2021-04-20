/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.class_diagram_app;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Rodrigo.Salguero
 */
public class Canvas extends JPanel implements MouseListener, MouseMotionListener, ActionListener{
    private Vector<Class> vectorClasses;
    private Vector<Interface> vectorInterfaces;
    private Vector<Association> vectorAssociations;
    private Class moveClassComponent;
    private Interface moveInterfaceComponent;
    private int indexClass, indexInterface, indexAssociation;
    private Point point1, point2;
    private JButton classButton, interfaceButton;
    private JFrame window;    
    ComponentFactory componentFactory = new ComponentFactory();
    
    public Canvas (JFrame window) {
        this.vectorClasses = new Vector<>();
        this.vectorInterfaces = new Vector<>();
        this.vectorAssociations = new Vector<>();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.window = window;
    }
    
    @Override
    public void paint (Graphics g){
        super.paint(g);        
        setComponentToolBar();        
        for (Class classes : vectorClasses) {
            classes.drawComponent(g);
        }
        for (Interface interfaces : vectorInterfaces) {
            interfaces.drawComponent(g);
        }
        for (Association associations : vectorAssociations) {
            associations.drawComponent(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            validateClassAssociation(e);            
            validateInterfaceAssociation(e);            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int countClass = 0;
        int countInterface = 0;
        validateClassToMove(e, countClass);
        validateInterfaceToMove(e, countInterface);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        moveClassComponent = null;
        moveInterfaceComponent = null;
        indexClass = -1;
        indexInterface = -1;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        validateClassDragged(e);
        validateInterfaceDragged(e);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }    

    private void setComponentToolBar() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
                
        classButton = new JButton("   Class   ");
        classButton.addActionListener(this);
        buttonPanel.add(classButton);
                
        interfaceButton = new JButton("Interface");
        interfaceButton.addActionListener(this);
        buttonPanel.add(interfaceButton);
                
        mainPanel.add(buttonPanel);
        this.window.add(mainPanel,BorderLayout.NORTH);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("method actionPerformed");
        System.out.println(e.getActionCommand());
        validateClassButton(e);
        validateInterfaceButton(e);        
    }

   
    private void validateClassButton(ActionEvent e) {
        if (e.getActionCommand() == "   Class   ") {
            String className = JOptionPane.showInputDialog("Introduce Class Name: ");
            Component classComponent = componentFactory.createComponent("Class",100,50, className, point1, point2);
            this.vectorClasses.add((Class) classComponent);
            repaint();
        }
    }

    private void validateInterfaceButton(ActionEvent e) {
        if (e.getActionCommand() == "Interface") {
            String interfaceName = JOptionPane.showInputDialog("Introduce Interface Name: ");
            Component interfaceDiagram=  componentFactory.createComponent("Interface",110,60, interfaceName, point1, point2);
            this.vectorInterfaces.add((Interface) interfaceDiagram);
            repaint();
        }
    }
    
    
    private void validateClassAssociation(MouseEvent e) {
        for (Class classComponent : vectorClasses) {
            if (new Rectangle(classComponent.getPositionX() - classComponent.width / 2, classComponent.getPositionY() - classComponent.height / 2, classComponent.width, classComponent.height).contains(e.getPoint())) {
                if (point1 == null) {
                    point1 = new Point(classComponent.getPositionX(), classComponent.getPositionY());
                } else {
                    point2 = new Point(classComponent.getPositionX(), classComponent.getPositionY());
                    String associationName = JOptionPane.showInputDialog("Introduce Type of Association: ");
                    Component associationLine = componentFactory.createComponent("Association", e.getX(), e.getY(), associationName, point1, point2);
                    this.vectorAssociations.add((Association) associationLine);
                    repaint();
                    point1 = null;
                    point2 = null;
                }
            }
        }
    }

    private void validateInterfaceAssociation(MouseEvent e) {
        for (Interface interfaceComponent : vectorInterfaces) {
            if (new Rectangle(interfaceComponent.getPositionX() - Interface.width / 2, interfaceComponent.getPositionY() - Interface.height / 2, Interface.width, Interface.height).contains(e.getPoint())) {
                if (point1 == null) {
                    point1 = new Point(interfaceComponent.getPositionX(), interfaceComponent.getPositionY());
                } else {
                    point2 = new Point(interfaceComponent.getPositionX(), interfaceComponent.getPositionY());
                    String associationName = JOptionPane.showInputDialog("Introduce Type of Association: ");
                    Component associationLine = componentFactory.createComponent("Association", e.getX(), e.getY(), associationName, point1, point2);
                    this.vectorAssociations.add((Association) associationLine);
                    repaint();
                    point1 = null;
                    point2 = null;
                }
            }
        }
    }

    private void validateClassToMove(MouseEvent e, int countClass) {
        for (Class classComponent : vectorClasses) {
            if (new Rectangle (classComponent.getPositionX() - Class.width/2, classComponent.getPositionY() - Class.height/2, Class.width, Class.height).contains(e.getPoint())) {
                moveClassComponent = classComponent;
                indexClass = countClass;
                break;
            }
            countClass++;
        }
    }

    private void validateInterfaceToMove(MouseEvent e, int countInterface) {
        for (Interface interfaceComponent : vectorInterfaces)  {
            if (new Rectangle (interfaceComponent.getPositionX() - Interface.width/2, interfaceComponent.getPositionY() - Interface.height/2, Interface.width, Interface.height).contains(e.getPoint())) {
                moveInterfaceComponent = interfaceComponent;
                indexInterface = countInterface;
                break;
            }
            countInterface++;
        }
    }

    private void validateClassDragged(MouseEvent e) {
        if (moveClassComponent != null) {
            this.vectorClasses.set(indexClass, new Class(e.getX(), e.getY(), moveClassComponent.getName()));
            indexAssociation = 0;
            for (Association enlace : vectorAssociations) {
                 if (new Rectangle (enlace.getPositionX1() - Class.width/2, enlace.getPositionY1() - Class.height/2, Class.width, Class.height).contains(e.getPoint())) {
                     this.vectorAssociations.set(indexAssociation, new Association(e.getX(), e.getY(), enlace.getPositionX2(), enlace.getPositionY2(), enlace.getNombre()));
                 }
                 else if (new Rectangle (enlace.getPositionX2() - Class.width/2, enlace.getPositionY2() - Class.height/2, Class.width, Class.height).contains(e.getPoint())) {
                     this.vectorAssociations.set(indexAssociation, new Association(enlace.getPositionX1(), enlace.getPositionY1(), e.getX(), e.getY(), enlace.getNombre()));
                 }
                 indexAssociation++;
            }
        } 
    }

    private void validateInterfaceDragged(MouseEvent e) {
        if (moveInterfaceComponent != null) {
            this.vectorInterfaces.set(indexInterface, new Interface(e.getX(), e.getY(), moveInterfaceComponent.getName()));
            indexAssociation = 0;
            for (Association enlace : vectorAssociations) {
                 if (new Rectangle (enlace.getPositionX1() - Interface.width/2, enlace.getPositionY1() - Interface.height/2, Interface.width, Interface.height).contains(e.getPoint())) {
                     this.vectorAssociations.set(indexAssociation, new Association(e.getX(), e.getY(), enlace.getPositionX2(), enlace.getPositionY2(), enlace.getNombre()));
                 }
                 else if (new Rectangle (enlace.getPositionX2() - Interface.width/2, enlace.getPositionY2() - Interface.height/2, Interface.width, Interface.height).contains(e.getPoint())) {
                     this.vectorAssociations.set(indexAssociation, new Association(enlace.getPositionX1(), enlace.getPositionY1(), e.getX(), e.getY(), enlace.getNombre()));
                 }
                 indexAssociation++;
            }
        }
    }
}
