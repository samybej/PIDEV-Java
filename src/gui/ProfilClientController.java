/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Utilitaire.Session;
import com.jfoenix.controls.JFXTextField;
import static gui.AlertBox.annulerButton;
import static gui.AlertBox.closeButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author azuz
 */
public class ProfilClientController implements Initializable {

   
    @FXML
    private Label id_login2;
    @FXML
    private Label label_login;
    @FXML
    private AnchorPane anchorPane;
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println(Session.getSession().getId());
        System.out.println(Session.getSession().getLogin());
        verifierSession();
    } 
    
    public void verifierSession()
    {
          if (Session.getSession() == null || Session.getSession().getId() == 0)
        {
         
        }
    }
    
     public void setResNom(TextField id_login) {
         
         this.id_login2.setText(id_login.getText());
        
      
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
