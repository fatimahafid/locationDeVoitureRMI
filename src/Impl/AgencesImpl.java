/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import Interfaces.Agences;
import bean.Agence;
import bean.Client;
import bean.Utilisateur;
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
public class AgencesImpl extends UnicastRemoteObject implements Agences {

    List<Agence> agenceList;
    private EntityManager em;
    private Class<Utilisateur> entityClass;

    public AgencesImpl() throws RemoteException {

        super();

        List<Agence> agenceList = new ArrayList();

    }

    protected EntityManager getEntityManager() {
        if (em == null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("locationDeVoiturePU");
            em = entityManagerFactory.createEntityManager();
        }
        return em;
    }

//    @Override
//
//    public List<Agence> findAll() {
//        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
//        cq.select(cq.from(entityClass));
//        return getEntityManager().createQuery(cq).getResultList();
//    }
    
    @Override
    public List<Agence> findAll() {
     
       return getEntityManager().createQuery("SELECT a.nom FROM Agence a").getResultList();
     
    }

    @Override
    public Agence findByNom(String nom) {
        return (Agence) getEntityManager().createQuery("SELECT a FROM Agence a WHERE a.nom='" + nom + "'").getResultList().get(0);
    }


   
}
