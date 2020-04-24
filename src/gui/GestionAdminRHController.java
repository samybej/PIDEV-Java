/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.AdminRH;
import Service.AdminRHService;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;


/**
 * FXML Controller class
 *
 * @author azuz
 */
public class GestionAdminRHController implements Initializable {

    @FXML
    private JFXTextField TextFieldLogin;
    @FXML
    private JFXTextField TextFieldEmail;
    @FXML
    private JFXPasswordField TextFieldMdp;
    @FXML
    private TableColumn<AdminRH, String> col_login;
    @FXML
    private TableColumn<AdminRH, String> col_mdp;
    @FXML
    private TableColumn<AdminRH, Integer> col_etat;
    @FXML
    private TableColumn<AdminRH, String> col_email;
    @FXML
    private TableView<AdminRH> tableview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ActionEvent event = new ActionEvent();
        
        col_login.setCellValueFactory(new PropertyValueFactory<>("login"));
        col_mdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
        col_etat.setCellValueFactory(new PropertyValueFactory<>("etat_compte"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("mail"));
        
        afficherAction(event);

        tableview.setEditable(true);
        
        tableview.getSelectionModel().setCellSelectionEnabled(true);
        
        col_login.setCellFactory(TextFieldTableCell.forTableColumn());
        col_etat.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        col_mdp.setCellFactory(TextFieldTableCell.forTableColumn());
        col_email.setCellFactory(TextFieldTableCell.forTableColumn());
        

        
        // TODO
    }    

    @FXML
    private void AjoutAdminRH(ActionEvent event) {
        
        String Login = TextFieldLogin.getText();
        String Mdp = TextFieldMdp.getText();
        String email = TextFieldEmail.getText();
        
        
        AdminRH rh = new AdminRH(Login,Mdp,email);
        AdminRHService rhService = new AdminRHService();
        rhService.ajouterAdminRH(rh);
        afficherAction(event); 
        
    }
    
    private void afficherAction(ActionEvent event) {
        AdminRHService rhService = new AdminRHService();
        List <AdminRH> list = rhService.getListAdminRH();
        ObservableList<AdminRH> oList = FXCollections.observableArrayList(list);

       

        tableview.setItems(oList);
        
    }
    
    @FXML
    private void OnEditLogin(CellEditEvent<AdminRH, String> event) {
        AdminRH rh=tableview.getSelectionModel().getSelectedItem();       
        rh.setLogin(event.getNewValue());
        AdminRHService rhService = new AdminRHService();
        rhService.modifierAdminRH(rh);
    }

    @FXML
    private void OnEditMdp(CellEditEvent<AdminRH, String> event) {
        AdminRH rh=tableview.getSelectionModel().getSelectedItem();       
        rh.setMdp(event.getNewValue());
        AdminRHService rhService = new AdminRHService();
        rhService.modifierAdminRH(rh);
    }

    @FXML
    private void OnEditEtat(CellEditEvent<AdminRH, Integer> event) {
        AdminRH rh=tableview.getSelectionModel().getSelectedItem();       
        rh.setEtat_compte(event.getNewValue());
        AdminRHService rhService = new AdminRHService();
        rhService.modifierAdminRH(rh);
    }

    @FXML
    private void OnEditEmail(CellEditEvent<AdminRH, String> event) {
        AdminRH rh=tableview.getSelectionModel().getSelectedItem();       
        rh.setMail(event.getNewValue());
        AdminRHService rhService = new AdminRHService();
        rhService.modifierAdminRH(rh);
    }

    @FXML
    private void SupprimerAdminRH(ActionEvent event) {
        
       
        AdminRH rh=tableview.getSelectionModel().getSelectedItem();  
        AdminRHService vService = new AdminRHService();
        vService.supprimerAdminRH(rh);
        
        afficherAction(event);
    
    }
    
    @FXML
    private void goBack(ActionEvent event)
    {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Backend.fxml"));
            try {
                Parent root = loader.load();
                BackendController apc = loader.getController();
                //apc.setResNom(tfNom);
                //apc.setResPrenom(tfPrenom);
                TextFieldLogin.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }

    
        
        
    
  
    
}
