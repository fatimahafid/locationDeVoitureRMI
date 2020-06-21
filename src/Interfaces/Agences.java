/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import bean.Agence;
import bean.Client;
import bean.Utilisateur;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author farah
 */
public interface Agences extends java.rmi.Remote {

    public Agence findByNom(String nom) throws java.rmi.RemoteException;

    public List<Agence> findAll() throws java.rmi.RemoteException;

    public List<Agence> findAllAgences() throws java.rmi.RemoteException;

    public void remove(Agence entity) throws java.rmi.RemoteException;

    public void create(Agence entity) throws java.rmi.RemoteException;

    public List<Agence> findByCriteriaAgence(String nom, String tel, String adresse, String mail) throws java.rmi.RemoteException;

    public void createAgence(Agence agence) throws java.rmi.RemoteException;

}
