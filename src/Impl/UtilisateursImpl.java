/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import Interfaces.Utilisateurs;
import bean.Agence;
import bean.Utilisateur;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import util.HashageUtil;

/**
 *
 * @author farah
 */
public class UtilisateursImpl extends UnicastRemoteObject implements Utilisateurs {

    List<Utilisateur> utilisateurList;
    private EntityManager em;
    private Class<Utilisateur> entityClass;

    public UtilisateursImpl() throws RemoteException {

        super();

        List<Utilisateur> utilisateurList = new ArrayList();

    }

    protected EntityManager getEntityManager() {
        if (em == null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("locationDeVoiturePU");
            em = entityManagerFactory.createEntityManager();
        }
        return em;
    }

//    @Override
//    public Utilisateur find(Object id) {
//        return getEntityManager().find(entityClass, id);
//    }
    @Override
    public Utilisateur find(String login) throws RemoteException {

        List<Utilisateur> clients = getEntityManager().createQuery("select u from Utilisateur u where u.login=" + "'" + login + "'").getResultList();

        return clients.get(0);
    }

    @Override
    public int seConnecter(Utilisateur utilisateur) throws RemoteException {
        Utilisateur loadedUtilisateur = find(utilisateur.getLogin());
        if (loadedUtilisateur == null) {
            System.out.println("echec 1");
            return -1;
        } else if (!loadedUtilisateur.getMdp().equals(HashageUtil.sha256(utilisateur.getMdp()))) {
            System.out.println("echec 2");
            return -2;
        } else {
            System.out.println("connexion avec succé");
            return 1;

        }

    }

    @Override
    public void create(Utilisateur entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void createUtilisateur(Utilisateur utilisateur) {
        utilisateur.setMdp(HashageUtil.sha256(utilisateur.getMdp()));
        create(utilisateur);
    }

    @Override
    public List<Utilisateur> findAll() {

        return getEntityManager().createQuery("SELECT u FROM Utilisateur u").getResultList();

    }

    @Override
    public void remove(Utilisateur entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(getEntityManager().merge(entity));
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void edit(Utilisateur entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(entity);
        getEntityManager().getTransaction().commit();

    }

    @Override
    public List<Utilisateur> findByCriteriaUtilisateur(String login, String nom, String email, String agence) {
        String query = "SELECT u From Utilisateur u WHERE 1=1";
        if (login != null) {
            query += " AND u.login='" + login + "'";
        }
        if (nom != null) {
            query += "  AND u.nom='" + nom + "'";
        }
        if (email != null) {
            query += " AND u.email='" + email + "'";
        }
        if (agence != null) {
            query += " AND u.agence.nom='" + agence + "'";
        }

        return getEntityManager().createQuery(query).getResultList();
    }

    @Override
    public List<Utilisateur> findAllUsers() throws RemoteException {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Utilisateur.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

}
