/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Postulation;
import Entity.Vehicule;
import Service.PostulationService;
import Service.VehiculeService;
import Utilitaire.Session;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

/**
 * FXML Controller class
 *
 * @author Med Aymen Barhoumi
 */
public class PostulerChauffeurController implements Initializable {

    @FXML
    private JFXTextField id_Nom;
    @FXML
    private JFXTextField id_tel;
    @FXML
    private JFXTextField id_prenom;
    @FXML
    private JFXTextField id_permis;
    @FXML
    private JFXTextField id_cin;
    @FXML
    private JFXComboBox<Integer> id_nbre;
    ObservableList<Integer> list = FXCollections.observableArrayList(0,1,2,3,4,5);
    @FXML
    private JFXComboBox<String> id_langue;
    @FXML
    private JFXToggleButton checkType;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        id_nbre.setItems(list);
              ObservableList<String> list1 = FXCollections.observableArrayList("anglais","francais","espagnole");
      
         id_langue.setItems(list1);
        
   
                }    
    
    
    
    public boolean VerifInt(String num) {
		String masque = "[0-9]";
		Pattern pattern = Pattern.compile(masque);
		Matcher controler = pattern.matcher(num);
		if (controler.matches()) {
			return true;
		}
		return false;
	}

    @FXML
    private void Postuler(ActionEvent event) {
      
      if(id_Nom.getText().trim().isEmpty() || id_prenom.getText().trim().isEmpty() || id_prenom.getText().trim().isEmpty() || id_prenom.getText().trim().isEmpty() ||id_prenom.getText().trim().isEmpty()  ){
  AlertBox.display("Erreur", "rempit tous les champs ");
   }   
        
       else{
          
         /*  if (VerifInt(id_permis.getText())==false ||VerifInt(id_tel.getText())==false ||VerifInt(id_cin.getText())==false ){
             AlertBox.display("Erreur", "les chmaps doit avoir des valeurs ");
        }
           else{*/
            
                   String nom = id_Nom.getText();
        String prenom = id_prenom.getText();
        
        int permis = Integer.parseInt(id_permis.getText());
        int tel = Integer.parseInt(id_tel.getText());
        int cin = Integer.parseInt(id_cin.getText());
        int nbr_annee = id_nbre.getValue();
        String langue = id_langue.getValue();
        
        String experience = "femme";
        if (checkType.isSelected()){
            experience="homme";
        }
        
        Date Sysdate = new Date();
      
         Postulation v = new Postulation(cin, Sysdate, permis, cin, experience, tel, permis, langue, nom, prenom,Session.getSession().getId());
        PostulationService vService = new PostulationService();
        vService.ajouterPostulation(v);
      }}
    //}
        

    @FXML
    private void goback(ActionEvent event) {
        
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Front.fxml"));
            try {
                Parent root = loader.load();
              FrontController lrc = loader.getController();
                                id_Nom.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }
    
 
    
}
