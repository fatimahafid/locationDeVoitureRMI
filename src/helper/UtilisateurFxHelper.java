/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import bean.Utilisateur;
import com.jfoenix.controls.JFXButton;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;


/**
 *
 * @author Ghassan
 */
public class UtilisateurFxHelper extends AbstractFxHelper<Utilisateur>{
    private static AbstractFxHelperItem[] titres;
  @FXML
  private static JFXButton actionBtn;
    static {

        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("         LOGIN        ", "login"),
             new AbstractFxHelperItem("       MOT DE PASSE        ", "mdp"),
            new AbstractFxHelperItem("        NOM         ", "nom"),
            new AbstractFxHelperItem("        PRENOM        ","prenom"),
            new AbstractFxHelperItem("        EMAIL         ", "email"),
            new AbstractFxHelperItem("        TEL         ", "tel"),
            new AbstractFxHelperItem("        EST UN AGENT         ", "isAgent"),
             new AbstractFxHelperItem("        AGENCE         ", "agence"),
           
        };
    }

    public UtilisateurFxHelper(TableView table, List<Utilisateur> list) {
        super(titres, table, list);
    }
    


    public UtilisateurFxHelper(TableView table) {
        super(titres, table);
    }
   
}
