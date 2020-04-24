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
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import static gui.AlertBox.annulerButton;
import static gui.AlertBox.closeButton;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.TimeStringConverter;
import javax.management.Notification;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class MesOffresController implements Initializable {

    @FXML
    private TableColumn<Offre, String> col_de;
    @FXML
    private TableColumn<Offre, String> col_a;
    @FXML
    private TableColumn<Offre, Float> col_tarif;
    @FXML
    private TableColumn<Offre, Date> col_date;
    @FXML
    private TableColumn<Offre, Integer> col_nbrplaces;
    @FXML
    private TableView<Offre> tableview;
    @FXML
    private TableColumn<Offre, String> col_time;
    @FXML
    private JFXButton goback;
    @FXML
    private ImageView cadeau;
    @FXML
    private JFXButton sinscrire1;
    
    @FXML
    private int v;
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        cadeau.setVisible(false);
       
        
        ListeDesOffres();
        
        col_de.setCellValueFactory(new PropertyValueFactory<>("depart"));
        col_a.setCellValueFactory(new PropertyValueFactory<>("arrive"));
        col_tarif.setCellValueFactory(new PropertyValueFactory<>("tarif"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        col_time.setCellValueFactory(new PropertyValueFactory<>("time"));
        col_nbrplaces.setCellValueFactory(new PropertyValueFactory<>("nb_place"));
        
        tableview.setEditable(true);
        
        tableview.getSelectionModel().setCellSelectionEnabled(true);
        
        col_de.setCellFactory(TextFieldTableCell.forTableColumn());
        col_a.setCellFactory(TextFieldTableCell.forTableColumn());
        col_tarif.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        col_date.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
        col_time.setCellFactory(TextFieldTableCell.forTableColumn());
        col_nbrplaces.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        
    }    
    
    public void notifier(){

    }
    
    public void ListeDesOffres(){
        
        OffreService oService = new OffreService(); 
        List<Offre> list = oService.getMyOffres(Session.getSession().getId());
        
        ObservableList<Offre> oList = FXCollections.observableArrayList(list);
        
        tableview.setItems(oList);
        
    }
    
    public void afficherCadeau(int v)
    {
        System.out.println("hhh");
        this.v=v;
        System.out.println(v);
        if (v == 1)
        {
            cadeau.setVisible(true);
        }
         
    }
 
 
 
    @FXML
    private void EditDe(TableColumn.CellEditEvent<Offre, String> event) {
         Offre o=tableview.getSelectionModel().getSelectedItem();    
        o.setDepart(event.getNewValue());
        OffreService oService = new OffreService();
        oService.modifierOffre(o);
    }
    @FXML
    private void EditA(TableColumn.CellEditEvent<Offre, String> event) {
         Offre o=tableview.getSelectionModel().getSelectedItem();    
        o.setArrive(event.getNewValue());
        OffreService oService = new OffreService();
        oService.modifierOffre(o);
    }
    @FXML
    private void EditTarif(TableColumn.CellEditEvent<Offre, Float> event) {
        Offre o=tableview.getSelectionModel().getSelectedItem();    
        o.setTarif(event.getNewValue());
        OffreService oService = new OffreService();
        oService.modifierOffre(o);
    }
    @FXML
    private void EditDate(TableColumn.CellEditEvent<Offre, Date> event) {
           Offre o=tableview.getSelectionModel().getSelectedItem();    
        o.setDate(event.getNewValue());
        OffreService oService = new OffreService();
        oService.modifierOffre(o);
    }
    @FXML
    private void EditNombre(TableColumn.CellEditEvent<Offre, Integer> event) {
         Offre o=tableview.getSelectionModel().getSelectedItem();    
        o.setNb_place(event.getNewValue());
        OffreService oService = new OffreService();
        oService.modifierOffre(o);
    }
    @FXML
    private void EditTime(TableColumn.CellEditEvent<Offre, String> event) {
        Offre o=tableview.getSelectionModel().getSelectedItem();    
        o.setTime(event.getNewValue());
        OffreService oService = new OffreService();
        oService.modifierOffre(o);
    }

    @FXML
    private void SupprimerOffre(ActionEvent event) {
        Offre o=tableview.getSelectionModel().getSelectedItem();
        
        OffreService oService = new OffreService();
        Client c = oService.getChauffeur(o.getId());
        
        if (oService.verifAvertissementDate(o) && oService.verifAvertissementNbrPlace(o))
        {
            oService.supprimerOffre(o);
        }
        else 
        {
            Stage window =new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("ATTENTION");
        window.setMinWidth(250);
        
        Label label = new Label();
        label.setText("Si vous annulez cette offre , vous risquez de faire bloquer votre compte . Voulez vous vraiment continuer ?");
       
        closeButton.setOnAction(e -> 
        {
            if (oService.verifierAvertissement(c))
                {
                    oService.supprimerOffre(o);
                    oService.retirerPoints(c);                 
                }   
                else 
                {
                    oService.supprimerOffre(o);
                    oService.bloquerClient(c);
                }
            window.close();
        });
        annulerButton.setOnAction(e -> window.close() );
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton, annulerButton);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();  
        }
        
        
        ListeDesOffres();
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
    private void redirigerCadeau(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Cadeau.fxml"));
            try {
                Parent root = loader.load();
                CadeauController apc = loader.getController();
                tableview.getScene().setRoot(root);
               //apc.setResNom(tfNom);
               // apc.setResPrenom(tfPrenom);
               // tfNom.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }


    
}
