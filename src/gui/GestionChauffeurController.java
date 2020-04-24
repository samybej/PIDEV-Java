/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Chauffeur;
import Service.ChauffeurService;
import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author azuz
 */
public class GestionChauffeurController implements Initializable {

    @FXML
    private JFXTextField TextFieldCin;
    @FXML
    private JFXTextField TextFieldNom;
    @FXML
    private JFXTextField TextFieldPrenom;
    @FXML
    private JFXTextField TextFieldTel;
    @FXML
    private JFXPasswordField TextFieldMdp;
    @FXML
    private JFXTextField TextFieldVehicule;
    @FXML
    private JFXButton annuler1;
    @FXML
    private JFXButton annuler;
    @FXML
    private TableView<Chauffeur> tableview;
    @FXML
    private TableColumn<Chauffeur, String> col_mdp;
    @FXML
    private TableColumn<Chauffeur, Integer> col_cin;
    @FXML
    private TableColumn<Chauffeur, String> col_nom;
    @FXML
    private TableColumn<Chauffeur, String> col_prenom;
    @FXML
    private TableColumn<Chauffeur, Integer> col_tel;
    @FXML
    private TableColumn<Chauffeur, Integer> col_idV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         
        ActionEvent event = new ActionEvent();
        
        col_cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        col_mdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        col_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        col_idV.setCellValueFactory(new PropertyValueFactory<>("id_V"));
        
        afficherAction(event);

        tableview.setEditable(true);
        
        tableview.getSelectionModel().setCellSelectionEnabled(true);
        
        col_cin.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        col_nom.setCellFactory(TextFieldTableCell.forTableColumn());
        col_prenom.setCellFactory(TextFieldTableCell.forTableColumn());
        col_tel.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        col_idV.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        

        // TODO
    }    

    @FXML
    private void AjoutChauffeur(ActionEvent event) {
        
        int Cin = Integer.parseInt(TextFieldCin.getText());
        String Nom = TextFieldNom.getText();
        String Prenom = TextFieldPrenom.getText();
        int tel = Integer.parseInt(TextFieldTel.getText());
        String mdp = TextFieldMdp.getText();
        int idV = Integer.parseInt(TextFieldVehicule.getText());
        
        Chauffeur ch = new Chauffeur(Cin,Nom,Prenom,tel,mdp,idV);
        ChauffeurService chService = new ChauffeurService();
        chService.ajouterChauffeur(ch);
        afficherAction(event); 
    }

    @FXML
    private void SupprimerChauffeur(ActionEvent event) {
        
        Chauffeur ch= tableview.getSelectionModel().getSelectedItem();
        ChauffeurService chService = new ChauffeurService();
        chService.supprimerChauffeur(ch);
        
        afficherAction(event);
    }


  

    @FXML
    private void OnEditVehic(TableColumn.CellEditEvent<Chauffeur, Integer> event) {
        Chauffeur ch=tableview.getSelectionModel().getSelectedItem();       
        ch.setId_vehicule(event.getNewValue());
        ChauffeurService chService = new ChauffeurService();
        chService.modifierChauffeur(ch);
    }

    @FXML
    private void OnEditCin(TableColumn.CellEditEvent<Chauffeur, Integer> event) {
        Chauffeur ch=tableview.getSelectionModel().getSelectedItem();       
        ch.setCIN(event.getNewValue());
        ChauffeurService chService = new ChauffeurService();
        chService.modifierChauffeur(ch);
    }

    @FXML
    private void OnEditNom(TableColumn.CellEditEvent<Chauffeur, String> event) {
        Chauffeur ch=tableview.getSelectionModel().getSelectedItem();       
        ch.setNom(event.getNewValue());
        ChauffeurService chService = new ChauffeurService();
        chService.modifierChauffeur(ch);
    }

    @FXML  
    private void OnEditPrénom(TableColumn.CellEditEvent<Chauffeur, String> event) {
          Chauffeur ch=tableview.getSelectionModel().getSelectedItem();       
        ch.setPrenom(event.getNewValue());
        ChauffeurService chService = new ChauffeurService();
        chService.modifierChauffeur(ch);
    }

    @FXML
    private void OnEditTel(TableColumn.CellEditEvent<Chauffeur, Integer> event) {
        Chauffeur ch=tableview.getSelectionModel().getSelectedItem();       
        ch.setTel(event.getNewValue());
        ChauffeurService chService = new ChauffeurService();
        chService.modifierChauffeur(ch);
    }


    private void afficherAction(ActionEvent event) {
        
        ChauffeurService cService = new ChauffeurService();
        List <Chauffeur> list = cService.getListChauffeur();
        ObservableList<Chauffeur> oList = FXCollections.observableArrayList(list);

       

        tableview.setItems(oList);
        
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
                TextFieldCin.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }
    
    
}


