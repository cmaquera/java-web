/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import dao.direccionDAO;

/**
 *
 * @author anon
 */
public class CListaDireccion {
    List<CDireccion> lDirecciones;
    
    public CListaDireccion(){
        lDirecciones =  new ArrayList<CDireccion>();
        direccionDAO oDireccionDAO  = new direccionDAO();
        lDirecciones = oDireccionDAO.getListaDireccion();
        
    }
    
    public String insDireccion(CDireccion odireccion){
        direccionDAO oDireccionDAO  = new direccionDAO();
        oDireccionDAO.insertDireccion(odireccion);
        
        lDirecciones.add(odireccion);
        
        return "Se inscribio exitosamente";
    }
    
    public void delDireccion(int codigo){
        int i=-1;
        for(CDireccion odireccion: lDirecciones){
            i++;
            if(odireccion.getCodigo() == codigo) break;
        }
        if(i> -1)   lDirecciones.remove(i);
        
        direccionDAO oDireccionDAO  = new direccionDAO();
        oDireccionDAO.deleteDireccion(codigo);
    }
    
    public int cantDireccion() {return lDirecciones.size();}
    public CDireccion elemento(int pos) {return lDirecciones.get(pos); }
    
    public CDireccion buscarxCodigo(int codigo)
    {
        for(CDireccion odireccion: lDirecciones){
            if(odireccion.getCodigo() == codigo)
                return odireccion;
        }
        return null;
    }
}
