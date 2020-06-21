/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import bean.Client;
import bean.Vehicule;
import java.util.List;

/**
 *
 * @author farah
 */
public interface Clients   extends java.rmi.Remote{
    
    public String getTheNom(Long id) throws java.rmi.RemoteException;
     public List<Client> findAll()throws java.rmi.RemoteException;
        
    public void remove(Client entity) throws java.rmi.RemoteException;
     public void create(Client entity) throws java.rmi.RemoteException;
    public void createClient(Client client) throws java.rmi.RemoteException;
     public List<Client> findByCriteriaClient(String nom, String prenom, String cin, String tel,Long point)throws java.rmi.RemoteException;
     public Client findByCin(String cin)throws java.rmi.RemoteException;
     public void edit(Client entity) throws java.rmi.RemoteException;
      
           
}
