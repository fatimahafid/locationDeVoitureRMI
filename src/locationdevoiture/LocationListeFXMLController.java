/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locationdevoiture;

import Interfaces.Locations;
import TestRmi.Testrmi;
import bean.Location;
import com.jfoenix.controls.JFXButton;
import helper.LocationFxHelper;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class LocationListeFXMLController implements Initializable {
  @FXML
    private JFXButton ajouterbtn;
 @FXML
    private JFXButton sup;
     @FXML
     private TableView tab;
 private LocationFxHelper locationFxHelper;
List<bean.Location> locations = new ArrayList<>();
   Locations  odLocations = Testrmi.odLocation;
    /**
     * Initializes the controller class.
     */
   public void handleAccueil(MouseEvent event) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/Menu.fxml"));
            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setTitle("Ajouter");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void handleClients(MouseEvent event) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/ClientList.fxml"));
            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setTitle("Ajouter");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void handleAgence(MouseEvent event) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/AgenceListFXML.fxml"));
            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setTitle("Ajouter");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void handleVehicule(MouseEvent event) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/VehiculeListFXML.fxml"));
            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setTitle("Ajouter");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void handleModele(MouseEvent event) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/ModeleListFXML.fxml"));
            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setTitle("Ajouter");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void handleLocation(MouseEvent event) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/LocationListeFXML.fxml"));
            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setTitle("Ajouter");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     public void handleAjouter(MouseEvent event) {
           
               Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/AjouterLocationFXML.fxml"));
                    javafx.stage.Stage stage = new javafx.stage.Stage();
                    stage.setTitle("Ajouter");
                    stage.setScene(new Scene(root));
                    stage.show();
                    // Hide this current window (if this is what you want)
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ajouterbtn.setOnMouseClicked(( e ) ->
            {
                   handleAjouter(e);
            });
          try {
            locations=odLocations.findAll() ;
        } catch (RemoteException ex) {
            Logger.getLogger(LocationListeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
                System.out.println("this is size test :"+locations.size()); 

        if(!locations.isEmpty())   { 
       locationFxHelper  = new LocationFxHelper(tab, locations);
       System.out.println("khkhkh"+locations.size()+locations.get(0).getId()); 

        }
        
         sup.setOnMouseClicked(( e ) ->
            {System.out.println("delete test"); 
            try {

               Location selectedItem = (Location) tab.getSelectionModel().getSelectedItem();
             if(selectedItem!=null){
 
               tab.getItems().remove(selectedItem);
                odLocations.remove(selectedItem);
                System.out.println(selectedItem);
                JOptionPane.showMessageDialog(null, "Suppression avec succée", "", 1);
             }else
           JOptionPane.showMessageDialog(null, "Vous devez selectionner une ligne", "", 1);

            } catch (RemoteException ex) {
                Logger.getLogger(LocationListeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }

            });
        
    }    
    
}
