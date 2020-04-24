/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Aziz Bousselmi
 */
public class Mail {
     public static void javaSendMail(String recepient) throws Exception{
        System.out.println("preparing to send my email");
        
        Properties properties =new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail = "mohamediyadhtajouri@gmail.com";
        String password = "@23548008@";
        
        Session session = Session.getInstance(properties,new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(myAccountEmail, password);
            }
      
        });
        
       Message message= prepareMessage(session,myAccountEmail,recepient);
        Transport.send(message);
        System.out.println("message send Successfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
Message message = new MimeMessage(session);
        try {
           
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("My First Email from java app");
            message.setText("Hey there, \n look my email!!!");
            return message; 
            
            
        } catch (Exception ex) {
           // Logger.getLogger(sendMail.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("erreur fel mail.java");
           ex.getMessage();
        }
         return null;
    }
    
}
