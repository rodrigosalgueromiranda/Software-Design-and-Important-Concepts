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
public class Rule {
    private String name;
    private String emailFrom;
    private String emailTo;
    private Folder folder;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Rule(String name, String email, Folder folder, String type) {
        this.name = name;
        this.emailFrom = email;
        this.folder = folder;
        this.type = type;
    }

    public Rule(String name, String emailFrom, String emailTo, String type) {
        this.name = name;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.type = type;
    }

    public Rule(String name, String email, String type) {
        this.name = name;
        this.emailFrom = email;
        this.type = type;
    }
    
    @Override
    public String toString(){
        return "name: " + name + ", emailFrom: " + emailFrom +  ", emailTo: " + emailTo + " type: " + type ;
    }
}
