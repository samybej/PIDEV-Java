/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.awt.image.BufferedImage;
import java.util.Date;


public class Chauffeur {
    private int id;
    private int cin;
    private String nom;
    private String prenom;
    private String mdp;
    private int Tel;
    private String sexe;
    private Date date_naissance;
    private float salaire;
    private float note;
    private BufferedImage img_profil;
    private int etat_compte;
    private String type_chauff;
    private int num_permis;
    private int id_vehicule;
    private int nbReclamation ;

    public Chauffeur() {
    }

    public Chauffeur(int cin, String nom, String prenom, int Tel, String mdp, int id_vehicule) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.Tel = Tel;
          this.mdp=mdp;
         this.id_vehicule = id_vehicule;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public Chauffeur(int CIN, String nom, String prenom, String mdp, int Tel, String sexe, Date date_naissance, float salaire, float note,String type_chauff, int num_permis, int id_vehicule) {
        this.cin = CIN;
        this.nom = nom;
        this.prenom = prenom;
        this.Tel = Tel;
        this.sexe = sexe;
        this.mdp=mdp;
        this.date_naissance = date_naissance;
        this.salaire = salaire;
        this.note = note;
        this.type_chauff = type_chauff;
        this.num_permis = num_permis;
        this.id_vehicule = id_vehicule;
    }

    @Override
    public String toString() {
        return "Chauffeur{" + "id=" + id + ", CIN=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", Tel=" + Tel + ", sexe=" + sexe + ", date_naissance=" + date_naissance + ", salaire=" + salaire + ", note=" + note + ", img_profil=" + img_profil + ", etat_compte=" + etat_compte + ", type_chauff=" + type_chauff + ", num_permis=" + num_permis + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        hash = 83 * hash + this.cin;
        hash = 83 * hash + this.Tel;
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
        final Chauffeur other = (Chauffeur) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.cin != other.cin) {
            return false;
        }
        if (this.Tel != other.Tel) {
            return false;
        }
        return true;
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
     * @return the CIN
     */
    public int getCIN() {
        return cin;
    }

    /**
     * @param CIN the CIN to set
     */
    public void setCIN(int CIN) {
        this.cin = CIN;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the Tel
     */
    public int getTel() {
        return Tel;
    }

    /**
     * @param Tel the Tel to set
     */
    public void setTel(int Tel) {
        this.Tel = Tel;
    }

    /**
     * @return the sexe
     */
    public String getSexe() {
        return sexe;
    }

    /**
     * @param sexe the sexe to set
     */
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    /**
     * @return the date_naissance
     */
    public Date getDate_naissance() {
        return date_naissance;
    }

    /**
     * @param date_naissance the date_naissance to set
     */
    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    /**
     * @return the salaire
     */
    public float getSalaire() {
        return salaire;
    }

    /**
     * @param salaire the salaire to set
     */
    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    /**
     * @return the note
     */
    public float getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(float note) {
        this.note = note;
    }

    /**
     * @return the img_profil
     */
    public BufferedImage getImg_profil() {
        return img_profil;
    }

    /**
     * @param img_profil the img_profil to set
     */
    public void setImg_profil(BufferedImage img_profil) {
        this.img_profil = img_profil;
    }

    /**
     * @return the etat_compte
     */
    public int getEtat_compte() {
        return etat_compte;
    }

    /**
     * @param etat_compte the etat_compte to set
     */
    public void setEtat_compte(int etat_compte) {
        this.etat_compte = etat_compte;
    }

    /**
     * @return the type_chauff
     */
    public String getType_chauff() {
        return type_chauff;
    }

    /**
     * @param type_chauff the type_chauff to set
     */
    public void setType_chauff(String type_chauff) {
        this.type_chauff = type_chauff;
    }

    /**
     * @return the num_permis
     */
    public int getNum_permis() {
        return num_permis;
    }

    /**
     * @param num_permis the num_permis to set
     */
    public void setNum_permis(int num_permis) {
        this.num_permis = num_permis;
    }

    /**
     * @return the mdp
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * @param mdp the mdp to set
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    public int getId_vehicule(){
        return this.id_vehicule;
    }
    
    public void setId_vehicule(int id_vehicule){
        this.id_vehicule=id_vehicule;
    }
    
    public void setNbReclamation(int nbReclamation) {
        this.nbReclamation = nbReclamation;
    }

    public int getNbReclamation() {
        return nbReclamation;
    }
}
