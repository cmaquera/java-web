/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.*;

/**
 *
 * @author root
 */
@Entity
@Table(name="empleado")
@PrimaryKeyJoinColumn(referencedColumnName = "DNI")
@DiscriminatorValue("EM")
public class CEmpleado extends CPersona{
    @ManyToOne
    @JoinColumn(name="Idcargo")
    private CCargo cargo;
    @Column(name="Horario")
    private String horario;
    
    public CEmpleado(){}
    
    public void setCargo(CCargo cargo){ this.cargo = cargo; }
    public void serHorario(String horario){ this.horario = horario; }
    
    public CCargo getCargo(){ return this.cargo; }
    public String getHorario(){  return this.horario; }

}
