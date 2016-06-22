/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.productoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anon
 */
public class CListaProducto {
    private List<CProducto> lProductos;
    
    public CListaProducto(){
        lProductos = new ArrayList<CProducto>();
        
        productoDAO oProductoDAO =  new productoDAO();
        lProductos = oProductoDAO.getListaProducto();
        
    }
    
    public String insProducto(CProducto oproducto){
        productoDAO oProductoDAO = new productoDAO();
        oProductoDAO.insertProducto(oproducto);
        
        lProductos.add(oproducto);
        
        return "registrado exitosamente";
    }
    
    public void delProducto(int codigo){
        int i = -1;
        for(CProducto oproducto: lProductos){
            i++;
            if(oproducto.getCodigo() == codigo){ break; }
        }
        if(i > -1)  lProductos.remove(i);
        
        productoDAO oProductoDAO =  new productoDAO();        
        oProductoDAO.deleteProducto(codigo);
    }
    
    public int cantProducto(){ return lProductos.size(); }
    public CProducto elemento(int index){ return lProductos.get(index); }
    
}
