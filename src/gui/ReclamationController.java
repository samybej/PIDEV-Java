/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Reclamation;
import Entity.Vehicule;
import Service.ReclamationService;
import Service.VehiculeService;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
//import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Message;
import java.io.IOException;
import java.net.URL;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
//import Service.ServiceSMS;
/**
 * FXML Controller class
 *
 * @author Mehdi HECHMI
 */
public class ReclamationController implements Initializable {
    
    @FXML
    private TableColumn<Reclamation, String> message;
       
    @FXML
        private TableColumn<Reclamation, String> date;
    @FXML
    private TableColumn<Reclamation, String> type;
    @FXML
    private TableColumn<Reclamation, String> idchauf;
    @FXML
    private TableView<Reclamation> tableview;
    @FXML
    private TableColumn<?, ?> nbr;
    @FXML
    private Button noter;
    @FXML
    private Button sms;
       

    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       Load();
    
        // TODO
    }    
    /*@FXML
    private void AjouterReclamation (ActionEvent event){
        String problem = (String) Probleme.getValue();
        String mes = Message.getText();
        int cli = Integer.parseInt(client.getText());
        int chauf = Integer.parseInt(Message.getText());
        
        java.sql.Date calend = java.sql.Date.valueOf(Calendar.getValue()) ;
        
      
    
        Reclamation r=new Reclamation(mes,calend,problem,cli,chauf);
     
        
        
        ReclamationService rService = new ReclamationService();
        rService.ajouterReclamation(r);
        
      afficherAction(event);
        
    }*/
    
    
    /*
    private void afficherAction(ActionEvent event){
        ReclamationService rService = new ReclamationService(); 
        List<Reclamation> list = rService.getListReclamation();
        ObservableList<Reclamation> oList = FXCollections.observableArrayList(list);
        
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        message.setCellValueFactory(new PropertyValueFactory<>("message"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        idclient.setCellValueFactory(new PropertyValueFactory<>("id_client"));
        idchauf.setCellValueFactory(new PropertyValueFactory<>("id_chauffeur"));
                date.setCellValueFactory(new PropertyValueFactory<>("date_rec"));

        tableview.setItems(oList);

}
 */   
    private void Load() {
        tableview.refresh();
        ReclamationService rs = new ReclamationService();
        ObservableList<Reclamation> tlist = rs.getListReclamation();
        //ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        message.setCellValueFactory(new PropertyValueFactory<>("message"));
        date.setCellValueFactory(new PropertyValueFactory<>("date_rec"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
//        idclient.setCellValueFactory(new PropertyValueFactory<>("id_client"));
        idchauf.setCellValueFactory(new PropertyValueFactory<>("id_chauffeur"));
        nbr.setCellValueFactory(new PropertyValueFactory<>("nbReclamation"));

        tableview.setItems(tlist);
        
                }

    private void Show(ActionEvent event) {
        tableview.refresh();
    }

    @FXML
    private void Add(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addRecl.fxml"));
        Parent root = loader.load();    
        tableview.getScene().setRoot(root);
    }

    @FXML
    private void Delete(ActionEvent event) {
        if(tableview.getSelectionModel().getSelectedItem() != null){
            ReclamationService rs = new ReclamationService();
            Reclamation r = tableview.getSelectionModel().getSelectedItem();
            rs.supprimerReclamation(r);
            //sendSMS re=new sendSMS();
            //re.sendSms("21656128435", "salut ca va", "feryel");
            Load();
            
        }
    }

    private void Edit(ActionEvent event) throws IOException {
        if(tableview.getSelectionModel().getSelectedItem() != null){
            ReclamationService rs = new ReclamationService();
            Reclamation r = tableview.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EditReclamation.fxml"));
            Parent root = loader.load();
            tableview.getScene().setRoot(root);
            EditReclamationController erc = loader.getController();
           
            erc.idField.setText(Integer.toString(r.getId()));
            erc.messageField.setText(r.getMessage());
            erc.typeField.setText((r.getType()));
            erc.idClientFild.setText(Integer.toString(r.getId_client()));
            erc.idChauffeurField.setText(Integer.toString(r.getId_chauffeur()));
            erc.dateField.setText(r.getDate_rec().toString());
        }
}

    @FXML
    private void noter(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Noter.fxml"));
        Parent root = loader.load();    
        tableview.getScene().setRoot(root);
    }

    @FXML
    private void sms(ActionEvent event) {
                
             //   ServiceSMS ss = new ServiceSMS();
            }
        
    }



