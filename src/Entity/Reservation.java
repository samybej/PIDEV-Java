/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;
import java.util.Objects;


public class Reservation {
    private int id;
    private float Distance;
    private String depart;
    private String arrive;
    private int etat;
    private Date date;
    private int id_chauffeur;
    private int id_client;
    private float tarif;
    private String type;

    public Reservation() {
    }

    public Reservation(float Distance, String depart, String arrive, Date date,int id_chauffeur,int id_client,float tarif,int etat,String type) {
        this.Distance = Distance;
        this.depart = depart;
        this.arrive = arrive;
        this.date = date;
        this.id_chauffeur=id_chauffeur;
        this.id_client=id_client;
        this.tarif=tarif;
        this.etat=etat;
        this.type=type;
    }

    @Override
    public String toString() {
        return "Reservation{" + "Distance=" + Distance + ", depart=" + depart + ", arrive=" + arrive + ", date=" + date + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Float.floatToIntBits(this.Distance);
        hash = 97 * hash + Objects.hashCode(this.depart);
        hash = 97 * hash + Objects.hashCode(this.arrive);
        hash = 97 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reservation other = (Reservation) obj;
        if (Float.floatToIntBits(this.Distance) != Float.floatToIntBits(other.Distance)) {
            return false;
        }
        if (!Objects.equals(this.depart, other.depart)) {
            return false;
        }
        if (!Objects.equals(this.arrive, other.arrive)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

   

    
    /**
     * @return the Distance
     */
    public float getDistance() {
        return Distance;
    }

    /**
     * @param Distance the Distance to set
     */
    public void setDistance(float Distance) {
        this.Distance = Distance;
    }

    /**
     * @return the depart
     */
    public String getDepart() {
        return depart;
    }

    /**
     * @param depart the depart to set
     */
    public void setDepart(String depart) {
        this.depart = depart;
    }

    /**
     * @return the arrive
     */
    public String getArrive() {
        return arrive;
    }

    /**
     * @param arrive the arrive to set
     */
    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
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

    public float getTarif() {
        return tarif;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
    
    
}
