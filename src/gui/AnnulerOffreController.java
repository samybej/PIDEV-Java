/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Offre;
import Service.OffreService;
import Utilitaire.Session;
import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AnnulerOffreController implements Initializable {

    @FXML
    private TableColumn<Offre, String> colDepart;
    @FXML
    private TableColumn<Offre, String> colArrivee;
    @FXML
    private TableColumn<Offre, Date> colDate;
    @FXML
    private TableColumn<Offre, String> colTime;
    @FXML
    private TableColumn<Offre, Float> colTarif;
    @FXML
    private TableView<Offre> tableview;
    @FXML
    private JFXButton annuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ListeDesOffres();
        
        colDepart.setCellValueFactory(new PropertyValueFactory<>("depart"));
        colArrivee.setCellValueFactory(new PropertyValueFactory<>("arrive"));
        colTarif.setCellValueFactory(new PropertyValueFactory<>("tarif"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
    }    
    
       public void ListeDesOffres()
       {
        
            OffreService oService = new OffreService(); 
            List<Offre> list = oService.getListOffresInscrits(Session.getSession().getId());

            ObservableList<Offre> oList = FXCollections.observableArrayList(list);

            tableview.setItems(oList);
        
        }
       
    @FXML
    public void annulerOffre(){
        Offre o=tableview.getSelectionModel().getSelectedItem();
        
        OffreService oService = new OffreService();
        oService.supprimerInscription(o,Session.getSession().getId());
        
        ListeDesOffres();
        
    }
    
    @FXML
    public void goBack(ActionEvent event)
    {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("RechercheOffre.fxml"));
            try {
                Parent root = loader.load();
                RechercheOffreController apc = loader.getController();
                tableview.getScene().setRoot(root);
               //apc.setResNom(tfNom);
               // apc.setResPrenom(tfPrenom);
               // tfNom.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }
    
}
