/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locationdevoiture;

import Interfaces.Modeles;
import Interfaces.Vehicules;
import TestRmi.Testrmi;
import static TestRmi.Testrmi.odModele;
import bean.Utilisateur;
import bean.Vehicule;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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
public class VehiculeListFXMLController implements Initializable {

    @FXML
    private JFXButton ajouterbtn;
    @FXML
    private JFXButton rechBtn;
    @FXML
    private JFXButton supBtn;
    @FXML
    private JFXTextField immTf;
    @FXML
    private JFXTextField kmmaxTf;
    @FXML
    private JFXTextField prixmaxTf;
    @FXML
    private JFXComboBox etatCb;
    @FXML
    private JFXComboBox carbCb;
    @FXML
    private JFXComboBox modeleCb;
    @FXML
    private TableView<Vehicule> vehiculeTv;
    private VehiculeFxHelper vehiculeFxHelper;
    List<Vehicule> vehicules = new ArrayList<>();
    Vehicules odVehicule = Testrmi.odVehicule;
    Modeles odModele = Testrmi.odModele;

    /**
     * Initializes the controller class.
     */
     public void sendVehiculeToOtherPage(MouseEvent event) {

         
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("locationdevoiture/VehiculeUpdateFXML.fxml"));
            root = loader.load();
            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setTitle("Ajouter");
            stage.setScene(new Scene(root));
            stage.show();
            VehiculeUpdateFXMLController controller = loader.getController();
            controller.initData(vehiculeTv.getSelectionModel().getSelectedItem());
            // Hide this current window (if this is what you want)
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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
       
            

        etatCb.getItems().addAll("Etat", "disponible", "non disponible");
        etatCb.getSelectionModel().select(0);

        carbCb.getItems().addAll("Carburant", "essence", "diesel", "hybride");
        carbCb.getSelectionModel().select(0);
        try {
            // TODO
             vehiculeFxHelper = new VehiculeFxHelper(vehiculeTv, odVehicule.findAllVehicule());
            System.out.println("lista" + odVehicule.findAll());
        } catch (RemoteException ex) {
            Logger.getLogger(UtilisateurListFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ajouterbtn.setOnMouseClicked((e)
                -> {
            handleAjouter(e);
        });

        supBtn.setOnAction((event) -> {
            try {

                Vehicule selectedItem = vehiculeTv.getSelectionModel().getSelectedItem();
                vehiculeTv.getItems().remove(selectedItem);
                odVehicule.remove(selectedItem);
                System.out.println(selectedItem);
                JOptionPane.showMessageDialog(null, "Suppression avec succée", "", 1);

            } catch (RemoteException ex) {
                Logger.getLogger(UtilisateurListFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        rechBtn.setOnAction((ActionEvent event) -> {
            vehiculeTv.getItems().clear();

            String imm = null;
            if (!immTf.getText().isEmpty()) {
                imm = immTf.getText();
            }
            Double km = null;
            if (!kmmaxTf.getText().isEmpty()) {
                km = new Double(kmmaxTf.getText());
            }
            Double prix = null;
            if (!prixmaxTf.getText().isEmpty()) {
                prix = new Double(prixmaxTf.getText());
            }
            String carb = null;
               if (!carbCb.getSelectionModel().getSelectedItem().toString().isEmpty()) {
              carb=  carbCb.getSelectionModel().getSelectedItem().toString();
               }
            //String modele = modeleCb.getSelectionModel().getSelectedItem().toString();
            boolean x = false;
            if (etatCb.getSelectionModel().getSelectedItem().equals("disponible")) {
                x = true;
            }

          
            try {
               List<Vehicule> vehiculess = odVehicule.findByCriteriaVehicule(imm, km, prix, x, carb );
                System.out.println("vehicules" + vehiculess);
             //   VehiculeFxHelper vehiculeFxHelper = new VehiculeFxHelper(vehiculeTv, vehicules);
                vehiculeFxHelper.setList(vehiculess);

            } catch (RemoteException ex) {
                Logger.getLogger(UtilisateurListFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

    }
}
