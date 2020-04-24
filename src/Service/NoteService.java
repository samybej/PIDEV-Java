/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Note;
import Entity.Vehicule;
import config.ConfigBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class NoteService {
 Connection cnx = ConfigBD.getInstance().getCnx();    
    public void ajouterNote(Note n){
        String requete="INSERT INTO note (note,id_client,id_chauffeur) VALUES(?,?,?)";
        
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setFloat(1, n.getNote());
            pst.setInt(2, n.getId_client());
            pst.setInt(3, n.getId_chauffeur());
         
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modifierNote(Note n){
        String requete="UPDATE note SET note=? WHERE id_chauffeur=? AND id_client=?";
        
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setFloat(1, n.getNote());
            pst.setInt(2, n.getId_chauffeur());
            pst.setInt(3, n.getId_client());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void supprimerNote(Note n){
        String requete = "DELETE FROM note WHERE id_client=? AND id_chauffeur=?";
        
         try {
             PreparedStatement statement = cnx.prepareStatement(requete);
             statement.setInt(1, n.getId_client());
             statement.setInt(2, n.getId_chauffeur());
             
             statement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
