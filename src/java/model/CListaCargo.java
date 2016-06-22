/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anon
 */
public class CListaCargo {
    private List<CCargo> lCargos;
    
    public CListaCargo(){
        lCargos = new ArrayList<CCargo>();
        
        cargoDAO oCargoDAO =  new cargoDAO();
        lCargos = oCargoDAO.getListaCargo();
        
    }
    
    public String insCargo(CCargo ocargo){
        cargoDAO oCargoDAO = new cargoDAO();
        oCargoDAO.insertCargo(ocargo);
        
        lCargos.add(ocargo);
        
        return "registrado exitosamente";
    }
    
    public void delCargo(int codigo){
        int i = -1;
        for(CCargo ocargo: lCargos){
            i++;
            if(ocargo.getCodigo() == codigo){ break; }
        }
        if(i > -1)  lCargos.remove(i);
        
        cargoDAO oCargoDAO =  new cargoDAO();        
        oCargoDAO.deleteCargo(codigo);
    }
    
    public int cantCargo(){ return lCargos.size(); }
    public CCargo elemento(int index){ return lCargos.get(index); }
    
    
}
