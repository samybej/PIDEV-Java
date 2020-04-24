/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Objects;


public class Vehicule {
    private int id;
    private String immatriculation;
    private int num_assurance;
    private String marque;
    private String type;
    private int etat;
    //private int id_chauffeur;

    public Vehicule() {
    }
    
       public Vehicule(String immatriculation, int num_assurance, String marque, String type) {
        this.immatriculation = immatriculation;
        this.num_assurance = num_assurance;
        this.marque = marque;
        this.type = type;
    }
    
    
    public Vehicule(String immatriculation, int num_assurance, String marque, String type, int etat) {
        this.immatriculation = immatriculation;
        this.num_assurance = num_assurance;
        this.marque = marque;
        this.type = type;
        this.etat = etat;
        //this.id_chauffeur=id_chauffeur;
    }

 


    @Override
    public String toString() {
        return "Vehicule{" + "id=" + id + ", immatriculation=" + immatriculation + ", num_assurance=" + num_assurance + ", marque=" + marque + ", type=" + type + ", etat=" + etat + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.immatriculation);
        hash = 31 * hash + this.num_assurance;
        hash = 31 * hash + Objects.hashCode(this.marque);
        hash = 31 * hash + Objects.hashCode(this.type);
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
        final Vehicule other = (Vehicule) obj;
        if (this.immatriculation != other.immatriculation) {
            return false;
        }
        if (this.num_assurance != other.num_assurance) {
            return false;
        }
        if (!Objects.equals(this.marque, other.marque)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
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
     * @return the immatriculation
     */
    public String getImmatriculation() {
        return immatriculation;
    }

    /**
     * @param immatriculation the immatriculation to set
     */
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    /**
     * @return the num_assurance
     */
    public int getNum_assurance() {
        return num_assurance;
    }

    /**
     * @param num_assurance the num_assurance to set
     */
    public void setNum_assurance(int num_assurance) {
        this.num_assurance = num_assurance;
    }

    /**
     * @return the marque
     */
    public String getMarque() {
        return marque;
    }

    /**
     * @param marque the marque to set
     */
    public void setMarque(String marque) {
        this.marque = marque;
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
     * @return the etat
     */
    public int getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(int etat) {
        this.etat = etat;
    }
    

}
