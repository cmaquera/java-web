/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.CProducto;

/**
 *
 * @author anon
 */
public class productoDAO extends DAO{
    public List<CProducto> getListaProducto(){
        try{
            return em.createQuery("select p from CProducto p").getResultList();
            
        }catch(Exception ex ){
            System.err.println(ex.toString());
            return null;
        }finally{        
        }
    }
    
    public void insertProducto(CProducto oproducto){
        try{
            em.getTransaction().begin();
            em.persist(oproducto);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println(ex.toString());
        }finally{
        }
    }
    
    public void updateProducto(CProducto oproducto){
        try{
            CProducto obj = em.find(CProducto.class, oproducto.getCodigo());
            
            em.getTransaction().begin();
            obj.setNombre(oproducto.getNombre());
            obj.setDescripcion(oproducto.getDescripcion());
            obj.setFotografias(oproducto.getFotografias());
            obj.setTipoProducto(oproducto.getTipoProducto());
            obj.setPrecio(oproducto.getPrecio());
            em.getTransaction().commit();
        
        }catch(Exception ex){
        }finally{
        }
    }
    
    public void deleteProducto(int codigo){
        
        try{
            CProducto obj = em.find(CProducto.class, codigo);
        
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println(ex.toString());
        }finally{
        }
    }
}
