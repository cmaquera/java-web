/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author anon
 */

@Entity
@Table(name="distrito")
public class CDistrito implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Iddistrito")
    private int codigo;
    @Column(name="Nombre")
    private String nombre;
    @OneToMany(mappedBy = "distrito")
    private List<CDireccion> lDirecciones;
    //private String descripcion;
    
    CDistrito(){}
    
    public void setCodigo(int codigo){ this.codigo = codigo; }
    public void setNombre(String nombre){ this.nombre = nombre; }
    public void setDireccion(CDireccion direccion){ this.lDirecciones.add(direccion); }
    
    public int getCodigo(){ return this.codigo; }
    public String getNombre(){ return this.nombre; }
    public List<CDireccion> getListaDirecciones(){ return lDirecciones; }
}

