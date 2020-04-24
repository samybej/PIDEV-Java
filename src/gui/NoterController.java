/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Chauffeur;
import Entity.Note;
import Service.ChauffeurService;
import Service.NoteService;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Mehdi HECHMI
 */
public class NoterController implements Initializable {

    @FXML
    private JFXComboBox<String> note;
    @FXML
    private Button noter;

    /**
     * Initializes the controller class.
     */
    
    ObservableList<String> n = 
    FXCollections.observableArrayList(
        "1","2","3","4","5"
    );
    
    @FXML
    private JFXComboBox<String> listChauffeur;
    
         ObservableList<String> ch = 
    FXCollections.observableArrayList(
        "aziz alaa",
        "samy bejaoui",
        "Khalil saheb Mehdi"
    );
    @FXML
    private Button Cancel;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              note.setItems(n);
              listChauffeur.setItems(ch);



    }    

    @FXML
    private void noter(ActionEvent event) throws IOException {
        String noteCh = note.getValue().toString();
        String message = listChauffeur.getValue().toString();
        String[] npCh=message.split(" ");
        ChauffeurService chS = new ChauffeurService();
        Chauffeur cha = chS.getListChauffeurByNomPrenom(npCh[0], npCh[1]);
        NoteService ns = new NoteService();
        Note no = new Note(Integer.valueOf(noteCh), 1, cha.getId());
        ns.ajouterNote(no);
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Reclamation.fxml"));
            Parent root = loader.load();
            note.getScene().setRoot(root);
        
    }

    @FXML
    private void Cancel(ActionEvent event) {
    }
    
}
