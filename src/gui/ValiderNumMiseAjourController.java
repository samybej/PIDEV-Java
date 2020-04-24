/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Client;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
    * @author azuz
 */
public class ValiderNumMiseAjourController implements Initializable {
int nbra=0;
Client c;
    @FXML
    private JFXTextField idNum;
    @FXML
    private JFXButton valid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void valider(ActionEvent event) throws ClassNotFoundException {
        
        if (nbra==Integer.valueOf(this.idNum.getText())){
        
        
FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("MotDePasseOublier.fxml"));
        try{
        loader.load();
        }catch (IOException ex){
        Logger.getLogger(ValiderNumMiseAjourController.class.getName()).log(Level.SEVERE,null,ex);
        
        }
        MotDePasseOublierController display=loader.getController();
            System.out.println("////////////**************");
            System.out.println(c.getMail());
            System.out.println("////////////**************");
        display.setUt2(c);
                Parent p =loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.showAndWait();
        
        }
        
    }
    
    public void setUN(Client cl,int nbra) throws ClassNotFoundException
    {
        

        this.nbra=nbra;
               this.c=cl;

    }    
    
}