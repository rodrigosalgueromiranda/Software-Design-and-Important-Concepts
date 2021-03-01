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
public abstract class Server{
    protected String address;
    protected int port;
    
    public Server(String address, int port){
        this.address = address;
        this.port = port;
    }
    
    public abstract boolean connectServer();
}
