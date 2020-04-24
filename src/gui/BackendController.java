/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Utilitaire.Session;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Iyadhtr
 */
public class BackendController implements Initializable {

    @FXML
    private Button goStatCovoiturage;
    @FXML
    private Button disconnect;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ListeReservation(ActionEvent event) {
          FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("ListeReservation.fxml"));
            try {
                Parent root = loader.load();
                ListeReservationController apc = loader.getController();
                //apc.setResNom(tfNom);
                //apc.setResPrenom(tfPrenom);
                disconnect.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
        
    }

    @FXML
    private void goStatCovoiturage(ActionEvent event) {
          FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("statistics.fxml"));
            try {
                Parent root = loader.load();
                StatisticsController apc = loader.getController();
                //apc.setResNom(tfNom);
                //apc.setResPrenom(tfPrenom);
                //tfNom.getScene().setRoot(root);
                goStatCovoiturage.getScene().setRoot(root);
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }

    @FXML
    private void deconnecter(ActionEvent event) {
             Session.getSession().destroySession();
            FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("LoginPage.fxml"));
            try {
                Parent root = loader.load();
                LoginPageController apc = loader.getController();
                //apc.setResNom(tfNom);
                //apc.setResPrenom(tfPrenom);
                disconnect.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }

    @FXML
    private void interfacePostulationAdmin(ActionEvent event) {
       // Session.getSession().destroySession();
            FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("ConsulterPostulation.fxml"));
            try {
                Parent root = loader.load();
                ConsulterPostulationController apc = loader.getController();
                //apc.setResNom(tfNom);
                //apc.setResPrenom(tfPrenom);
                disconnect.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }

    @FXML
    private void interfaceFormation(ActionEvent event) {
        //Session.getSession().destroySession();
            FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("GestionFormation.fxml"));
            try {
                Parent root = loader.load();
                GestionFormationController apc = loader.getController();
                //apc.setResNom(tfNom);
                //apc.setResPrenom(tfPrenom);
                disconnect.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }

    @FXML
    private void ajouterChauffeur(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("GestionChauffeur.fxml"));
            try {
                Parent root = loader.load();
                GestionChauffeurController apc = loader.getController();
                //apc.setResNom(tfNom);
                //apc.setResPrenom(tfPrenom);
                disconnect.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }

    @FXML
    private void ajouterAdminRH(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("GestionAdminRH.fxml"));
            try {
                Parent root = loader.load();
                GestionAdminRHController apc = loader.getController();
                //apc.setResNom(tfNom);
                //apc.setResPrenom(tfPrenom);
                disconnect.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }
    
}
