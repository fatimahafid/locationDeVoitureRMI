/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import Interfaces.Utilisateurs;
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

        List<Utilisateur> clients = getEntityManager().createQuery("select u from Utilisateur u where u.login="+"'"+login+"'").getResultList();

        return clients.get(0);
    }

    @Override
    public int seConnecter(Utilisateur utilisateur) throws RemoteException {
        Utilisateur loadedUtilisateur =  find(utilisateur.getLogin());
        if (loadedUtilisateur == null) {
            System.out.println("echec 1");
            return -1;
        } else if (!loadedUtilisateur.getMdp().equals(utilisateur.getMdp())) {
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
     public void createUtilisateur(Utilisateur utilisateur){
         utilisateur.setMdp(utilisateur.getMdp());
           create(utilisateur);
     }
     
//          public int creerProduit(Long id, String nom ){
//          Produit produit = new Produit();
//          produit.setNom(nom);
//          produit.setId(id);
//          create(produit);
//          return 1;
//}
}
