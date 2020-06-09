/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Client;

   

/**
 *
 * @author fatima
 */
public class ClientService extends AbstractFacade<Client>{
    public ClientService() {
        super(Client.class);
}
   
     
     public void create(Client client){
         
         super.create(client);
     }
    
      
    
      
}

