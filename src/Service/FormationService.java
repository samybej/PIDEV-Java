/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Chauffeur;
import config.ConfigBD;
import Entity.Formation;
import Entity.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




public class FormationService {
    Connection cnx = ConfigBD.getInstance().getCnx();
    
    public void ajouterFormation(Formation f){
        String requete="INSERT INTO formation (date_debut,date_fin,titre,lieu,time,nbr_place) VALUES(?,?,?,?,?,?)";
        
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            java.sql.Date d_debut = new java.sql.Date(f.getDate_debut().getTime());
            st.setDate(1, d_debut);
            java.sql.Date d_fin = new java.sql.Date(f.getDate_fin().getTime());
            st.setDate(2, d_fin);
            st.setString(3, f.getTitre());
            st.setString(4, f.getLieu());
                        st.setString(5, f.getTime());
                        st.setInt(6, f.getNbr_place());

            
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public void modiferFormation(Formation f){
        String requete="UPDATE formation set date_debut=?, date_fin=?, titre=?, lieu=? WHERE id=?";
        
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            java.sql.Date d_debut = new java.sql.Date(f.getDate_debut().getTime());
            st.setDate(1, d_debut);
            java.sql.Date d_fin = new java.sql.Date(f.getDate_fin().getTime());
            st.setDate(2, d_fin);
            st.setString(3, f.getTitre());
            st.setString(4, f.getLieu());
            st.setInt(5, f.getId()); 
            
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
     public void supprimerFormation(Formation f){
        String requete = "DELETE FROM formation WHERE id=?";
        
         try {
             PreparedStatement statement = cnx.prepareStatement(requete);
             statement.setInt(1, f.getId());
             statement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
     
     public List<Formation> getListFormation(){
         String requete="SELECT * FROM formation";
         List<Formation> list = new ArrayList<>();
         
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                Formation f = new Formation();
                f.setId(rs.getInt(1));
                f.setDate_debut(rs.getDate(2));
                f.setDate_fin(rs.getDate(3));
                f.setTitre(rs.getString(4));
                f.setLieu(rs.getString(5));
                f.setTime(rs.getString(6));
                f.setNbr_place(rs.getInt(7));
                
                list.add(f);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return list;
     }
     
     //besh najem naffichi ken eli mazelo disponible
     public List<Formation> getListFormationDisponible(){
         String requete="SELECT * FROM formation where nbr_place<>0 and DATEDIFF(date_debut,Sysdate())>=1  ";
         List<Formation> list = new ArrayList<>();
         
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                Formation f = new Formation();
                f.setId(rs.getInt(1));
                f.setDate_debut(rs.getDate(2));
                f.setDate_fin(rs.getDate(3));
                f.setTitre(rs.getString(4));
                f.setLieu(rs.getString(5));
                f.setTime(rs.getString(6));
                f.setNbr_place(rs.getInt(7));
                
                list.add(f);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return list;
     }
     
     
     
     
     
     //khdemt b hedhy
      public void participerFormation(int id ,Formation f){
             String requete="INSERT INTO participation (id_formation,id_chauffeur) VALUES (?,?)";
               
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
           
            pst.setInt(1, f.getId());
            pst.setInt(2, id);         
             
            pst.executeUpdate();
            updateNbrDispo(f);
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
      
      
        public void participerFormation2( int ic,int i){
             String requete="INSERT INTO participation (id_formation,id_chauffeur) VALUES (?,?)";
               
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
           
            pst.setInt(1, i);
            pst.setInt(2, ic);         
             
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

          public void supprimerParticipation(Formation f,int i){
        String requete = "DELETE FROM participation WHERE id_chauffeur=? and id_formation=?";
        
         try {
             PreparedStatement statement = cnx.prepareStatement(requete);
             statement.setInt(1, i);
                          statement.setInt(2, f.getId());

             
             statement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
         
          
            
     public List<Formation> getListparticipation(int i){
  
        String requete="SELECT f.id,f.date_debut,f.date_fin,f.titre,f.lieu FROM `formation` f ,`participation`p where p.id_formation=f.id and p.id_chauffeur='"+i+"'";
       // String requete= "Select * from participation";
       List<Formation> list = new ArrayList<>();
         
        try {
            Statement st = cnx.createStatement();
             
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                Formation f = new Formation();
                f.setId(rs.getInt(1));
                f.setDate_debut(rs.getDate(2));
                f.setDate_fin(rs.getDate(3));
                f.setTitre(rs.getString(4));
                f.setLieu(rs.getString(5));
                
                list.add(f);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return list;
     }
     
          
          
          
    public List<Chauffeur>  getlistparticipantFormation(int i){
 //String requete="Select c.id ,c.nom ,c.prenom ,c.tel ,c.note from chauffeur c ,participation p,formation f WHERE c.id= p.id_chauffeur and f.id=p.id_formation"; 
String requete= "select    DISTINCT   nom,prenom,tel,note from `chauffeur`,`participation` ,`formation` WHERE participation.id_chauffeur=chauffeur.id AND '"+i+"'=participation.id_formation";


        List<Chauffeur> list = new ArrayList<>();
        
        try {
           Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requete);
           while (rs.next()){
               Chauffeur c = new Chauffeur();
              
          //   c.setId(rs.getInt("id"));
            
               c.setNom(rs.getString("nom"));
               c.setPrenom(rs.getString("prenom"));
               c.setTel(rs.getInt("tel"));
               c.setNote(rs.getFloat("note"));
               list.add(c);
           }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
         
        

    
     public List<Reclamation>  getlistReclamtionBychauffeur(int i){
 //String requete="Select c.id ,c.nom ,c.prenom ,c.tel ,c.note from chauffeur c ,participation p,formation f WHERE c.id= p.id_chauffeur and f.id=p.id_formation"; 
    String requete= "Select r.message from reclamation r where'"+i+"'=r.id_chauffeur" +

"";


        List<Reclamation> list = new ArrayList<>();
        
        try {
           Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requete);
           while (rs.next()){
              
               Reclamation r = new Reclamation();
          //   c.setId(rs.getInt("id"));
               r.setMessage(rs.getString("message"));
             
               list.add(r);
           }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
        
     //pour statistique
                 public int participantselonformation(String jour) throws ParseException{
             List<Integer> list = new ArrayList<>();
                
                int nbr=0;
               // System.out.println(jour);
                String requete="SELECT COUNT(*) FROM participation p WHERE p.id_formation in (select formation.id from formation where formation.titre='"+jour+"')";
                
                try {
           PreparedStatement st =cnx.prepareStatement(requete);
                  /*  String sDate1=jour+"/02/2020"; 
                    System.out.println(sDate1);
                    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1); 
                    java.sql.Date t = new java.sql.Date(date1.getTime());
                    st.setDate(1, t);*/
                
      
           ResultSet rs = st.executeQuery();
           while (rs.next()){
               nbr =  ((Number) rs.getObject(1)).intValue();
               //System.out.println(nbr);
             
           }
           
            }
                 catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
                
                return nbr;
            }
             
                 
                 
              
     public void updateNbrDispo(Formation f){
        String requete="UPDATE Formation SET nbr_place=nbr_place-1 WHERE id=?";
        
         try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, f.getId());        
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
                 
                 
                 
          }
                  
        
          
          
          
          

