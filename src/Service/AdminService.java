/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Admin;
import Entity.AdminRH;
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


public class AdminService {
     Connection cnx = ConfigBD.getInstance().getCnx();
    
    public void ajouterAdmin(Admin a){
        String requete="INSERT INTO admin (login,mdp,etat_compte,mail) VALUES (?,?,?,?)";
        
        
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, a.getLogin());
            pst.setString(2, a.getMdp());
            pst.setInt(3, a.getEtat_compte());
            pst.setString(4, a.getMail());
           
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modifierAdmin(Admin a){
        String requete="UPDATE admin set login=?, mdp=?, etat_compte=?, mail=? WHERE login=?";
        
        
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, a.getLogin());
            pst.setString(2, a.getMdp());
            pst.setInt(3, a.getEtat_compte());
            pst.setString(4, a.getMail());
            pst.setString(5, a.getLogin());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void supprimerAdmin(Admin a){
        String requete = "DELETE FROM admin WHERE login=?";
        
         try {
             PreparedStatement statement = cnx.prepareStatement(requete);
             statement.setString(1, a.getLogin());
             statement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
     public List<Admin> getListAdmin(){
        List<Admin> list = new ArrayList<>();
        String requete="SELECT * from adminrh";
        
        try {
           Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requete);
           while (rs.next()){
               Admin a = new Admin();
               a.setLogin(rs.getString(1));
               a.setMdp(rs.getString(2));
               a.setEtat_compte(rs.getInt(3));
               a.setMdp(rs.getString(4));
                           
               list.add(a);
           }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
}
