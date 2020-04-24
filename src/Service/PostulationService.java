/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Chauffeur;
import Entity.Client;
import Entity.Formation;
import config.ConfigBD;
import Entity.Postulation;
import Entity.Vehicule;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.cell.PropertyValueFactory;


public class PostulationService {
     Connection cnx = ConfigBD.getInstance().getCnx();
     
     public void ajouterPostulation(Postulation p){
        
String requete="INSERT INTO postulation (date_demande,num_permis,cin,sexe,tel,experience,langue,nom,prenom,id_client) VALUES(SYSDATE(),?,?,?,?,?,?,?,?,?)";
         
     
         try {
            PreparedStatement statement = cnx.prepareStatement(requete);
            java.sql.Date d =  new java.sql.Date(p.getDate_demande().getTime());
            //statement.setDate(1 , d);
            statement.setInt(1 , p.getNum_permis());
            statement.setInt(2 , p.getCin());
            statement.setString(3, p.getSexe());
            statement.setInt(4 , p.getTel());
            statement.setInt(5, p.getExperience());
            statement.setString(6,p.getLangue());
            statement.setString(7,p.getNom());
            statement.setString(8,p.getPrenom());
            statement.setInt(9,p.getId_client());
            

           
          
            
           // InputStream inputStream = new FileInputStream(new File(file));
           // statement.setString(6, p.getCv_file());
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeService.class.getName()).log(Level.SEVERE, null, ex);
        
     }
     }
     
       /*public void ajouterarticle(article a )
    {
   String sql =   "INSERT INTO `article`(`titre`, `sujet`, `nomauteur`, `mail`, `contenu`, `date`,`etat`) VALUES ('"+a.getTitre_article()+"','"+a.getSujet_article()+"','"+a.getNom_auteur()+"','"+a.getAdresse_mail()+"','"+a.getContenu()+"', SYSDATE(),'non valide');";
 
           //"INSERT INTO `article`(`titre`, `sujet`, `nomauteur`, `mail`, `contenu`, `date`) VALUES("+a.getTitre_article()+ "','" +a.getSujet_article()+"','"+a.getNom_auteur()+"','"+a.getAdresse_mail()+"','"+a.getContenu()+"',SYSDATE());";
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            
        } catch (SQLException ex ) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
           
        }*/
     
     
     
     
     
     
     public void supprimerPostulation(int c){
        String requete = "DELETE FROM postulation WHERE postulation.cin=?";
        
         try {
             PreparedStatement statement = cnx.prepareStatement(requete);
             statement.setInt(1, c);
             statement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
     
      public List<Postulation> getListPostulation(){
        List<Postulation> list = new ArrayList<>();
       
        String requete="SELECT postulation.nom,postulation.prenom,postulation.cin,postulation.num_permis,postulation.experience,postulation.Langue,postulation.tel,postulation.date_demande,postulation.sexe FROM `postulation`";
        
        Statement statement;
        try {
            statement = cnx.createStatement();
            ResultSet rs = statement.executeQuery(requete);
            
            while (rs.next()){
             Postulation p = new Postulation();
             p.setNom(rs.getString("nom"));
             p.setPrenom(rs.getString("prenom"));
             p.setCin(rs.getInt("cin"));
             p.setNum_permis(rs.getInt("num_permis"));
              p.setExperience(rs.getInt("experience"));//Langue
              p.setLangue(rs.getString("Langue")); //,postulation.sexe
               p.setTel(rs.getInt("tel"));
             p.setDate_demande(rs.getDate("date_demande"));
               p.setSexe(rs.getString("sexe"));
             
              
             
             
             list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
      
      
      
        public List<Client> getinformationClient(int i){
        List<Client> list = new ArrayList<>();
       
        String requete="Select c.nom,c.prenom,c.tel,c.adresse,p.cv_fichier FROM `Client` c ,`postulation`p where p.id_client='"+i+"'";
        
        Statement statement;
        try {
            statement = cnx.createStatement();
            ResultSet rs = statement.executeQuery(requete);
            
            while (rs.next()){
             Client p = new Client();
             
             //p.setId(rs.getInt(1));
             p.setNom(rs.getString("nom"));
              p.setPrenom(rs.getString("prenom"));
             p.setTel(rs.getInt("tel"));
                          p.setAdresse(rs.getString("adresse"));

            
             
             list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
        
        
        
          
        public List<Postulation>  getclientcv(int i){
        List<Postulation> list = new ArrayList<>();
       
        String requete="Select p.cv_fichier FROM `postulation`p where p.id_client='"+i+"'";
        
        Statement statement;
        try {
            statement = cnx.createStatement();
            ResultSet rs = statement.executeQuery(requete);
            
            while (rs.next()){
             Postulation p = new Postulation();
             
           //  p.setCv_file(rs.getString("cv_fichier"));
             
            
             
             list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
        

           public void accepterPostulation(int id){
             String requete="INSERT INTO `chauffeur`(`cin`, `nom`, `prenom`, `tel`, `sexe`,`num_permis`) Select postulation.cin, postulation.nom,postulation.prenom,postulation.tel,postulation.sexe, postulation.num_permis from postulation where postulation.cin='"+id+"'";
               
        try {
           Statement pst = cnx.createStatement();
           
          
            pst.executeUpdate(requete);
            supprimerPostulation(id);
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
      
           public void genererPdf(Document document) throws SQLException, DocumentException
           {
               String requete="select * from postulation";
               
               PreparedStatement st = cnx.prepareStatement(requete);
               
               ResultSet rs = st.executeQuery();
               
               while (rs.next())
               {                  
                   Paragraph para = new Paragraph(rs.getString("nom")+" "+rs.getString("prenom")+" la date de demande est :"+ rs.getDate("date_demande")+" le numero permis est "+rs.getInt("num_permis")+",numero cin est "+rs.getInt("cin")+",il est excellent en "+rs.getString("Langue"));
                   document.add(para);
                   document.add(new Paragraph(" "));
               }
               
               document.close();
               
           }
        
       
     
      
     
}
