/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import dao.*;


/**
 *
 * @author anon
 */
public class CListaPedido {
    private List<CPedido> lPedidos;
    
    public CListaPedido(){
        lPedidos =  new ArrayList<CPedido>();
        pedidoDAO oPedidoDAO = new pedidoDAO();
        lPedidos = oPedidoDAO.getListaPedido();
    }
    
    public String insPedido(CPedido opedido){
        pedidoDAO oPedidoDAO = new pedidoDAO();
        oPedidoDAO.insertPedido(opedido);
        lPedidos.add(opedido);
        return "Registrado/Actualizado exitosamente";
    }
    
    public void delGrupo(String codigo){
        int i=-1;
        for(CPedido obj : lPedidos){
            i++;
            if(obj.getCodigo() == Integer.parseInt(codigo)){
                break;
            }
        }
        if(i>1) lPedidos.remove(i);
        
        pedidoDAO oPedidoDAO  = new pedidoDAO();
        oPedidoDAO.deletePedido(i);
    }
    
    public CPedido buscarxCodigo(int codigo){
        for(CPedido obj: lPedidos){
            if(obj.getCodigo() == codigo){
                return obj;
            }
        }
        return null;
    }
    
    public int cantPedido(){ return lPedidos.size(); }
    public CPedido elemento(int index){ return lPedidos.get(index); }
    
}
