/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locationdevoiture;

import Interfaces.Clients;
import TestRmi.Testrmi;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author farah
 */
public class TestController implements Initializable {

    @FXML
    private Button chercher;
    @FXML
    private TextField age2;
    @FXML
    private Label reslab1;
    Clients od = Testrmi.od;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chercher.setOnAction((event) -> {

            
            System.out.println("u clicked!");
            String res2 = "a";
            System.out.println(Long.valueOf(age2.getText()));
            try {
                if (od != null) {
                    res2 = od.getTheNom(Long.valueOf(age2.getText()));
                } else {
                    System.out.println("od est  null");
                }
            } catch (RemoteException ex) {
                Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(res2);

            reslab1.setText("Le nom du client est  :" + res2);

        });
        

    }

}
