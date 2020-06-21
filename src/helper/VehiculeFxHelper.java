/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import bean.Utilisateur;
import bean.Vehicule;
import java.util.List;
import javafx.scene.control.TableView;


/**
 *
 * @author Ghassan
 */
public class VehiculeFxHelper extends AbstractFxHelper<Vehicule>{
    private static AbstractFxHelperItem[] titres;
 
    static {

        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("    IMMATRICULATION        ", "numImm"),
             new AbstractFxHelperItem("    DATE MISE EN CIRC        ", "dateMiseEncirculation"),
            new AbstractFxHelperItem("     KILOMETRAGE         ", "kilometrage"),
            new AbstractFxHelperItem("     PRIX        ","prix"),
            new AbstractFxHelperItem("     EST DISPONIBLE         ", "pris"),
            new AbstractFxHelperItem("     CARBURANT         ", "carburant"),
            new AbstractFxHelperItem("     MODELE         ", "modelenom"),
            
           
        };
    }

    public VehiculeFxHelper(TableView table, List<Vehicule> list) {
        super(titres, table, list);
    }
    


    public VehiculeFxHelper(TableView table) {
        super(titres, table);
    }
   
}
