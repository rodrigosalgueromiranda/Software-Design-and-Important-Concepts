
package com.mycompany.homework_encapsulation_email_client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Rodrigo.Salguero
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int option;
    static boolean quit = false;

    public static void main(String[] args) {
        int indexFolder, indexMessage, indexFolderToMove;
        String ipOrigenMessage, fromMessage, toMessage, ccMessage, subjectMessage, bodyMessage, nameFolder;
        System.out.println("***************************************************************\n"
                          + "***************** WELCOME TO THE EMAIL CLIENT *****************"
                          + "\n***************************************************************");        
           
        Account rodrigoAccount = new Account ("Rodrigo Salguero","Rodrigo.Salguero@jalasoft.com","12345");
        EmailClient rodrigoEmailClient = new EmailClient(rodrigoAccount);        
        Server rodrigoIncomingServer = new Incoming ("imap.jalasoft.com",993,"IMAP");
        Server rodrigoOutgoingServer = new Outgoing ("smtp.jalasoft.com",587);
        
        if (rodrigoEmailClient.receiveMessage(rodrigoIncomingServer)){
            System.out.println("Incoming server connected");            
        }
        else{
            System.out.println("Incoming server not connected");  
        }
        
        if (rodrigoEmailClient.sendMessage(rodrigoOutgoingServer)){
            System.out.println("Outgoing server connected");
        }
        else{
            System.out.println("Outgoing server not connected");  
        }
        
        Folder inboxFolder = new Folder("Inbox", "Default");
        Folder sentFolder = new Folder("Sent Items", "Default");
        rodrigoEmailClient.addFolder(inboxFolder);
        rodrigoEmailClient.addFolder(sentFolder);
        
        Message messageFromLourdes = new Message("20-02-21", "192.168.0.10", "lmiranda@hotmail.com", "Rodrigo.Salguero@jalasoft.com", "", "Saludos", "Espero que te encuentres bien, muchos saludos");
        Message messageFromJuan = new Message("21-02-21", "192.168.0.20", "jpoma@hotmail.com", "Rodrigo.Salguero@jalasoft.com", "", "Agradeciemineto", "Agradezco la reunión que tuvimos, muchos saludos");
        Message messageToMonica = new Message("22-02-21", "192.168.0.70", "Rodrigo.Salguero@jalasoft.com", "Monica.Pardo@jalasoft.com", "", "Respuesta", "Espero que también te encuentres bien, muchos saludos");
        rodrigoEmailClient.createMessageToFolder(inboxFolder, messageFromLourdes);
        rodrigoEmailClient.createMessageToFolder(inboxFolder, messageFromJuan);
        rodrigoEmailClient.createMessageToFolder(sentFolder, messageToMonica);
 
        System.out.println(rodrigoEmailClient.listFoldersMessages());

        while (!quit) {
            try {
                System.out.println("***************************************************************\n"
                        + "************************ MENU OPTIONS *************************"
                        + "\n***************************************************************\n"
                        + " 1.- Create Email\n"
                        + " 2.- Delete Email\n"
                        + " 3.- Create Folder\n"
                        + " 4.- Delete Folder\n"
                        + " 5.- Move Email to a Folder\n"
                        + " 6.- Create Rule\n"
                        + " 0.- Quit\n");
                System.out.println("Choose an option:");

                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1:                        
                        System.out.println("To:");
                        toMessage = scanner.nextLine();
                        
                        System.out.println("Cc:");
                        ccMessage = scanner.nextLine();
                        
                        System.out.println("Subject:");
                        subjectMessage = scanner.nextLine();
                        
                        System.out.println("Message:");
                        bodyMessage = scanner.nextLine();
                        
                        Date myDate = new Date();
                        Message newMessage = new Message(new SimpleDateFormat("dd-MM-yyyy").format(myDate), "192.168.0.70", rodrigoAccount.getUser(), toMessage, ccMessage, subjectMessage, bodyMessage);
                        
                        if (rodrigoEmailClient.sendMessage(rodrigoOutgoingServer)){
                            rodrigoEmailClient.createMessageToFolder(sentFolder, newMessage);
                            System.out.println(rodrigoEmailClient.listIndexFolders(2));
                        } else {
                            System.out.println("The message couldn't be sent, Outgoing server not connected");
                        }
                        
                        break;
                    case 2:
                        System.out.println("\nSelect the folder you want to list the messages");
                        System.out.println(rodrigoEmailClient.listFolders());
                        
                        System.out.println("\nEnter folder index:");
                        indexFolder = Integer.parseInt(scanner.nextLine());
                        System.out.println(rodrigoEmailClient.listIndexFolders(indexFolder));
                        
                        System.out.println("\nEnter message index you want to delete:");
                        indexMessage = Integer.parseInt(scanner.nextLine());
                        
                        rodrigoEmailClient.deleteMessageFromFolder(rodrigoEmailClient.folderObject(indexFolder), indexMessage);
                        System.out.println(rodrigoEmailClient.listIndexFolders(indexFolder));
                        
                        break;
                    case 3:                        
                        System.out.println("Folder name:");
                        nameFolder = scanner.nextLine();
                        
                        Folder newFolder = new Folder(nameFolder, "Personalized");
                        rodrigoEmailClient.addFolder(newFolder);
                        System.out.println(rodrigoEmailClient.listFolders() + "\n");
                        
                        break;
                    case 4:
                        System.out.println("\nSelect the folder you want to delete:");
                        System.out.println(rodrigoEmailClient.listFolders());
                        
                        System.out.println("\nEnter folder index:");
                        indexFolder = Integer.parseInt(scanner.nextLine());
                        
                        rodrigoEmailClient.deleteFolder(rodrigoEmailClient.folderObject(indexFolder));
                        System.out.println(rodrigoEmailClient.listFolders() + "\n");
                        
                        break;
                    case 5:
                        System.out.println("\nSelect the folder you want to list the messages");
                        System.out.println(rodrigoEmailClient.listFolders());                        
                        System.out.println("\nEnter folder index:");
                        indexFolder = Integer.parseInt(scanner.nextLine());
                        System.out.println(rodrigoEmailClient.listIndexFolders(indexFolder));
                        
                        System.out.println("\nEnter message index you want to move:");
                        indexMessage = Integer.parseInt(scanner.nextLine());
                        
                        System.out.println("\nSelect the folder you want to move the messages");
                        System.out.println(rodrigoEmailClient.listFolders());                        
                        System.out.println("\nEnter folder index:");
                        indexFolderToMove = Integer.parseInt(scanner.nextLine());
                        
                        rodrigoEmailClient.moveMessageToFolder(rodrigoEmailClient.folderObject(indexFolder), rodrigoEmailClient.folderObject(indexFolderToMove), indexMessage);
                        System.out.println(rodrigoEmailClient.listIndexFolders(indexFolder) + rodrigoEmailClient.listIndexFolders(indexFolderToMove));
                        
                        break;
                    case 6:
                        createRule(rodrigoEmailClient);
                        
                        break;
                    case 0:
                        System.out.println("See you soon!");
                        quit = true;
                        break;
                    default:
                        System.out.println("Unrecognized number");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Please just enter numbers from the list!");
            }
        }
    }
    
        public static void createRule(EmailClient emailClient) {
        String nameRule, emailAddressFrom, emailAddressTo;
        int indexFolder;
        boolean quit = false;
                
        while (!quit) {
            try {
                System.out.println("\nSelect the rule you want to create\n"
                        + "\n1) Redirect Email to a Folder"
                        + "\n2) Forward Email"
                        + "\n3) Delete Email"
                        + "\n0) Back\n");
                System.out.println("Choose an option:");
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1:
                        System.out.println("\nEnter name of the rule:");
                        nameRule = scanner.nextLine();
                        
                        System.out.println("\nEnter the email address you want to redirect:");
                        emailAddressFrom = scanner.nextLine();
                        
                        System.out.println("\nSelect the folder you want to redirect the messages");
                        System.out.println(emailClient.listFolders());                        
                        System.out.println("\nEnter folder index:");
                        indexFolder = Integer.parseInt(scanner.nextLine());
                        
                        Rule redirectRule = new Rule (nameRule, emailAddressFrom, emailClient.folderObject(indexFolder),"Redirect");
                        emailClient.addRule(redirectRule);
                        System.out.println();
                        quit = true;
                        
                        break;
                    case 2:
                        System.out.println("\nEnter name of the rule:");
                        nameRule = scanner.nextLine();
                        
                        System.out.println("\nEnter the email address you want to forward from:");
                        emailAddressFrom = scanner.nextLine();
                        
                        System.out.println("\nEnter the email address you want to forward to:");
                        emailAddressTo = scanner.nextLine();
                        
                        Rule forwardRule = new Rule (nameRule, emailAddressFrom, emailAddressFrom,"Forward");
                        emailClient.addRule(forwardRule);
                        System.out.println();
                        quit = true;
                        
                        break;
                    case 3:
                        System.out.println("\nEnter name of the rule:");
                        nameRule = scanner.nextLine();
                        
                        System.out.println("\nEnter the email address you want to delete:");
                        emailAddressFrom = scanner.nextLine();
                        
                        Rule deleteRule = new Rule (nameRule, emailAddressFrom,"Delete");
                        emailClient.addRule(deleteRule);
                        System.out.println();
                        quit = true;  
                        
                        break;
                    case 0:
                        System.out.println();
                        quit = true;
                        break;
                    default:
                        System.out.println("Unrecognized number");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Please just enter numbers from the list!");
            }
        }
    }
}
