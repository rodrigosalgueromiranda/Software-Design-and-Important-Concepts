/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.homework_encapsulation_email_client;

/**
 *
 * @author Rodrigo Salguero
 */
public class Account {
    private String name;
    private String user;
    private String password;
    private Server server;

    public Account(String name, String user, String password){
        this.name = name;
        this.user = user;
        this.password = password;
    }

    public Account(String name, String user, String password, Server server){
        this.name = name;
        this.user = user;
        this.password = password;
        this.server = server;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 
    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
           
    @Override
    public String toString(){
        return "-User name: "+ name + ", User: " + user;
    }
}
