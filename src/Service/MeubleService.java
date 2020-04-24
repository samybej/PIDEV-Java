/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import config.ConfigBD;
import Entity.Meuble;
import Entity.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class MeubleService {
        Connection cnx = ConfigBD.getInstance().getCnx();           
           public void ajouterMeuble(Meuble m){
               String requete="INSERT INTO meuble (taille,prix,id_reservation) VALUES(?,?,?)";
               
                try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, m.getTaille());
           
            pst.setFloat(2, m.getPrix());
            pst.setInt(3, m.getId_reservation());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
           }
           
           public void modiferMeuble(Meuble m){
               String requete="UPDATE meuble SET taille=?, prix=?, id_reservation=? WHERE id=?";
               
                try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, m.getTaille());
   
            pst.setFloat(2, m.getPrix());
            pst.setInt(3, m.getId_reservation());
             pst.setInt(4, m.getId());
             
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
           }
           
             public void supprimerMeuble(Meuble m){
        String requete = "DELETE FROM meuble WHERE id=?";
        
         try {
             PreparedStatement statement = cnx.prepareStatement(requete);
             statement.setInt(1, m.getId());
             statement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
         
              public Meuble getMeuble(Reservation r,Meuble m){
                  
        String requete="SELECT * from meuble WHERE id_reservation=?";
        
       
               try {
                   PreparedStatement st = cnx.prepareStatement(requete);
                   st.setInt(1,r.getId());
                   ResultSet rs = st.executeQuery();
                   
               } catch (SQLException ex) {
                   Logger.getLogger(MeubleService.class.getName()).log(Level.SEVERE, null, ex);
               }
         
        
        return m;
    }
}
