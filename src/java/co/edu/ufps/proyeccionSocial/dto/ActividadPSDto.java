/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.proyeccionSocial.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Objects;
/**
 *
 * @author Edinson
 */
public class ActividadPSDto implements Serializable{
    
    private int idActividadPS;
    
    private Date fecha;
    private String lugar;
    private int convenio_id;
    private int presupesto_id;
    private int lider_codigoUFPS;
    private String nombre;
    private String estado;
    private String descripcion;
    private String hora;
    
    public ActividadPSDto() {
    }

   
    /**
     * metodo constructos
     * @param idActividadPS identificador de la actividad
     * @param nombre nombre de la actividad
     * @param fecha fecha en que se realizara la actividad
     * @param lugar lugar donde se realiza la actividad
     * @param convenio_id identificador del convenio
     * @param presupesto_id identificador del presupuesto
     * @param lider_codigoUFPS codigo del lider encargado de la actividad
     */
    public ActividadPSDto(int idActividadPS, Date fecha, String lugar, int convenio_id, int presupesto_id, int lider_codigoUFPS, String nombre, String estado, String descripcion, String hora) {
        this.idActividadPS = idActividadPS;
        this.fecha = fecha;
        this.lugar = lugar;
        this.convenio_id = convenio_id;
        this.presupesto_id = presupesto_id;
        this.lider_codigoUFPS = lider_codigoUFPS;
        this.nombre = nombre;
        this.estado = estado;
        this.descripcion = descripcion;
        this.hora = hora;
    }

    

    /**
     * Metodos get y set
     * @return 
     */
    

    public int getIdActividadPS() {
        return idActividadPS;
    }

    public void setIdActividadPS(int idActividadPS) {
        this.idActividadPS = idActividadPS;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getConvenio_id() {
        return convenio_id;
    }

    public void setConvenio_id(int convenio_id) {
        this.convenio_id = convenio_id;
    }

    public int getPresupesto_id() {
        return presupesto_id;
    }

    public void setPresupesto_id(int presupesto_id) {
        this.presupesto_id = presupesto_id;
    }

    public int getLider_codigoUFPS() {
        return lider_codigoUFPS;
    }

    public void setLider_codigoUFPS(int lider_codigoUFPS) {
        this.lider_codigoUFPS = lider_codigoUFPS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    

   
    /**
     * Metodo hashcode
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idActividadPS;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.fecha);
        hash = 89 * hash + Objects.hashCode(this.lugar);
        return hash;
    }

    /**
     * Metodo equals
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ActividadPSDto other = (ActividadPSDto) obj;
        if (this.idActividadPS != other.idActividadPS) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.lugar, other.lugar)) {
            return false;
        }
        return true;
    }

    

    /**
     * Metodo toString
     * @return 
     */
    
    @Override
    public String toString() {
        return "ActividadPSDto{" + "idActividadPS=" + idActividadPS + ", fecha=" + fecha + 
                ", lugar=" + lugar + ", convenio_id=" + convenio_id +
                ", presupesto_id=" + presupesto_id + ", lider_codigoUFPS=" + lider_codigoUFPS + 
                ", nombre=" + nombre + ", estado=" + estado + ", descripcion=" + descripcion +", hora=" + hora + '}';
    }
    
    
    
    
}
