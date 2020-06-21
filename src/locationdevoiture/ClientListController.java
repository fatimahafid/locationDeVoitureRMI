/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locationdevoiture;

import Interfaces.Clients;
import TestRmi.Testrmi;
import bean.Agence;
import bean.Client;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import helper.ClientFxHelper;
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
 * @author farah
 */
public class ClientListController implements Initializable {

    @FXML
    private JFXButton ajouterbtn;
    @FXML
    private JFXButton modifier;
    @FXML
    private JFXButton sup;
    @FXML
    private JFXButton rechBtn;
    @FXML
    private JFXTextField nomTf;
    @FXML
    private JFXTextField prenomTf;
    @FXML
    private JFXTextField telTf;
    @FXML
    private JFXTextField cinTf;
    @FXML
    private JFXTextField pointTf;
    @FXML
    private TableView clientstab;
    private ClientFxHelper clientFxHelper;
    List<bean.Client> clients = new ArrayList<>();
    Clients odclient = Testrmi.od;

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
    public void handlemodfier(MouseEvent event) {

          Parent root;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("locationdevoiture/ModifierClientFXML.fxml"));
            root = loader.load();
            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setTitle("Modifier");
            stage.setScene(new Scene(root));
            stage.show();
           ModifierClientController controller = loader.getController();
            controller.initData((Client) clientstab.getSelectionModel().getSelectedItem());
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
            root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/AjouterClientFXML.fxml"));
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
        modifier.setOnMouseClicked((e)
                -> {
             if ((Client) clientstab.getSelectionModel().getSelectedItem() != null) {

                                handlemodfier(e);

                } else {
                    JOptionPane.showMessageDialog(null, "Vous devez selectionner une ligne", "", 1);
                }
        });
        try {
            clients = odclient.findAll();
        } catch (RemoteException ex) {
            Logger.getLogger(ClientListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("khkhkh" + clients.size() + clients.get(0).getNom());
        if (!clients.isEmpty()) {
            clientFxHelper = new ClientFxHelper(clientstab, clients);
        }
//        TableColumn Action = new TableColumn("Action");
//        	Action.setCellValueFactory(button);
//        	table.getColumns().add(column);

        sup.setOnMouseClicked((e)
                -> {
            System.out.println("delete test");
            try {

                Client selectedItem = (Client) clientstab.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {

                    clientstab.getItems().remove(selectedItem);
                    odclient.remove(selectedItem);
                    System.out.println(selectedItem);
                    JOptionPane.showMessageDialog(null, "Suppression avec succée", "", 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Vous devez selectionner une ligne", "", 1);
                }

            } catch (RemoteException ex) {
                Logger.getLogger(ClientListController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        
        rechBtn.setOnAction((ActionEvent event) -> {

            clientstab.getItems().clear();

            String nom = null;
            if (nomTf.getText() != null && !nomTf.getText().equals("")) {
                nom = nomTf.getText();
            }
            String prenom = null;
            if (prenomTf.getText() != null && !prenomTf.getText().equals("")) {
                prenom = prenomTf.getText();
            }
            String cin = null;
            if (cinTf.getText() != null && !cinTf.getText().equals("")) {
                cin = cinTf.getText();
            }
            String tel = null;
            if (telTf.getText() != null && !telTf.getText().equals("")) {
                tel = telTf.getText();
            }
            Long point = null;
            if (pointTf.getText() != null && !pointTf.getText().equals("")) {
               
                 point = new Long(pointTf.getText());
            }
            

            try {
                List<Client> clientss = odclient.findByCriteriaClient(nom, prenom, cin, tel, point);
               
                System.out.println("clientss" + clientss);

                clientFxHelper.setList(clientss);

                // UtilisateurFxHelper utilisateurFxHelper = new UtilisateurFxHelper(utilisateureTv, utilisateurss);
            } catch (RemoteException ex) {
                Logger.getLogger(UtilisateurListFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

}
