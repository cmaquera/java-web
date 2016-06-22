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
 * @author root
 */
@Entity
@Table(name="persona")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="Tipo")
public class CPersona implements Serializable {
    @Id
    @Column(name="DNI")
    private String DNI;
    @Column(name="Nombre")
    private String nombres;
    @Column(name="Apellidos")
    private String apellidos;
    @Column(name="Usuario")
    private String usuario;
    @Column(name="Contraseña")
    private String contraseña;
    @Column(name="Correo")
    private String correo;
    
    public CPersona(){
        
    }
    
    public String getNombres(){ return this.nombres; }
    public String getApellidos(){ return this.apellidos; }
    public String getDNI(){ return this.DNI; }
    public String getUsuario(){ return this.usuario; }
    public String getContraseña(){ return this.contraseña; }
    public String getCorreo(){ return this.correo; }
    
    
    public void setNombres(String nombres) { this.nombres = nombres; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public void setDNI(String DNI) { this.DNI = DNI; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
    public void setCorreo(String correo) { this.correo = correo; }
    
}
