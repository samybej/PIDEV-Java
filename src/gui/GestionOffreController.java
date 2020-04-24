/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Utilitaire.ControlesaisieJ;
import Entity.Offre;
import Entity.Vehicule;
import Service.OffreService;
import Service.VehiculeService;
import Utilitaire.Session;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class GestionOffreController implements Initializable {

    @FXML
    private JFXComboBox<Integer> box_nbrplaces;
         ObservableList<Integer> list = FXCollections.observableArrayList(1,2,3,4,5);
         
    @FXML
    private JFXTextField depart;
    @FXML
    private JFXTextField arrivee;
    @FXML
    private JFXDatePicker date_offre;
    @FXML
    private JFXButton Ajouter;
    @FXML
    private JFXTextField tarif;
    @FXML
    private JFXTimePicker time_offre;
    @FXML
    private JFXComboBox<String> col_bagage;
     
    @FXML
    private JFXTextField col_vehicule;
    @FXML
    private Label ControleDepart;
    @FXML
    private Label ControleArrivee;
    @FXML
    private Label ControleDate;
    @FXML
    private Label ControleTarif;
    

 
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    ObservableList<String> data = FXCollections.observableArrayList("non", "s", "m","l");
    
    box_nbrplaces.setItems(list);
    col_bagage.setItems(data);
   
    }    

    @FXML
    private void AjouterOffre(ActionEvent event) throws ParseException {
        ControlesaisieJ cj = new ControlesaisieJ();
        if(depart.getText().trim().isEmpty() || arrivee.getText().trim().isEmpty() || date_offre.getValue() == null || tarif.getText().trim().isEmpty() || time_offre.getValue() == null ){
            AlertBox.display("Erreur", "Veuillez saisir des données");
        }
        else 
        {
        
        Date d_actuelle = new Date();
        String d_actuelleString = d_actuelle.toString();
        String departText = depart.getText();
        String arriveeText = arrivee.getText();
        java.sql.Date date_offreText = null;
        if (date_offre.getValue() != null)
        {
             date_offreText = java.sql.Date.valueOf(date_offre.getValue());
        }  
        String time="";
        if (time_offre.getValue() != null)
        {
            time = time_offre.getValue().toString(); 
        }
    
        int nbr_placesText = box_nbrplaces.getValue();
        String bagage = col_bagage.getValue();
        String vehicule = col_vehicule.getText();
        float tarifText=0.0f;
        if (isNumeric(tarif.getText()))
        {
            tarifText = Float.parseFloat(tarif.getText());
            System.out.println(tarifText);
        }
        
       
        String date_string = date_offreText.toString();
        
                String masque = "[+-]?([0-9]*[.])?[0-9]+";
		Pattern pattern = Pattern.compile(masque);
		Matcher controler = pattern.matcher(String.valueOf(tarifText));
                
                 Calendar calendar = Calendar.getInstance();
                   
    calendar.setTime( date_offreText ); // la date saisie fel formulaire heyya date_offre
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    
       Calendar calendar1 = Calendar.getInstance();

    calendar1.setTime( d_actuelle ); // date mte3 lyoum 
    calendar1.set(Calendar.HOUR_OF_DAY, 0);
    calendar1.set(Calendar.MINUTE, 0);
    calendar1.set(Calendar.SECOND, 0);
    calendar1.set(Calendar.MILLISECOND, 0);
    
    Date dateOffre = calendar.getTime();
    Date dateActuelle = calendar1.getTime();
        
    
       if (dateOffre.compareTo(dateActuelle) < 0 && LocalTime.now().isAfter( LocalTime.parse(time ) ))
       {
           ControleDate.setText("Erreur ! veuillez saisir une date correcte");
       }
       else
       {
           ControleDate.setText("");
       }
    
       if (!controler.matches())
       {
           ControleTarif.setText("Erreur ! Veuillez saisir un nombre");
       }
       else 
       {
           ControleTarif.setText("");
       }
       if (!cj.testnomprenom(departText))
       {
           ControleDepart.setText("Erreur ! Saisir des caractères valides");
       }
       else 
       {
           ControleDepart.setText("");
       }
       if (!cj.testnomprenom(arriveeText))
       {
           ControleArrivee.setText("Erreur ! Saisir des caractères valides");
       }
       else 
       {
           ControleArrivee.setText("");
       }
        
       // Timestamp timetime = new Timestamp(time_offreText);
       if ( dateOffre.compareTo(dateActuelle) >= 0 && controler.matches() && cj.testnomprenom(departText) && cj.testnomprenom(arriveeText) )
       {
           System.out.println("aseaeaa");
        Offre o = new Offre(nbr_placesText,departText,arriveeText,date_offreText,time,tarifText,Session.getSession().getId(),vehicule,bagage);
        OffreService oService = new OffreService();
        int nbr_covoiturage = oService.OffresChauffeur(o.getId_offreur());
        int v=0;
        if (nbr_covoiturage > 4 && oService.CountDepartAllee(o.getId_offreur()) > 5)
        {
                        v=1;
                       Image img = new Image("/assets/cadeau.png");
            Notifications notificationBuilder = Notifications.create();
            notificationBuilder
                    .title("Congratulations ! ")
                    .text("Vous avez reçu un cadeau ! Cliquez pour plus de details" )
                    .graphic(new ImageView(img))
                    .hideAfter(Duration.seconds(10))
                    .position(Pos.TOP_RIGHT)
                    .onAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
               
                }
            });
            
              notificationBuilder.darkStyle();
            notificationBuilder.show();

            oService.affecterCadeau(o.getId_offreur());
        }
        oService.ajouterOffre(o);
        
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("MesOffres.fxml"));
            try {
                Parent root = loader.load();
                MesOffresController apc = loader.getController();
                
                depart.getScene().setRoot(root);
                apc.afficherCadeau(v);
               //apc.setResNom(tfNom);
               // apc.setResPrenom(tfPrenom);
               // tfNom.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
            
       }
    }
          
    }
    
    
    public static boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        float d = Float.parseFloat(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}

    @FXML
    private void goBack(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("RechercheOffre.fxml"));
            try {
                Parent root = loader.load();
                RechercheOffreController apc = loader.getController();
                depart.getScene().setRoot(root);
               //apc.setResNom(tfNom);
               // apc.setResPrenom(tfPrenom);
               // tfNom.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }
    
   

    
}
