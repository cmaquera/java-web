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
 * @author root
 */
@Entity
@Table(name="producto")
public class CProducto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Idproducto")
    private int codigo;
    @Column(name="Nombre")
    private String nombre;
    @Column(name="Precio")
    private double precio;
    @Column(name="Descripcion")
    private String descripcion;
    @Column(name="Fotografia")
    private String fotografia;
    @ManyToMany(mappedBy="lProductos")
    private List<CPedido> lPedidos;
    @ManyToOne
    @JoinColumn(name="Idtipo_producto")
    private CTipoProducto tipo_producto;
    
    
    public CProducto(){}
    
    public void setCodigo( int codigo ){ this.codigo = codigo; }
    public void setNombre( String nombre ){ this.nombre = nombre; }
    public void setPrecio( double precio ){ this.precio = precio; }
    public void setDescripcion( String descripcion ){ this.descripcion = descripcion; }
    public void setFotografias( String fotografia ){ this.fotografia = fotografia; }
    public void setTipoProducto(CTipoProducto tipo_producto){ this.tipo_producto = tipo_producto; }
    public void setPedidos(CPedido pedido){ this.lPedidos.add(pedido); }
    
    public int getCodigo(){ return this.codigo; }
    public String getNombre(){ return this.nombre; }
    public double getPrecio(){ return this.precio; }
    public String  getDescripcion(){ return this.descripcion; }
    public String getFotografias(){ return this.fotografia; }
    public CTipoProducto getTipoProducto(){ return this.tipo_producto; }
    public List<CPedido> getListaPedido(){ return this.lPedidos; }
    
}
