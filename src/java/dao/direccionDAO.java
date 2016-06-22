/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.CDireccion;

/**
 *
 * @author anon
 */
public class direccionDAO extends DAO{
    public List<CDireccion> getListaDireccion(){
        try{
            return em.createQuery("select d from CDireccion d").getResultList();
            
        }catch(Exception ex ){
            System.err.println(ex.toString());
            return null;
        }finally{        
        }
    }
    
    public void insertDireccion(CDireccion odireccion){
        try{
            em.getTransaction().begin();
            em.persist(odireccion);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println(ex.toString());
        }finally{
        }
    }
    
    public void updateDireccion(CDireccion odireccion){
        try{
            CDireccion obj = em.find(CDireccion.class, odireccion.getCodigo());
            
            em.getTransaction().begin();
            obj.setCliente(odireccion.getCliente());
            obj.setCalle(odireccion.getCalle());
            obj.setLote(odireccion.getLote());
            obj.setManzana(odireccion.getManzana());
            obj.setNumero(odireccion.getNumero());
            obj.setUrbanizacion(odireccion.getUrbanizacion());
            obj.setDistrito(odireccion.getDistrito());
            em.getTransaction().commit();
        
        }catch(Exception ex){
        }finally{
        }
    }
    
    public void deleteDireccion(int codigo){
        
        try{
            CDireccion obj = em.find(CDireccion.class, codigo);
        
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println(ex.toString());
        }finally{
        }
    }
}
