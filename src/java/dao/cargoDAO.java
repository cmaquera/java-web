/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.CCargo;

/**
 *
 * @author anon
 */
public class cargoDAO extends DAO{
    public List<CCargo> getListaCargo(){
        try{
            return em.createQuery("select c from CCargo c").getResultList();
            
        }catch(Exception ex ){
            System.err.println(ex.toString());
            return null;
        }finally{        
        }
    }
    
    public void insertCargo(CCargo ocargo){
        try{
            em.getTransaction().begin();
            em.persist(ocargo);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println(ex.toString());
        }finally{
        }
    }
    
    public void updateCargo(CCargo ocargo){
        try{
            CCargo obj = em.find(CCargo.class, ocargo.getCodigo());
            
            em.getTransaction().begin();
            obj.setNombre(ocargo.getNombre());
            em.getTransaction().commit();
        
        }catch(Exception ex){
        }finally{
        }
    }
    
    public void deleteCargo(int codigo){
        
        try{
            CCargo obj = em.find(CCargo.class, codigo);
        
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println(ex.toString());
        }finally{
        }
    }
}
