/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author anon
 */
@Entity
@Table(name="direccion")
public class CDireccion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    @Column(name="Iddireccion")
    private int codigo;
    @ManyToOne
    @JoinColumn(name="Iddistrito")
    private CDistrito distrito;
    @OneToOne(mappedBy = "direccion")
    private CCliente cliente;
    @Column(name="Calle")
    private String calle;
    @Column(name="Manzana")
    private String manzana;
    @Column(name="Lote")
    private String lote;
    @Column(name="Numero")
    private String numero;
    @Column(name="Urbanizacion")
    private String urbanizacion;
    
    
    public void setCodigo(int codigo){ this.codigo = codigo; }
    public void setDistrito(CDistrito distrito){ this.distrito = distrito; }
    public void setCliente(CCliente cliente){ this.cliente = cliente; }
    public void setCalle(String calle){ this.calle = calle; }
    public void setManzana(String manzana){ this.manzana = manzana; }
    public void setLote(String lote){ this.lote = lote; }
    public void setNumero(String numero){ this.numero = numero; }
    public void setUrbanizacion(String urbanizacion){ this.urbanizacion = urbanizacion; }
    
    public int getCodigo(){ return this.codigo; }
    public CDistrito getDistrito(){ return  this.distrito; }
    public CCliente getCliente(){ return  this.cliente; }
    public String getCalle(){ return  this.calle; }
    public String getManzana(){ return  this.manzana; }
    public String getLote(){ return  this.lote; }
    public String getNumero(){ return  this.numero; }
    public String getUrbanizacion(){ return  this.urbanizacion; }
}
