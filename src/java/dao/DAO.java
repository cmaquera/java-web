/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author anon
 */
public class DAO {
    protected static EntityManagerFactory factory=null;
    protected static EntityManager em=null;
    
    public DAO(){
        
        if(factory==null){
            try{
               
            factory = Persistence.createEntityManagerFactory("foodJPA"); 
            em =  factory.createEntityManager();
            }
            catch(Exception ex){
            System.err.println(ex.toString());
            }
        }
    }
    
}
