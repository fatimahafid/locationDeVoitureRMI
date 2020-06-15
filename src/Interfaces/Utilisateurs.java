/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import bean.Utilisateur;
import java.util.List;

/**
 *
 * @author farah
 */
public interface Utilisateurs extends java.rmi.Remote {
    // public Utilisateur find(Object id)throws java.rmi.RemoteException;

    public Utilisateur find(String login) throws java.rmi.RemoteException;

    public int seConnecter(Utilisateur utilisateur) throws java.rmi.RemoteException;

    public void create(Utilisateur entity) throws java.rmi.RemoteException;

    public void createUtilisateur(Utilisateur utilisateur) throws java.rmi.RemoteException;
    
    public List<Utilisateur> findAll()throws java.rmi.RemoteException;;
    
  
    
            
           
}
