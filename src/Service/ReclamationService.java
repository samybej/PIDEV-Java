/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Client;
import Entity.Formation;
import Entity.Reclamation;
import config.ConfigBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class ReclamationService {
    Connection cnx = ConfigBD.getInstance().getCnx();
    
    public void ajouterReclamation(Reclamation r){
        String requete="INSERT INTO reclamation(message,date_rec,type,id_client,id_chauffeur) VALUES(?,?,?,?,?)";
        
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setString(1, r.getMessage());
            //java.sql.Date d_rec = new java.sql.Date(r.getDate_rec().getTime());
           // st.setDate(2, d_rec);
           st.setString(2, r.getDate_rec());
           
            st.setString(3, r.getType());
            st.setInt(4, r.getId_client());
            st.setInt(5, r.getId_chauffeur());
            
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update (int id,String message, String date_rec, String type,int id_client,int id_chauffeur) throws ParseException
     {
         //SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        // Date da = sdf.parse(date_rec);
             String requete="UPDATE reclamation SET message='"+message+"',date_rec='"+date_rec+"',type='"+type+"',id_client='"+id_client+"',id_chauffeur='"+id_chauffeur+"' WHERE id="+id;
         try{
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("reclamation bien modofiée");
        } catch (SQLException ex) {
            Logger.getLogger(ConfigBD.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    
    
    /* public void modifierReclamation(Reclamation r){
        String requete="UPDATE reclamation SET message=?, date_rec=?, type=?, id_client=?, id_chauffeur=? WHERE id=?";
        
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setString(1, r.getMessage());
            java.sql.Date d_rec = new java.sql.Date(r.getDate_rec().getTime());
            st.setDate(2, d_rec);
            st.setString(3, r.getType());
            st.setInt(4, r.getId_client());
            st.setInt(5, r.getId_chauffeur());
            st.setInt(6, r.getId());
            
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    } */
     
      public void supprimerReclamation(Reclamation r){
        String requete = "DELETE FROM reclamation WHERE id=?";
        
         try {
             PreparedStatement statement = cnx.prepareStatement(requete);
             statement.setInt(1, r.getId());
             statement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
      
      public ObservableList<Reclamation> getListReclamation(){
         String requete="SELECT * FROM reclamation";
         ObservableList<Reclamation> list = FXCollections.observableArrayList();        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                Reclamation r = new Reclamation();
                r.setId(rs.getInt(1));
                r.setMessage(rs.getString(2));
                r.setDate_rec(rs.getString(3));
                r.setType(rs.getString(4));
                r.setId_client(rs.getInt(5));
                r.setId_chauffeur(rs.getInt(6));
                
                
                list.add(r);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return list;
     }
      
      public int getNbrReclamationsClient(Client c){
          int nbr=0;
          String requete="SELECT COUNT(*) FROM reclamation WHERE id_client=? AND type=?";
          
          try {
             PreparedStatement st = cnx.prepareStatement(requete);
             st.setInt(1, c.getId());
             st.setString(2, "chauffeur");
             ResultSet rs = st.executeQuery();
             while (rs.next()){
             nbr =  ((Number) rs.getObject(1)).intValue();
             }
         } catch (SQLException ex) {
             Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
         }
           
         return nbr;
      }
}
