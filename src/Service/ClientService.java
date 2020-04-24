/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.Connection;
import config.ConfigBD;
import Entity.Client;
import Utilitaire.CryptPassword;
        
//import com.itextpdf.text.pdf.qrcode.WriterException;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.provider.MD5;




public class ClientService {
    
    Connection cnx = ConfigBD.getInstance().getCnx();     
     public void ajouterClient(Client c){
                    CryptPassword encryption = new CryptPassword() ;

        String requete="INSERT INTO client (nom,prenom,tel,adresse,mdp,etat_compte,mail) VALUES (?,?,?,?,?,?,?)";
        
       
        
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, c.getNom());
            pst.setString(2, c.getPrenom());
            pst.setInt(3, c.getTel());
            pst.setString(4, c.getAdresse());
         try {
                pst.setString(5, encryption.cryptme(c.getMdp()));
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
            }
            pst.setInt(6, c.getEtat_compte());
           // inputStream = new FileInputStream(c.getImg_profil());          
            pst.setString(7, c.getMail());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
    public Client rechercheUtilisateurParUsername(String mail) {
        //    Client a = new Client();
          Client c = new Client();

            String requete = "SELECT * FROM client  WHERE  mail='" + mail + "';";
          
            try {
           Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requete);
           while (rs.next()){
             
               c.setId(rs.getInt(1));
               c.setNom(rs.getString("nom"));
               c.setPrenom(rs.getString("prenom"));
               c.setTel(rs.getInt(4));
               c.setAdresse(rs.getString("adresse"));
               c.setMdp(rs.getString("mdp"));
               c.setEtat_compte(rs.getInt(7));
               c.setMail(rs.getString("mail"));
               System.out.println(mail);
               System.out.println(c.getMail());
              
           }
        } catch (SQLException ex) {

            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;   }
       
    public List<Client> getListClient(){
        List<Client> list = new ArrayList<>();
        String requete="SELECT * from client";
        
        try {
           Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requete);
           while (rs.next()){
               Client c = new Client();
               c.setId(rs.getInt(1));
               c.setNom(rs.getString("nom"));
               c.setPrenom(rs.getString("prenom"));
               c.setTel(rs.getInt(4));
               c.setAdresse(rs.getString("adresse"));
               c.setMdp(rs.getString("mdp"));
               c.setEtat_compte(rs.getInt(7));
               c.setMail(rs.getString("mail"));
               
               list.add(c);
           }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public void modifierClient(Client c){
        String requete="UPDATE client SET nom=?, prenom=?, tel=?, adresse=?, mdp=?, etat_compte=?, mail=? WHERE id=? ";
        
        
        
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, c.getNom());
            pst.setString(2, c.getPrenom());
            pst.setInt(3, c.getTel());
            pst.setString(4, c.getAdresse());
            pst.setString(5, c.getMdp());
            pst.setInt(6, c.getEtat_compte());
           // inputStream = new FileInputStream(c.getImg_profil());          
            pst.setString(7, c.getMail());
            System.out.println(c.getId());
            pst.setInt(8, c.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void supprimerClient(Client c){
        String requete = "DELETE FROM client WHERE id=?";
        
         try {
             PreparedStatement statement = cnx.prepareStatement(requete);
             statement.setInt(1, c.getId());
             statement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void calculerPoints(Client c){
        ReservationService rService = new ReservationService();
        ReclamationService recService = new ReclamationService();
        
        int nbr_res=rService.recupererNbrReservations(c);
        int nbr_rec=recService.getNbrReclamationsClient(c);
        System.out.println(nbr_res);
        System.out.println(nbr_rec);
        if (nbr_res >= 5 && nbr_rec > 2 ) {
            System.out.println("fff");
            c.setPoints(c.getPoints()+5);
        } 
    }
    public void updatePoints(Client c){
        calculerPoints(c);
         String requete="UPDATE client SET point=? WHERE id=?";
            
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setFloat(1, c.getPoints());
            pst.setInt(2, c.getId());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChauffeurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
    public void updateMdpUtilisateur(String mdp,String email) {
        try {
           
           CryptPassword encryption = new CryptPassword() ;
           String requete="";
            try {
                requete = "UPDATE client SET mdp ='"+encryption.cryptme(mdp)+"' WHERE mail ='"+email+"';";
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
            }

            Statement stl = cnx.createStatement();
            int rs =stl.executeUpdate(requete);
            
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
}
    
    
    public int recupererPointsParId(int id){
        int points=0;
        
         String requete="SELECT point FROM client WHERE id=?";
            
            
         try {
             PreparedStatement st = cnx.prepareStatement(requete);
             st.setInt(1,id);
             ResultSet rs = st.executeQuery();
             while (rs.next()){
             points =  ((Number) rs.getObject(1)).intValue();
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return points;
    }
    
    public Client recupererClientLogin(String mail,String mdp)
    {
        Client c = new Client();
            String requete = "SELECT * FROM client WHERE mail = ? and mdp = ?";
            
             try {
             PreparedStatement st = cnx.prepareStatement(requete);
             st.setString(1, mail);
             st.setString(2, mdp);
             ResultSet rs = st.executeQuery();
             while (rs.next()){
               c.setId(rs.getInt(1));
               c.setNom(rs.getString("nom"));
               c.setPrenom(rs.getString("prenom"));
               c.setTel(rs.getInt(4));
               c.setAdresse(rs.getString("adresse"));
               c.setMdp(rs.getString("mdp"));
               c.setEtat_compte(rs.getInt(7));
               c.setMail(rs.getString("mail"));
               c.setPoints(rs.getInt("point"));
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
         }
            
        return c;
    }
    
    public void modifierClientProfil(Client c){
        String requete="UPDATE client SET nom=?, prenom=?, mdp=?,  tel=?  WHERE id=? ";
        
        
        
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, c.getNom());
            pst.setString(2, c.getPrenom());
            pst.setString(3, c.getMdp());
            pst.setInt(4, c.getTel());            
            System.out.println(c.getId());
            pst.setInt(5, c.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean verifEmail(String email) {
            boolean verif =true;

                    //   String sql = "SELECT * FROM fos_user  WHERE roles like '%ROLE_UTILISATEUR%'and email='"+ Email+"';";
                       String sql = "SELECT * FROM client  WHERE  mail='"+ email+"';";

                       try {
                           Statement stl = cnx.createStatement();
                           ResultSet rs = stl.executeQuery(sql);

                           if (rs.next()) {
                            verif=false;
                           }

                       } catch (SQLException ex) {
                           Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   return verif;            }
    
    
     public Client getClientParId(int id){
        Client c = new Client();
        String requete="SELECT * from client WHERE id=?";
        
        try {
          PreparedStatement st = cnx.prepareStatement(requete);
          st.setInt(1, id);
           ResultSet rs = st.executeQuery();
           while (rs.next()){
                c.setId(rs.getInt(1));
               c.setNom(rs.getString("nom"));
               c.setPrenom(rs.getString("prenom"));
               c.setTel(rs.getInt(4));
               c.setAdresse(rs.getString("adresse"));
               c.setMdp(rs.getString("mdp"));
               c.setEtat_compte(rs.getInt(7));
               c.setMail(rs.getString("mail"));
           }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
    }
    
}
