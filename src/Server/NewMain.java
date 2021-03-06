/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Impl.AgencesImpl;
import Impl.ClientsImpl;
import Impl.LocationsImpl;
import Impl.MarquesImpl;
import Impl.ModelesImpl;
import Impl.TypesImpl;
import Impl.UtilisateursImpl;
import Impl.VehiculesImpl;
import Impl.VilleImpl;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author farah
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

try{//creationde l OD
           LocateRegistry.createRegistry(1099);

           
            //enregistrement de l OD client dans RMI
            Naming.rebind("clienttest", new ClientsImpl());
            System.out.println("L objet Distant ODclient est enregistré dans RMI...Serveur Pret");
            //enregistrement de l OD utilisateur dans RMI
            Naming.rebind("utilisateurtest", new UtilisateursImpl());
            System.out.println("L objet Distant ODutilisateur est enregistré dans RMI...Serveur Pret");
          //  enregistrement de l OD utilisateur dans RMI
            Naming.rebind("agencetest", new AgencesImpl());
            System.out.println("L objet Distant ODAgence est enregistré dans RMI...Serveur Pret");
            //  enregistrement de l OD vehicule dans RMI
            Naming.rebind("vehiculetest", new VehiculesImpl());
            System.out.println("L objet Distant ODvehicule est enregistré dans RMI...Serveur Pret");
            //  enregistrement de l OD modele dans RMI
            Naming.rebind("modeletest", new ModelesImpl());
            System.out.println("L objet Distant ODmodele est enregistré dans RMI...Serveur Pret");
            //  enregistrement de l OD marque dans RMI
            Naming.rebind("marquetest", new MarquesImpl());
            System.out.println("L objet Distant ODmarque est enregistré dans RMI...Serveur Pret");
             //  enregistrement de l OD marque dans RMI
            Naming.rebind("locationtest", new LocationsImpl());
            System.out.println("L objet Distant ODlocation est enregistré dans RMI...Serveur Pret");
             //  enregistrement de l OD marque dans RMI
            Naming.rebind("villetest", new VilleImpl());
            System.out.println("L objet Distant ODville est enregistré dans RMI...Serveur Pret");
             //  enregistrement de l OD type dans RMI
            Naming.rebind("typetest", new TypesImpl());
            System.out.println("L objet Distant ODtype est enregistré dans RMI...Serveur Pret");
           
           
        
    }catch (Exception e){
            System.out.println("Serveur Non Lancé !!" +e.getMessage());
    }



    
    }  
}
