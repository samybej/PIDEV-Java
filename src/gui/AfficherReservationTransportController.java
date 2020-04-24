/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Meuble;
import Entity.Reservation;
import Service.MeubleService;
import Service.ReservationService;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.FloatStringConverter;

/**
 * FXML Controller class
 *
 * @author Iyadhtr
 */
public class AfficherReservationTransportController implements Initializable {

    @FXML
    private TableView<Reservation> tableviewtransport;
    @FXML
    private TableColumn<Reservation, Float> col_distance;
    @FXML
    private TableColumn<Reservation, String> col_depart;
    @FXML
    private TableColumn<Reservation, String> col_arrive;
    @FXML
    private TableColumn<Reservation, Date> col_date;
    @FXML
    private TableColumn<Reservation, Float> col_tarif;
    @FXML
    private TableView<Meuble> tableviewmeuble;
    @FXML
    private TableColumn<Meuble, String> col_taille;
    @FXML
    private TableColumn<Meuble, Float> col_prix;
    @FXML
    private Button SupprimerTransport;
    @FXML
    private Button SupprimerMeuble;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ActionEvent event= new ActionEvent();
    
        
        col_distance.setCellValueFactory(new PropertyValueFactory<>("distance"));
        col_depart.setCellValueFactory(new PropertyValueFactory<>("depart"));
        col_arrive.setCellValueFactory(new PropertyValueFactory<>("arrive"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        col_tarif.setCellValueFactory(new PropertyValueFactory<>("tarif"));
        col_taille.setCellValueFactory(new PropertyValueFactory<>("taille"));
        col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
     
        
        
        afficherAction(event);
         
         
        tableviewtransport.setEditable(true);
       tableviewmeuble.setEditable(true);
       
        tableviewtransport.getSelectionModel().setCellSelectionEnabled(true);
        tableviewmeuble.getSelectionModel().setCellSelectionEnabled(true);
        
        col_distance.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        col_depart.setCellFactory(TextFieldTableCell.forTableColumn());
        col_arrive.setCellFactory(TextFieldTableCell.forTableColumn());
        col_date.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
        col_tarif.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        col_taille.setCellFactory(TextFieldTableCell.forTableColumn());
        col_prix.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
    }   
    
    public void afficherAction(ActionEvent event){
        ReservationService reService = new ReservationService();
        List<Reservation> list = reService.getListReservationTransporteur();
        ObservableList<Reservation> olist = FXCollections.observableArrayList(list);
        
        ReservationService mService = new ReservationService();
        List<Meuble> listm = mService.getListMeubleReservation();
        ObservableList<Meuble> olistt = FXCollections.observableArrayList(listm);
        
        tableviewtransport.setItems(olist);
        tableviewmeuble.setItems(olistt);
    }

     @FXML
    private void SupprimerReservationTransport(ActionEvent event) {
         Reservation re=tableviewtransport.getSelectionModel().getSelectedItem();  
        ReservationService vService = new ReservationService();
        vService.supprimerReservation(re);
        
        afficherAction(event);
    }
     @FXML
    private void SupprimerReservationMeuble(ActionEvent event) {
         Meuble m=tableviewmeuble.getSelectionModel().getSelectedItem();  
         m.setId(4);
         MeubleService mService = new MeubleService();
        mService.supprimerMeuble(m);
        
        afficherAction(event);
    }

      @FXML
    private void BackAction (ActionEvent event) {
                FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("AjoutReservationTransport.fxml"));
            try {
                Parent root = loader.load();
                AjoutReservationTransportController lrc = loader.getController();
                                tableviewmeuble.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }
    @FXML
    private void onEditDistance(TableColumn.CellEditEvent<Reservation, Float> event) {
        Reservation re=tableviewtransport.getSelectionModel().getSelectedItem();       
        re.setDistance(event.getNewValue());
        ReservationService reService = new ReservationService();
        reService.modifierReservation(re);
    }
    @FXML
    private void onEditDepart(TableColumn.CellEditEvent<Reservation, String> event) {
        Reservation re=tableviewtransport.getSelectionModel().getSelectedItem();       
        re.setDepart(event.getNewValue());
        ReservationService reService = new ReservationService();
        reService.modifierReservation(re);
    }
    @FXML
    private void onEditArriver(TableColumn.CellEditEvent<Reservation, String> event) {
        Reservation re=tableviewtransport.getSelectionModel().getSelectedItem();       
        re.setArrive(event.getNewValue());
        ReservationService reService = new ReservationService();
        reService.modifierReservation(re);
    }
    @FXML
    private void onEditDate(TableColumn.CellEditEvent<Reservation, Date> event) {
        Reservation re=tableviewtransport.getSelectionModel().getSelectedItem();  
        re.setDate(event.getNewValue());
        ReservationService reService = new ReservationService();
        reService.modifierReservation(re);
    }
    @FXML
    private void onEditTarif(TableColumn.CellEditEvent<Reservation, Float> event) {
        Reservation re=tableviewtransport.getSelectionModel().getSelectedItem();  
        re.setTarif(event.getNewValue());
        ReservationService reService = new ReservationService();
        reService.modifierReservation(re);
    }
    @FXML
     private void onEditTaille(TableColumn.CellEditEvent<Meuble, String> event) {
        Meuble m=tableviewmeuble.getSelectionModel().getSelectedItem();  
        m.setTaille(event.getNewValue());
        System.out.println(m);
        System.out.println(m.getId());
        MeubleService meService = new MeubleService();
        meService.modiferMeuble(m);
    }
     @FXML
      private void onEditPrix(TableColumn.CellEditEvent<Meuble, Float> event) {
        Meuble m=tableviewmeuble.getSelectionModel().getSelectedItem();  
        m.setPrix(event.getNewValue());
        MeubleService meService = new MeubleService();
        meService.modiferMeuble(m);
    }
      

    
}

    

