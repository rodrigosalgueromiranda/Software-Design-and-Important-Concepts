/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.homework_encapsulation_email_client;

import java.util.ArrayList;

/**
 *
 * @author Rodrigo.Salguero
 */
public class Folder {
    private String name;
    private String type;
    private ArrayList<Message> messages;

    public Folder(String name, String type) {
        this.name = name;
        this.type = type;
        this.messages = new ArrayList<Message>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void addMessageToFolder(Message message) {
        this.messages.add(message);
    }
    
    public void deleteMessageFromFolder(Message message) {
        this.messages.remove(message);
    }
    
    public Message messageObject (int indexMessage){
        int count = 0;
        Message message = null;
        for (int i = 0; i < messages.size(); ++i) {
            if(indexMessage == ++count){                 
                message = messages.get(i);
                --i;
            }            
        }
        return message;
    }
     
    public String listMessages() {
	int count = 0;
        String result = "";
        for (Message message : this.messages) {
            result += "\n"+ ++count + ")" +  message.toString();
        }
        return result;
    }
    
    public String toStringFolderMessage(){
        return "==============================================================="
                + "\nFOLDER: "+ name.toUpperCase() 
                + "\n==============================================================="
                + "\nMESSAGES:"
                + "" + listMessages() + "\n";
    }
    
    public String toStringFolder(){
        return name.toUpperCase();
    }
}
