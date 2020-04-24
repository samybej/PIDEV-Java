/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;
import java.util.Objects;


public class Reclamation {
    private int id;
    private String message;
    private String date_rec;
    private String type;
    private int id_client;
    private int id_chauffeur;

    public Reclamation() {
    }

    public Reclamation(int id,String message, String type, String date_rec,int id_client,int id_chauffeur) {
        this.id=id;
        this.message = message;
        this.date_rec = date_rec;
        this.type = type;
        this.id_client=id_client;
        this.id_chauffeur=id_chauffeur;
    }

    public Reclamation(String message, String date_rec, String type, int id_client, int id_chauffeur) {
        this.message = message;
        this.date_rec = date_rec;
        this.type = type;
        this.id_client = id_client;
        this.id_chauffeur = id_chauffeur;
    }

    
    /*public Reclamation(String problem, String typeR) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Reclamation(String problem, String typeR, java.sql.Date calend) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Reclamation(String problem, java.sql.Date calend, String typeR, String cli, String chauf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } */

    @Override
    public String toString() {
        return "Reclamation{" + "message=" + message + ", date_rec=" + date_rec + ", type=" + type + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.message);
        hash = 67 * hash + Objects.hashCode(this.date_rec);
        hash = 67 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamation other = (Reclamation) obj;
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (!Objects.equals(this.date_rec, other.date_rec)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }

    
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the date_rec
     */
    public String getDate_rec() {
        return date_rec;
    }

    /**
     * @param date_rec the date_rec to set
     */
    public void setDate_rec(String date_rec) {
        this.date_rec = date_rec;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the id_client
     */
    public int getId_client() {
        return id_client;
    }

    /**
     * @param id_client the id_client to set
     */
    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    /**
     * @return the id_chauffeur
     */
    public int getId_chauffeur() {
        return id_chauffeur;
    }

    /**
     * @param id_chauffeur the id_chauffeur to set
     */
    public void setId_chauffeur(int id_chauffeur) {
        this.id_chauffeur = id_chauffeur;
    }
    
    
}
