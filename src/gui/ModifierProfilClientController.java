/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Client;
import Service.ClientService;
import Utilitaire.Session;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author azuz
 */
public class ModifierProfilClientController implements Initializable {

    @FXML
    private JFXTextField idNom;
    @FXML
    private JFXTextField idPrenom;
    @FXML
    private JFXPasswordField idMdp1;
    @FXML
    private JFXPasswordField idMdp2;
    @FXML
    private JFXTextField idNum;
    @FXML
    private Button btnMod;
    @FXML
    private Label label_login;
    @FXML
    private Label id_login2;
    @FXML
    private Button btnAcc;
    @FXML
    private Button btnMod11;
    @FXML
    private Label LMdp1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ModifierProfil(ActionEvent event) {
        String Nom = idNom.getText();
        String Prenom = idPrenom.getText();
        String Mdp = idMdp1.getText();
        String Mdp2 = idMdp2.getText();
        int num = Integer.parseInt(idNum.getText());
        
if(     Mdp.equals(Mdp2)){
    
    Client cl = new Client(Nom,Prenom,Mdp,num);
    
    ClientService ClService = new ClientService();
    cl.setId(Session.getSession().getId());
    ClService.modifierClientProfil(cl);
    
}    else{
    
        this.LMdp1.setText("* Reverifier votre mot de passe");
    
}
             
    }

    @FXML
    private void retourAccueil(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Backend.fxml"));
            try {
                Parent root = loader.load();
                BackendController apc = loader.getController();
                //apc.setResNom(tfNom);
                //apc.setResPrenom(tfPrenom);
                id_login2.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }

    @FXML
    private void deconnexion(ActionEvent event) {
        Session.getSession().destroySession();
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("LoginPage.fxml"));
            try {
                Parent root = loader.load();
                LoginPageController apc = loader.getController();
                //apc.setResNom(tfNom);
                //apc.setResPrenom(tfPrenom);
                id_login2.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }
    
}
