/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import bean.Agence;
import bean.Client;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author farah
 */
public interface Agences   extends java.rmi.Remote{
    
    public Agence findByNom(String nom) throws java.rmi.RemoteException;
     public List<Agence> findAll()throws java.rmi.RemoteException;

            
           
}
