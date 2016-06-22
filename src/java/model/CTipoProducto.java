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
@Table(name="tipo_producto")
public class CTipoProducto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Idtipo_producto")
    private int codigo;
    @Column(name="Nombre")
    private String nombre;
    @Column(name="Descripcion")
    private String descripcion;
    @OneToMany(mappedBy="tipo_producto")
    private List<CProducto> lProductos;
    
    public CTipoProducto(){}
    
    public void setCodigo(int codigo){ this.codigo = codigo; }
    public void setNombre(String nombre){ this.nombre = nombre; }
    public void setDescripcion(String descripcion){this.descripcion = descripcion; }
    public void setProducto(CProducto producto){ this.lProductos.add(producto); }
    
    public int getCodigo(){ return this.codigo; }
    public String getNombre(){ return this.nombre; }
    public String getDescripcion(){ return this.descripcion; }
    public List<CProducto> getListaProductos(){ return this.lProductos; }
    
}
