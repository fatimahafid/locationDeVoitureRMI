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
     @Override
    public List<Client> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Client.class));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    
    @Override
    public void remove(Client entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(getEntityManager().merge(entity));
        getEntityManager().getTransaction().commit();
    }
    
     @Override
    public void create(Client entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void createClient(Client client) {
        create(client);
    }
    
    @Override
     public List<Client> findByCriteriaClient(String nom, String prenom, String cin, String tel,Long point){
          String query="SELECT c From Client c WHERE 1=1";
          if(nom!= null){
              query+=" AND c.nom='"+nom+"'";
          }
          if(tel!= null){
              query+="  AND c.tel='"+tel+"'";
          }
            if(prenom!= null){
              query+=" AND c.prenom='"+prenom+"'"; 
          }
              if(cin!= null){
              query+=" AND c.cin='"+cin+"'";
          }
                 if(point!= null){
              query+=" AND c.point='"+point+"'";
          }
              
          return getEntityManager().createQuery(query).getResultList();
      } 
     @Override
    public Client findByCin(String cin) {
        return (Client) getEntityManager().createQuery("SELECT c FROM Client c WHERE c.cin ='" + cin + "'").getResultList().get(0);
    }

    @Override
    public void edit(Client entity) throws RemoteException {
      getEntityManager().getTransaction().begin();
        getEntityManager().merge(entity);
        getEntityManager().getTransaction().commit();
    }
}
