/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


public class Meuble {
    private int id;
    private String taille;
    private float prix;
    private int id_reservation;

    public Meuble() {
    }

    public Meuble(String taille, int id_reservation) {
        this.taille = taille;
        this.prix = 1;
        this.id_reservation=id_reservation;
    }

    @Override
    public String toString() {
        return "Meuble{" + "taille=" + getTaille() + ", prix=" + getPrix() + '}';
    }

    /**
     * @return the taille
     */
    public String getTaille() {
        return taille;
    }

    /**
     * @param taille the taille to set
     */
    public void setTaille(String taille) {
        this.taille = taille;
    }



    /**
     * @return the prix
     */
    public float getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(float prix) {
        this.prix = prix;
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
     * @return the id_reservation
     */
    public int getId_reservation() {
        return id_reservation;
    }

    /**
     * @param id_reservation the id_reservation to set
     */
    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }
    
    
}
