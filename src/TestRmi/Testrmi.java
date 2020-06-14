/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestRmi;

import Interfaces.Agences;
import Interfaces.Clients;
import Interfaces.Utilisateurs;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author farah
 */
public class Testrmi extends Application {
    public static Clients od;
    public static Utilisateurs odUtilisateur;
    public static Agences odAgence;
  
    public static Clients getOd() {
        return od;
    }

    public static void setOd(Clients od) {
        Testrmi.od = od;
    }

    public static Utilisateurs getOdUtilisateur() {
        return odUtilisateur;
    }

    public static void setOdUtilisateur(Utilisateurs odUtilisateur) {
        Testrmi.odUtilisateur = odUtilisateur;
    }

    public static Agences getOdAgence() {
        return odAgence;
    }

    public static void setOdAgence(Agences odAgence) {
        Testrmi.odAgence = odAgence;
    }
    
    

   
 
    
    @Override
    public void start(Stage stage) throws IOException, RemoteException, NotBoundException {
      
     
        Parent root = FXMLLoader.load(Testrmi.class.getClass().getResource("/locationdevoiture/AjouterUtilisateurFXML.fxml"));
      
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
             //od client
            String urll="rmi://localhost/clienttest";
           od = (Clients)Naming.lookup(urll);
            setOd(od);
            //od utilisateur
            String url2="rmi://localhost/utilisateurtest";
           odUtilisateur = (Utilisateurs)Naming.lookup(url2);
            setOdUtilisateur(odUtilisateur);
            //od agence
            String url3="rmi://localhost/agencetest";
           odAgence = (Agences)Naming.lookup(url3);
            setOdAgence(odAgence);
           
            launch(args);
        }
        catch (Exception x) {
            x.printStackTrace();
        }
         

    }
    
}
