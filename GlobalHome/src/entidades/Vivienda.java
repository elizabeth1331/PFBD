/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author jeremy
 */
public class Vivienda {
    //atributos de instancia
    private long viviendaID;
    private String direccion;
    private long longitud;
    private long latitud;
    private int capacidadMax;
    private String descripcion;
    private Date fechaEstatus;
    private boolean esVVenta;
    private boolean esVRenta;
    private boolean esVVacacionar;
    private long usuarioID;
    private long estatusViviendaID;
    
    //metodo constructor de la clase
    public Vivienda() {
        this.viviendaID = 0;
        this.direccion = null;
        this.longitud = 0;
        this.latitud = 0;
        this.capacidadMax = 0;
        this.descripcion = null;
        this.fechaEstatus = null;
        this.esVVenta = false;
        this.esVRenta = false;
        this.esVVacacionar = false;
        usuarioID = 0;
        this.estatusViviendaID = 0;      
    }        
    
    //Métodos getters y setters
    public void setViviendaID(long viviendaID){
        this.viviendaID = viviendaID;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public void setLongitud(long longitud){
        this.longitud = longitud;
    }
    
    public void setLatitud(long latitud){
        this.latitud = latitud;
    }

    public void setCapacidadMax(int capacidadMax){
        this.capacidadMax = capacidadMax;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setFechaEstatus(Date fechaEstatus){
        this.fechaEstatus = fechaEstatus;
    }
    
    public void setEsVVenta(boolean esVVenta){
        this.esVVenta = esVVenta;
    }

    public void setEsVRenta(boolean esVRenta){
        this.esVRenta = esVRenta;
    }    

    public void setEsVVacacionar(boolean esVVacacionar){
        this.esVVacacionar = esVVacacionar;
    }     
   

    public void setUsuarioID(long usuarioID){
        this.usuarioID = usuarioID;
    }     
    
    public void setEstatusViviendaID(long estatusViviendaID){
        this.estatusViviendaID = estatusViviendaID;
    }      

    
    public long getViviendaID(){
        return this.viviendaID;
    }
    
    public String getDireccion(){
        return this.direccion;
    }
    
    public long getLongitud(){
        return this.longitud;
    }
    
    public long getLatitud(){
        return this.latitud;
    }

    public int getCapacidadMax(){
        return this.capacidadMax;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }

    public Date getFechaEstatus(){
        return this.fechaEstatus;
    }
    
    public boolean getEsVVenta(){
        return this.esVVenta = esVVenta;
    }

    public boolean getEsVRenta(){
        return this.esVRenta;
    }    

    public boolean getEsVVacacionar(){
        return this.esVVacacionar;
    }     
   

    public long getUsuarioID(){
        return this.usuarioID;
    }     
    
    public long getEstatusViviendaID(){
        return this.estatusViviendaID;
    }     
}
