/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Formation;
import Service.FormationService;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Med Aymen Barhoumi
 */
public class AjouterFormationController implements Initializable {

    @FXML
    private JFXComboBox<String> titre;
    ObservableList<String> list = FXCollections.observableArrayList("ionic", "Gestion de stress", "anglais","time Managment","formation","body luanguage");
    @FXML
    private JFXTextField lieu;
    @FXML
    private JFXDatePicker Date_debut;
    @FXML
    private JFXDatePicker Date_fin;
    @FXML
    private JFXTimePicker id_time;
    @FXML
    private JFXTextField nbr_place;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      titre.setItems(list);
    }    

    @FXML
    private void AjouterFormation(ActionEvent event) throws IOException {

      
     
   if(lieu.getText().trim().isEmpty() || Date_debut.getValue()==null ||Date_fin.getValue()==null|| id_time.getValue()==null   ){
  AlertBox.display("Erreur", "rempit tous les champs ");
   }
        
    else{
       
         String Titre = titre.getValue();
        String Lieu = lieu.getText();
        int nbre_place =Integer.parseInt(nbr_place.getText());
        
        
       // Date  date_debut = Date_debut.getValue();
     // Date  date_fin = Date_fin.getValue();
         
      String time =id_time.getValue().toString();
       Date d_actuelle= new Date();
      java.sql.Date DDebut = java.sql.Date.valueOf(Date_debut.getValue());
       java.sql.Date DFin = java.sql.Date.valueOf(Date_fin.getValue());
       
       Calendar calendar = Calendar.getInstance();
                   
    calendar.setTime( DFin ); // la date saisie fel formulaire heyya date_offre
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    
       Calendar calendar1 = Calendar.getInstance();

    calendar1.setTime( DDebut ); // date mte3 lyoum 
    calendar1.set(Calendar.HOUR_OF_DAY, 0);
    calendar1.set(Calendar.MINUTE, 0);
    calendar1.set(Calendar.SECOND, 0);
    calendar1.set(Calendar.MILLISECOND, 0);
    
    Date DFinTrim = calendar.getTime();
    Date DDebutTrim = calendar1.getTime();
       
       
           if (DFinTrim.compareTo(DDebutTrim) < 0 || DDebut.compareTo(d_actuelle) < 0 )
       {
           AlertBox.display("Erreur", "Saisir une date valide ");
       }
       else 
       {
       
           // Foramtion f = new Formation(Date_debut, Date_fin, "Titre", "Lieu");
      Formation f=new Formation(DDebutTrim, DFinTrim, Titre, Lieu, time, nbre_place);
        FormationService fService = new FormationService();
        fService.ajouterFormation(f);
        
        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("GestionFormation.fxml"));
                        Loder.load();
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
       }}
      
    }
}
