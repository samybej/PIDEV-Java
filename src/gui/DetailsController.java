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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class DetailsController implements Initializable {
    
    private Offre o;
    @FXML
    private Label labelMail;
    @FXML
    private Label labelTel;
    @FXML
    private Label labelNom;
    @FXML
    private Label labelNbrOffres;
   /* private TableColumn<Client, String> col_nom;
    private TableColumn<Client, String> col_prenom;
    private TableColumn<Client, String> col_adresse;*/
    private TableView<Client> tableview;
    @FXML
    private JFXButton sinscrire;
    @FXML
    private JFXButton goback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       /* col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        */
    }    

    @FXML
    public void inscrire(ActionEvent event) {
        OffreService oService = new OffreService();
        if (oService.verifierInscription(o, Session.getSession().getId()))
        {
            oService.inscrireOffre(o,Session.getSession().getId());
            AlertBox.display("SUCCESS", "Inscription Terminée !");
        }
        else
        {
            AlertBox.display("ECHEC", "Vous Etes déja inscrits ! !");
        }
        
    }
    
    public void setIdOffre(Offre o){
        this.o=o;
    }
    
    public void afficherClientConducteur(Client c,int nbr){
        labelNom.setText(c.getNom()+ " " + c.getPrenom());
        labelTel.setText(""+ c.getTel());
        labelMail.setText(c.getMail());
        labelNbrOffres.setText(""+nbr);
        
        
    }
 /*   public void afficherListeClients(int nbr_participants){
         ObservableList<Client> oList = FXCollections.observableArrayList(list);
         
         tableview.setItems(oList);
    }
*/

    @FXML
    private void goBack(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("RechercheOffre.fxml"));
            try {
                Parent root = loader.load();
                RechercheOffreController apc = loader.getController();
                labelMail.getScene().setRoot(root);
               //apc.setResNom(tfNom);
               // apc.setResPrenom(tfPrenom);
               // tfNom.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }
    
}
