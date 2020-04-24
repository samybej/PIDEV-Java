/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
 * @author Asus
 */
public class frontendchauffeurController implements Initializable {

    @FXML
    private Button participation;
    @FXML
    private Button historique;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
@FXML
    private void pariciper(ActionEvent event) {
             
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("InscriptionFormation.fxml"));
            try {
                Parent root = loader.load();
             InscriptionFormationController lrc = loader.getController();
                                participation.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    
    }
    
    @FXML
    private void historique(ActionEvent event) {
             
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Mesparticipations.fxml"));
            try {
                Parent root = loader.load();
             MesparticipationsController lrc = loader.getController();
                                historique.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    
    }

   
    
}
