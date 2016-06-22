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
@Table(name="cargo")
public class CCargo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Idcodigo")
    private int codigo;
    @Column(name="Nombre")
    private String nombre;
    @OneToMany(mappedBy="cargo")
    private List<CEmpleado> lEmpleados;
    
    public CCargo(){}
    
    public void setCodigo(int codigo){ this.codigo = codigo; }
    public void setNombre(String nombre){ this.nombre = nombre; }
    public void setEmplado(CEmpleado empleado){ this.lEmpleados.add(empleado); }
    
    public int getCodigo(){ return this.codigo; }
    public String getNombre(){ return this.nombre; }
    public List<CEmpleado> getListaEmpleado(){ return this.lEmpleados; }
    
}
