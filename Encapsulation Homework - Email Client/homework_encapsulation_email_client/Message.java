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
public class Message {
    private String date;
    private String ipOrigen;
    private String emailFrom;
    private String emailTo;
    private String cc;
    private String subject;
    private String body;
    
    public Message(String date, String ipOrigen, String from, String to, String cc, String subject, String body){
        this.date = date;
        this.ipOrigen = ipOrigen;
        this.emailFrom = from;
        this.emailTo = to;
        this.cc = cc;
        this.subject = subject;
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIpOrigen() {
        return ipOrigen;
    }

    public void setIpOrigen(String ipOrigen) {
        this.ipOrigen = ipOrigen;
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

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }   
    
    @Override
    public String toString(){
        return "-------------------------------------------------------------\n" +
                "Date: " + date + ", Ip Origen: " + ipOrigen +  "\nFrom: " + emailFrom + "\nTo: " + emailTo + "\nCc: " + cc + "\nSubject: " + subject + "\nBody: " + body + 
                "\n---------------------------------------------------------------";
    }
}
