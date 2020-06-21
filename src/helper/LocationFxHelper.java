/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import bean.Client;
import bean.Location;
import java.util.List;
import javafx.scene.control.TableView;


/**
 *
 * @author Ghassan
 */
public class LocationFxHelper extends AbstractFxHelper<Location>{
    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("    ID    ", "id"),
            new AbstractFxHelperItem("         DATE DEBUT         ", "dateDebutLoc"),
             new AbstractFxHelperItem("          DATE DEBUT REELLE          ", "dateDebutReelLoc"),
            new AbstractFxHelperItem("       DATE FIN        ", "dateFinLoc"),
            new AbstractFxHelperItem("           DATE FIN REELLE           ", "dateFinReelLoc"),
            new AbstractFxHelperItem("           DATE PAIEMENT EFFECTIVE       ","datePaiementEffectif"),
            new AbstractFxHelperItem("         DATE PAIEMENT PREVUE         ", "datePaiementPrevu"),
            new AbstractFxHelperItem("     DATE RESERVATION     ", "dateReservation"),
            new AbstractFxHelperItem("     MONTANT     ", "mtnLoc"),
            new AbstractFxHelperItem("     VEHICULE     ", "vehiculenom"),
            new AbstractFxHelperItem("     AGENCE     ", "agencenom"),
            new AbstractFxHelperItem("     CLIENT     ", "clientnom"),
            new AbstractFxHelperItem("     MODELE     ", "modelenom"),
         
        };
    }

    public LocationFxHelper(TableView table, List<Location> list) {
        super(titres, table, list);
    }


   
   
}
