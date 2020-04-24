/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Offre;
import Service.FormationService;
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
public class StatisticsFormationController implements Initializable {
        
    @FXML
    private BarChart<String, Number> barChart;
    
     @FXML
    private CategoryAxis xAxis;
       
      private ObservableList<String> FormationNames = FXCollections.observableArrayList();
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
      
      barChart.setTitle("Nombre de participant"); 
      xAxis.setLabel("formation");

 List<String> jours = Arrays.asList("ionic", "Gestion de stress", "anglais","time Managment","formation","body luanguage");
       ObservableList<String> listType = FXCollections.observableArrayList(jours); 
         xAxis.setCategories(listType);
         
         setNbrparicipant(jours);
    }
      
       public void setNbrparicipant( List<String> jours ) {
        // Count the number of people having their birthday in a specific month.
       FormationService oService = new FormationService();
       int nbrCounter[] = new int[6];
       System.out.println(jours.size());
        for (int i=0; i <jours.size();i++) {
           try {
               int nbr = oService.participantselonformation(jours.get(i));
               nbrCounter[i] = nbr;
              // System.out.println(nbr);
           } catch (ParseException ex) {
               Logger.getLogger(StatisticsFormationController.class.getName()).log(Level.SEVERE, null, ex);
           }
        }

        
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Nombre de participants");
        
        // Create a XYChart.Data object for each month. Add it to the series.
        for (int i = 0; i < nbrCounter.length; i++) 
        {
            IntegerStringConverter integerConvert= new IntegerStringConverter();
            
            String nbr_convert1 = integerConvert.toString(nbrCounter[i]);
            Number nbr_convert2 = integerConvert.fromString(nbr_convert1);
            series.getData().add(new XYChart.Data<>(jours.get(i), nbr_convert2));
        }
        
        barChart.getData().add(series);
        
    }

    @FXML
    private void goback(ActionEvent event) {
        
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("GestionFormation.fxml"));
            try {
                Parent root = loader.load();
               GestionFormationController lrc = loader.getController();
                                barChart.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }
      
    }    
    

