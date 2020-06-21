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
public interface Vehicules extends java.rmi.Remote {

    public void create(Vehicule entity) throws java.rmi.RemoteException;

    public void createVehicule(Vehicule vehicule) throws java.rmi.RemoteException;

    public List<Vehicule> findAll() throws java.rmi.RemoteException;
 public List<Vehicule> findAllVehicule() throws java.rmi.RemoteException;
    public void remove(Vehicule entity) throws java.rmi.RemoteException;
 public void edit(Vehicule entity) throws java.rmi.RemoteException;
    public List<Vehicule> findByCriteriaVehicule(String immatriculation, Double kmmax, Double prixmax, Boolean etat, String carburant)
            throws java.rmi.RemoteException;
     public Vehicule findByNumImm(String numImm) throws java.rmi.RemoteException;

}
