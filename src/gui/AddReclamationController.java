/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Reclamation;
import Service.ReclamationService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mehdi HECHMI
 */
public class AddReclamationController implements Initializable {

    @FXML
    private TextField idField;
    @FXML
    private TextField messageField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField typeField;
    @FXML
    private TextField idClientField;
    @FXML
    private TextField idChauffeurField;
    @FXML
    private Button cancelButton;
    @FXML
    private Button addButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

     @FXML
    private void cancel(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Reclamation.fxml"));
        Parent root = loader.load();    
        idField.getScene().setRoot(root);
    }

    @FXML
    private void Add(ActionEvent event) throws IOException {
        if(!idField.getText().isEmpty() && !messageField.getText().isEmpty() && !typeField.getText().isEmpty() && !dateField.getText().isEmpty() && !idClientField.getText().isEmpty() && !idChauffeurField.getText().isEmpty())
        {
            String text;
            text = idField.getText();
            ReclamationService rs = new ReclamationService ();
        // SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        //  Date da = sdf.parse(date_rec);
        Reclamation rr = new Reclamation(Integer.parseInt(idField.getText()), messageField.getText(), typeField.getText(), dateField.getText(),Integer.parseInt(idClientField.getText()),Integer.parseInt(idChauffeurField.getText()));
            rs.ajouterReclamation(rr);
            
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Reclamation.fxml"));
            Parent root = loader.load();
            idField.getScene().setRoot(root);
            
        }
    }
    
}
