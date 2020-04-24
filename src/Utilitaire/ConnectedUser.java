/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaire;

import Entity.Client;
/**
 *
 * @author azuz
 */
public class ConnectedUser {
    
    
 
    private static Client client=null;
    
    
    public static void setConnectedUser(Client c){
    
    client = c;
    }
    
    public static Client getConnectedUser(){
     return client;
    }
    
}
