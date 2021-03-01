/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.homework_encapsulation_email_client;

/**
 *
 * @author Rodrigo.Salguero
 */
public class Outgoing extends Server{

    public Outgoing(String address, int port) {
        super(address, port);
    }
    
    @Override
    public boolean connectServer() {
        return true;
    }    
}
