/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaire;

import Entity.Client;

/**
 *
 * @author Asus
 */
public final class Session {
    private static Session instance;

    private int id;
    private String login;
    
    private Session()
    {
        this.id=0;
        this.login="";
       // this.password="";
    }
  

    private Session(int id) {
        this.id = id;
     //   this.password = clientConnecte;
    }
    
    private Session(String login) {
        this.login = login;
     //   this.password = clientConnecte;
    }
    
    public static Session getSession()
    {
     /*   if (instance == null)
        {
            instance = new Session();
            return instance;
        }*/
        return instance;
    }

    public static Session getInstace(int id) {
        if(instance == null) {
            instance = new Session(id);
        }
        return instance;
    }
    
    public static Session getInstace(String login) {
        if(instance == null) {
            instance = new Session(login);
        }
        return instance;
    }

    public int getId() {
        return id;
    }
     public String getLogin() {
        return login;
    }
  

    public void cleanUserSession() {
        id = 0;// or null
        login="";
    }
    
    public void destroySession()
    {
        instance = null;
    }
    @Override
    public String toString() {
        return "UserSession{" +
                "userName='" + id + '\'';
    }
}