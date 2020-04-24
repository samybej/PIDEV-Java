/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Chauffeur;
import Entity.Client;
import Entity.Formation;
import Entity.Offre;
import Entity.Reservation;
import config.ConfigBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ChauffeurService {
 Connection cnx = ConfigBD.getInstance().getCnx();
 
 public void ajouterChauffeur(Chauffeur c){
        String requete="INSERT INTO chauffeur (cin,nom,prenom,tel,mdp,id_vehicule) VALUES (?,?,?,?,?,?)";
        
        
        
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, c.getCIN());
            pst.setString(2, c.getNom());
            pst.setString(3, c.getPrenom());
            pst.setInt(4, c.getTel());

       
           // inputStream = new FileInputStream(c.getImg_profil());          
            pst.setString(5, c.getMdp());
            pst.setInt(6, c.getId_vehicule());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




 
/*   public void ajouterChauffeur(Chauffeur c){
        String requete="INSERT INTO chauffeur (cin,nom,prenom,tel,sexe,date_naissance,salaire,note,etat_compte,role,num_permis,mdp,id_vehicule) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        
        
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, c.getCIN());
            pst.setString(2, c.getNom());
            pst.setString(3, c.getPrenom());
            pst.setInt(4, c.getTel());
            pst.setString(5, c.getSexe());
            java.sql.Date sqlDate = new java.sql.Date(c.getDate_naissance().getTime());
            pst.setDate(6, sqlDate);
            pst.setFloat(7, c.getSalaire());
           // inputStream = new FileInputStream(c.getImg_profil());          
            pst.setFloat(8, c.getNote());
            pst.setInt(9, c.getEtat_compte());
            pst.setString(10, c.getType_chauff());
            pst.setInt(11, c.getNum_permis());
            pst.setString(12, c.getMdp());
            pst.setInt(13, c.getId_vehicule());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    } */ 
    
    public List<Chauffeur> getListChauffeur(){
        List<Chauffeur> list = new ArrayList<>();
        String requete="SELECT * from chauffeur";
        
        try {
           Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requete);
           while (rs.next()){
               Chauffeur c = new Chauffeur();
               c.setId(rs.getInt(1));
               c.setCIN(rs.getInt(2));
               c.setNom(rs.getString("nom"));
               c.setPrenom(rs.getString("prenom"));
               c.setTel(rs.getInt(5));
               c.setSexe(rs.getString("sexe"));
               c.setMdp(rs.getString("mdp"));
               c.setEtat_compte(rs.getInt(11));
               c.setDate_naissance(rs.getDate("date_naissance"));
               c.setSalaire(rs.getFloat("salaire"));
               c.setNote(rs.getFloat("note"));
               c.setType_chauff(rs.getString("role"));
               c.setNum_permis(rs.getInt("num_permis"));
               c.setId_vehicule(rs.getInt("id_vehicule"));
              
               
               list.add(c);
           }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
     /*  public void modifierChauffeur(Chauffeur c){
        String requete="UPDATE chauffeur SET cin=?, nom=?, prenom=?, tel=?, sexe=?, date_naissance=?, salaire=?, note=?, etat_compte=?, role=?, num_permis=?, mdp=?, id_vehicule=?, nbReclamation=? WHERE id=?";
        
        
        
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, c.getCIN());
            pst.setString(2, c.getNom());
            pst.setString(3, c.getPrenom());
            pst.setInt(4, c.getTel());
            pst.setString(5, c.getSexe());
            java.sql.Date sqlDate = new java.sql.Date(c.getDate_naissance().getTime());
            pst.setDate(6, sqlDate);
            pst.setFloat(7, c.getSalaire());
           // inputStream = new FileInputStream(c.getImg_profil());          
            pst.setFloat(8, c.getNote());
            pst.setInt(9, c.getEtat_compte());
            pst.setString(10, c.getType_chauff());
            pst.setInt(11, c.getNum_permis());
            pst.setString(12, c.getMdp());
            
            pst.setInt(13, c.getId_vehicule());
            pst.setInt(14, c.getNbReclamation());
            pst.setInt(15, c.getId());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    } */ 
       
       public void modifierChauffeur(Chauffeur c){
        String requete="UPDATE chauffeur SET cin=?, nom=?, prenom=?, tel=?, mdp=?, id_vehicule=? WHERE id=?";
        
        
        
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, c.getCIN());
            pst.setString(2, c.getNom());
            pst.setString(3, c.getPrenom());
            pst.setInt(4, c.getTel());
           
           // inputStream = new FileInputStream(c.getImg_profil());          
            
           
            pst.setString(5, c.getMdp());
            
            pst.setInt(6, c.getId_vehicule());
            pst.setInt(7, c.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        public void supprimerChauffeur(Chauffeur c){
        String requete = "DELETE FROM chauffeur WHERE id=?";
        
         try {
             PreparedStatement statement = cnx.prepareStatement(requete);
             statement.setInt(1, c.getId());
             statement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
        
        public void calculerChauffeur(Chauffeur c){
            Date date_actuelle = new Date();
             java.sql.Date d_actuelle = new java.sql.Date(date_actuelle.getTime());
            
            String requete="SELECT * FROM reservation WHERE id_chauffeur=? AND etat=0 AND DATEDIFF(?,?) <= 30  ";
                        
              try {
           PreparedStatement st = cnx.prepareStatement(requete);
           st.setInt(1, c.getId());
            java.sql.Date date_naissance = new java.sql.Date(c.getDate_naissance().getTime());
           st.setDate(2, date_naissance);
           st.setDate(3, d_actuelle);
           ResultSet rs = st.executeQuery();
           while (rs.next()){
               Reservation r = new Reservation();
               ReservationService  resService = new ReservationService();
               
               r.setId(rs.getInt(1));
               r.setDistance(rs.getFloat(2));
               r.setDepart(rs.getString(3));
               r.setArrive(rs.getString(4));
              
               r.setDate(rs.getDate(5));
               r.setId_chauffeur(rs.getInt(6));
               r.setId_client(rs.getInt(7));
               r.setType("taxi");
               r.setTarif(rs.getFloat(9));
               r.setEtat(rs.getInt(10));
               
               resService.calculTarif(r);
               c.setSalaire(c.getSalaire()+(r.getTarif()*0.2f));

           }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        
        public void updateSalaire(Chauffeur c){
            calculerChauffeur(c);
            String requete="UPDATE chauffeur SET salaire=? WHERE id=?";
            
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setFloat(1, c.getSalaire());
            pst.setInt(2, c.getId());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChauffeurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        public void calculerNote(Chauffeur c){
            
            String requete="SELECT AVG(note) FROM note WHERE id_chauffeur=?";
            
            try {
             PreparedStatement st = cnx.prepareStatement(requete);
             st.setInt(1, c.getId());
            // st.setString(2, "chauffeur");
             ResultSet rs = st.executeQuery();
             while (rs.next()){
            float nbr =  ((Number) rs.getObject(1)).floatValue();
            c.setNote(nbr);
             }
         } catch (SQLException ex) {
             Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
        
       
        public int nbrReclamationsChauffeur(int id_chauffeur){
            String requete="SELECT COUNT(*) FROM reclamation WHERE type=? AND id_chauffeur=?";
            int nbr=0;
             try {
             PreparedStatement st = cnx.prepareStatement(requete);
             st.setString(1, "chauffeur");
             st.setInt(2, id_chauffeur);
             ResultSet rs = st.executeQuery();
             while (rs.next()){
             nbr =  ((Number) rs.getObject(1)).intValue();
             }
                         
         } catch (SQLException ex) {
             Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
         }
             return nbr;
        }
        
        public void bloquerChauffeur(Chauffeur c,Formation f){
            int nbr = nbrReclamationsChauffeur(c.getId());
            //   System.out.println(c.getId());
            if (nbr >= 5){
                ChauffeurService cService = new ChauffeurService();
                FormationService fService = new FormationService();
                c.setEtat_compte(0);
                cService.modifierChauffeur(c);
                
                fService.participerFormation(c.getId(), f);
                
            }
        }
        
        
         public List<Chauffeur> getListChauffeurByNote(int note){
        List<Chauffeur>list = new ArrayList<>();
        String requette="SELECT * from chauffeur where note>=?";
        
        try {
           PreparedStatement st =cnx.prepareStatement(requette);
                      st.setInt(1,note);

           ResultSet rs = st.executeQuery();
           while (rs.next()){
               Chauffeur c = new Chauffeur();
             
               c.setId(rs.getInt(1));
               c.setCIN(rs.getInt(2));
               c.setNom(rs.getString("nom"));
               c.setPrenom(rs.getString("prenom"));
               c.setTel(rs.getInt(5));
               c.setSexe(rs.getString("sexe"));
               c.setMdp(rs.getString("mdp"));
               c.setEtat_compte(rs.getInt(11));
               c.setDate_naissance(rs.getDate("date_naissance"));
               c.setSalaire(rs.getFloat("salaire"));
               c.setNote(rs.getFloat("note"));
               c.setType_chauff(rs.getString("role"));
               c.setNum_permis(rs.getInt("num_permis"));
               c.setId_vehicule(rs.getInt("id_vehicule"));
               
            
               list.add(c);
           }
        }
        
        catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return list ;
        
}
         
         public Chauffeur recupererChauffeurLogin(String mail,String mdp)
    {
        Chauffeur c = new Chauffeur();
            String requete = "SELECT * FROM chauffeur WHERE cin = ? and mdp = ?";
            
             try {
             PreparedStatement st = cnx.prepareStatement(requete);
             st.setString(1, mail);
             st.setString(2, mdp);
             ResultSet rs = st.executeQuery();
             while (rs.next()){
               c.setId(rs.getInt(1));
               c.setCIN(rs.getInt("cin"));
               c.setNom(rs.getString("nom"));
               c.setPrenom(rs.getString("prenom"));
               c.setTel(rs.getInt("tel"));
               c.setSexe(rs.getString("sexe"));
               c.setDate_naissance(rs.getDate("date_naissance"));
               c.setMdp(rs.getString("mdp"));
               c.setEtat_compte(rs.getInt("etat_compte"));
               c.setSalaire(rs.getFloat("salaire"));
               c.setNote(rs.getFloat("note"));
               c.setType_chauff(rs.getString("role"));
               c.setNum_permis(rs.getInt("num_permis"));
               c.setId_vehicule(rs.getInt("id_vehicule"));
               
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
         }
            
        return c;
    }
         
             public Chauffeur getListChauffeurByNomPrenom(String nom, String prenom){
                Chauffeur c = new Chauffeur();
        String requette="SELECT * from chauffeur where nom>=? AND prenom=?";
        
        try {
           PreparedStatement st =cnx.prepareStatement(requette);
                      st.setString(1,nom);
                      st.setString(2,prenom);

           ResultSet rs = st.executeQuery();
           
            
             while(rs.next()){
               c.setId(rs.getInt(1));
               c.setCIN(rs.getInt(2));
               c.setNom(rs.getString("nom"));
               c.setPrenom(rs.getString("prenom"));
               c.setTel(rs.getInt(5));
               c.setSexe(rs.getString("sexe"));
               c.setMdp(rs.getString("mdp"));
               c.setEtat_compte(rs.getInt(11));
               c.setDate_naissance(rs.getDate("date_naissance"));
               c.setSalaire(rs.getFloat("salaire"));
               c.setNote(rs.getFloat("note"));
               c.setType_chauff(rs.getString("role"));
               c.setNum_permis(rs.getInt("num_permis"));
               c.setId_vehicule(rs.getInt("id_vehicule"));
               c.setNbReclamation(rs.getInt("nbReclamation"));
            
             }
           }
        
        
        catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return c ;
        
}     
    
        
        
        
}
