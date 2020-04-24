/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Med Aymen Barhoumi
 */
public class FormationFrontController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void insrireformation(ActionEvent event) {
        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("InscriptionFormation.fxml"));
        try {
            Loder.load();
        } catch (IOException ex) {
            Logger.getLogger(FormationFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();          

    }

    @FXML
    private void mesparticipations(ActionEvent event) {
        try {
            FXMLLoader Loder = new FXMLLoader();
            Loder.setLocation(getClass().getResource("Mesparticipations.fxml"));
            Loder.load();
            Parent AnchorPane = Loder.getRoot();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(AnchorPane);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(FormationFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
