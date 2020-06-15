/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import bean.Marque;
import bean.Modele;
import java.util.List;

/**
 *
 * @author farah
 */
public interface Modeles   extends java.rmi.Remote{
    
  public List<Modele> findAll()throws java.rmi.RemoteException;
  public Modele findByNom(String nom) throws java.rmi.RemoteException;
    

            
           
}
