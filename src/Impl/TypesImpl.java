/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import Interfaces.Types;
import bean.Agence;
import bean.Type;
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
public class TypesImpl extends UnicastRemoteObject implements Types {

    List<Type> typeList;
    private EntityManager em;
    private Class<Type> entityClass;

    public TypesImpl() throws RemoteException {

        super();

        List<Type> typeList = new ArrayList();

    }

    protected EntityManager getEntityManager() {
        if (em == null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("locationDeVoiturePU");
            em = entityManagerFactory.createEntityManager();
        }
        return em;
    }


    
    @Override
    public List<Type> findAll() {
     
       return getEntityManager().createQuery("SELECT t.libelle FROM Type t").getResultList();
     
    }

    @Override
    public Type findByLibelle(String libelle) {
        return (Type) getEntityManager().createQuery("SELECT t FROM Type t WHERE t.libelle='" + libelle + "'").getResultList().get(0);
    }


    
    @Override
    public void remove(Type entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(getEntityManager().merge(entity));
        getEntityManager().getTransaction().commit();
    }
    @Override
    public void create(Type entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void createType(Type type) {
        create(type);
    }
      @Override
    public List<Type> findAllTypes() throws RemoteException {
 javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Type.class));
        return getEntityManager().createQuery(cq).getResultList();
    }
}
