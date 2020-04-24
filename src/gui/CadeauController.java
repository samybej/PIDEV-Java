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

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class CadeauController implements Initializable {

    @FXML
    private JFXButton sinscrire;
    @FXML
    private JFXButton goback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Button b = new Button();
    }   
    
    @FXML
    private void inscrire(ActionEvent event)
    {
        
    }

    @FXML
    private void goBack(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("RechercheOffre.fxml"));
            try {
    
                Parent root = loader.load();
                RechercheOffreController apc = loader.getController();
                goback.getScene().setRoot(root);
               //apc.setResNom(tfNom);
               // apc.setResPrenom(tfPrenom);
               // tfNom.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }
    
}
