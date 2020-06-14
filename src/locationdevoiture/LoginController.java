/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locationdevoiture;

import Interfaces.Utilisateurs;
import TestRmi.Testrmi;
import bean.Utilisateur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import util.Session;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class LoginController implements Initializable {

    @FXML
    private JFXButton connButton;
    @FXML
    private JFXTextField loginTf;
    @FXML
    private JFXPasswordField mdpPf;
    Utilisateurs odUtilisateurs = Testrmi.odUtilisateur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        connButton.setOnAction((event) -> {
            System.out.println("u clicked!");
            int res2 = 0;
            try {
                if (odUtilisateurs != null) {
                    Utilisateur utilisateur = new Utilisateur();
                    utilisateur.setLogin(loginTf.getText());
                    utilisateur.setMdp(mdpPf.getText());
                    System.out.println("login: " + loginTf.getText());
                    System.out.println("mdp: " + mdpPf.getText());
                    res2 = odUtilisateurs.seConnecter(utilisateur);
                    if (res2 > 0) {
                        Session.updateAttribute(utilisateur, "utilisateurConnecté");
                        JOptionPane.showMessageDialog(null, "Connexion avec succes bienvenue : " + utilisateur.getLogin(), "Info", JOptionPane.INFORMATION_MESSAGE);
                        Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/Menu.fxml"));
                            Stage stage = new Stage();
                            stage.setTitle("apresConnexion");
                            stage.setScene(new Scene(root));
                            stage.show();
                            // Hide this current window 
                            ((Node) (event.getSource())).getScene().getWindow().hide();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Connexion echec ", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    System.out.println("odUtilisateur est  null");
                }
            } catch (RemoteException ex) {
                Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(res2);
        });

    }

}
