/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.File;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;


public class Postulation {
    private int id;
    private Date date_demande;
    private int Num_permis;
    private int Cin;
    private String sexe;
    private int tel;
    private int experience;
    private String langue;
    private String nom;
    private String prenom;
    private int id_client;
    private int etat ;
    
    private static final Logger LOG = Logger.getLogger(Postulation.class.getName());

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_demande() {
        return date_demande;
    }

    public void setDate_demande(Date date_demande) {
        this.date_demande = date_demande;
    }

    public int getNum_permis() {
        return Num_permis;
    }

    public void setNum_permis(int Num_permis) {
        this.Num_permis = Num_permis;
    }

    public int getCin() {
        return Cin;
    }

    public void setCin(int Cin) {
        this.Cin = Cin;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Postulation{" + "id=" + id + ", date_demande=" + date_demande + ", Num_permis=" + Num_permis + ", Cin=" + Cin + ", sexe=" + sexe + ", tel=" + tel + ", experience=" + experience + ", langue=" + langue + ", nom=" + nom + ", prenom=" + prenom + ", id_client=" + id_client + ", etat=" + etat + '}';
    }

    public Postulation(int id, Date date_demande, int Num_permis, int Cin, String sexe, int tel, int experience, String langue, String nom, String prenom, int id_client) {
        this.id = id;
        this.date_demande = date_demande;
        this.Num_permis = Num_permis;
        this.Cin = Cin;
        this.sexe = sexe;
        this.tel = tel;
        this.experience = experience;
        this.langue = langue;
        this.nom = nom;
        this.prenom = prenom;
        this.id_client = id_client;
    }

    public Postulation(int id, Date date_demande, int Num_permis, int Cin, String sexe, int tel, int experience, String langue, String nom, String prenom, int id_client, int etat) {
        this.id = id;
        this.date_demande = date_demande;
        this.Num_permis = Num_permis;
        this.Cin = Cin;
        this.sexe = sexe;
        this.tel = tel;
        this.experience = experience;
        this.langue = langue;
        this.nom = nom;
        this.prenom = prenom;
        this.id_client = id_client;
        this.etat = etat;
    }

    public Postulation() {
    }
    
    
    
    
}
   