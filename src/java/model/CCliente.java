/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author root
 */
@Entity
@Table(name="cliente")
@PrimaryKeyJoinColumn(referencedColumnName = "DNI")
@DiscriminatorValue("CI")
public class CCliente extends CPersona{
    @OneToOne
    @JoinColumn(name="Iddireccion")
    private CDireccion direccion;
    @Column(name="Telefono")
    private String telefono;
    @OneToMany(mappedBy="cliente")
    private List<CPedido> lPedidos;
    
    public CCliente(){}
    
    public void setDireccion(CDireccion direccion){ this.direccion = direccion; }
    public void setTelefono(String telefono){ this.telefono = telefono; }
    public void setPedido(CPedido pedido){ this.lPedidos.add(pedido); }
    
    public CDireccion getDireccion(){ return this.direccion; }
    public String getTelefono(){ return this.telefono; }
    public List<CPedido> getPedidos(){ return this.lPedidos; }
    
}
