/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.CEmpleado;

/**
 *
 * @author anon
 */
public class empleadoDAO extends DAO{
    public List<CEmpleado> getListaEmpleado(){
        try{
            return em.createQuery("select e from CEmpleado e").getResultList();
        }catch(Exception ex){
            System.err.println(ex.toString());
            return null;
        }finally{
        }
    }
    
    public void insertEmpleado(CEmpleado oempleado){
        try{
            em.getTransaction().begin();
            em.persist(oempleado);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println(ex.toString());
        }finally{
        }
    }
    
    public void updateEmpleado(CEmpleado oempleado){
        try{
            CEmpleado xempleado = em.find(CEmpleado.class, oempleado.getDNI());
            
            em.getTransaction().begin();
            xempleado.setNombres(oempleado.getNombres());
            xempleado.setHorario(oempleado.getHorario());
            xempleado.setCorreo(oempleado.getCorreo());
            xempleado.setContraseña(oempleado.getContraseña());
            xempleado.setUsuario(oempleado.getUsuario());
            xempleado.setCargo(oempleado.getCargo());
            em.getTransaction().commit();
        }catch(Exception ex){
        }finally{
        }
    }
    
    public void deleteEmpleado(String DNI){
        try{
            CEmpleado oempleado = em.find(CEmpleado.class, DNI);
            
            em.getTransaction().begin();
            em.remove(oempleado);
            em.getTransaction().commit();
            
        }catch(Exception ex){
            System.err.println(ex.toString());
        }finally{
        }
    }
    
    
}
