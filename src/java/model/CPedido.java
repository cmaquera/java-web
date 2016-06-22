/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author anon
 */
@Entity
@Table(name="pedido")
public class CPedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Idpedido")
    private int codigo;
    @ManyToOne
    @JoinColumn(name="DNI")
    private CCliente cliente;
    @ManyToOne
    @JoinColumn(name="Idlocal")
    private CLocales local;
    @ManyToMany
    @JoinTable(
            name="detalle_pedido",
            joinColumns=@JoinColumn(name="Idpedido", referencedColumnName="Idpedido"),
            inverseJoinColumns=@JoinColumn(name="Idproducto", referencedColumnName="Idproducto")
    )
    private List<CProducto> lProductos;
    @Column(name="Hora")
    private String hora;
    @Column(name="Fecha")
    private String fecha;
    @Column(name="Importe")
    private double importe;

    public CPedido(){}
    
    public void setCodigo(int codigo){ this.codigo = codigo; }
    public void setHora(String hora){ this.hora = hora; }
    public void setFecha(String fecha){ this.fecha = fecha; }
    public void setImporte(double importe){ this.importe= importe; }
    public void setLocal(CLocales local){ this.local = local; }
    public void setCliente(CCliente cliente){ this.cliente = cliente; }
    public void setProductos(CProducto producto){ this.lProductos.add(producto); }
    
    public int getCodigo(){ return this.codigo; }
    public String getHora(){ return this.hora; }
    public String getFecha(){ return this.fecha; }
    public double getImporte(){ return this.importe; }
    public CLocales getLocal(){ return this.local; }
    public CCliente getCliente(){ return this.cliente; }
    public List<CProducto> getProdcutos(){ return this.lProductos; }
    
}
