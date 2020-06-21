/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import bean.Ville;
import java.util.List;

/**
 *
 * @author farah
 */
public interface Villes   extends java.rmi.Remote{
    
  
    public List<Ville> findAll()throws java.rmi.RemoteException;
    public Ville findByLibelle(String libelle)throws java.rmi.RemoteException;

   

    

            
           
}
