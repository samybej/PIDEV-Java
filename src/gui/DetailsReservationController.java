/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Chauffeur;
import Entity.Meuble;
import Entity.Reservation;
import Entity.Vehicule;

import Service.ReservationService;
//import com.google.maps.model.Vehicle;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Iyadhtr
 */
public class DetailsReservationController implements Initializable {

    @FXML
    private TableView<Vehicule> tableviewvehicule;
    @FXML
    private TableColumn<?, ?> col_immatriculation;
    @FXML
    private TableColumn<?, ?> col_numeroassurance;
    @FXML
    private TableColumn<?, ?> col_marque;
    @FXML
    private TableView<Chauffeur> tableviewchauffeur;
    @FXML
    private TableColumn<?, ?> col_cin;
    @FXML
    private TableColumn<?, ?> col_nom;
    @FXML
    private TableColumn<?, ?> col_prenom;
    @FXML
    private TableColumn<?, ?> col_tel;
    @FXML
    private TableColumn<?, ?> col_sexe;
    @FXML
    private TableColumn<?, ?> col_salaire;
    @FXML
    private TableColumn<?, ?> col_note;
    private TableView<Meuble> tableviewmeuble;
    private TableColumn<?, ?> col_taille;
    private TableColumn<?, ?> col_prix;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 @FXML
    private void BackAction(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("ListeReservation.fxml"));
            try {
                Parent root = loader.load();
                ListeReservationController lrc = loader.getController();
                                tableviewvehicule.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }
    
    public void AfficherVehiculeReservation(int i) {
          ReservationService rService = new ReservationService(); 
        List<Vehicule> list = rService.getListVehiculeReservation(i);
        ObservableList<Vehicule> oList = FXCollections.observableArrayList(list);
        
        col_immatriculation.setCellValueFactory(new PropertyValueFactory<>("immatriculation"));
        col_numeroassurance.setCellValueFactory(new PropertyValueFactory<>("num_assurance"));
        col_marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
                tableviewvehicule.setItems(oList);

    }
    public void AfficherChauffeurReservation(int i) {
          ReservationService rService = new ReservationService(); 
        List<Chauffeur> list = rService.getListChauffeurReservation(i);
        ObservableList<Chauffeur> oList = FXCollections.observableArrayList(list);
        
        col_cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         col_sexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        col_salaire.setCellValueFactory(new PropertyValueFactory<>("salaire"));
        col_note.setCellValueFactory(new PropertyValueFactory<>("note"));
                tableviewchauffeur.setItems(oList);

    }
     public void AfficherMeubleReservation() {
          ReservationService rService = new ReservationService(); 
        List<Meuble> list = rService.getListMeubleReservation();
        ObservableList<Meuble> oList = FXCollections.observableArrayList(list);
        col_taille.setCellValueFactory(new PropertyValueFactory<>("taille"));
        col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
                tableviewmeuble.setItems(oList);

    }
    
}
