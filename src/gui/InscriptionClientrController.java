/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Client;
import Service.ClientService;
import Utilitaire.ControlesaisieJ;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author azuz
 */
public class InscriptionClientrController implements Initializable {

    @FXML
    private JFXTextField idLoginIns;
    @FXML
    private Label lblErreur;
    @FXML
    private JFXPasswordField idMdp;
    @FXML
    private JFXPasswordField idConfirmMdp;
    @FXML
    private JFXTextField idNom;
    @FXML
    private JFXTextField idPrenom;
    @FXML
    private JFXTextField idNumtel;
    @FXML
    private Button btnInscr;
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
    private void inscriptionClient(ActionEvent event)  throws NoSuchAlgorithmException, ClassNotFoundException, IOException {
            ControlesaisieJ cn=new ControlesaisieJ();
            ClientService es = new ClientService();

        String Login = idLoginIns.getText();
        String Mdp = idMdp.getText();
        String Mdp2 = idConfirmMdp.getText();
        String Nom = idNom.getText();
        String Prenom = idPrenom.getText(); 
        int num = Integer.parseInt(idNumtel.getText());
        
        if (Login.length()>0 && cn.mailformat(Login)){
               if(es.verifEmail(Login)){
                
                this.lblErreur.setText("");
                if(     Mdp.equals(Mdp2)){
     Client cl = new Client(Login,Mdp,Nom,Prenom,num);
    ClientService ClService = new ClientService();
    ClService.ajouterClient(cl);
    
}    else{
    
        this.LMdp1.setText("* Reverifier votre mot de passe");
}
                
                                  }
               else{
                   this.lblErreur.setText("Email deja Utilisé");

               }

         }else {
             
             this.lblErreur.setText("* Email erroné");

         }
        

             
        
        
      
        
    
             
        
        
      
        
    }

    @FXML
    private void retourCnx(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("LoginPage.fxml"));
            try {
                Parent root = loader.load();
                LoginPageController apc = loader.getController();
                //apc.setResNom(tfNom);
                //apc.setResPrenom(tfPrenom);
                idLoginIns.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
            }

        
}