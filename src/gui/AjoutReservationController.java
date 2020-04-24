/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Utilitaire.ControlesaisieJ;
import Entity.Reservation;
import Service.ReservationService;
import com.google.maps.GeoApiContext;
import com.google.maps.PlaceAutocompleteRequest;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AutocompletePrediction;
import com.google.maps.model.ComponentFilter;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;

import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;
import Utilitaire.Session;

/**
 * FXML Controller class
 *
 * @author Aziz Bousselmi
 */
public class AjoutReservationController implements Initializable,MapComponentInitializedListener {
    static String type ="taxi";
    

    @FXML
    private GoogleMapView mapView;
    @FXML
    private TextField depart;
    @FXML
    private TextField image;
    @FXML
    private Button VoirEtab;
    @FXML
    private TextField arrive;
    @FXML
    private TextField prix;
    @FXML
    private TextField distance;
    public Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
      private GoogleMap map;
   private GeocodingService geocodingService;

    private StringProperty address = new SimpleStringProperty();
   GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyBHjlgL6dSHWPvn20tm_kzbDURUCYyCuXE");

    List<String> hints = new ArrayList<>();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        prix.setAlignment(Pos.CENTER);
                distance.setAlignment(Pos.CENTER);
        System.out.println(date);

           prix.setText("10");
        prix.setEditable(false);
        distance.setText("10");
        distance.setEditable(false);
        System.out.println(AjoutReservationController.type);
                                         mapView.addMapInializedListener(this);

            depart.setEditable(true);

        address.bind(depart.textProperty());
       TextFields.bindAutoCompletion(depart, e -> {
            hints.clear();
            
            if (depart.getText().trim().length() > 0) {
                PlaceAutocompleteRequest req = PlacesApi.placeAutocomplete(context, depart.getText());
                req.components(ComponentFilter.country("tn"));
                try {
                    AutocompletePrediction[] results = req.await();
                    System.out.println("ldekhel");
                    for (AutocompletePrediction item : results) {
                        hints.add(item.description);
                    }        
                } catch (ApiException ex) {
                    //Logger.getLogger(HomepageController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AjoutReservationController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(AjoutReservationController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            return hints;
            
        });
         depart.setEditable(true);
             mapView.addMapInializedListener((MapComponentInitializedListener) this);
        address.bind(arrive.textProperty());
       TextFields.bindAutoCompletion(arrive, e -> {
            hints.clear();
            
            if (depart.getText().trim().length() > 0) {
                PlaceAutocompleteRequest req = PlacesApi.placeAutocomplete(context, arrive.getText());
                req.components(ComponentFilter.country("tn"));
                try {
                    AutocompletePrediction[] results = req.await();
                    System.out.println("ldekhel");
                    for (AutocompletePrediction item : results) {
                        hints.add(item.description);
                    }        
                } catch (ApiException ex) {
                    //Logger.getLogger(HomepageController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AjoutReservationController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(AjoutReservationController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            return hints;
            
        });
         
        // TODO
        
        // TODO*/
    }    

    @FXML
    private void AjoutReservation(ActionEvent event) {

            ControlesaisieJ cs = new ControlesaisieJ();
            
        int id_chauffeur=20;
        int id_client=Session.getSession().getId();
        String _depart = depart.getText();
        String _arrive= arrive.getText();
        if(_depart.length()<=0 || _arrive.length()<=0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("Erreur");

alert.setContentText("Champs contenant des caractères innapropriés!");

alert.showAndWait();
        }
        else {
            
        
        
        float _distance = (float) 45.4;
        Reservation r = new Reservation(_distance, _depart, _arrive, date, id_chauffeur, id_client, _distance, 1, AjoutReservationController.type);
        ReservationService rs = new ReservationService();
        rs.ajouterReservation(r);
        
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("AfficherReservation.fxml"));
            try {
                Parent root = loader.load();
                AfficherReservationController lrc = loader.getController();
                                depart.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
        }
        
        
     
    }
    
    public void mapInitialized() {
        geocodingService = new GeocodingService();
        MapOptions options = new MapOptions();

        options.center(new LatLong(34.73, 10.04))
                
                .zoomControl(true)
                .zoom(6)
                .overviewMapControl(false)
                .mapType(MapTypeIdEnum.ROADMAP);
         map = mapView.createMap(options);
       
    }
    @FXML
    private void BackAction (ActionEvent event) {
                FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("ChoixReservation.fxml"));
            try {
                Parent root = loader.load();
                ChoixReservationController lrc = loader.getController();
                                arrive.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
    }

       @FXML
    private void toTextFieldAction(ActionEvent event) {
        
         geocodingService.geocode(depart.getText(), (GeocodingResult[] results, GeocoderStatus status) -> {
            map.clearMarkers();
            LatLong latLong = null;
            
            if( status == GeocoderStatus.ZERO_RESULTS) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No matching address found");
                alert.show();
                return;
            } else if( results.length > 1 ) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Multiple results found, showing the first one.");
                alert.show();
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
            } else {
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
            }
            
            map.setCenter(latLong);
            map.setZoom(15);
            MarkerOptions markerOptions = new MarkerOptions();
             markerOptions.position(latLong)
            .visible(true);
             Marker marker = new Marker(markerOptions);
             map.addMarker(marker);

        });
    }
}
