/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;
import java.util.Objects;


public class Formation {
    private int id;
    private Date Date_debut;
    private Date Date_fin;
    private String Titre;
    private String Lieu;
    private String time ;
    private int id_chauffeur;
    private int nbr_place ;

    public Formation() {
    }

    public int getNbr_place() {
        return nbr_place;
    }

    public void setNbr_place(int nbr_place) {
        this.nbr_place = nbr_place;
    }

    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Formation(Date Date_debut, Date Date_fin,String Titre, String Lieu, String time) {
       
        this.Date_debut = Date_debut;
        this.Date_fin = Date_fin;
        this.Titre = Titre;
        this.Lieu = Lieu;
        this.time=time;
    }

    public Formation(Date Date_debut, Date Date_fin, String Titre, String Lieu, String time, int nbr_place) {
        this.Date_debut = Date_debut;
        this.Date_fin = Date_fin;
        this.Titre = Titre;
        this.Lieu = Lieu;
        this.time = time;
        this.nbr_place = nbr_place;
    }

    public Formation(int id, Date Date_debut, Date Date_fin, String Titre, String Lieu, String time, int id_chauffeur, int nbr_place) {
        this.id = id;
        this.Date_debut = Date_debut;
        this.Date_fin = Date_fin;
        this.Titre = Titre;
        this.Lieu = Lieu;
        this.time = time;
        this.id_chauffeur = id_chauffeur;
        this.nbr_place = nbr_place;
    }
    
    
    

    @Override
    public String toString() {
        return "Formation{" + "Titre=" + Titre + ", Lieu=" + Lieu + ", Date_debut=" + Date_debut + ", Date_fin=" + Date_fin + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.Titre);
        hash = 73 * hash + Objects.hashCode(this.Lieu);
        hash = 73 * hash + Objects.hashCode(this.Date_debut);
        hash = 73 * hash + Objects.hashCode(this.Date_fin);
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
        final Formation other = (Formation) obj;
        if (!Objects.equals(this.Titre, other.Titre)) {
            return false;
        }
        if (!Objects.equals(this.Lieu, other.Lieu)) {
            return false;
        }
        if (!Objects.equals(this.Date_debut, other.Date_debut)) {
            return false;
        }
        if (!Objects.equals(this.Date_fin, other.Date_fin)) {
            return false;
        }
        return true;
    }

    
    /**
     * @return the Titre
     */
    public String getTitre() {
        return Titre;
    }

    /**
     * @param Titre the Titre to set
     */
    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    /**
     * @return the Lieu
     */
    public String getLieu() {
        return Lieu;
    }

    /**
     * @param Lieu the Lieu to set
     */
    public void setLieu(String Lieu) {
        this.Lieu = Lieu;
    }

    /**
     * @return the Date_debut
     */
    public Date getDate_debut() {
        return Date_debut;
    }

    /**
     * @param Date_debut the Date_debut to set
     */
    public void setDate_debut(Date Date_debut) {
        this.Date_debut = Date_debut;
    }

    /**
     * @return the Date_fin
     */
    public Date getDate_fin() {
        return Date_fin;
    }

    /**
     * @param Date_fin the Date_fin to set
     */
    public void setDate_fin(Date Date_fin) {
        this.Date_fin = Date_fin;
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
    
    
    
}
