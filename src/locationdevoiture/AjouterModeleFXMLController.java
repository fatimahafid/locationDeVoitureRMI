/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locationdevoiture;

import Interfaces.Marques;
import Interfaces.Modeles;
import TestRmi.Testrmi;
import bean.Marque;
import bean.Modele;
import bean.Type;
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
public class AjouterModeleFXMLController implements Initializable {

    @FXML
    private JFXButton ajoutermodeleBtn;
    @FXML
    private JFXButton ajoutermarqueBtn;
    @FXML
    private JFXButton ajoutertypeBtn;
    @FXML
    private JFXComboBox marqueCb;
    private Marque marque = null;
    @FXML
    private JFXComboBox marqueCb1;
    @FXML
    private JFXComboBox typeCb;
    private Type type = null;

    @FXML
    private JFXTextField libelleTf;
    @FXML
    private JFXTextField libelleTf1;

    Modeles odModeles = Testrmi.odModele;
    Marques odMarques = Testrmi.odMarque;
    Interfaces.Types odTypes = (Interfaces.Types) Testrmi.odType;

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
            marqueCb.getItems().addAll(odMarques.findAll());
        } catch (RemoteException ex) {
            Logger.getLogger(AjouterAgenceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        try {
            // TODO
            typeCb.getItems().addAll(odTypes.findAll());
        } catch (RemoteException ex) {
            Logger.getLogger(AjouterAgenceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        marqueCb.getSelectionModel().select(0);
        typeCb.getSelectionModel().select(0);

        ajoutermodeleBtn.setOnAction((event) -> {
            System.out.println("u clicked!");
            int res2 = 0;
            try {
                if (odModeles != null) {

                    marque = odMarques.findByLibelle(marqueCb.getSelectionModel().getSelectedItem().toString());
                    type = odTypes.findByLibelle(typeCb.getSelectionModel().getSelectedItem().toString());
                    Modele modele = new Modele(marque, type);

                    JOptionPane.showMessageDialog(null, "Ajout avec succée", "Bienvenue", JOptionPane.INFORMATION_MESSAGE);
                    odModeles.createModele(modele);
                    Parent root;
                    try {
                        root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/ModeleListFXML.fxml"));
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

        
        
        ajoutermarqueBtn.setOnAction((event) -> {
            System.out.println("u clicked!");
            int res2 = 0;
            try {
                if (odMarques != null) {

                  
                    Marque marque = new Marque(libelleTf.getText());

                    JOptionPane.showMessageDialog(null, "Ajout avec succée", "Bienvenue", JOptionPane.INFORMATION_MESSAGE);
                    odMarques.createMarque(marque);
                    Parent root;
                    try {
                        root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/ModeleListFXML.fxml"));
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
        
        
        ajoutertypeBtn.setOnAction((event) -> {
            System.out.println("u clicked!");
            int res2 = 0;
            try {
                if (odTypes != null) {

                   
                    Type type = new Type(libelleTf1.getText());

                    JOptionPane.showMessageDialog(null, "Ajout avec succée", "Bienvenue", JOptionPane.INFORMATION_MESSAGE);
                    odTypes.createType(type);
                    Parent root;
                    try {
                        root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/ModeleListFXML.fxml"));
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
