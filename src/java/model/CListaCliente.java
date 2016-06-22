/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.clienteDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class CListaCliente {
    private List<CCliente> lClientes;
    
    public CListaCliente(){
        lClientes = new ArrayList<CCliente>();
        
        clienteDAO oClienteDAO =  new clienteDAO();
        lClientes = oClienteDAO.getListaCliente();
    }
    
    public CCliente BuscarCliente(String DNI){
        for(CCliente objCliente : lClientes){
            if(objCliente.getDNI().equals(DNI)){
                return objCliente;
            }
        }
        return null;
    }
    
    public String insCliente(CCliente ocliente){
        clienteDAO oClienteDAO = new clienteDAO();
        oClienteDAO.insertCliente(ocliente);
        
        lClientes.add(ocliente);
        
        return "registrado exitosamente";
    }
    
    public void delCliente(String DNI){
        int i = -1;
        for(CCliente ocliente: lClientes){
            i++;
            if(ocliente.getDNI().equals(DNI)){ break; }
        }
        if(i > -1)  lClientes.remove(i);
        
        clienteDAO oClienteDAO =  new clienteDAO();        
        oClienteDAO.deleteCliente(DNI);
    }
    
    public CCliente BuscarUsuario(String correo, String contraseña){
        for(CCliente objCliente :  this.lClientes){
            if(objCliente.getCorreo().equals(correo) && objCliente.getContraseña().equals(contraseña)){
                return objCliente;
            }
        }
        return null;
    }
    
    public int entCliente(){
        return lClientes.size();
    }
    
    
    public CCliente elemento(int pos){
        return lClientes.get(pos);
    }
}
