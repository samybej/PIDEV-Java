/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 


/**
 *
 * @author Aziz Bousselmi
 */
public class NewFXMain extends Application {
   // public static Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
     
        
        
        Scene scene = new Scene(root);
        stage.setTitle("test crud basique");
        
        stage.setScene(scene);
        stage.show();

    /**
     * @param args the command line arguments
     * 
     */
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
