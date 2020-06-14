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
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
     private Agence agence=null;
   
    

    Utilisateurs odUtilisateurs = Testrmi.odUtilisateur;
     Agences odAgences = Testrmi.odAgence;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO

            agenceCb.getItems().addAll(odAgence.getNom());
        } catch (RemoteException ex) {
            Logger.getLogger(AjouterUtilisateurFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
                agenceCb.getSelectionModel().select(0);
        ajouterBtn.setOnAction((event) -> {
            System.out.println("u clicked!");
            int res2 = 0;
            try {
                if (odUtilisateurs != null) {
                     boolean x= false;
            if(geRb.isSelected()) x = true;
            
        
            agence = odAgence.findByNom(agenceCb.getSelectionModel().getSelectedItem().toString());
                    Utilisateur utilisateur = new Utilisateur(loginTf.getText(), mdpPf.getText(), nomTf.getText(), prenomTf.getText(), emailTf.getText(),telTf.getText(),x,agence);
                    if (!mdpPf.getText().equals(cmdpPf.getText())) {
                        JOptionPane.showMessageDialog(null, "Erreur de confirmation Mot De Passe", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Inscription avec succée", "Bienvenue", JOptionPane.INFORMATION_MESSAGE);
                        odUtilisateurs.create(utilisateur);
                        //utilisateurFxHelper.create(utilisateur);
                    }
                }
                }catch (RemoteException ex) {
                Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
            }
                System.out.println(res2);
            });

        }

    }
