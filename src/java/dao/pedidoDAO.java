/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.*;
/**
 *
 * @author anon
 */
public class pedidoDAO extends DAO{
    
    public List<CPedido> getListaPedido(){
        try{
            return em.createQuery("select p from CPedido p").getResultList();
            
        }catch(Exception ex ){
            System.err.println(ex.toString());
            return null;
        }finally{        
        }
    }
    
    public void insertPedido(CPedido opedido){
        try{
            em.getTransaction().begin();
            em.persist(opedido);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println(ex.toString());
        }finally{
        }
    }
    
    public void updatePedido(CPedido opedido){
        try{
            CPedido obj = em.find(CPedido.class, opedido.getCodigo());
            
            em.getTransaction().begin();
            obj.setCliente(opedido.getCliente());
            obj.setFecha(opedido.getFecha());
            obj.setHora(opedido.getHora());
            obj.setImporte(opedido.getImporte());
            obj.setLocal(opedido.getLocal());
            em.getTransaction().commit();
        
        }catch(Exception ex){
        }finally{
        }
    }
    
    public void deletePedido(int codigo){
        
        try{
            CPedido obj = em.find(CPedido.class, codigo);
        
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println(ex.toString());
        }finally{
        }
    }
    
    public List<CProducto> getListaProductoxPedido(CPedido pedido){
        //List<CProducto> orderList = em.createNamedQuery("findAllCProductosByCpedido")
        //        .setParameter("pedido", CPedido) .getResultList();
        //return orderList;
        return null;
    }
}

