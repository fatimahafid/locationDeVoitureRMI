/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locationdevoiture;

import Interfaces.Marques;
import Interfaces.Modeles;
import Interfaces.Vehicules;
import TestRmi.Testrmi;
import bean.Marque;
import bean.Modele;
import bean.Vehicule;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class AjouterVehiculeFXMLController implements Initializable {

    @FXML
    private JFXButton ajouterBtn;
    @FXML
    private JFXTextField kmTf;
    @FXML
    private JFXTextField immTf;
    @FXML
    private JFXTextField prixTf;
    @FXML
    private JFXComboBox carCb;
    @FXML
    private JFXComboBox etatCb;
    @FXML
    private JFXComboBox modeleCb;
    @FXML
    private JFXDatePicker datemisecirDp;

    Vehicules odVehicules = Testrmi.odVehicule;
    Modeles odModele = Testrmi.odModele;
    Marques odMarque = Testrmi.odMarque;
    private Modele modele = null;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            // TODO
            modeleCb.getItems().addAll(odModele.findAll());
        } catch (RemoteException ex) {
            Logger.getLogger(AjouterUtilisateurFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        etatCb.getItems().addAll("Etat", "disponible", "non disponible");
        etatCb.getSelectionModel().select(0);

        carCb.getItems().addAll("Carburant", "essence", "diesel", "hybride");
        carCb.getSelectionModel().select(0);

        ajouterBtn.setOnAction((event) -> {
            System.out.println("u clicked!");
            int res2 = 0;
            try {
                if (odVehicules != null) {

                    boolean x = false;
                    if (etatCb.getSelectionModel().getSelectedItem().equals("disponible")) {
                        x = true;
                    }
                    String carb = null;
                    carb = carCb.getSelectionModel().getSelectedItem().toString();
                   
                   
                     Marque idMarque=odMarque.findByLibelle(modeleCb.getSelectionModel().getSelectedItem().toString());
                     modele = odModele.findByNom( idMarque.getLibelle());
                     java.sql.Date gettedDatePickerDate = java.sql.Date.valueOf(datemisecirDp.getValue());
                    Vehicule vehicule = new Vehicule( immTf.getText(), gettedDatePickerDate, new Double(kmTf.getText()), new Double(prixTf.getText()), true, carb, modele);
                   
                   
                    JOptionPane.showMessageDialog(null, "insertion avec succée", "Bienvenue", 1);
                    odVehicules.createVehicule(vehicule);
                    Parent root;
                    try {
                        root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/VehiculeListFXML.fxml"));
                        Stage stage = new Stage();
                        stage.setTitle("apresAjoutvehcule");
                        stage.setScene(new Scene(root));
                        stage.show();
                        // Hide this current window 
                        ((Node) (event.getSource())).getScene().getWindow().hide();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //utilisateurFxHelper.create(utilisateur);

                }
            } catch (RemoteException ex) {
                Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(res2);
        });
    }

}
