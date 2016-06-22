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
@Table(name="local")
public class CLocales implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Idlocal")
    private int codigo;
    @Column(name="Nombre")
    private String nombre;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Iddireccion")
    private CDireccion direccion;
    @Column(name="Descripcion")
    private String descripcion;
    @Column(name="Fotografia")
    private String fotografia;
    @OneToMany(mappedBy="local")
    private List<CPedido> lPedidos;
    
    public CLocales(){}
    
    public void setCodigo(int codigo){ this.codigo = codigo; }
    public void setNombre(String nombre){ this.nombre = nombre; }
    public void setDireccion(CDireccion direccion){ this.direccion = direccion; }
    public void setDescripcion(String descripcion){ this.descripcion = descripcion; }
    public void setFotografia(String fotografia){ this.fotografia = fotografia; }
    public void setPedido(CPedido pedido){ this.lPedidos.add(pedido); }

    public int getCodigo(){ return this.codigo; }
    public String getNombre(){ return this.nombre; }
    public CDireccion getDireccion(){ return this.direccion; }
    public String getDescripcion(){ return this.descripcion; }
    public String getFotografia(){ return this.fotografia; }
    public List<CPedido> getPedidos(){ return this.lPedidos; }
    
}
