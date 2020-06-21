/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locationdevoiture;

import Interfaces.Agences;
import TestRmi.Testrmi;
import bean.Agence;
import bean.Utilisateur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import helper.AgenceFxHelper;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
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
public class AgenceListFXMLController implements Initializable {

    @FXML
    private JFXButton ajouterbtn;
    @FXML
    private JFXButton rechBtn;
    @FXML
    private JFXTextField nomTf;
    @FXML
    private JFXTextField adresseTf;
    @FXML
    private JFXTextField telTf;
    @FXML
    private JFXTextField mailTf;

    @FXML
    private JFXButton sup;
    @FXML
    private TableView tab;
    private AgenceFxHelper agenceFxHelper;
    List<bean.Agence> agences = new ArrayList<>();
    Agences odAgences = Testrmi.odAgence;

    /**
     * Initializes the controller class.
     */
    public void handleAjouter(MouseEvent event) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/AjouterAgenceFXML.fxml"));
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
        ajouterbtn.setOnMouseClicked((e)
                -> {
            handleAjouter(e);
        });

        try {
            agences = odAgences.findAllAgences();
        } catch (RemoteException ex) {
            Logger.getLogger(AgenceListFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("this is size test :" + agences.size());

        if (!agences.isEmpty()) {
            agenceFxHelper = new AgenceFxHelper(tab, agences);
            System.out.println("khkhkh" + agences.size() + agences.get(0).getId());

        }

        sup.setOnMouseClicked((e)
                -> {
            System.out.println("delete test");
            try {

                Agence selectedItem = (Agence) tab.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {

                    tab.getItems().remove(selectedItem);
                    odAgences.remove(selectedItem);
                    System.out.println(selectedItem);
                    JOptionPane.showMessageDialog(null, "Suppression avec succée", "", 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Vous devez selectionner une ligne", "", 1);
                }

            } catch (RemoteException ex) {
                Logger.getLogger(AgenceListFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        rechBtn.setOnAction((ActionEvent event) -> {

            tab.getItems().clear();

            String nom = null;
            if (nomTf.getText() != null && !nomTf.getText().equals("")) {
                nom = nomTf.getText();
            }
            String email = null;
            if (mailTf.getText() != null && !mailTf.getText().equals("")) {
                email = mailTf.getText();
            }
            String adresse = null;
            if (adresseTf.getText() != null && !adresseTf.getText().equals("")) {
                adresse = adresseTf.getText();
            }
            String tel = null;
            if (telTf.getText() != null && !telTf.getText().equals("")) {
                tel = telTf.getText();
            }

            try {
                List<Agence> agencess = odAgences.findByCriteriaAgence(nom, tel, adresse, email);

                System.out.println("agencess" + agencess);

                agenceFxHelper.setList(agencess);

                // UtilisateurFxHelper utilisateurFxHelper = new UtilisateurFxHelper(utilisateureTv, utilisateurss);
            } catch (RemoteException ex) {
                Logger.getLogger(UtilisateurListFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

}
