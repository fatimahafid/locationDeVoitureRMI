/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import bean.Agence;
import bean.Client;
import bean.Marque;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author farah
 */
public interface Marques   extends java.rmi.Remote{
    
    public Marque findByLibelle(String nom) throws java.rmi.RemoteException;
    public List<Marque> findAll()throws java.rmi.RemoteException;
    public void remove(Marque entity) throws java.rmi.RemoteException;
     public void create(Marque entity) throws java.rmi.RemoteException;
public List<Marque> findAllMarques()throws java.rmi.RemoteException;
    public void createMarque(Marque marque) throws java.rmi.RemoteException;
   
   

    

            
           
}
