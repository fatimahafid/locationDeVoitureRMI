/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import Interfaces.Modeles;
import bean.Agence;
import bean.Marque;
import bean.Modele;
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
public class ModelesImpl extends UnicastRemoteObject implements Modeles {

    List<Modele> odeleList;
    private EntityManager em;
    private Class<Modele> entityClass;

    public ModelesImpl() throws RemoteException {

        super();

        List<Modele> modeleList = new ArrayList();

    }

    protected EntityManager getEntityManager() {
        if (em == null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("locationDeVoiturePU");
            em = entityManagerFactory.createEntityManager();
        }
        return em;
    }

    @Override
    public List<Modele> findAll() {

        return getEntityManager().createQuery("SELECT m.marque.libelle FROM Modele m").getResultList();

    }

    @Override
    public Modele findByNom(String nom) {

        return (Modele) getEntityManager().createQuery("SELECT m FROM Modele m WHERE m.marque.libelle= '" + nom + "'").getResultList().get(0);
    }
    @Override
    public Modele findById(Long id) {

        return (Modele) getEntityManager().createQuery("SELECT m FROM Modele m WHERE m.id= '" + id + "'").getResultList().get(0);
    }

    @Override
    public List<Modele> findAllModeles() throws RemoteException {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Modele.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @Override
    public void remove(Modele entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(getEntityManager().merge(entity));
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void create(Modele entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void createModele(Modele modele) {
        create(modele);
    }
}
