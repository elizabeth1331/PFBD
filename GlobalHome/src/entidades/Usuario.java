/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author jeremy
 */
public class Usuario {
    
    //atributos de instancia
    private long usuarioID;
    private String nombreUsuario;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String email;
    private String pwd;
    
    
    //metodo constructor de la clase
    public Usuario() {
        this.usuarioID = 0;
        this.nombreUsuario = null;
        this.nombre = null;
        this.apPaterno = null;
        this.apMaterno = null;
        this.email = null;
        this.pwd = null;        
    }        
    
    //Métodos getters y setters
    public void setUsuarioID(long usuarioID){
        this.usuarioID = usuarioID;
    }
    
    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setApPaterno(String apPaterno){
        this.apPaterno = apPaterno;
    }
    
    public void setApMaterno(String apMaterno){
        this.apMaterno = apMaterno;
    }

    public void setEmail(String email){
        this.email = email;
    }
    
    public void setPwd(String pwd){
        this.pwd = pwd;
    }
    
    public long getUsuarioID(){
        return this.usuarioID;
    }    
    
    public String getNombreUsuario(){
        return this.nombreUsuario;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getApPaterno(){
        return this.apPaterno;
    }
    
    public String getApMaterno(){
        return this.apMaterno;
    }

    public String getEmail(){
        return this.email;
    }
    
    public String getPwd(){
        return this.pwd;
    }   
    
    
    
}
