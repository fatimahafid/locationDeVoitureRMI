/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locationdevoiture;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class ModeleListFXMLController implements Initializable {
@FXML
    private JFXButton ajouterbtn;
    /**
     * Initializes the controller class.
     */
     public void handleAjouter(MouseEvent event) {
           
               Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("locationdevoiture/AjouterAgenceFXML.fxml"));
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
         ajouterbtn.setOnMouseClicked(( e ) ->
            {
                   handleAjouter(e);
            });
    }    
    
}
