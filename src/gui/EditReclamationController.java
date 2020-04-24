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
import java.text.ParseException;
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
public class EditReclamationController implements Initializable {

    @FXML
    private Button Save;
    @FXML
    private Button Cancel;
    @FXML
    protected TextField messageField;
    @FXML
    protected TextField typeField;
    @FXML
    protected TextField idField;
    @FXML
    protected TextField dateField;
    @FXML
    protected TextField idClientFild;
    @FXML
    protected TextField idChauffeurField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
  /*  private void Save(ActionEvent event) throws IOException {
       ReclamationService rs = new ReclamationService();
        Reclamation r = new Reclamation();
        rs.modifierReclamation(r);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Reclamation.fxml"));
        Parent root = loader.load();    
        idField.getScene().setRoot(root); 
    } */
@FXML
    private void Edit(ActionEvent event) throws IOException, ParseException {
          ReclamationService rs = new ReclamationService();
        Reclamation r = new Reclamation();
        rs.update(Integer.parseInt(idField.getText()),messageField.getText(),dateField.getText(),typeField.getText(), (int) Float.parseFloat(idClientFild.getText()),Integer.parseInt(idChauffeurField.getText()));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Reclamation.fxml"));
        Parent root = loader.load();    
        idField.getScene().setRoot(root);
        
    }
  @FXML
    private void Cancel(ActionEvent event) throws IOException {
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Reclamation.fxml"));
        Parent root = loader.load();    
        idField.getScene().setRoot(root);
        
    }

    public void setSave(Button Save) {
        this.Save = Save;
    }

    public void setCancel(Button Cancel) {
        this.Cancel = Cancel;
    }

    public void setMessageField(TextField messageField) {
        this.messageField = messageField;
    }

    public void setTypeField(TextField typeField) {
        this.typeField = typeField;
    }

    public void setIdField(TextField idField) {
        this.idField = idField;
    }

    public void setDateField(TextField dateField) {
        this.dateField = dateField;
    }

    public void setIdClientFild(TextField idClientFild) {
        this.idClientFild = idClientFild;
    }

    public void setIdChauffeurField(TextField idChauffeurField) {
        this.idChauffeurField = idChauffeurField;
    }

    
    }

    
    

