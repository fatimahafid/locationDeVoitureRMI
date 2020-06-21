/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import Interfaces.Villes;
import bean.Ville;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author farah
 */
public class VilleImpl extends UnicastRemoteObject implements Villes {

    List<Ville> villeList;
    private EntityManager em;
    private Class<Ville> entityClass;

    public VilleImpl() throws RemoteException {

        super();

        List<Ville> villeList = new ArrayList();

    }

    protected EntityManager getEntityManager() {
        if (em == null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("locationDeVoiturePU");
            em = entityManagerFactory.createEntityManager();
        }
        return em;
    }
 @Override
    public Ville findByLibelle(String libelle) {
        return (Ville) getEntityManager().createQuery("SELECT v FROM Ville v WHERE v.libelle='" + libelle + "'").getResultList().get(0);
    }

    
    @Override
    public List<Ville> findAll() {
     
       return getEntityManager().createQuery("SELECT v.libelle FROM Ville v").getResultList();
     
    }

   
}
