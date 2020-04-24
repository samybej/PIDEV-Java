/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Client;
import Entity.Offre;
import Service.OffreService;
import Utilitaire.Session;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ResultatRechercheController implements Initializable {
    private String departRec;
    private String arriveRec;
    private java.sql.Date date;
    @FXML private TableColumn<?, ?> depart;
    @FXML private TableColumn<?, ?> arrive;
    //private java.sql.Date date;
    @FXML
    private TableView<Offre> tableview;
    @FXML
    private TableColumn<Offre, Float> tarif;
    @FXML
    private TableColumn<Offre, Integer> nbr;
    @FXML
    private TableColumn<Offre, String> time;
    @FXML
    private TableColumn<Offre, String> vehicule;
    @FXML
    private TableColumn<Offre, String> bagage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ListedesOffres();
        
        
        tableview.setEditable(true);
        
         depart.setCellValueFactory(new PropertyValueFactory<>("depart"));
        arrive.setCellValueFactory(new PropertyValueFactory<>("arrive"));
        tarif.setCellValueFactory(new PropertyValueFactory<>("tarif"));
        
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        nbr.setCellValueFactory(new PropertyValueFactory<>("nb_place"));
        vehicule.setCellValueFactory(new PropertyValueFactory<>("vehicule"));
        bagage.setCellValueFactory(new PropertyValueFactory<>("bagage"));
        
        
    }    
    
      public void setDepart(String tf){
        this.departRec = tf;
        //System.out.println(depart);
    }
    
    public void setArrive(String tf){
        this.arriveRec = tf;
    }
    public void setDate(java.sql.Date d){
        this.date=d;
    }
    
    public void ListedesOffres(){
         Offre o = new Offre();
        OffreService oService = new OffreService();
         // System.out.println(date);
        
        List<Offre> list = oService.rechercherOffre(departRec,arriveRec, date);
        System.out.println(list);
        
        ObservableList<Offre> oList = FXCollections.observableArrayList(list);
        
        tableview.setItems(oList);
        
    }
    @FXML
    private void details(TableColumn.CellEditEvent<Offre, String> event) {
        Offre o=tableview.getSelectionModel().getSelectedItem();  
        
        OffreService oService = new OffreService();
        int nbr_particiapnts = oService.getClientsParticipants(o.getId());
        System.out.println(o.getId());
        Client conducteur = oService.getChauffeur(o.getId());
        int nbr_offres =oService.OffresChauffeur(o.getId_offreur());
        
          FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("details.fxml"));
            try {

                Parent root = loader.load();
                DetailsController drc = loader.getController();
                drc.afficherClientConducteur(conducteur, nbr_offres);
               // drc.afficherListeClients(list);
                drc.setIdOffre(o);
                tableview.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        
    }

  

    @FXML
    private void goBack(ActionEvent event) {
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

    @FXML
    private void inscrire(ActionEvent event) {
        Offre o=tableview.getSelectionModel().getSelectedItem();  
        
        OffreService oService = new OffreService();
        if (oService.verifierInscription(o, Session.getSession().getId()))
        {
            oService.inscrireOffre(o,Session.getSession().getId());
            AlertBox.display("SUCCESS", "Inscription Terminée !");
        }
        else 
        {
            AlertBox.display("ECHEC", "Vous Etes déja inscrits !");
        }
        
        
        
    }

   
    
    
  
    
    
    
}
