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
public class EmailClient {
    private Account account;
    private ArrayList<Message> messages;
    private ArrayList<Folder> folders;
    private ArrayList<Rule> rules;

    public EmailClient(Account account){ 
        this.account = account;
        this.messages = new ArrayList<Message>();
        this.folders = new ArrayList<Folder>();
        this.rules = new ArrayList<Rule>();    
    }
    
    public boolean receiveMessage(Server server){
        return server.connectServer();
    }
        
    public boolean sendMessage(Server server){
        return server.connectServer();
    }

    public void addFolder(Folder folder) {
        this.folders.add(folder);
    }
    
    public void deleteFolder(Folder folder) {
        if(!folder.getType().equals("Default")){
            this.folders.remove(folder);
        }
    }
    
    public void createMessageToFolder(Folder folder, Message message) {
        folder.addMessageToFolder(message);
    }
    
    public void deleteMessageFromFolder(Folder folder, int indexMessage) {
        folder.deleteMessageFromFolder(folder.messageObject(indexMessage));
    }
   
    public void moveMessageToFolder(Folder fromFolder, Folder toFolder, int indexMessage) {
        toFolder.addMessageToFolder(fromFolder.messageObject(indexMessage));
        fromFolder.deleteMessageFromFolder(fromFolder.messageObject(indexMessage));
    }
    
    public void addRule(Rule rule) {
        this.rules.add(rule);
    }

    public Folder folderObject (int indexFolder){
        int count = 0;
        Folder folder = null;
        for (int i = 0; i < folders.size(); ++i) {
            if(indexFolder == ++count){                 
                folder = folders.get(i);
                --i;
            }            
        }
        return folder;
    }
    
    public String listFoldersMessages() {
	String result = "";
        for (Folder folder : this.folders) {
            result += "\n" + folder.toStringFolderMessage();
        }
        return result;
    }
    
    public String listFolders() {
        int count = 0;
	String result = "";
        for (Folder folder : this.folders) {
            result += "\n" + ++count + ") " + folder.toStringFolder();
            if(folder.getType().equals("Default")) {
                result += " (default)";
            }
        }
        return result;
    }
    
    public String listIndexFolders (int index) {
        int count = 0;
	String result = "";
        for (Folder folder : this.folders) {
            if(index == ++count){
                result += "\n" + folder.toStringFolderMessage();
            }            
        }
        return result;
    }
}
