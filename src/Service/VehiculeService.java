/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Chauffeur;
import Entity.Client;
import Entity.Vehicule;
import config.ConfigBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class VehiculeService {
        Connection cnx = ConfigBD.getInstance().getCnx();    
    
    public void ajouterVehicule(Vehicule v){
        String requete="INSERT INTO Vehicule (immatriculation,numero_assurance,marque,type,etat) VALUES(?,?,?,?,?)";
        
        try {
            PreparedStatement statement = cnx.prepareStatement(requete);
            statement.setString(1 , v.getImmatriculation());
            statement.setInt(2 , v.getNum_assurance());
            statement.setString(3 , v.getMarque());
            statement.setString(4, v.getType());
            statement.setInt(5, v.getEtat());
           // statement.setInt(6, v.getId_chauffeur());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void modifierVehicule(Vehicule v){
        String requete="UPDATE Vehicule SET immatriculation=?, numero_assurance=?, marque=?, type=?, etat=? WHERE id=?";
        
        try {
            PreparedStatement statement = cnx.prepareStatement(requete);
            statement.setString(1 , v.getImmatriculation());
            statement.setInt(2 , v.getNum_assurance());
            statement.setString(3 , v.getMarque());
            statement.setString(4, v.getType());
            statement.setInt(5, v.getEtat());
           // statement.setInt(6, v.getId_chauffeur());
            statement.setInt(6, v.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<Vehicule> getListVehicule(){
        List<Vehicule> list = new ArrayList<>();
       
        String requete="SELECT * FROM vehicule";
        
        Statement statement;
        try {
            statement = cnx.createStatement();
            ResultSet rs = statement.executeQuery(requete);
            
            while (rs.next()){
             Vehicule v = new Vehicule();
             
             v.setId(rs.getInt(1));
             v.setImmatriculation(rs.getString("immatriculation"));
             v.setNum_assurance(rs.getInt(3));
             v.setMarque(rs.getString("marque"));
             v.setType(rs.getString("type"));
             v.setEtat(rs.getInt("etat"));
           
             
             list.add(v);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
     public void supprimerVehicule(Vehicule v){
        String requete = "DELETE FROM vehicule WHERE id=?";
        
         try {
             PreparedStatement statement = cnx.prepareStatement(requete);
             statement.setInt(1, v.getId());
             statement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
     
     public List<Vehicule> getVehiculesDispo(){
         List<Vehicule> list = new ArrayList<>();       
         String requete="SELECT * FROM vehicule WHERE etat=0";
        
        Statement statement;
        try {
            statement = cnx.createStatement();        
            ResultSet rs = statement.executeQuery(requete);
                    
            while (rs.next()){
             Vehicule v = new Vehicule();
             
             v.setId(rs.getInt(1));
             v.setImmatriculation(rs.getString("immatriculation"));
             v.setNum_assurance(rs.getInt(3));
             v.setMarque(rs.getString("marque"));
             v.setType(rs.getString("type"));
             v.setEtat(rs.getInt("etat"));
           
             
             list.add(v);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return list;
     }
}
