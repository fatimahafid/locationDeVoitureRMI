/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import bean.Marque;
import bean.Type;
import java.util.List;
import javafx.scene.control.TableView;


/**
 *
 * @author Ghassan
 */
public class TypeFxHelper extends AbstractFxHelper<Type>{
    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("    ID    ", "id"),
            new AbstractFxHelperItem("         Type         ", "libelle"),
            
            
        };
    }

    public TypeFxHelper(TableView table, List<Type> list) {
        super(titres, table, list);
    }


   
   
}
