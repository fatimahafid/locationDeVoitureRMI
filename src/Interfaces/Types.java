/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import bean.Type;
import java.util.List;

/**
 *
 * @author farah
 */
public interface Types   extends java.rmi.Remote{
    
    public Type findByLibelle(String libelle) throws java.rmi.RemoteException;
    public List<Type> findAll()throws java.rmi.RemoteException;
   
    public void remove(Type entity) throws java.rmi.RemoteException;
     public void create(Type entity) throws java.rmi.RemoteException;
public List<Type> findAllTypes()throws java.rmi.RemoteException;
    public void createType(Type type) throws java.rmi.RemoteException;
   

    

            
           
}
