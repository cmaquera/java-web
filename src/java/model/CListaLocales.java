/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public class CListaLocales {
    private final ArrayList<CLocales> lLocales;
    
    public CListaLocales(){
        lLocales =  new ArrayList<>();
    }
    
    public CLocales BuscarLocales(int codigo){
        for(CLocales objLocales : lLocales){
            if(objLocales.getCodigo() == codigo){
                return objLocales;
            }
        }
        return null;
    }
    
    public String insertarLocales(CLocales objLocales){
        lLocales.add(objLocales);
        return "Se registro correctamente "; 
    }
    
    public String modificarLocales(CLocales objLocales){
        int ubicacion = 0;
        for(int i=0; i< this.cantLocales(); i++){
            if(lLocales.get(i).getCodigo() == objLocales.getCodigo()) ubicacion = i;
        }
        lLocales.set(ubicacion, objLocales);
        return "Se modifico correctamente";
    }
    
    public String borrarLocales(int index){
        int ubicacion = 0;
        for(int i=0; i< this.cantLocales(); i++){
            if(lLocales.get(i).getCodigo() == index) ubicacion = i;
        }
        lLocales.remove(ubicacion);
        return "Se Elimino correctamente";
    }
    public int cantLocales(){
        return lLocales.size();
    }
    
    
    public CLocales getLocales(int pos){
        return lLocales.get(pos);
    }
}
