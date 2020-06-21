/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import Interfaces.Marques;
import bean.Agence;
import bean.Marque;
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
public class MarquesImpl extends UnicastRemoteObject implements Marques {

    List<Marque> marqueList;
    private EntityManager em;
    private Class<Marque> entityClass;

    public MarquesImpl() throws RemoteException {

        super();

        List<Marque> marqueList = new ArrayList();

    }

    protected EntityManager getEntityManager() {
        if (em == null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("locationDeVoiturePU");
            em = entityManagerFactory.createEntityManager();
        }
        return em;
    }


    
   @Override
    public Marque findByLibelle(String nom) {
        return (Marque) getEntityManager().createQuery("SELECT m FROM Marque m WHERE m.libelle ='" + nom + "'").getResultList().get(0);
    }


   @Override
    public List<Marque> findAll() {
     
       return getEntityManager().createQuery("SELECT m.libelle FROM Marque m").getResultList();
     
    }
     @Override
    public void remove(Marque entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(getEntityManager().merge(entity));
        getEntityManager().getTransaction().commit();
    }
    @Override
    public void create(Marque entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void createMarque(Marque marque) {
        create(marque);
    }
      @Override
    public List<Marque> findAllMarques() throws RemoteException {
 javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Marque.class));
        return getEntityManager().createQuery(cq).getResultList();
    }
}
