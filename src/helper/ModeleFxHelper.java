/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import bean.Client;
import bean.Modele;
import java.util.List;
import javafx.scene.control.TableView;


/**
 *
 * @author Ghassan
 */
public class ModeleFxHelper extends AbstractFxHelper<Modele>{
    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("    ID    ", "id"),
            new AbstractFxHelperItem("         MARQUE         ", "marquenom"),
             new AbstractFxHelperItem("          TYPE          ", "typenom"),
            
        };
    }

    public ModeleFxHelper(TableView table, List<Modele> list) {
        super(titres, table, list);
    }


   
   
}
