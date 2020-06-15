/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import Interfaces.Vehicules;
import bean.Utilisateur;
import bean.Vehicule;
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
public class VehiculesImpl extends UnicastRemoteObject implements Vehicules {

    List<Vehicule> vehiculeList;
    private EntityManager em;
    private Class<Vehicule> entityClass;

    public VehiculesImpl() throws RemoteException {

        super();

        List<Vehicule> vehiculeList = new ArrayList();

    }

    protected EntityManager getEntityManager() {
        if (em == null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("locationDeVoiturePU");
            em = entityManagerFactory.createEntityManager();
        }
        return em;
    }

    @Override
    public void create(Vehicule entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void createVehicule(Vehicule vehicule) {
        create(vehicule);
    }

    @Override
    public List<Vehicule> findAll() {

        return getEntityManager().createQuery("SELECT v FROM Vehicule v").getResultList();

    }

}
