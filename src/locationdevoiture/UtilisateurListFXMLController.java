/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locationdevoiture;

import Interfaces.Agences;
import Interfaces.Modeles;
import Interfaces.Utilisateurs;
import TestRmi.Testrmi;
import static TestRmi.Testrmi.odAgence;
import bean.Utilisateur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import helper.UtilisateurFxHelper;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class UtilisateurListFXMLController implements Initializable {

    @FXML
    private JFXButton ajouterbtn;
    @FXML
    private JFXButton modifierBtn;
    @FXML
    private JFXButton modBtn;
    @FXML
    private JFXButton supBtn;
    @FXML
    private JFXButton rechBtn;
    @FXML
    private JFXComboBox agenceCb;
    @FXML
    private JFXTextField loginTf;
    @FXML
    private JFXTextField nomTf;
    @FXML
    private JFXTextField emailTf;
    @FXML
    private TableView<Utilisateur> utilisateureTv;
    @FXML
    private JFXButton actionBtn = new JFXButton("S");
    private UtilisateurFxHelper utilisateurFxHelper;
    List<Utilisateur> utilisateurs = new ArrayList<>();
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
    public void handleAjouter(MouseEvent event) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/AjouterUtilisateurFXML.fxml"));
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
        try {
            // TODO
         
            utilisateurFxHelper = new UtilisateurFxHelper(utilisateureTv, odUtilisateurs.findAllUsers());
        } catch (RemoteException ex) {
            Logger.getLogger(UtilisateurListFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
       // TableColumn action = new TableColumn("ACTIONn");
      //  utilisateureTv.getColumns().addAll(action);
        ajouterbtn.setOnMouseClicked((e)
                -> {
            handleAjouter(e);
        });
      
        // System.out.println("hana"+utilisateurFxHelper.getSelected());
        supBtn.setOnAction((event) -> {
            try {

                Utilisateur selectedItem = utilisateureTv.getSelectionModel().getSelectedItem();
                utilisateureTv.getItems().remove(selectedItem);
                odUtilisateurs.remove(selectedItem);
                System.out.println(selectedItem);
                JOptionPane.showMessageDialog(null, "Suppression avec succée", "", 1);

            } catch (RemoteException ex) {
                Logger.getLogger(UtilisateurListFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        rechBtn.setOnAction((ActionEvent event) -> {
                      
                utilisateureTv.getItems().clear();
                
                String nom = null;
                if (nomTf.getText()!=null && !nomTf.getText().equals("")) {
                    nom = nomTf.getText();
                }
                String email = null;
                if (emailTf.getText()!=null && !emailTf.getText().equals("")) {
                    email = emailTf.getText();
                }
                String login = null;
                if (loginTf.getText()!=null && !loginTf.getText().equals("")) {
                    login = loginTf.getText();
                }
                String agence = agenceCb.getSelectionModel().getSelectedItem().toString();
                
                 try {
               List<Utilisateur> utilisateurss  = odUtilisateurs.findByCriteriaUtilisateur(login, nom, email, agence);
               System.out.println("users"+utilisateurss); 
              
               utilisateurFxHelper.setList(utilisateurss);
                
                // UtilisateurFxHelper utilisateurFxHelper = new UtilisateurFxHelper(utilisateureTv, utilisateurss);
            } catch (RemoteException ex) {
                Logger.getLogger(UtilisateurListFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
        });
    }

}
