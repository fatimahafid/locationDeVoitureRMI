/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locationdevoiture;

import Interfaces.Agences;
import Interfaces.Utilisateurs;
import TestRmi.Testrmi;
import static TestRmi.Testrmi.odAgence;

import bean.Agence;
import bean.Utilisateur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
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
public class AjouterUtilisateurFXMLController implements Initializable {

    @FXML
    private JFXButton ajouterBtn;
    @FXML
    private JFXTextField loginTf;
    @FXML
    private JFXTextField nomTf;
    @FXML
    private JFXTextField prenomTf;
    @FXML
    private JFXTextField emailTf;
    @FXML
    private JFXTextField telTf;
    @FXML
    private JFXPasswordField mdpPf;
    @FXML
    private JFXPasswordField cmdpPf;
    @FXML
    private JFXComboBox agenceCb;
    @FXML
    private JFXRadioButton geRb;
    
    private Agence agence = null;
    Utilisateurs odUtilisateurs = Testrmi.odUtilisateur;
    Agences odAgences = Testrmi.odAgence;

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

        try {
            // TODO
            agenceCb.getItems().addAll(odAgence.findAll());
        } catch (RemoteException ex) {
            Logger.getLogger(AjouterUtilisateurFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        agenceCb.getSelectionModel().select(0);
        ajouterBtn.setOnAction((event) -> {
            System.out.println("u clicked!");
            int res2 = 0;
            try {
                if (odUtilisateurs != null) {
                    boolean x = false;
                    if (geRb.isSelected()) {
                        x = true;
                    }

                    agence = odAgence.findByNom(agenceCb.getSelectionModel().getSelectedItem().toString());
                    Utilisateur utilisateur = new Utilisateur(loginTf.getText(), mdpPf.getText(), nomTf.getText(), prenomTf.getText(), emailTf.getText(), telTf.getText(), x, agence);
                   
                    if (!mdpPf.getText().equals(cmdpPf.getText())) {
                        JOptionPane.showMessageDialog(null, "Erreur de confirmation Mot De Passe", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Inscription avec succée", "Bienvenue", JOptionPane.INFORMATION_MESSAGE);
                        odUtilisateurs.createUtilisateur(utilisateur);
                         Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/UtilisateurListFXML.fxml"));
                            Stage stage = new Stage();
                            stage.setTitle("apresAjoutUser");
                            stage.setScene(new Scene(root));
                            stage.show();
                            // Hide this current window 
                            ((Node) (event.getSource())).getScene().getWindow().hide();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //utilisateurFxHelper.create(utilisateur);
                    }
                }
            } catch (RemoteException ex) {
                Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(res2);
        });

    }

}
