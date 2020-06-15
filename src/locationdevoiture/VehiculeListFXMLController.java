/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locationdevoiture;

import Interfaces.Vehicules;
import TestRmi.Testrmi;
import bean.Vehicule;
import com.jfoenix.controls.JFXButton;
import helper.UtilisateurFxHelper;
import helper.VehiculeFxHelper;
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

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class VehiculeListFXMLController implements Initializable {
 @FXML
    private JFXButton ajouterbtn;
 @FXML
    private TableView  vehiculeTv;
  private UtilisateurFxHelper utilisateurFxHelper;
    List<Vehicule> vehicules = new ArrayList<>();
    Vehicules odVehicule = Testrmi.odVehicule;
   


    /**
     * Initializes the controller class.
     */
     public void handleAjouter(MouseEvent event) {
           
               Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/AjouterVehiculeFXML.fxml"));
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
        
         try {
            // TODO
            VehiculeFxHelper vehiculeFxHelper = new VehiculeFxHelper(vehiculeTv, odVehicule.findAll());
             System.out.println("lista"+odVehicule.findAll());
        } catch (RemoteException ex) {
            Logger.getLogger(UtilisateurListFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         ajouterbtn.setOnMouseClicked(( e ) ->
            {
                   handleAjouter(e);
            });
    }    
    
}
