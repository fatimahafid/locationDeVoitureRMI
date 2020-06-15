/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locationdevoiture;

import Interfaces.Agences;
import Interfaces.Utilisateurs;
import TestRmi.Testrmi;
import bean.Agence;
import bean.Utilisateur;
import com.jfoenix.controls.JFXButton;
import helper.UtilisateurFxHelper;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class UtilisateurListFXMLController implements Initializable {

    @FXML
    private JFXButton ajouterbtn;
    @FXML
    private TableView utilisateureTv;
    @FXML 
    private JFXButton actionBtn = new JFXButton("S");
    private UtilisateurFxHelper utilisateurFxHelper;
    List<Utilisateur> utilisateurs = new ArrayList<>();
    Utilisateurs odUtilisateurs = Testrmi.odUtilisateur;
    Agences odAgences = Testrmi.odAgence;
    
    /**
     * Initializes the controller class.
     */
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
            UtilisateurFxHelper utilisateurFxHelper = new UtilisateurFxHelper(utilisateureTv, odUtilisateurs.findAll());
        } catch (RemoteException ex) {
            Logger.getLogger(UtilisateurListFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
      TableColumn action = new TableColumn("ACTIONn");
      utilisateureTv.getColumns().addAll(action);
    
        
        ajouterbtn.setOnMouseClicked((e)
                -> {
            handleAjouter(e);
        });
    


                }

}