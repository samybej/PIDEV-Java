/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpi;

import config.ConfigBD;
import Entity.*;
import Service.*;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Date;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 *
 * @author Asus
 */
public class ProjetPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        ConfigBD connexion = ConfigBD.getInstance();
        
      /* Client c1 = new Client("samy","bejaoui",1231,"menzah 1","hello",0,"hh@hh");
         Client c2 = new Client("khalil","bejaoui",1231,"menzah 1","hello",0,"hh@hh");
        ClientService cs = new ClientService();
        
        cs.ajouterClient(c1);
        cs.ajouterClient(c2);                           // Ajout d'un client
        System.out.println(cs.getListClient());
        
        c1.setAdresse("el manar");
        c1.setEtat_compte(1);
        c1.setMdp("bbb");
        c1.setId(44);
        cs.modifierClient(c1);
        cs.supprimerClient(c1);
        System.out.println(cs.getListClient());
        
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, 11); 
         c.set(Calendar.DATE, 11); 
          c.set(Calendar.YEAR, 11); 
          d = c.getTime();
          
           Vehicule v1 = new Vehicule("126 tunis 2030",1111,"Ford","Taxi",0);
             VehiculeService vService = new VehiculeService();
        
        
        vService.ajouterVehicule(v1);
        System.out.println(vService.getListVehicule());
        v1.setEtat(1);
        v1.setId(39);
        vService.modifierVehicule(v1);
         System.out.println(vService.getListVehicule());
         
        Chauffeur cf1 = new Chauffeur(1133,"aziz","barhoumi","hahaha",55231,"homme",d,133.2f,4.3f,"taxi",4455,39);
        ChauffeurService cfservice = new ChauffeurService();
        
        cfservice.ajouterChauffeur(cf1);
        System.out.println(cfservice.getListChauffeur());
        cf1.setEtat_compte(1);
        cf1.setPrenom("alaa");
        cf1.setId(18);
        cfservice.modifierChauffeur(cf1);
         System.out.println(cfservice.getListChauffeur());
        //cfservice.supprimerChauffeur(cf1);
        
       
         
         Date d2 = new Date();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.MONTH, 11); 
         calendar2.set(Calendar.DATE, 11); 
          calendar2.set(Calendar.YEAR, 11); 
          d2 = c.getTime();
       
          
         Postulation post = new Postulation(d2,4512,11223,"homme",46);
         
         PostulationService postService = new PostulationService();
         
         postService.ajouterPostulation(post);
         
         System.out.println(postService.getListPostulation());
         
         post.setEtat(1);
         post.setId(99);
         postService.modifierPostulation(post);
         System.out.println(postService.getListPostulation());
         
       //  postService.supprimerPostulation(post);
       
       Date d3 = new Date();
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(Calendar.MONTH, 11); 
         calendar3.set(Calendar.DATE, 11); 
          calendar3.set(Calendar.YEAR, 11); 
          d3 = c.getTime();
          
       Offre o1 = new Offre(4,"tunis","sousse",d3,4.2f,46);
       
       OffreService offService = new OffreService();
       
       offService.ajouterOffre(o1);
       System.out.println(offService.getListOffre());
       
       o1.setDepart("kasserine");
       o1.setId(59);
       offService.modifierOffre(o1);
       System.out.println(offService.getListOffre());
        Date d4 = new Date();
        Calendar calendar4 = Calendar.getInstance();
        calendar4.set(Calendar.MONTH, 1); 
         calendar4.set(Calendar.DATE, 20); 
          calendar4.set(Calendar.YEAR, 2020); 
          d4 = c.getTime();
       Reservation r1 = new Reservation(22.3f,"tunis","ariana",d4,18,46,1,0,false);
       Reservation r2 = new Reservation(22.3f,"monastir","sousse",d4,18,46,1,0,false);
       ReservationService resService = new ReservationService();
       
       resService.ajouterReservation(r1);
       resService.ajouterReservation(r2);
       System.out.println(resService.getListReservation());
       
       r1.setArrivee("monastir");
       r1.setId(14);
       resService.modifierReservation(r1);
       System.out.println(resService.getListReservation());
       
       AdminRH ar = new AdminRH("barhoumi","hhh","barhoumi@gmail.tn");
       AdminRHService arService = new AdminRHService();
       arService.ajouterAdminRH(ar);
       System.out.println(arService.getListAdminRH());
       
       ar.setMdp("kalalalalal");
       arService.modifierAdminRH(ar);
       System.out.println(arService.getListAdminRH());
       
       Admin a = new Admin("barhoumi","hhh","barhoumi@gmail.tn");
       AdminService aService = new AdminService();
       aService.ajouterAdmin(a);
       System.out.println(aService.getListAdmin());
       
       a.setMdp("jjjkkkk");
       aService.modifierAdmin(a);
       System.out.println(aService.getListAdmin());
       
          
       Formation f = new Formation(d4,d4,"formation","ariana");
       FormationService fService = new FormationService();
       
       fService.ajouterFormation(f);
       System.out.println(fService.getListFormation());
       
       f.setLieu("tunis");
       f.setId(1);
       fService.modiferFormation(f);
       System.out.println(fService.getListFormation());
       
       Reclamation rec = new Reclamation("ooo",d4,"chauffeur",46,18);
       
       ReclamationService recService = new ReclamationService();
       
       recService.ajouterReclamation(rec);
       System.out.println(recService.getListReclamation());
       
       rec.setMessage("chauffeurppp");
       rec.setId(15);
       recService.modifierReclamation(rec);
       System.out.println(recService.getListReclamation());
      // System.out.println(resService.calculTarif(r1));
      cf1.setId(18);
      cfservice.updateSalaire(cf1);
      System.out.println(cf1.getSalaire());
       
      c2.setId(46);
      System.out.println(resService.recupererNbrReservations(c2));
      System.out.println(recService.getNbrReclamationsClient(c2));
      
      //cs.updatePoints(c2);
      //System.out.println(c2.getPoints());
      
      resService.ajouterReservation(r2);
        
      Reservation r3 = new Reservation(22.3f,"tunis","ariana",d4,18,46,1,0,true); 
      r3.setId(14);    
      resService.modifierReservation(r3);// Reservation de type Transport (true)
      Meuble m1 = new Meuble("moyenne",119);
      MeubleService mService = new MeubleService();  
      mService.ajouterMeuble(m1);                                                // Ajout d'un meuble
      System.out.println(mService.getMeuble(r3,m1));
      
      m1.setTaille("petite");
      mService.modiferMeuble(m1);                                                //Modification d'un meuble
      System.out.println(mService.getMeuble(r3,m1));
      
      Chauffeur cf3 = new Chauffeur(1133,"samy","bejaoui","hahaha",55231,"homme",d,133.2f,4.3f,"taxi",4455,40);
      arService.validerPostulation(post, cf3 );                                  // Validation de postulation
      o1.setId(59);
      o1.setId_offreur(46);
      o1.setId_client(46);
       
      offService.inscrireOffre(o1, 46);         // Inscription à un offre déja crée
      
      Note n = new Note(4,46,18);               // Ajout d'une note
      
      NoteService nService = new NoteService();
      
      nService.ajouterNote(n);
      
      cfservice.calculerNote(cf1);                  // Calcul Moyenne note du chauffeur
      
      f.setId(1);
      fService.modiferFormation(f);
      //fService.participerFormation(cf1, f);         // Participation à une formation
      
      cfservice.bloquerChauffeur(cf1, f);
      
      System.out.println(offService.getListReservationBydepart("kasserine"));       // liste des reservations par départ
      System.out.println(offService.getoffreBydate());
      
      System.out.println(cfservice.getListChauffeurByNote(4));                      // Liste Chauffeurs Par Note
      
      System.out.println(resService.getListReservationMeubleBydate());              // Liste des reservations meuble
      */
    }
    
}
