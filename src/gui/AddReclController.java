/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

//import Entity.sendSMS;
import Entity.Chauffeur;
import Entity.Reclamation;
import Service.ChauffeurService;
import Service.ReclamationService;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Mehdi HECHMI
 */
public class AddReclController implements Initializable {

    @FXML
    private JFXDatePicker date;
    @FXML
    private JFXComboBox<String> listMessage;
    @FXML
    private JFXRadioButton chauffeurRB;
    @FXML
    private ToggleGroup type;
    @FXML
    private JFXRadioButton applicationRB;
    @FXML
    private JFXComboBox<String> listChauffeur;
    @FXML
    private Button addRec;

    /**
     * Initializes the controller class.
     */
    
    ObservableList<String> options = 
    FXCollections.observableArrayList(
        "Fraude",
        "Manque de politesse",
        "Retard exagérer"
    );
    
       ObservableList<String> ch = 
    FXCollections.observableArrayList(
        "aziz alaa",
        "samy bejaoui",
        "aziz barhoumi"
    );
    @FXML
    private Button Cancel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      listChauffeur.setItems(ch);
      listMessage.setItems(options);

    }    

    @FXML
    private void Add(ActionEvent event) throws IOException {
        String message = listMessage.getValue().toString();
        String chauf = listChauffeur.getValue().toString();
        String dateRec = date.getValue().toString();
        String typeRec = "";
        if(chauffeurRB.isSelected()){
        typeRec = "chauffeur";
        }
        else if (applicationRB.isSelected()){
        typeRec = "application";
        }
        int idClient = 46;
        String[] npCh=chauf.split(" ");
        System.out.println(npCh[0]+"ss" );
                System.out.println(npCh[1] +"ss");
        ChauffeurService chS = new ChauffeurService();
        Chauffeur ch = chS.getListChauffeurByNomPrenom(npCh[0], npCh[1]);
        System.out.println(ch.getId());
                System.out.println(ch.getNbReclamation());

        
        if(!listMessage.getValue().isEmpty() && !listChauffeur.getValue().isEmpty() && dateRec != null )
        {
          
            ReclamationService rs = new ReclamationService ();
        // SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        //  Date da = sdf.parse(date_rec);
        Reclamation rr = new Reclamation(message, dateRec, typeRec, idClient, ch.getId());
         rs.ajouterReclamation(rr);
         int nb =ch.getNbReclamation()+ 1 ; 
        ch.setNbReclamation(nb);
        chS.modifierChauffeur(ch);
                        System.out.println(ch.getNbReclamation());

        if(ch.getNbReclamation() == 5){
            chS.supprimerChauffeur(ch);
        }
            
            
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Reclamation.fxml"));
            Parent root = loader.load();
            date.getScene().setRoot(root);
            
        }
       // sendSMS re=new sendSMS();
            //re.sendSms("21656128435", "salut ca va", "feryel");
           // re.sendSms();
        
        
    }
    
    private List<Chauffeur> fillListCh(){
        
        ChauffeurService chS = new ChauffeurService();
        List<Chauffeur> listC = chS.getListChauffeur();
               return listC; 
                }

    @FXML
    private void Cancel(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Reclamation.fxml"));
        Parent root = loader.load();    
        listMessage.getScene().setRoot(root);
        
    }
    
    

    
    
}
