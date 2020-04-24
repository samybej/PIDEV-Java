/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Client;
import Entity.Reservation;
import Entity.Vehicule;
import Service.ClientService;
import Service.ReservationService;
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
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.NativeRegExp;

/**
 * FXML Controller class
 *
 * @author Aziz Bousselmi
 */
public class ListeReservationController implements Initializable {

    @FXML

    private TableColumn<Reservation, ?> col_distance;
    @FXML

    private TableColumn<Reservation, ?> col_depart;
    @FXML

    private TableColumn<Reservation, ?> col_arrive;
    @FXML

    private TableColumn<Reservation, ?> col_date;
    @FXML

    private TableColumn<Reservation, ?> col_type;
    @FXML

    private TableColumn<Reservation, ?> col_tarif;
    @FXML

    private TableView<Reservation> tableview;
    @FXML
    private TableColumn<?, ?> col_etat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableview.setEditable(true);
        ActionEvent event = new ActionEvent();
        afficherAction(event);
        // TODO
    }
   

    private void afficherAction(ActionEvent event) {
        ReservationService rService = new ReservationService();
        List<Reservation> list = rService.getListReservation();
        ObservableList<Reservation> oList = FXCollections.observableArrayList(list);

        col_distance.setCellValueFactory(new PropertyValueFactory<>("distance"));
        col_depart.setCellValueFactory(new PropertyValueFactory<>("depart"));
        col_arrive.setCellValueFactory(new PropertyValueFactory<>("arrive"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        col_tarif.setCellValueFactory(new PropertyValueFactory<>("tarif"));

        tableview.setItems(oList);

    }

    public void afficherDetails(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("DetailsReservation.fxml"));
        try {
            Parent root = loader.load();
            DetailsReservationController drc = loader.getController();
            tableview.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void test(TableColumn.CellEditEvent<Reservation, Float> event) {
        if (tableview.getSelectionModel().getSelectedItem() != null) {
            Reservation v = tableview.getSelectionModel().getSelectedItem();
            String type = v.getType();
            int id_chauff = v.getId_chauffeur();
            int id_res=v.getId();
            if ("transporteur".equals(type)) {
                
                ReservationService rs = new ReservationService();
            rs.getListVehiculeReservation(id_chauff);
            rs.getListChauffeurReservation(id_chauff);
            rs.getListMeubleReservation();
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("DetailsReservation.fxml"));
            try {

                Parent root = loader.load();
                DetailsReservationController drc = loader.getController();
                drc.AfficherVehiculeReservation(id_chauff);
                drc.AfficherChauffeurReservation(id_chauff);
                drc.AfficherMeubleReservation();
                tableview.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            }
            else if ("taxi".equals(type)){
                  ReservationService rs = new ReservationService();
            rs.getListVehiculeReservation(id_chauff);
            rs.getListChauffeurReservation(id_chauff);
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("DetailsReservation2.fxml"));
            try {

                Parent root = loader.load();
                DetailsReservationController drc = loader.getController();
                drc.AfficherVehiculeReservation(id_chauff);
                drc.AfficherChauffeurReservation(id_chauff);
                tableview.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
                    
                    }
            }
        
            
        }

    @FXML
    private void back(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Backend.fxml"));
            try {
                Parent root = loader.load();
                BackendController lrc = loader.getController();
                                tableview.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }
    

  
    }

