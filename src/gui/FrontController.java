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
public class FrontController implements Initializable {

    @FXML
    private Button covoiturage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void interfaceOffre(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("RechercheOffre.fxml"));
                     
                     try {
                Parent root = loader.load();
                RechercheOffreController apc = loader.getController();
               // apc.setResNom(idLogin);
                //apc.setResPrenom1(tfPrenom);
                covoiturage.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }

    @FXML
    private void interfacePostulation(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("postulerChauffeur.fxml"));
                     
                     try {
                Parent root = loader.load();
                PostulerChauffeurController apc = loader.getController();
               // apc.setResNom(idLogin);
                //apc.setResPrenom1(tfPrenom);
                covoiturage.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }
    
     @FXML
    private void interfaceReservation(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("ChoixReservation.fxml"));
                     
                     try {
                Parent root = loader.load();
                ChoixReservationController apc = loader.getController();
               // apc.setResNom(idLogin);
                //apc.setResPrenom1(tfPrenom);
                covoiturage.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }

    @FXML
    private void interfaceReclamation(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("addRecl.fxml"));
                     
                     try {
                Parent root = loader.load();
                AddReclController apc = loader.getController();
               // apc.setResNom(idLogin);
                //apc.setResPrenom1(tfPrenom);
                covoiturage.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }

    @FXML
    private void profilClient(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("ModifierProfilClient.fxml"));
                     
                     try {
                Parent root = loader.load();
                ModifierProfilClientController apc = loader.getController();
               // apc.setResNom(idLogin);
                //apc.setResPrenom1(tfPrenom);
                covoiturage.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }

    @FXML
    private void seDeconnecter(ActionEvent event) {
         Session.getSession().destroySession();
            FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("LoginPage.fxml"));
            try {
                Parent root = loader.load();
                LoginPageController apc = loader.getController();
                //apc.setResNom(tfNom);
                //apc.setResPrenom(tfPrenom);
                covoiturage.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }
    
}
