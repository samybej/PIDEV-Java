/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Client;
import Entity.Reservation;
import Service.ClientService;
import gui.Mail;
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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author Iyadhtr
 */
public class AfficherReservationController implements Initializable {

    @FXML
    private TableView<Reservation> tableviewtaxi;
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
    private Button Supprimer;
    @FXML
    private Button mail;

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
     
        
        
        afficherAction(event);
         
         
        tableviewtaxi.setEditable(true);
       
        tableviewtaxi.getSelectionModel().setCellSelectionEnabled(true);
        
        col_distance.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        col_depart.setCellFactory(TextFieldTableCell.forTableColumn());
        col_arrive.setCellFactory(TextFieldTableCell.forTableColumn());
        col_date.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
        col_tarif.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
    }    
    
    public void afficherAction(ActionEvent event){
        ReservationService reService = new ReservationService();
        List<Reservation> list = reService.getListReservationTaxi();
        ObservableList<Reservation> olist = FXCollections.observableArrayList(list);
        
        tableviewtaxi.setItems(olist);
    }

    @FXML
    private void SupprimerReservationTaxi(ActionEvent event) {
         Reservation re=tableviewtaxi.getSelectionModel().getSelectedItem();  
        ReservationService vService = new ReservationService();
        vService.supprimerReservation(re);
        
        afficherAction(event);
    }

    @FXML
    private void BackAction(ActionEvent event) {
        
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("AjoutReservation.fxml"));
            try {
                Parent root = loader.load();
                AjoutReservationController lrc = loader.getController();
                                tableviewtaxi.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
        
        
        
    }
    @FXML
    private void onEditDistance(CellEditEvent<Reservation, Float> event) {
        Reservation re=tableviewtaxi.getSelectionModel().getSelectedItem();       
        re.setDistance(event.getNewValue());
        ReservationService reService = new ReservationService();
        reService.modifierReservation(re);
    }
    @FXML
    private void onEditDepart(CellEditEvent<Reservation, String> event) {
        Reservation re=tableviewtaxi.getSelectionModel().getSelectedItem();       
        re.setDepart(event.getNewValue());
        ReservationService reService = new ReservationService();
        reService.modifierReservation(re);
    }
    @FXML
    private void onEditArriver(CellEditEvent<Reservation, String> event) {
        Reservation re=tableviewtaxi.getSelectionModel().getSelectedItem();       
        re.setArrive(event.getNewValue());
        ReservationService reService = new ReservationService();
        reService.modifierReservation(re);
    }
    @FXML
    private void onEditDate(CellEditEvent<Reservation, Date> event) {
        Reservation re=tableviewtaxi.getSelectionModel().getSelectedItem();  
        re.setDate(event.getNewValue());
        ReservationService reService = new ReservationService();
        reService.modifierReservation(re);
    }
    @FXML
    private void onEditTarif(CellEditEvent<Reservation, Float> event) {
        Reservation re=tableviewtaxi.getSelectionModel().getSelectedItem();  
        re.setTarif(event.getNewValue());
        ReservationService reService = new ReservationService();
        reService.modifierReservation(re);
    }

    @FXML
    private void envoyerMail(ActionEvent event) {
      System.out.println("ezeeebi");
        Reservation r = tableviewtaxi.getSelectionModel().getSelectedItem();
        System.out.println(r.getId());
       
        ClientService cService = new ClientService();
        Client c = cService.getClientParId(r.getId_client());
        System.out.println(c.getMail());
         try {
        Mail.javaSendMail(c.getMail());
        }
        catch(Exception e){
            System.out.println("erreur");
            e.getMessage();
        }
        
    }
    
    

    
    
}
