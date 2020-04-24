/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Chauffeur;
import Entity.Formation;
import Service.FormationService;
import Utilitaire.Session;
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

/**
 * FXML Controller class
 *
 * @author Med Aymen Barhoumi
 */
public class InscriptionFormationController implements Initializable {

    @FXML
    private TableView<Formation> tableview;
    @FXML
    private TableColumn<?, ?> col_id;
    @FXML
    private TableColumn<?, ?> col_Date_debut;
    @FXML
    private TableColumn<?, ?> col_Date_fin;
    @FXML
    private TableColumn<?, ?> col_titre;
    @FXML
    private TableColumn<?, ?> col_lieu;
    @FXML
    private TableColumn<?, ?> col_lieu1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       tableview.setEditable(true);
       ActionEvent event = new ActionEvent();
       afficherAction(event);
    }    
private void afficherAction(ActionEvent event){
        FormationService fService = new FormationService(); 
        List<Formation> listf = fService.getListFormationDisponible();
       // List<Formation> list = fService.getListFormation();
       ObservableList<Formation> flist = FXCollections.observableArrayList(listf);
      //  ObservableList<Formation> fList = FXCollections.observableArrayList(listf);
      
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_lieu.setCellValueFactory(new PropertyValueFactory<>("Lieu"));
       col_titre.setCellValueFactory(new PropertyValueFactory<>("Titre"));
       col_Date_fin.setCellValueFactory(new PropertyValueFactory<>("Date_fin"));
        col_Date_debut.setCellValueFactory(new PropertyValueFactory<>("Date_debut"));
        
        tableview.setItems(flist);
           // tableview.setItems(fList);gf         
}

      /*@FXML
    private int test(TableColumn.CellEditEvent<Formation,?> event) {
        int id_form=0 ;
         if (tableview.getSelectionModel().getSelectedItem() != null) {
             System.out.println("9rit nazla");
            Formation v = tableview.getSelectionModel().getSelectedItem();
             id_form = v.getId();
       }
         return id_form;
    }
           @FXML
    
    private void #ajouterInscription(int i) {
        Formation v=tableview.getSelectionModel().getSelectedItem();  
        FormationService vService = new FormationService();
        vService.participerFormation2(46,i);
        
    }*/
@FXML
    private void test(TableColumn.CellEditEvent<Formation, ?> event) {
          if (tableview.getSelectionModel().getSelectedItem() != null) {
             System.out.println("9rit nazla");
            Formation v = tableview.getSelectionModel().getSelectedItem();
            int id_form = v.getId();
             
                FormationService rs = new FormationService();
rs.participerFormation(Session.getSession().getId(), v);
               // rs.participerFormation2(46,id_form);
                
          AlertBox.display("confirmation", "inscription avec succees");
          
           /* FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("ConsulterParticipant.fxml"));
            try {

                Parent root = loader.load();
                ConsulterParticipantController drc = loader.getController();
                drc.Afficherpticipation(id_form);
                
                tableview.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
  
        }*/
          }
    }

    @FXML
    private void ajouterInscription(ActionEvent event) {
        
    }

    

    @FXML
    private void goback(ActionEvent event) {
        
               
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("frontendchauffeur.fxml"));
            try {
                Parent root = loader.load();
             frontendchauffeurController lrc = loader.getController();
                                tableview.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    

}
}
