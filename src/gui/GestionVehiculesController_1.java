/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Vehicule;
import Service.VehiculeService;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.net.URL;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author Aziz Bousselmi
 */
public class GestionVehiculesController_1 implements Initializable {

    @FXML
    private JFXTextField matricule_1;
    @FXML
    private JFXTextField matricule_2;
    @FXML
    private JFXTextField num_assurance;
    @FXML
    private JFXTextField marque;
    @FXML
    private TableColumn<Vehicule, String> col_id;
    @FXML
    private TableColumn<Vehicule, String> col_immatriulation;
    @FXML
    private TableColumn<Vehicule, Integer> col_assurance;
    @FXML
    private TableColumn<Vehicule, String> col_marque;
    @FXML
    private TableColumn<Vehicule, String> col_type;
    @FXML
    private JFXToggleButton checkType;
    @FXML
    private TableView<Vehicule> tableview;
  
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        ActionEvent event= new ActionEvent();
    
        
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_immatriulation.setCellValueFactory(new PropertyValueFactory<>("immatriculation"));
        col_assurance.setCellValueFactory(new PropertyValueFactory<>("num_assurance"));
        col_marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
     
        
        
         afficherAction(event);
         
         
        tableview.setEditable(true);
        
        ObservableList<String> listType = FXCollections.observableArrayList();
        listType.add("taxi");
        listType.add("camion");
        // 
        tableview.getSelectionModel().setCellSelectionEnabled(true);
        col_immatriulation.setCellFactory(TextFieldTableCell.forTableColumn());
        col_assurance.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        col_marque.setCellFactory(TextFieldTableCell.forTableColumn());
        col_type.setCellFactory(ComboBoxTableCell.forTableColumn(listType));
    }    

    @FXML
    private void AjouterVehicule(ActionEvent event){
        String mat1 = matricule_1.getText();
        String mat2 = matricule_2.getText();
        
        String mat_final=mat1+"tunis"+mat2;
        
        int num = Integer.parseInt(num_assurance.getText());
       
        String type = "Camion";
        if (checkType.isSelected()){
            type="Taxi";
        }
     
        String marque1 = marque.getText();
        Vehicule v = new Vehicule(mat_final,num,marque1,type);
        VehiculeService vService = new VehiculeService();
        vService.ajouterVehicule(v);
        
        afficherAction(event);
        
    }
    
    private void afficherAction(ActionEvent event){
        VehiculeService vService = new VehiculeService(); 
        List<Vehicule> list = vService.getListVehicule();
        ObservableList<Vehicule> oList = FXCollections.observableArrayList(list);
         
        
        tableview.setItems(oList);
         
        
        
    }
    @FXML
    private void onEditImmatriculation(CellEditEvent<Vehicule, String> event) {
        Vehicule v=tableview.getSelectionModel().getSelectedItem();       
        v.setImmatriculation(event.getNewValue());
        VehiculeService vService = new VehiculeService();
        vService.modifierVehicule(v);
    }
    @FXML
    private void onEditAssurance(CellEditEvent<Vehicule, Integer> event) {
        Vehicule v=tableview.getSelectionModel().getSelectedItem();       
        v.setNum_assurance(event.getNewValue());
        VehiculeService vService = new VehiculeService();
        vService.modifierVehicule(v);
    }
    @FXML
    private void onEditMarque(CellEditEvent<Vehicule, String> event) {
        Vehicule v=tableview.getSelectionModel().getSelectedItem();       
        v.setMarque(event.getNewValue());
        VehiculeService vService = new VehiculeService();
        vService.modifierVehicule(v);
    }
    @FXML
    private void onEditType(CellEditEvent<Vehicule, String> event) {
        Vehicule v=tableview.getSelectionModel().getSelectedItem();       
        v.setType(event.getNewValue());
        VehiculeService vService = new VehiculeService();
        vService.modifierVehicule(v);
    }

    
    @FXML
    private void DeleteVehicule(ActionEvent event) {
        Vehicule v=tableview.getSelectionModel().getSelectedItem();  
        VehiculeService vService = new VehiculeService();
        vService.supprimerVehicule(v);
        
        afficherAction(event);
    }


    
   
    
}
