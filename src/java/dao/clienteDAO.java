/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.CCliente;

/**
 *
 * @author anon
 */
public class clienteDAO extends DAO{
    public List<CCliente> getListaCliente(){
        try{
            return em.createQuery("select c from CCliente c").getResultList();
            
        }catch(Exception ex ){
            System.err.println(ex.toString());
            return null;
        }finally{        
        }
    }
    
    public void insertCliente(CCliente ocliente){
        try{
            em.getTransaction().begin();
            em.persist(ocliente);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println(ex.toString());
        }finally{
        }
    }
    
    public void updateCliente(CCliente ocliente){
        try{
            CCliente obj = em.find(CCliente.class, ocliente.getDNI());
            
            em.getTransaction().begin();
            obj.setNombres(ocliente.getNombres());
            obj.setApellidos(ocliente.getApellidos());
            obj.setContraseña(ocliente.getContraseña());
            obj.setCorreo(ocliente.getCorreo());
            obj.setDireccion(ocliente.getDireccion());
            obj.setTelefono(ocliente.getTelefono());
            obj.setUsuario(ocliente.getUsuario());
            em.getTransaction().commit();
        
        }catch(Exception ex){
        }finally{
        }
    }
    
    public void deleteCliente(String DNI){
        
        try{
            CCliente obj = em.find(CCliente.class, DNI);
        
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println(ex.toString());
        }finally{
        }
    }
}
