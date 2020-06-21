/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locationdevoiture;

import Interfaces.Agences;
import Interfaces.Clients;
import Interfaces.Locations;
import Interfaces.Modeles;
import Interfaces.Vehicules;
import TestRmi.Testrmi;
import static TestRmi.Testrmi.odAgence;
import static TestRmi.Testrmi.odModele;
import static TestRmi.Testrmi.odVehicule;
import bean.Agence;
import bean.Client;
import bean.Location;
import bean.Modele;
import bean.Vehicule;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import util.DateUtil;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class AjouterLocationFXMLController implements Initializable {

    @FXML
    private JFXButton ajouterBtn;
    @FXML
    private JFXTextField montantTf;
    @FXML
    private JFXTextField cinTf;
    @FXML
    private JFXDatePicker dateresDp;
    @FXML
    private JFXDatePicker datedeblocDp;
    @FXML
    private JFXDatePicker datefinlocDp;
    @FXML
    private JFXDatePicker datedebreelDp;
    @FXML
    private JFXDatePicker datefinreelDp;
    @FXML
    private JFXDatePicker datepaiprevuDp;
    @FXML
    private JFXDatePicker datepaieffDp;
    @FXML
    private JFXComboBox agenceCb;
    @FXML
    private JFXComboBox vehiculeCb;
    @FXML
    private JFXComboBox ModeleCb;

    private Agence agence = null;
    private Modele modele = null;
    private Vehicule vehicule = null;
    private Client client = null;
    Locations odLocation = Testrmi.odLocation;
    Clients odClient = Testrmi.od;
    Agences odAgences = Testrmi.odAgence;
    Vehicules odVehicules = Testrmi.odVehicule;
    Modeles odModeles = Testrmi.odModele;

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
            agenceCb.getItems().addAll(odAgence.findAll());
        } catch (RemoteException ex) {
            Logger.getLogger(AjouterUtilisateurFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ModeleCb.getItems().addAll(odModeles.findAll());
        } catch (RemoteException ex) {
            Logger.getLogger(AjouterUtilisateurFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            vehiculeCb.getItems().addAll(odVehicules.findAll());
        } catch (RemoteException ex) {
            Logger.getLogger(AjouterUtilisateurFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        agenceCb.getSelectionModel().select(0);
        ModeleCb.getSelectionModel().select(0);
        vehiculeCb.getSelectionModel().select(0);

        ajouterBtn.setOnAction((event) -> {
            System.out.println("u clicked!");
            int res2 = 0;
            try {
                if (odLocation != null) {

                    agence = odAgence.findByNom(agenceCb.getSelectionModel().getSelectedItem().toString());
                    modele = odModele.findByNom(ModeleCb.getSelectionModel().getSelectedItem().toString());
                    vehicule = odVehicule.findByNumImm(vehiculeCb.getSelectionModel().getSelectedItem().toString());
                    client = odClient.findByCin(cinTf.getText());
                    java.util.Date datedebloc = java.sql.Date.valueOf(datedeblocDp.getValue());
                    java.util.Date datedebreel = java.sql.Date.valueOf(datedebreelDp.getValue());
                    java.util.Date datefinloc = java.sql.Date.valueOf(datefinlocDp.getValue());
                    java.util.Date datefinreel = java.sql.Date.valueOf(datefinreelDp.getValue());
                    java.util.Date datepaieff = java.sql.Date.valueOf(datepaieffDp.getValue());
                    java.util.Date datepaiprevu = java.sql.Date.valueOf(datepaiprevuDp.getValue());
                    java.util.Date dateres = java.sql.Date.valueOf(dateresDp.getValue());

                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                         
                        Date dateAvant = sdf.parse(DateUtil.formateDate("MM/dd/yyyy", datedebloc));
                        Date dateApres = sdf.parse(DateUtil.formateDate("MM/dd/yyyy", datefinloc));
                        long diff = dateApres.getTime() - dateAvant.getTime();
                        float res = (diff / (1000 * 60 * 60 * 24));
                        System.out.println("Nombre de jours entre les deux dates est: " + res);
              
                        Double res3 = res*vehicule.getPrix();
                    Location location = new Location(dateres, datedebloc, datefinloc, datedebreel, datefinreel, res3, datepaiprevu, datepaieff, modele, vehicule,client, agence);

                    
                        JOptionPane.showMessageDialog(null, "Le montant de la location est de : "+res3, "Bienvenue", JOptionPane.INFORMATION_MESSAGE);
                        odLocation.createLocation(location);
                        Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/LocationListeFXML.fxml"));
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
            } catch (RemoteException ex) {
                Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(AjouterLocationFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(res2);
        });
    }

}
