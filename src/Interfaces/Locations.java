/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import bean.Client;
import bean.Location;
import java.util.List;

/**
 *
 * @author farah
 */
public interface  Locations extends java.rmi.Remote{
        public List<Location> findAll()throws java.rmi.RemoteException;
        public void remove(Location entity) throws java.rmi.RemoteException;
        public void create(Location entity) throws java.rmi.RemoteException;
    public void createLocation(Location location) throws java.rmi.RemoteException;

}
