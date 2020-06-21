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

        return getEntityManager().createQuery("SELECT v.numImm FROM Vehicule v").getResultList();

    }

    @Override
    public void remove(Vehicule entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(getEntityManager().merge(entity));
        getEntityManager().getTransaction().commit();
    }

    @Override
    public List<Vehicule> findByCriteriaVehicule(String immatriculation, Double kmmax, Double prixmax, Boolean etat,String carburant) {
        String query = "SELECT v From Vehicule v WHERE 1=1";
        if (immatriculation != null) {
            query += " AND v.numImm='" + immatriculation + "'";
        }
        if (kmmax != null) {
            query += "  AND v.kilometrage <='" + kmmax + "'";
        }

        if (prixmax !=null) {
            query += " AND v.prix <='" + prixmax + "'";
        }
        if (etat != null) {
            query += " AND v.pris='" + etat + "'";
        }
        if (carburant != null) {
            query += " AND v.carburant='" + carburant + "'";
        }
       
        return getEntityManager().createQuery(query).getResultList();
    }
    @Override
    public Vehicule findByNumImm(String numImm) {
     
        return (Vehicule) getEntityManager().createQuery("SELECT v FROM Vehicule v WHERE v.numImm= '" + numImm + "'").getResultList().get(0);
    }
    
     @Override
    public List<Vehicule> findAllVehicule() throws RemoteException {
 javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Vehicule.class));
        return getEntityManager().createQuery(cq).getResultList();
    }
     @Override
    public void edit(Vehicule entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(entity);
        getEntityManager().getTransaction().commit();

    }
}
