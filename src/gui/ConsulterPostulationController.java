/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Formation;
import Entity.Postulation;
import Service.FormationService;
import Service.PostulationService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Med Aymen Barhoumi
 */
public class ConsulterPostulationController implements Initializable {

    @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> prenom;
    @FXML
    private TableColumn<?, ?> cin;
    @FXML
    private TableColumn<?, ?> num_permis;
    @FXML
    private TableColumn<?, ?> experience;
    @FXML
    private TableColumn<?, ?> Langue;
    @FXML
    private TableColumn<?, ?> tel;
    @FXML
    private TableColumn<?, ?> date_demande;
    @FXML
    private TableColumn<?, ?> sexe;
    @FXML
    private TableView<Postulation> tableview;
    @FXML
    private Button accepter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tableview.setEditable(true);
        ActionEvent event = new ActionEvent();
       
  
        //col_lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        //col_titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        //col_ltime.setCellValueFactory(new PropertyValueFactory<>("time"));
               afficherAction(event);

    }    
    
    private void afficherAction(ActionEvent event){
        PostulationService fService = new PostulationService(); 
        List<Postulation> listf = fService.getListPostulation();
       // List<Formation> list = fService.getListFormation();
       ObservableList<Postulation> flist = FXCollections.observableArrayList(listf);
      //  ObservableList<Formation> fList = FXCollections.observableArrayList(listf);
      
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
       cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
       num_permis.setCellValueFactory(new PropertyValueFactory<>("num_permis"));
        experience.setCellValueFactory(new PropertyValueFactory<>("experience"));
        Langue.setCellValueFactory(new PropertyValueFactory<>("Langue"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        date_demande.setCellValueFactory(new PropertyValueFactory<>("date_demande"));
        sexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));


        tableview.setItems(flist);
           // tableview.setItems(fList);
    
}
        @FXML
    private void test(TableColumn.CellEditEvent<Formation, ?> event) {
         }

    @FXML
    private void goback(ActionEvent event) {
             
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Backend.fxml"));
            try {
                Parent root = loader.load();
             BackendController lrc = loader.getController();
                                tableview.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    
    }


    @FXML
    private void accepter(ActionEvent event) {
          Postulation v = tableview.getSelectionModel().getSelectedItem();
            int id_form = v.getCin();
             PostulationService rs = new PostulationService();

                rs.accepterPostulation(id_form);
          AlertBox.display("confirmation", "inscription avec succees");
          afficherAction(event);
    }
    
    @FXML
    private void genererPDF(ActionEvent event) throws FileNotFoundException, DocumentException, SQLException
    {
        String file_name="C:\\pdf\\test_pdf.pdf";
        Document document = new Document();
        
        PdfWriter.getInstance(document, new FileOutputStream(file_name));
        document.open();
        
        PostulationService pService = new PostulationService();
        
        pService.genererPdf(document);
        
        
        
    }

    
    
}
