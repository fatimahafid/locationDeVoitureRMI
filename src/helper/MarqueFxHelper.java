/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import bean.Marque;
import java.util.List;
import javafx.scene.control.TableView;


/**
 *
 * @author Ghassan
 */
public class MarqueFxHelper extends AbstractFxHelper<Marque>{
    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("    ID    ", "id"),
            new AbstractFxHelperItem("         MARQUE         ", "libelle"),
            
            
        };
    }

    public MarqueFxHelper(TableView table, List<Marque> list) {
        super(titres, table, list);
    }


   
   
}
