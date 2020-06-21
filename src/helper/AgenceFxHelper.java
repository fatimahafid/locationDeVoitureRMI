/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import bean.Agence;
import bean.Client;
import java.util.List;
import javafx.scene.control.TableView;


/**
 *
 * @author Ghassan
 */
public class AgenceFxHelper extends AbstractFxHelper<Agence>{
    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("    ID    ", "id"),
            new AbstractFxHelperItem("         ADRESSE         ", "adr"),
             new AbstractFxHelperItem("          EMAIL          ", "email"),
            new AbstractFxHelperItem("       NOM       ", "nom"),
            new AbstractFxHelperItem("           TEL           ", "tel"),
            new AbstractFxHelperItem("           Ville           ", "villenom"),
            
        };
    }

    public AgenceFxHelper(TableView table, List<Agence> list) {
        super(titres, table, list);
    }
 public AgenceFxHelper(TableView table) {
        super(titres, table);
    }

   
   
}
