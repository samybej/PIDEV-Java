/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Iyadhtr
 */
public class ChoixReservationController implements Initializable {

    @FXML
    private Label label_taxi;
    @FXML
    private JFXButton matmessouch;
    @FXML
            private Label azer;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterReservation(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("AjoutReservation.fxml"));
            Parent root = loader.load();
            AjoutReservationController arc = loader.getController();
            label_taxi.getScene().setRoot(root);
            
    }
       @FXML
    private void AjoutReservationTransport(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("AjoutReservationTransport.fxml"));
            Parent root = loader.load();
            AjoutReservationTransportController arc = loader.getController();
            label_taxi.getScene().setRoot(root);
            
    }

     @FXML
    private void front(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Front.fxml"));
            try {
                Parent root = loader.load();
                FrontController lrc = loader.getController();
                                azer.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }
    
    
}
