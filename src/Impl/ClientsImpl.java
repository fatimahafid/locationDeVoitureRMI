/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import Interfaces.Clients;
import bean.Client;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author farah
 */
public class ClientsImpl extends UnicastRemoteObject implements Clients {

     List<Client> clientList;
     private EntityManager em;

 
public ClientsImpl() throws RemoteException {

   super();

      List<Client> clientList = new ArrayList();

        }

protected EntityManager getEntityManager() {
        if (em == null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("locationDeVoiturePU");
            em = entityManagerFactory.createEntityManager();
        }
        return em;
    }
    
    @Override
    public String getTheNom(Long id) throws RemoteException {

 List<Client> clients =getEntityManager().createQuery("select c from Client c where c.id= "+id).getResultList();

        return clients.get(0).getNom();
    }
    
    
    
}
