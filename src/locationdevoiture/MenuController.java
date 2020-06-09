/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locationdevoiture;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author farah
 */
public class MenuController implements Initializable {
@FXML
    private Button agentBtn;
@FXML
    private Button agenceBtn;
@FXML
    private Button clientBtn;
@FXML
    private Button locationBtn;
@FXML
    private Button modeleBtn;
@FXML
    private Button vehiculeBtn;
    /**
     * Initializes the controller class.
     */
     public void handleUser(MouseEvent event) {
           
               Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/UtilisateurListFXML.fxml"));
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
                }public void handleClient(MouseEvent event) {
           
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
                
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         agentBtn.setOnMouseClicked(( e ) ->
            {
                   handleUser(e);
            });
         agenceBtn.setOnMouseClicked(( e ) ->
            {
                   handleAgence(e);
            });
         clientBtn.setOnMouseClicked(( e ) ->
            {
                   handleClient(e);
            });
         locationBtn.setOnMouseClicked(( e ) ->
            {
                   handleLocation(e);
            });
         modeleBtn.setOnMouseClicked(( e ) ->
            {
                   handleModele(e);
            });
         vehiculeBtn.setOnMouseClicked(( e ) ->
            {
                   handleVehicule(e);
            });
    }    
    
}
