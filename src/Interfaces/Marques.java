/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import bean.Agence;
import bean.Client;
import bean.Marque;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author farah
 */
public interface Marques   extends java.rmi.Remote{
    
    public Marque findByNom(String nom) throws java.rmi.RemoteException;
   

    

            
           
}
