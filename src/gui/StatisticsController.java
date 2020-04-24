/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Offre;
import Utilitaire.IntegerStringConverter;
import Service.OffreService;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class StatisticsController implements Initializable {
        
    
     @FXML
    private CategoryAxis xAxis;
       
      private ObservableList<String> joursNames = FXCollections.observableArrayList();
    @FXML
    private LineChart<String, Number> lineChart;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
      /*  final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        
        xAxis.setLabel("Jours du mois");
        
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
        
        lineChart.setTitle("Statistiques Des Offres");
        
         XYChart.Series series = new XYChart.Series();
         
          series.getData().add(rb);*/
      
      lineChart.setTitle("Nombre de covoiturages du dernier mois"); 
      xAxis.setLabel("Jour du mois");
      
      
     List<String> jours = Arrays.asList("01", "02", "03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30");
       ObservableList<String> listType = FXCollections.observableArrayList(jours); 
         xAxis.setCategories(listType);
         
         setNbrCovoiturages(jours);
    }
      
       public void setNbrCovoiturages( List<String> jours ) {
        // Count the number of people having their birthday in a specific month.
       OffreService oService = new OffreService();
       int nbrCounter[] = new int[30];
       System.out.println(jours.size());
        for (int i=0; i <jours.size();i++) {
           try {
               int nbr = oService.OffresSelonDate(jours.get(i));
               nbrCounter[i] = nbr;
              // System.out.println(nbr);
           } catch (ParseException ex) {
               Logger.getLogger(StatisticsController.class.getName()).log(Level.SEVERE, null, ex);
           }
            
            
        }

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Nombre de covoiturages");
        
        // Create a XYChart.Data object for each month. Add it to the series.
        for (int i = 0; i < nbrCounter.length; i++) 
        {
            IntegerStringConverter integerConvert= new IntegerStringConverter();
            
            String nbr_convert1 = integerConvert.toString(nbrCounter[i]);
            Number nbr_convert2 = integerConvert.fromString(nbr_convert1);
            if (nbrCounter[i] != 0 )
            {
                series.getData().add(new XYChart.Data<>(jours.get(i), nbr_convert2));
            }
            
        }
        
        lineChart.getData().add(series);
        
    }

    @FXML
    private void goBack(ActionEvent event) {
    
          FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Backend.fxml"));
            try {
    
                Parent root = loader.load();
                BackendController apc = loader.getController();
                xAxis.getScene().setRoot(root);
               //apc.setResNom(tfNom);
               // apc.setResPrenom(tfPrenom);
               // tfNom.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }
}    
    

