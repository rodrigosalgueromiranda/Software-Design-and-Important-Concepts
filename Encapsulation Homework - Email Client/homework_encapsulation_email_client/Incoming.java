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
public class Incoming extends Server{
    private String type; //POP3, IMAP, Exchange

    public Incoming(String address, int port, String type) {
        super(address, port);
        this.type = type;
    }
    
    @Override
    public boolean connectServer() {
        return true;
    }    
}
