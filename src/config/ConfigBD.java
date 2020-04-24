/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConfigBD {
    
    private Connection cnx;
    private String url="jdbc:mysql://localhost:3306/projetpi";
    private String login="root";
    private String mdp="";
    static ConfigBD myconfig;
    
    private ConfigBD() {
        try {
            cnx = DriverManager.getConnection(url,login,mdp);
        } catch (SQLException ex) {
            Logger.getLogger(ConfigBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public Connection getCnx(){
        return cnx;
    }
    
    public static ConfigBD getInstance(){
        if (myconfig==null){
            myconfig = new ConfigBD();
        }
        return myconfig;
    }
    
    
}
