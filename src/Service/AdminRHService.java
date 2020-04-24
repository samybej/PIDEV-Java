/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.AdminRH;
import Entity.Chauffeur;
import Entity.Client;
import Entity.Meuble;
import Entity.Postulation;
import Entity.Reservation;
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


public class AdminRHService {
    Connection cnx = ConfigBD.getInstance().getCnx();
    
    public void ajouterAdminRH(AdminRH a){
        String requete="INSERT INTO adminrh (login,mdp,etat_compte,mail) VALUES (?,?,?,?)";
        
        
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
    
    public void modifierAdminRH(AdminRH a){
        String requete="UPDATE adminrh set login=?, mdp=?, etat_compte=?, mail=? WHERE login=?";
        
        
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
     
    public void supprimerAdminRH(AdminRH a){
        String requete = "DELETE FROM adminrh WHERE login=?";
        
         try {
             PreparedStatement statement = cnx.prepareStatement(requete);
             statement.setString(1, a.getLogin());
             statement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
     public List<AdminRH> getListAdminRH(){
        List<AdminRH> list = new ArrayList<>();
        String requete="SELECT * from adminrh";
        
        try {
           Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requete);
           while (rs.next()){
               AdminRH a = new AdminRH();
               a.setLogin(rs.getString(1));
               a.setMdp(rs.getString(2));
               a.setEtat_compte(rs.getInt(3));
               a.setMail(rs.getString(4));
                           
               list.add(a);
           }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
     
     public void validerPostulation(Postulation p,Chauffeur c){
         String requete="DELETE FROM postulation WHERE id_client=?";
         
         try {
             PreparedStatement statement = cnx.prepareStatement(requete);
             statement.setInt(1, p.getId_client());
             statement.executeUpdate();
             
             ChauffeurService chService = new ChauffeurService();
             chService.ajouterChauffeur(c);
             
         } catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
         
     }
     
     
    public AdminRH recupererAdminLogin(String mail,String mdp)
    {
        AdminRH c = new AdminRH();
        
            String requete = "SELECT * FROM adminrh WHERE login = ? and mdp = ?";
            
             try {
             PreparedStatement st = cnx.prepareStatement(requete);
             st.setString(1, mail);
             st.setString(2, mdp);
             ResultSet rs = st.executeQuery();
             while (rs.next()){
               c.setLogin(rs.getString(1));
               c.setMdp(rs.getString("mdp"));
               c.setEtat_compte(rs.getInt(3));
               c.setMail(rs.getString(4));
               
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
         }
            
             System.out.println(c);
        return c;
    }
     
     
}


