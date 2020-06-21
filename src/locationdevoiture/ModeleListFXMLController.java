/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locationdevoiture;

import Interfaces.Marques;
import Interfaces.Modeles;
import Interfaces.Types;
import TestRmi.Testrmi;
import bean.Marque;
import bean.Modele;
import bean.Type;
import com.jfoenix.controls.JFXButton;
import helper.MarqueFxHelper;
import helper.ModeleFxHelper;
import helper.TypeFxHelper;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class ModeleListFXMLController implements Initializable {

    @FXML
    private JFXButton ajouterbtn1;
    @FXML
    private JFXButton ajouterbtn2;
    @FXML
    private JFXButton ajouterbtn3;
    @FXML
    private TableView tab;
    @FXML
    private TableView tab2;
    @FXML
    private TableView tab3;
    private ModeleFxHelper modeleFxHelper;
    List<bean.Modele> modeles = new ArrayList<>();
    Modeles odModeles = Testrmi.odModele;
    
    private MarqueFxHelper marqueFxHelper;
    List<bean.Marque> marques = new ArrayList<>();
    Marques odMarques = Testrmi.odMarque;
    
    private TypeFxHelper typeFxHelper;
    List<bean.Type> types = new ArrayList<>();
    Types odTypes = Testrmi.odType;
    @FXML
    private JFXButton sup;
    @FXML
    private JFXButton sup2;
    @FXML
    private JFXButton sup3;

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
            root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/AjouterModeleFXML.fxml"));
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
//        ajouterbtn1.setOnMouseClicked((e)
//                -> {
//            handleAjouter(e);
//        });
//        ajouterbtn2.setOnMouseClicked((e)
//                -> {
//            handleAjouter(e);
//        });
//        ajouterbtn3.setOnMouseClicked((e)
//                -> {
//            handleAjouter(e);
//        });
        
        try {
            modeles = odModeles.findAllModeles();
        } catch (RemoteException ex) {
            Logger.getLogger(ModeleListFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            marques = odMarques.findAllMarques();
        } catch (RemoteException ex) {
            Logger.getLogger(ModeleListFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            types = odTypes.findAllTypes();
        } catch (RemoteException ex) {
            Logger.getLogger(ModeleListFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("this is size test :" + modeles.size());

        if (!modeles.isEmpty()) {
            modeleFxHelper = new ModeleFxHelper(tab, modeles);
            System.out.println("khkhkh" + modeles.size() + modeles.get(0).getId());

        }
        if (!marques.isEmpty()) {
            marqueFxHelper = new MarqueFxHelper(tab2, marques);
            System.out.println("khkhkh" + modeles.size() + modeles.get(0).getId());

        }
        if (!types.isEmpty()) {
            typeFxHelper = new TypeFxHelper(tab3, types);
            System.out.println("khkhkh" + modeles.size() + modeles.get(0).getId());

        }

        sup.setOnMouseClicked((e)
                -> {
            System.out.println("delete test");
            try {

                Modele selectedItem = (Modele) tab.getSelectionModel().getSelectedItem();

                if (selectedItem != null) {
                    tab.getItems().remove(selectedItem);
                    odModeles.remove(selectedItem);
                    System.out.println(selectedItem);
                    JOptionPane.showMessageDialog(null, "Suppression avec succée", "", 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Vous devez selectionner une ligne", "", 1);
                }

            } catch (RemoteException ex) {
                Logger.getLogger(ModeleListFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        sup3.setOnMouseClicked((e)
                -> {
            System.out.println("delete test");
            try {

                Type selectedItem = (Type) tab3.getSelectionModel().getSelectedItem();

                if (selectedItem != null) {
                    tab3.getItems().remove(selectedItem);
                    odTypes.remove(selectedItem);
                    System.out.println(selectedItem);
                    JOptionPane.showMessageDialog(null, "Suppression avec succée", "", 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Vous devez selectionner une ligne", "", 1);
                }

            } catch (RemoteException ex) {
                Logger.getLogger(ModeleListFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        sup2.setOnMouseClicked((e)
                -> {
            System.out.println("delete test");
            try {

                Marque selectedItem = (Marque) tab2.getSelectionModel().getSelectedItem();

                if (selectedItem != null) {
                    tab2.getItems().remove(selectedItem);
                    odMarques.remove(selectedItem);
                    System.out.println(selectedItem);
                    JOptionPane.showMessageDialog(null, "Suppression avec succée", "", 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Vous devez selectionner une ligne", "", 1);
                }

            } catch (RemoteException ex) {
                Logger.getLogger(ModeleListFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

}
