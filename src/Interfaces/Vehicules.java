/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import bean.Vehicule;
import java.util.List;

/**
 *
 * @author farah
 */
public interface Vehicules   extends java.rmi.Remote{
    
      public void create(Vehicule entity) throws java.rmi.RemoteException;

    public void createVehicule(Vehicule vehicule) throws java.rmi.RemoteException;

     public List<Vehicule> findAll()throws java.rmi.RemoteException;

            
           
}
