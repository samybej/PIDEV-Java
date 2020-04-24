/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Chauffeur;
import Service.FormationService;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Med Aymen Barhoumi
 */
public class ConsulterParticipantController implements Initializable {

    @FXML
    private TableView<Chauffeur> tableview;
    @FXML
    private TableColumn<?, ?> col_nom;
    @FXML
    private TableColumn<?, ?> col_prenom;
    @FXML
    private TableColumn<?, ?> col_tel;
    @FXML
    private TableColumn<?, ?> col_note;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void Afficherpticipation(int i) {
     
        FormationService fService = new FormationService(); 
        List<Chauffeur> listf = fService.getlistparticipantFormation(i);
       // List<Formation> list = fService.getListFormation();
       ObservableList<Chauffeur> flist = FXCollections.observableArrayList(listf);
      //  ObservableList<Formation> fList = FXCollections.observableArrayList(listf);
      
       // col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
       col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
       col_tel.setCellValueFactory(new PropertyValueFactory<>("Tel"));
        col_note.setCellValueFactory(new PropertyValueFactory<>("note"));
        
        tableview.setItems(flist);
           // tableview.setItems(fList);
    
}
    
   

    @FXML
    private void goback(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("GestionFormation.fxml"));
            try {
                Parent root = loader.load();
               GestionFormationController lrc = loader.getController();
                                tableview.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }

   
   

    }
    

