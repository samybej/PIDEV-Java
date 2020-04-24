/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Utilitaire.ControlesaisieJ;
import Entity.Offre;
import Service.OffreService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class RechercheOffreController implements Initializable {

    @FXML
    private JFXTextField col_depart;
    @FXML
    private JFXTextField col_arrivee;
    @FXML
    private JFXDatePicker col_date;
    
    private Stage windowDialog;
    @FXML
    private JFXButton sinscrire1;
    @FXML
    private JFXButton sinscrire11;
    @FXML
    private Label ColDepart;
    @FXML
    private Label ColArrivee;
    @FXML
    private Label ColDate;
    @FXML
    private JFXButton consulterOffres;
    @FXML
    private JFXButton consulterInscriptions;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        windowDialog = new Stage();
    }    

    @FXML
    private void RechercherOffre(ActionEvent event) {
        ControlesaisieJ cj = new ControlesaisieJ();
        Date d_actuelle = new Date();
        java.sql.Date date_actuelle = new java.sql.Date(d_actuelle.getTime());
        String depart = col_depart.getText();
        String arrive = col_arrivee.getText();
        Date d_init = new Date(0, 2, 2000);
         java.sql.Date date_offre = new java.sql.Date(d_init.getTime());
         
         //LocalDate firstDate = date_offre.toLocalDate();
         //LocalDate secondDate = date_actuelle.toLocalDate();
         
         
          if (col_date.getValue() != null)
        {
          date_offre = java.sql.Date.valueOf(col_date.getValue()); 
        }    
          
          
    Calendar calendar = Calendar.getInstance();
                   
    calendar.setTime( date_offre ); // la date saisie fel formulaire heyya date_offre
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    
       Calendar calendar1 = Calendar.getInstance();

    calendar1.setTime( date_actuelle ); // date mte3 lyoum 
    calendar1.set(Calendar.HOUR_OF_DAY, 0);
    calendar1.set(Calendar.MINUTE, 0);
    calendar1.set(Calendar.SECOND, 0);
    calendar1.set(Calendar.MILLISECOND, 0);
    
    Date dateOffrePure = calendar.getTime();
    Date dateActuellePure = calendar1.getTime();
    
    System.out.println(dateOffrePure);
    System.out.println(dateActuellePure);

         
        if (dateOffrePure.compareTo(dateActuellePure) < 0)
        {
            ColDate.setText("Erreur ! Veuillez insérer une date valide !");
        }
        else 
        {
             ColDate.setText("");
        }
        if (!cj.testnomprenom(depart))
        {
            ColDepart.setText("Erreur ! Veuillez insérer un lieu valide");
        }
        else 
        {
             ColDepart.setText("");
        }
        if (!cj.testnomprenom(arrive))
        {
            ColArrivee.setText("Erreur ! Veuillez insérer un lieu valide");
        }
        else 
        {
            ColArrivee.setText("");
        }
        if (cj.testnomprenom(depart) && cj.testnomprenom(arrive) && dateOffrePure.compareTo(dateActuellePure) >= 0)
        {
            
        Offre o = new Offre();
        OffreService oService = new OffreService();
      //  List<Offre> list = oService.rechercherOffre(depart, arrive, date_offre);
        
      //  ObservableList<Offre> oList = FXCollections.observableArrayList(list);
        //  AlertBox.display("aa", "aa");
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("ResultatRecherche.fxml"));
            try {
                Parent root = loader.load();
                ResultatRechercheController apc = loader.getController();
                apc.setDepart(depart);
                apc.setArrive(arrive);
                apc.setDate(date_offre);
                apc.ListedesOffres();
                //tfNom.getScene().setRoot(root);
                
                col_depart.getScene().setRoot(root);
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
                
        }
        
    }

    @FXML
    private void ProposerOffre(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("GestionOffre.fxml"));
            try {
                Parent root = loader.load();
                GestionOffreController apc = loader.getController();
                //apc.setResNom(tfNom);
                //apc.setResPrenom(tfPrenom);
                //tfNom.getScene().setRoot(root);
                col_depart.getScene().setRoot(root);
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }

    
    @FXML
    private void consulterOffres(ActionEvent event)
    {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("MesOffres.fxml"));
            try {
                Parent root = loader.load();
                MesOffresController apc = loader.getController();
                //apc.setResNom(tfNom);
                //apc.setResPrenom(tfPrenom);
                //tfNom.getScene().setRoot(root);
                col_depart.getScene().setRoot(root);
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }

    @FXML
    private void consulterInscriptions(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("AnnulerOffre.fxml"));
            try {
                Parent root = loader.load();
                AnnulerOffreController apc = loader.getController();
                //apc.setResNom(tfNom);
                //apc.setResPrenom(tfPrenom);
                //tfNom.getScene().setRoot(root);
                col_depart.getScene().setRoot(root);
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }
    
    @FXML
    private void goBack(ActionEvent event)
    {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Front.fxml"));
            try {
                Parent root = loader.load();
                FrontController apc = loader.getController();
                //apc.setResNom(tfNom);
                //apc.setResPrenom(tfPrenom);
                //tfNom.getScene().setRoot(root);
                col_depart.getScene().setRoot(root);
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }
    
}
