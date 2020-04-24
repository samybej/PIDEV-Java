/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.AdminRH;
import Entity.Chauffeur;
import Service.ClientService;
import Utilitaire.Session;
import Entity.Client;
import Service.AdminRHService;
import Service.ChauffeurService;
import com.jfoenix.controls.JFXTextField;
import config.ConfigBD;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
import java.util.Optional;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author azuz
 */
public class LoginPageController implements Initializable {
    
    @FXML
    private JFXTextField idLogin;
    @FXML
    private JFXTextField idMdp;
    @FXML
    private Label lblErreur;
    @FXML
    private Button btnSignin;
    @FXML
    private Label login;

    Stage dialogStage = new Stage();
    Scene scene;
    
  
 
    
    
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @FXML
    private AnchorPane anchorPane;

    
      public LoginPageController() {
        con = ConfigBD.getInstance().getCnx();
    }

  
    public void handleButtonAction(MouseEvent event) {

        if (event.getSource() == btnSignin) {
            //login here
            if (seConnecter().equals("Success"+idLogin.getText())) {
                try {
                  
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/OnBoard.fxml")));
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }

            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     //   System.out.println(Session.getSession().getId());
       // System.out.println(Session.getSession().getLogin());
         if (con == null) {
            lblErreur.setTextFill(Color.TOMATO);
            lblErreur.setText("Connexion échouée");
        } else {
            lblErreur.setTextFill(Color.GREEN);
            lblErreur.setText("Connexion établie");
        }
    }    
    
  
    
    @FXML
    private String seConnecter() {
        String status = "Success";

        String email = idLogin.getText();
        String password = idMdp.getText();
        
        if(email.isEmpty() || password.isEmpty()) {
            setLblError(Color.TOMATO, "Remplissez les champs");
            status = "Error";
        } else {
           // Session.getInstace(email);
            //System.out.println(Session.getInstace(email, password).toString());
            //query
            ClientService cService = new ClientService();
            Client c = new Client();
            c=cService.recupererClientLogin(email, password);
            System.out.println(c.getId());
             Session.getInstace(c.getId());
             System.out.println(Session.getSession().getId());
             
            if (c.getId() == 0 )
            {
                setLblError(Color.TOMATO, "Email/Login incorrect");
                status = "Error";
            }
            else 
            {
                setLblError(Color.GREEN, "Attendre svp");
                     FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Front.fxml"));
                     
                     try {
                Parent root = loader.load();
                FrontController apc = loader.getController();
               // apc.setResNom(idLogin);
                //apc.setResPrenom1(tfPrenom);
                idLogin.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
                     
                     
            }
            
            
            
           
        }
        
        return status+idLogin.getText();
    }
    
    @FXML
    private void seConnecterAdmin()
    {
          String status = "Success";
          //System.out.println("hhahahha");

        String email = idLogin.getText();
        String password = idMdp.getText();
        
        if(email.isEmpty() || password.isEmpty()) {
            setLblError(Color.TOMATO, "Remplissez les champs");
            status = "Error";
        } else {
           // Session.getInstace(email);
            //System.out.println(Session.getInstace(email, password).toString());
            //query
            AdminRHService cService = new AdminRHService();
            AdminRH c = new AdminRH();
            c=cService.recupererAdminLogin(email, password);
            
             //Session.getInstace(c.getLogin());
             System.out.println(c.getLogin());
             Session.getInstace(c.getLogin());
             System.out.println(Session.getSession().getLogin());
             //System.out.println("hahah");
             
            if (c.getLogin()== "")
            {
                setLblError(Color.TOMATO, "Email/Login incorrect");
                status = "Error";
            }
            else 
            {
                setLblError(Color.GREEN, "Attendre svp");
                     FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Backend.fxml"));
                     
                     try {
                Parent root = loader.load();
                BackendController apc = loader.getController();
                //apc.setResNom(idLogin);
                //apc.setResPrenom1(tfPrenom);
                idLogin.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
                     
                     
            }
            
            
            
           
        }
    }
    
    @FXML
    private void seConnecterChauffeur()
    {
           String status = "Success";

        String email = idLogin.getText();
        String password = idMdp.getText();
        
        if(email.isEmpty() || password.isEmpty()) {
            setLblError(Color.TOMATO, "Remplissez les champs");
            status = "Error";
        } else {
           // Session.getInstace(email);
            //System.out.println(Session.getInstace(email, password).toString());
            //query
            ChauffeurService cService = new ChauffeurService();
            Chauffeur c = new Chauffeur();
            c=cService.recupererChauffeurLogin(email, password);
            
             Session.getInstace(c.getId());
             System.out.println(Session.getInstace(c.getId()).toString());
             
            if (c.getId() == 0 || c.getMdp() == "" )
            {
                setLblError(Color.TOMATO, "Email/Login incorrect");
                status = "Error";
            }
            else 
            {
                setLblError(Color.GREEN, "Attendre svp");
                     FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("frontendchauffeur.fxml"));
                     
                     try {
                Parent root = loader.load();
                frontendchauffeurController apc = loader.getController();
                //apc.setResNom(idLogin);
                //apc.setResPrenom1(tfPrenom);
                idLogin.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
                     
                     
            }
                       
        }
    }
    
    
    
    
    
      private void setLblError(Color color, String text) {
        lblErreur.setTextFill(color);
        lblErreur.setText(text);
        System.out.println(text);
    }
      
   
    @FXML
    private void pageInscr(MouseEvent event) {
        
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("InscriptionClient.fxml"));
            try {
                Parent root = loader.load();
                InscriptionClientrController apc = loader.getController();
                //apc.setResNom(tfNom);
                //apc.setResPrenom(tfPrenom);
                idLogin.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
        
    }

    @FXML
    private void MdpOub(MouseEvent event) throws ClassNotFoundException {
        
           
    
        
                  ClientService cs= new ClientService();
                  Client c =new Client();
                  
        if (!idLogin.getText().equals("")){
        c=cs.rechercheUtilisateurParUsername(idLogin.getText());
        System.out.println("hhhh"+c.getMail());
            System.out.println("99999999999999999999");
            System.out.println(c.getMail());
            System.out.println("99999999999999999999");
            if (c.getMail()!=null){
                    this.login.setText("");

         Random r = new Random();
int valeur = 1000 + r.nextInt(9999 - 1000);
            System.out.println(valeur);
            
            
       /*  sendSMS sms=new sendSMS();
         sms.envoitSms(uop.getTelephone(), valeur);
         */


        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("ValiderNumMiseAjour.fxml"));
        try{
        loader.load();
        }catch (IOException ex){
        Logger.getLogger(LoginPageController.class.getName()).log(Level.SEVERE,null,ex);
        
        }
        ValiderNumMiseAjourController display=loader.getController();
        display.setUN(c, valeur);
                Parent p =loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.showAndWait();
        
        }else {
             
             this.idLogin.setText("* Username erroné");

         }}
        else {             this.idLogin.setText("* Inserer Username");
}

    }

  
    
   
}
