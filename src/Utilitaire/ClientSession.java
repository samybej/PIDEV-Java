/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaire;
import Entity.Client;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azuz
 */
public class ClientSession  {
  
  static  Client c =new Client();
    //private static UserSession instance=null;
    public ClientSession(){}
    private ClientSession (Client cc) throws ClassNotFoundException {
    
         

            c = cc;
        

       
    }
    public void setUser(Client cli){
        c=cli;
    
    }
    public void resetUser(){
    
        c=new Client();
    }
    
   /* public static UserSession getInstance(Utilisateur uu) throws ClassNotFoundException{
        if( instance == null)
            instance = new UserSession(uu);
        
        return instance;
    }*/
    
    public Client getUser() {
        return c;
    
    } 
}
    