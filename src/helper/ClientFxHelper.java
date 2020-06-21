/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import bean.Client;
import bean.Utilisateur;
import java.util.List;
import javafx.scene.control.TableView;


/**
 *
 * @author Ghassan
 */
public class ClientFxHelper extends AbstractFxHelper<Client>{
    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("    ID    ", "id"),
            new AbstractFxHelperItem("         NOM         ", "nom"),
             new AbstractFxHelperItem("          PRENOM          ", "prenom"),
            new AbstractFxHelperItem("       CIN       ", "cin"),
            new AbstractFxHelperItem("           ADR           ", "adr"),
            new AbstractFxHelperItem("           EMAIL           ","email"),
            new AbstractFxHelperItem("         TEL         ", "tel"),
            new AbstractFxHelperItem("     POINT     ", "point"),
         
        };
    }

    public ClientFxHelper(TableView table, List<Client> list) {
        super(titres, table, list);
    }


   
   
}
