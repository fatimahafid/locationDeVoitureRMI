/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locationdevoiture;

import Interfaces.Agences;
import Interfaces.Villes;
import TestRmi.Testrmi;
import bean.Agence;
import bean.Ville;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
public class AjouterAgenceFXMLController implements Initializable {

    @FXML
    private JFXButton ajouterBtn;
    @FXML
    private JFXTextField nomTf;
    @FXML
    private JFXTextField adresseTf;
    @FXML
    private JFXTextField emailTf;
    @FXML
    private JFXTextField telTf;
     @FXML
    private JFXComboBox villeCb;
      private Ville ville = null;

    Agences odAgences = Testrmi.odAgence;
    Villes odVilles = Testrmi.odVille;

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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
            // TODO
            villeCb.getItems().addAll(odVilles.findAll());
        } catch (RemoteException ex) {
            Logger.getLogger(AjouterAgenceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        villeCb.getSelectionModel().select(0);
        ajouterBtn.setOnAction((event) -> {
            System.out.println("u clicked!");
            int res2 = 0;
            try {
                if (odAgences != null) {
                   

                    ville = odVilles.findByLibelle(villeCb.getSelectionModel().getSelectedItem().toString());
                    Agence agence = new Agence(adresseTf.getText(), telTf.getText(), nomTf.getText(), emailTf.getText(), ville);
                   
                 
                        JOptionPane.showMessageDialog(null, "Inscription avec succée", "Bienvenue", JOptionPane.INFORMATION_MESSAGE);
                        odAgences.createAgence(agence);
                         Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/AgenceListFXML.fxml"));
                            Stage stage = new Stage();
                            stage.setTitle("apresAjoutAgence");
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


