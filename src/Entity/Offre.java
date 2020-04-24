/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;


public class Offre {
    private int id;
    private int nb_place;
    private String depart;
    private String arrive;
    private Date date;
    private String time;
    private float tarif;
    private int id_offreur;
    private int id_client;
    private String vehicule;
    private String bagage;

    public Offre() {
    }
    
    public Offre(int nb_place, String depart, String arrive, Date date,String time, float tarif, int id_offreur,String vehicule,String bagage) {
        this.nb_place = nb_place;
        this.depart = depart;
        this.arrive = arrive;
        this.date = date;
        this.time=time;
        this.tarif = tarif;
        this.id_offreur = id_offreur;
       this.id_client= id_offreur;
       this.vehicule=vehicule;
       this.bagage=bagage;
    }
    public Offre(int nb_place, String depart, String arrive, Date date,String time, float tarif, int id_offreur, int id_client,String vehicule,String bagage) {
        this.nb_place = nb_place;
        this.depart = depart;
        this.arrive = arrive;
        this.date = date;
        this.time=time;
        this.tarif = tarif;
        this.id_offreur = id_offreur;
        this.id_client = id_client;
        this.vehicule=vehicule;
        this.bagage=bagage;
    }

    
    @Override
    public String toString() {
        return "Offre{" +"id=" + id + "nb_place=" + nb_place + ", depart=" + depart + ", arrive=" + arrive + ", date=" + date + ", tarif=" + tarif + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + this.nb_place;
        hash = 97 * hash + Objects.hashCode(this.depart);
        hash = 97 * hash + Objects.hashCode(this.arrive);
        hash = 97 * hash + Objects.hashCode(this.date);
        hash = 97 * hash + Float.floatToIntBits(this.tarif);
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
        final Offre other = (Offre) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.nb_place != other.nb_place) {
            return false;
        }
        if (!Objects.equals(this.depart, other.depart)) {
            return false;
        }
        if (!Objects.equals(this.arrive, other.arrive)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (Float.floatToIntBits(this.tarif) != Float.floatToIntBits(other.tarif)) {
            return false;
        }
        return true;
    }

    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    /**
     * @return the nb_place
     */
    public int getNb_place() {
        return nb_place;
    }

    /**
     * @param nb_place the nb_place to set
     */
    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
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
     * @return the tarif
     */
    public float getTarif() {
        return tarif;
    }

    /**
     * @param tarif the tarif to set
     */
    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    /**
     * @return the id_offreur
     */
    public int getId_offreur() {
        return id_offreur;
    }

    /**
     * @param id_offreur the id_offreur to set
     */
    public void setId_offreur(int id_offreur) {
        this.id_offreur = id_offreur;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVehicule() {
        return vehicule;
    }

    public void setVehicule(String vehicule) {
        this.vehicule = vehicule;
    }

    public String getBagage() {
        return bagage;
    }

    public void setBagage(String bagage) {
        this.bagage = bagage;
    }
    
    
    
}
