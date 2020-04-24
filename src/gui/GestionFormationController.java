/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Formation;
import Entity.Reservation;
import Entity.Vehicule;
import Service.FormationService;
import Service.ReservationService;
import Service.VehiculeService;
//import Service.sendSMS;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DateStringConverter;
//import org.apache.pdfbox.util.DateConverter;

/**
 * FXML Controller class
 *
 * @author Med Aymen Barhoumi
 */
public class GestionFormationController implements Initializable {
    
    
    
    
    @FXML
    private TableView<Formation> tableview;
    @FXML
    private TableColumn<Formation, Integer> col_id;
    @FXML
    private TableColumn<Formation, Date> col_Date_debut;
    @FXML
    private TableColumn<Formation, Date> col_Date_fin;
    @FXML
    private TableColumn<Formation, String> col_titre;
    @FXML
    private TableColumn<Formation, String> col_lieu;
    @FXML
    private TableColumn<Formation, String> col_ltime;
    @FXML
    private TableColumn<Formation, Integer> col_place;
    
    
   
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       ActionEvent event = new ActionEvent();
       
  
        //col_lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        //col_titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        //col_ltime.setCellValueFactory(new PropertyValueFactory<>("time"));
               afficherAction(event);

 tableview.setEditable(true);
tableview.getSelectionModel().setCellSelectionEnabled(true);
        
       col_titre.setCellFactory(TextFieldTableCell.forTableColumn());
       col_lieu.setCellFactory(TextFieldTableCell.forTableColumn());
      col_Date_fin.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
       col_Date_debut.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter() ));
      col_ltime.setCellFactory(TextFieldTableCell.forTableColumn());
        afficherAction(event);
    }    

    private void afficherAction(ActionEvent event){
        FormationService fService = new FormationService(); 
        List<Formation> listf = fService.getListFormation();
       // List<Formation> list = fService.getListFormation();
       ObservableList<Formation> flist = FXCollections.observableArrayList(listf);
      //  ObservableList<Formation> fList = FXCollections.observableArrayList(listf);
      
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_lieu.setCellValueFactory(new PropertyValueFactory<>("Lieu"));
       col_titre.setCellValueFactory(new PropertyValueFactory<>("Titre"));
       col_Date_fin.setCellValueFactory(new PropertyValueFactory<>("Date_fin"));
        col_Date_debut.setCellValueFactory(new PropertyValueFactory<>("Date_debut"));
       col_ltime.setCellValueFactory(new PropertyValueFactory<>("time"));
        col_place.setCellValueFactory(new PropertyValueFactory<>("nbr_place"));
        
        tableview.setItems(flist);
           // tableview.setItems(fList);
    
}
    
    
    
    
   @ FXML
    private void deleteRow(ActionEvent event) {
        Formation v=tableview.getSelectionModel().getSelectedItem();  
        FormationService vService = new FormationService();
        vService.supprimerFormation(v);
      //  sendSMS.sendSms("21656128435", "la formation est annulle", "AdminRh");

        afficherAction(event);
        
    }

     @FXML
     public void ajouterFormation(ActionEvent event) throws IOException {
        

           
                        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("AjouterFormation.fxml"));
                        Loder.load();
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
                    
                
                        
            }
     @ FXML
    private void test(TableColumn.CellEditEvent<Formation,?> event) {
         if (tableview.getSelectionModel().getSelectedItem() != null) {
             System.out.println("9rit nazla");
            Formation v = tableview.getSelectionModel().getSelectedItem();
            int id_form = v.getId();
           
                
                FormationService rs = new FormationService();

                rs.getlistparticipantFormation(id_form);
          
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("ConsulterParticipant.fxml"));
            try {

                Parent root = loader.load();
                ConsulterParticipantController drc = loader.getController();
                drc.Afficherpticipation(id_form);
                
                tableview.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
  
        }
    }
    @ FXML
    private void onEdiDatedebut(TableColumn.CellEditEvent<Formation, Date> event) {
        Formation v=tableview.getSelectionModel().getSelectedItem();  
         v.setDate_debut(event.getNewValue());
        FormationService vService = new FormationService();
        vService.modiferFormation(v);
    }
    @ FXML
    private void onEdiDatefin(TableColumn.CellEditEvent<Formation, Date> event) {
        Formation v=tableview.getSelectionModel().getSelectedItem();  
       // v.setDate_fin(java.sql.Date.valueOf(event.getNewValue()));
        FormationService vService = new FormationService();
        vService.modiferFormation(v);
    }
    @ FXML
    private void onEdititre(TableColumn.CellEditEvent<Formation, String> event) {
        Formation v=tableview.getSelectionModel().getSelectedItem();  
        v.setTitre(event.getNewValue());
        System.out.println(v.getTitre());
        FormationService vService = new FormationService();
        vService.modiferFormation(v);
    }
    @ FXML
    private void onEdilieu(TableColumn.CellEditEvent<Formation, String> event) {
        Formation v=tableview.getSelectionModel().getSelectedItem();  
        v.setLieu(event.getNewValue());
        FormationService vService = new FormationService();
        vService.modiferFormation(v);
    }
    @ FXML
    private void onEditime(TableColumn.CellEditEvent<Formation, String> event) {
        Formation v=tableview.getSelectionModel().getSelectedItem();  
        v.setTime(event.getNewValue());
        FormationService vService = new FormationService();
        vService.modiferFormation(v);
    }
    
    
    
    @FXML
 public void statistiqueFormation (ActionEvent event) throws IOException {
        

           
                        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("statisticsFormation.fxml"));
                        Loder.load();
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
                    
                
                        
            }

    


    @FXML
    private void acceuil(ActionEvent event) {
        
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Backend.fxml"));
            try {
                Parent root = loader.load();
             BackendController lrc = loader.getController();
                                tableview.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    
    }

   

   
   
   

   
    }

   
    
     
      
    



     
     
  
 
    
