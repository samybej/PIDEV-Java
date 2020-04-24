/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Chauffeur;
import Entity.Client;
import Entity.Offre;
import config.ConfigBD;
import java.sql.Connection;
import Entity.Reservation;
import Entity.Meuble;
import Entity.Vehicule;
import Service.MeubleService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservationService {

    Connection cnx = ConfigBD.getInstance().getCnx();

    public void ajouterReservation(Reservation r) {
        ClientService c = new ClientService();
        int points = c.recupererPointsParId(r.getId_client());

        String requete = "INSERT INTO reservation (distance,depart,arrive,date,id_chauffeur,id_client,type,tarif,etat) VALUES (?,?,?,?,?,?,?,?,?)";

        if (points >= 20) {
            r.setTarif(0);
        }

        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setFloat(1, r.getDistance());
            pst.setString(2, r.getDepart());
            pst.setString(3, r.getArrive());
            java.sql.Date d = new java.sql.Date(r.getDate().getTime());
            pst.setDate(4, d);
            pst.setInt(5, r.getId_chauffeur());
            pst.setInt(6, r.getId_client());
            pst.setString(7, r.getType());
            pst.setFloat(8, r.getTarif());
            pst.setInt(9, r.getEtat());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modifierReservation(Reservation r) {
        String requete = "UPDATE reservation set distance=?, depart=?, arrive=?, date=?, id_chauffeur=?, id_client=?, type=?, tarif=?, etat=? where id=?";

        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setFloat(1, r.getDistance());
            pst.setString(2, r.getDepart());
            pst.setString(3, r.getArrive());
            java.sql.Date d = new java.sql.Date(r.getDate().getTime());
            pst.setDate(4, d);
            pst.setFloat(5, r.getId_chauffeur());
            pst.setFloat(6, r.getId_client());
            pst.setString(7, r.getType());
            pst.setFloat(8, r.getTarif());
            pst.setInt(9, r.getEtat());
            pst.setFloat(10, r.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* public void modifierReservationMeuble(Reservation r,Meuble m){
        String requete="UPDATE reservation set distance=?, depart=?, arrive=?, date=?, id_chauffeur=? where id_chauffeur=?";
         
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setFloat(1, r.getDistance());
            pst.setString(2, r.getDepart());
            pst.setString(3, r.getArrive());
            java.sql.Date d = new java.sql.Date(r.getDate().getTime());
            pst.setDate(4, d);
            pst.setFloat(5, r.getId_chauffeur());
            pst.setFloat(6, r.getId_chauffeur());
            MeubleService mService = new MeubleService();
            mService.modiferMeuble(m);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     */
    public void supprimerReservation(Reservation r) {
        String requete = "DELETE FROM reservation WHERE id=?";

        try {
            PreparedStatement statement = cnx.prepareStatement(requete);
            statement.setInt(1, r.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Reservation> getListReservationTaxi() {
        List<Reservation> list = new ArrayList<>();
        String requete = "SELECT * from reservation where type=\"taxi\" ";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Reservation r = new Reservation();
                r.setId(rs.getInt(1));
                r.setDistance(rs.getFloat(2));
                r.setDepart(rs.getString(3));
                r.setArrive(rs.getString(4));

                r.setDate(rs.getDate(5));
                r.setId_chauffeur(rs.getInt(6));
                r.setId_client(rs.getInt(7));
                r.setType(rs.getString(8));

                list.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
     public List<Reservation> getListReservationTransporteur() {
        List<Reservation> list = new ArrayList<>();
        String requete = "SELECT * from reservation where type=\"transporteur\" ";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Reservation r = new Reservation();
                r.setId(rs.getInt(1));
                r.setDistance(rs.getFloat(2));
                r.setDepart(rs.getString(3));
                r.setArrive(rs.getString(4));

                r.setDate(rs.getDate(5));
                r.setId_chauffeur(rs.getInt(6));
                r.setId_client(rs.getInt(7));
                r.setType(rs.getString(8));

                list.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public List<Reservation> getListReservation() {
        List<Reservation> list = new ArrayList<>();
        String requete = "SELECT * from reservation ";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Reservation r = new Reservation();
                r.setId(rs.getInt(1));
                r.setDistance(rs.getFloat(2));
                r.setDepart(rs.getString(3));
                r.setArrive(rs.getString(4));

                r.setDate(rs.getDate(5));
                r.setId_chauffeur(rs.getInt(6));
                r.setId_client(rs.getInt(7));
                r.setType(rs.getString(8));

                list.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public void calculTarif(Reservation r) {
        r.setTarif(1);
        int nbr = (int) (r.getDistance() / 10);
        r.setTarif(nbr * 2);
    }

    public int recupererNbrReservations(Client c) {
        int nbr = 0;
        String requete = "SELECT COUNT(*) FROM reservation WHERE id_client=?";

        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setInt(1, c.getId());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                nbr = ((Number) rs.getObject(1)).intValue();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nbr;
    }

    //reservation meubles
    public List<Reservation> getListReservationMeubleBydate() {
        List<Reservation> list = new ArrayList<>();
        String requete = "SELECT * from reservation where type=0 order by date desc";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Reservation r = new Reservation();
                r.setId(rs.getInt(1));
                r.setDistance(rs.getFloat(2));
                r.setDepart(rs.getString(3));
                r.setArrive(rs.getString(4));

                r.setDate(rs.getDate(5));
                r.setId_chauffeur(rs.getInt(6));
                r.setId_client(rs.getInt(7));

                list.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public List<Vehicule> getListVehiculeReservation(int i) {
        List<Vehicule> list = new ArrayList<>();
        String requete = "select DISTINCT immatriculation,numero_assurance,marque   from `vehicule` , `chauffeur` , `reservation` WHERE chauffeur.id_vehicule=vehicule.id AND '" + i + "'=chauffeur.id ;";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {

                Vehicule v = new Vehicule();
                v.setImmatriculation(rs.getString(1));
                v.setNum_assurance(rs.getInt(2));
                v.setMarque(rs.getString(3));

                list.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public List<Chauffeur> getListChauffeurReservation(int id) {
        List<Chauffeur> list = new ArrayList<>();
        String requete = "SELECT DISTINCT cin,nom,prenom,tel,sexe,salaire,note FROM `chauffeur`,`reservation` WHERE chauffeur.id='" + id + "' ";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                //Reservation r = new Reservation();

                Chauffeur ch = new Chauffeur();
                ch.setCin(rs.getInt(1));

                ch.setNom(rs.getString(2));
                ch.setPrenom(rs.getString(3));
                ch.setTel(rs.getInt(4));
                ch.setSexe(rs.getString(5));
                ch.setSalaire((float) rs.getDouble(6));
                ch.setNote(rs.getFloat(7));

                list.add(ch);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public List<Meuble> getListMeubleReservation() {
        List<Meuble> list = new ArrayList<>();
        int i=7;
        String requete = "SELECT taille,prix FROM `meuble`,`reservation` WHERE '"+i+"'=reservation.id ";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
              
                Meuble mb = new Meuble();
                mb.setTaille(rs.getString(1));

                mb.setPrix(rs.getFloat(2));

                list.add(mb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public int getIdMeubleReservation() throws SQLException {

        String a = "Transporteur";
        String requete = "SELECT id FROM reservation WHERE id=(SELECT MAX(id) FROM reservation) AND reservation.type='"+a+"'";


  int b = 1;
            PreparedStatement st = cnx.prepareStatement(requete);
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                int c =  rs.getInt(1);
                b=c;
            }
          
                
            
        return b;

        } 

        
    

    //recherche reservation meuble par chauffeur
    /*  public List<Reservation> getListReservationBydepart(String depart){
        List<eservation> list = new ArrayList<>();
        String requette="SELECT * from reservation where depart=?";
        
        try {
           PreparedStatement st =cnx.prepareStatement(requette);
                      st.setString(1,depart);

           ResultSet rs = st.executeQuery();
           while (rs.next()){
               Offre r = new Offre();
               r.setId(rs.getInt(1));
               r.setNb_place(rs.getInt(2));
               r.setDepart(rs.getString(3));
               r.setArrive(rs.getString(4));
              
               r.setDate(rs.getDate(5));
               r.setTarif(rs.getInt(6));
               r.setId_offreur(rs.getInt(7));
               r.setId_client(rs.getInt(8));
            
               list.add(r);
           }
        }
        
        catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return list ;
        
}*/
}
