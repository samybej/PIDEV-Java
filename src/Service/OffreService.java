/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Chauffeur;
import Entity.Client;
import Entity.Offre;
import Entity.Reservation;
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




public class OffreService {
        
    Connection cnx = ConfigBD.getInstance().getCnx();
    
    public void ajouterOffre(Offre o){
        String requete="INSERT INTO offre (nb_place,depart,arrive,date,time,tarif,id_offreur,id_client,vehicule,bagage) VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        
        
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, o.getNb_place());
            pst.setString(2, o.getDepart());
            pst.setString(3, o.getArrive());
            java.sql.Date d = new java.sql.Date(o.getDate().getTime());
            pst.setDate(4, d);
           // java.sql.Time t = new java.sql.Time(o.getTime().getTime());
            pst.setString(5, o.getTime());
            pst.setFloat(6, o.getTarif());
          
            pst.setInt(7, o.getId_offreur());      
             pst.setInt(8, o.getId_client());   
             pst.setString(9, o.getVehicule());
             pst.setString(10, o.getBagage());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateNbrDispo(Offre o){
        String requete="UPDATE offre SET nb_place=nb_place-1 WHERE id=?";
        
         try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, o.getId());        
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean verifierInscription(Offre o,int id_client)
    {
        int nbr=0;
        String requete="SELECT COUNT(*) from inscri_offre WHERE id_offre=? AND id_client=?";
         try {
           PreparedStatement st = cnx.prepareStatement(requete);
           st.setInt(1, o.getId());
           st.setInt(2, id_client);
           ResultSet rs = st.executeQuery();
           while (rs.next()){
                nbr =  ((Number) rs.getObject(1)).intValue();
               
           }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
         if (nbr != 0)
         {
             System.out.println(nbr);
              return false;
         }
        return true;
    }
    public void inscrireOffre(Offre o,int id_client){
        String requete="INSERT INTO inscri_offre (id_offre,id_client,id_offreur) VALUES (?,?,?)";
               
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
           
            pst.setInt(1, o.getId());
            pst.setInt(2, id_client);   
            pst.setInt(3, o.getId_offreur());      
 
             
            pst.executeUpdate();
            updateNbrDispo(o);
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Liste de tous les offres de tous les offreurs
    public List<Offre> getListOffre(){
        List<Offre> list = new ArrayList<>();
        String requete="SELECT * from offre";
        
        try {
           Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requete);
           while (rs.next()){
               Offre c = new Offre();
               c.setId(rs.getInt(1));
               c.setNb_place(rs.getInt(2));
               c.setDepart(rs.getString(3));
               c.setArrive(rs.getString(4));
               c.setDate(rs.getDate(5));
               c.setTarif(rs.getFloat(6));
               c.setId_offreur(rs.getInt(7));
               c.setId_client(rs.getInt(8));
            
              
               
               list.add(c);
           }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
     public List<Offre> getMyOffres(int id){
        List<Offre> list = new ArrayList<>();
        String requete="SELECT * from offre where id_offreur=?";
        
        try {
           PreparedStatement st = cnx.prepareStatement(requete);
           st.setInt(1, id);
           ResultSet rs = st.executeQuery();
           while (rs.next()){
               Offre c = new Offre();
               c.setId(rs.getInt(1));
               c.setNb_place(rs.getInt(2));
               c.setDepart(rs.getString(3));
               c.setArrive(rs.getString(4));
               c.setDate(rs.getDate(5));
               c.setTime(rs.getString(6));
               c.setTarif(rs.getFloat(7));
               c.setId_offreur(rs.getInt(8));
               c.setId_client(rs.getInt(9));
               c.setVehicule(rs.getString(10));
               c.setBagage(rs.getString(11));
            
              
               
               list.add(c);
           }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
     
      public List<Offre> consulterOffre(int id){
        List<Offre> list = new ArrayList<>();
        String requete="SELECT * from inscri_offre where id_client=?";
        
        try {
           PreparedStatement st = cnx.prepareStatement(requete);
           st.setInt(1, id);
           ResultSet rs = st.executeQuery();
           while (rs.next()){
               Offre c = new Offre();
               c.setId(rs.getInt(1));
               c.setNb_place(rs.getInt(2));
               c.setDepart(rs.getString(3));
               c.setArrive(rs.getString(4));
               c.setDate(rs.getDate(5));
               c.setTarif(rs.getFloat(6));
               c.setId_offreur(rs.getInt(7));
               c.setId_client(rs.getInt(8));
            
              
               
               list.add(c);
           }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
      
     
    
     public void modifierOffre(Offre o){
        String requete="UPDATE offre set nb_place=?, depart=?, arrive=?, date=?,time=? ,tarif=?, id_offreur=?, id_client=? WHERE id=?";
        
        
        
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, o.getNb_place());
            pst.setString(2, o.getDepart());
            pst.setString(3, o.getArrive());
            java.sql.Date d = new java.sql.Date(o.getDate().getTime());
            pst.setDate(4, d);
            pst.setString(5, o.getTime());
            pst.setFloat(6, o.getTarif());         
            pst.setInt(7, o.getId_offreur());      
             pst.setInt(8, o.getId_client());      
             pst.setInt(9, o.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
        public void supprimerOffre(Offre o){

        String requete = "DELETE FROM offre WHERE id=?";
        
         try {
             PreparedStatement statement = cnx.prepareStatement(requete);
             statement.setInt(1, o.getId());
             statement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
            
    }
             
           public List<Offre> rechercherOffre(String depart,String arrivee,java.sql.Date date){
               //java.sql.Date d = new java.sql.Date(date.getTime());
               System.out.println(date);
           String requette= "Select * from offre WHERE depart LIKE '%" +depart+ "%' AND arrive LIKE '%" + arrivee+ "%' AND date LIKE '%" +date+ "%' AND nb_place <> 0";
           List<Offre> list= new ArrayList<>();
        try {
            PreparedStatement statement =cnx.prepareStatement(requette);
           // statement.setString(1, "%" + depart + "%");
           // statement.setString(2, "%" + arrivee + "%");
           // statement.setDate(1,date);
            
            ResultSet rs= statement.executeQuery();
           
            while (rs.next()){
                Offre c = new Offre();
               c.setId(rs.getInt(1));
               c.setNb_place(rs.getInt(2));
               c.setDepart(rs.getString(3));
               c.setArrive(rs.getString(4));
               c.setDate(rs.getDate(5));
               c.setTime(rs.getString(6));
               c.setTarif(rs.getFloat(7));
               c.setId_offreur(rs.getInt(8));
               c.setId_client(rs.getInt(9));
               c.setVehicule(rs.getString(10));
               c.setBagage(rs.getString(11));
            
                        
               list.add(c);
}
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
         
           return list ;
           }  
             
           /*public List<> DetailsPersonnesInscrits(){
               
           }
           */
           
           
         //recherche par depart  
            public List<Offre> getListOffreParDepart(String depart){
        List<Offre> list = new ArrayList<>();
        String requette="SELECT * from offre where depart=?";
        
        try {
           PreparedStatement st =cnx.prepareStatement(requette);
                      st.setString(1,depart);

           ResultSet rs = st.executeQuery();
           while (rs.next()){
               Offre r = new Offre();
               r.setId(rs.getInt(1));
               r.setNb_place(rs.getInt(2));
               r.setDepart(rs.getString(3));
               r.setArrive(rs.getString(4));
              
               r.setDate(rs.getDate(5));
               r.setTarif(rs.getInt(6));
               r.setId_offreur(rs.getInt(7));
               r.setId_client(rs.getInt(8));
            
               list.add(r);
           }
        }
        
        catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return list ;
        
    }
            
               public List<Offre> getListOffresInscrits(int id){
        List<Offre> list = new ArrayList<>();
        String requette="SELECT * from offre o JOIN inscri_offre i ON o.id=i.id_offre WHERE i.id_client=?";
        
        try {
           PreparedStatement st =cnx.prepareStatement(requette);
                      st.setInt(1,id);

           ResultSet rs = st.executeQuery();
           while (rs.next()){
               Offre r = new Offre();
               
               r.setId(rs.getInt(1));
               r.setNb_place(rs.getInt(2));
               r.setDepart(rs.getString(3));
               r.setArrive(rs.getString(4));
              
               r.setDate(rs.getDate(5));
               r.setTarif(rs.getInt(6));
               r.setId_offreur(rs.getInt(7));
               r.setId_client(rs.getInt(8));
               r.setVehicule(rs.getString("vehicule"));
               r.setBagage(rs.getString("bagage"));
            
               list.add(r);
           }
        }
        
        catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return list ;
        
    }
               
               
               public void supprimerInscription(Offre o,int id)
               {
                   String requete = "DELETE FROM inscri_offre WHERE id_offre=? AND id_client=?";
        
                        try {
                            PreparedStatement statement = cnx.prepareStatement(requete);
                            statement.setInt(1, o.getId());
                            statement.setInt(2, id);
                            statement.executeUpdate();
                        } catch (SQLException ex) {
                            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
                        }
               }
            
            public int getClientsParticipants(int id){
                List<Client> list = new ArrayList<>();
                int nbr_participants=0;
            
                String requete="SELECT COUNT(*) FROM inscri_offre i JOIN offre o ON o.id=i.id_offre AND o.id=?";
                
                try {
                     PreparedStatement st =cnx.prepareStatement(requete);
                     st.setInt(1,id);

                     ResultSet rs = st.executeQuery();
           while (rs.next()){
               nbr_participants =  ((Number) rs.getObject(1)).intValue();
           }
            }
                 catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return nbr_participants ;
            
            
            }
            
            
            public Client getChauffeur(int id){
             //   List<Client> list = new ArrayList<>();
                
                Client c = new Client();
                String requete="SELECT c.id ,c.nom , c.prenom , c.tel , c.adresse, c.mdp, c.etat_compte, c.mail, c.point,c.avertissement FROM client c JOIN offre o ON c.id=o.id_offreur AND o.id=?";
                
                try {
           PreparedStatement st =cnx.prepareStatement(requete);
                     st.setInt(1,id);

           ResultSet rs = st.executeQuery();
           while (rs.next()){
             //  Client c = new Client();
               c.setId(rs.getInt("id"));
               c.setNom(rs.getString("nom"));
               c.setPrenom(rs.getString("prenom"));
               c.setTel(rs.getInt("tel"));
               c.setAdresse(rs.getString("adresse"));
               c.setMdp(rs.getString("mdp"));
               c.setEtat_compte(rs.getInt("etat_compte"));
               c.setMail(rs.getString("mail"));
               c.setPoints(rs.getInt("point"));
               c.setAvertissement(rs.getInt("avertissement"));
               
           }
            }
                 catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
                
                return c;
            }
            
             public int OffresChauffeur(int id){
             
                int nbr=0;
                System.out.println(id);
                String requete="SELECT COUNT(*) FROM offre o WHERE o.id_offreur=?";
                
                try {
           PreparedStatement st =cnx.prepareStatement(requete);
                     st.setInt(1,id);

           ResultSet rs = st.executeQuery();
           while (rs.next()){
               nbr =  ((Number) rs.getObject(1)).intValue();
               System.out.println(nbr);
             
           }
            }
                 catch (SQLException ex) {
             Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
         }
                
                return nbr;
            }
             
              public int OffresSelonDate(String jour) throws ParseException{
             
                int nbr=0;
               // System.out.println(jour);
                String requete="SELECT COUNT(*) FROM offre o WHERE o.date=?";
                
                try {
           PreparedStatement st =cnx.prepareStatement(requete);
                    String sDate1=jour+"/02/2020"; 
                    System.out.println(sDate1);
                    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1); 
                    java.sql.Date t = new java.sql.Date(date1.getTime());
                    st.setDate(1, t);

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
              
              public boolean verifAvertissementDate(Offre o){
                  int difference_date=0;
                  String requete="SELECT DATEDIFF(?,?) FROM OFFRE WHERE id=?";
                  
             Date date_actuelle = new Date();
             java.sql.Date d_actuelle = new java.sql.Date(date_actuelle.getTime());
             java.sql.Date d_offre = new java.sql.Date(o.getDate().getTime());
               try {
           PreparedStatement st = cnx.prepareStatement(requete);
           
           st.setDate(1, d_offre);
           st.setDate(2, d_actuelle);
           st.setInt(3, o.getId());
           ResultSet rs = st.executeQuery();
           while (rs.next()){
               difference_date =  ((Number) rs.getObject(1)).intValue();

           }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
               if (difference_date < 2){
                   return false;
               }
            
                  return true;
              }
              
              
              public boolean verifAvertissementNbrPlace(Offre o){
                  int nbr_places=0;
                  String requete="SELECT nb_place FROM offre WHERE id=?";
                  
                  try {
           PreparedStatement st = cnx.prepareStatement(requete);
           
           st.setInt(1, o.getId());
           ResultSet rs = st.executeQuery();
           while (rs.next()){
               nbr_places =  ((Number) rs.getObject(1)).intValue();

           }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
               if (nbr_places < 2){
                   return false;
               }
            
                  return true;
              }
              
              public void retirerPoints(Client c){
                  String requete="UPDATE client SET point=point-5,avertissement=1 WHERE id=?";
                  
                  try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, c.getId());   
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
              }
              
              public boolean verifierAvertissement(Client c){
                  
                   int nbr_avertissement=0;
                  String requete="SELECT avertissement FROM client WHERE id=?";
                  
                  try {
           PreparedStatement st = cnx.prepareStatement(requete);
           
           st.setInt(1, c.getId());
           ResultSet rs = st.executeQuery();
           while (rs.next()){
               nbr_avertissement =  ((Number) rs.getObject(1)).intValue();

           }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
               if (nbr_avertissement == 1){
                   return false;
               }
               
                  return true;
              }
              
                public void bloquerClient(Client c){
          
               ClientService cService = new ClientService();
                c.setEtat_compte(0);
                cService.modifierClient(c);
                
            }
                
                
                public void affecterCadeau(int id){
                    
                    String requete="UPDATE client SET cadeau=1 WHERE id=?";
                  
                  try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, id);   
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
                }
                
                public int CountDepartAllee(int id)
                {
                                int nbr=0;
                            System.out.println(id);
                            String requete="SELECT COUNT(DISTINCT offre.depart,offre.arrive) FROM offre WHERE id_offreur=?";

                            try {
                       PreparedStatement st =cnx.prepareStatement(requete);
                                 st.setInt(1,id);

                       ResultSet rs = st.executeQuery();
                       while (rs.next()){
                           nbr =  ((Number) rs.getObject(1)).intValue();
                           System.out.println(nbr);

                       }
                        }
                             catch (SQLException ex) {
                         Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
                     }
                
             return nbr;
                }
                
        
             
             
}
