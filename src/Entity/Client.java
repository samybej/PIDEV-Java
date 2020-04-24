package Entity;


import java.awt.image.BufferedImage;
import java.util.Objects;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Client {
    private int id;
    private String nom;
    private String prenom;
    private int tel;
    private String adresse;
    private String mdp;
    private int etat_compte;
    private String mail;
    private BufferedImage img_profil;
    private int points;
    private int avertissement;

    public Client() {
    }
    
    public Client(String nom, String prenom, String mdp, int tel ) {
       this.nom = nom;
       this.prenom= prenom;
       this.mdp = mdp;
       this.tel = tel;
      
    }

    public Client(String nom, String prenom, int tel, String adresse, String mdp, int etat_compte, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.adresse = adresse;
        this.mdp = mdp;
        this.etat_compte = etat_compte;
        this.mail = mail;
 
    }

    public Client(String mail, String mdp, String nom, String prenom, int tel ) {
        this.mail = mail;
        this.mdp = mdp;
        this.nom = nom; 
        this.prenom = prenom;
        this.tel = tel;
      
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.getId();
        hash = 67 * hash + Objects.hashCode(this.getMail());
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
        final Client other = (Client) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
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
     * @return the tel
     */
    public int getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(int tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", adresse=" + getAdresse() + ", mdp=" + getMdp() + ", etat_compte=" + getEtat_compte() + ", mail=" + getMail() + ", img_profil=" + getImg_profil() + '}';
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
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
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    public int getAvertissement() {
        return avertissement;
    }

    public void setAvertissement(int avertissement) {
        this.avertissement = avertissement;
    }
    
}
