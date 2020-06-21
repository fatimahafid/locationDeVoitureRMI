/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locationdevoiture;

import Interfaces.Clients;
import TestRmi.Testrmi;
import bean.Client;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author farah
 */
public class ModifierClientController implements Initializable {
@FXML
    private JFXButton modifierBtn;
    @FXML
    private JFXTextField nomTf;
    @FXML
    private JFXTextField prenomTf;
    @FXML
    private JFXTextField cinTf;
    @FXML
    private JFXTextField adresseTf;
    @FXML
    private JFXTextField emailTf;
    @FXML
    private JFXTextField telTf;
    @FXML
    private JFXTextField numpermisTf;
    @FXML
    private JFXTextField pointTf;
    
   
    Clients odClients = Testrmi.od;
    public Client client=new Client();    
      void initData(Client c) {
        System.out.println("c : "+c.getNom());    
        this.client=c;
         System.out.println("client : "+client.getNom());    

   

 }

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
        System.out.println("in controller");
      
    Platform.runLater(() -> {
            System.out.println("Running Later");
            nomTf.setText(client.getNom());
        prenomTf.setText(client.getPrenom());
        cinTf.setText(client.getCin());
        emailTf.setText(client.getEmail());
        telTf.setText(client.getTel());
        adresseTf.setText(client.getAdr());
          
    
    
     modifierBtn.setOnAction((event) -> {
            
            client.setAdr(adresseTf.getText());
            client.setCin(cinTf.getText());
            client.setEmail(emailTf.getText());
            client.setNom(nomTf.getText());
            client.setPrenom(prenomTf.getText());
            client.setTel(telTf.getText());
            client.setPoint(Long.valueOf(pointTf.getText()));
                try {
                    odClients.edit(client);
                } catch (RemoteException ex) {
                    Logger.getLogger(ModifierClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
            
            
             Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/ClientList.fxml"));
                            Stage stage = new Stage();
                            stage.setTitle("apresModificationClient");
                            stage.setScene(new Scene(root));
                            stage.show();
                            // Hide this current window 
                            ((Node) (event.getSource())).getScene().getWindow().hide();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
          
        });
    
    
    
    
    
    
    
    
    
    
    });
       
        
    }    

  
    
}
