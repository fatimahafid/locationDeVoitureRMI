/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import bean.Modele;
import java.util.List;

/**
 *
 * @author farah
 */
public interface Modeles   extends java.rmi.Remote{
    
  public List<Modele> findAll()throws java.rmi.RemoteException;
  public Modele findByNom(String nom) throws java.rmi.RemoteException;
  public Modele findById(Long id) throws java.rmi.RemoteException;
    public List<Modele> findAllModeles()throws java.rmi.RemoteException;
  public void remove(Modele entity) throws java.rmi.RemoteException;
  public void create(Modele entity) throws java.rmi.RemoteException;

    public void createModele(Modele modele) throws java.rmi.RemoteException;

    

            
           
}
