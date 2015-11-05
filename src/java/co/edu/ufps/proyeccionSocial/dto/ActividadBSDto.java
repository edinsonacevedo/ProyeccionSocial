
package co.edu.ufps.proyeccionSocial.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Edinson
 */
public class ActividadBSDto implements Serializable{
    
    private int idActividadBS;
    private String descripcion;
    private String lugar;
    private Date fecha;
    private int programa_id;
    private int presupuesto_id;
    private int lider_codigoUFPS;
    private String nombre;
    private String estado;
  

    public ActividadBSDto() {
    }

   

    /**
     * Metodo constructor
     * @param idActividadBS identificador de la actividad de bienestar social
     * @param descripcion descripcion de la actividad
     * @param lugar lugar donde se realizara la actividad
     * @param fecha fecha en que se realiza la actividad
     * @param programa_id identificador del progra al cual pertenece la actividad
     * @param presupuesto_id identificador del presupiesto destinado para esta actividad
     * @param lider_codigoUFPS codigo del lider encargado de la actividad
     */

     public ActividadBSDto(int idActividadBS, String descripcion, String lugar, Date fecha, int programa_id, int presupuesto_id, int lider_codigoUFPS, String nombre, String estado) {
        this.idActividadBS = idActividadBS;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.fecha = fecha;
        this.programa_id = programa_id;
        this.presupuesto_id = presupuesto_id;
        this.lider_codigoUFPS = lider_codigoUFPS;
        this.nombre = nombre;
        this.estado = estado;
    }



    /**
     * Metodos get y set
     * @return 
     */
     
        public int getIdActividadBS() {
        return idActividadBS;
    }

    public void setIdActividadBS(int idActividadBS) {
        this.idActividadBS = idActividadBS;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPrograma_id() {
        return programa_id;
    }

    public void setPrograma_id(int programa_id) {
        this.programa_id = programa_id;
    }

    public int getPresupuesto_id() {
        return presupuesto_id;
    }

    public void setPresupuesto_id(int presupuesto_id) {
        this.presupuesto_id = presupuesto_id;
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

   

    /**
     * Metodo hashcode
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idActividadBS;
        hash = 97 * hash + Objects.hashCode(this.descripcion);
        hash = 97 * hash + Objects.hashCode(this.lugar);
        hash = 97 * hash + Objects.hashCode(this.fecha);
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
        final ActividadBSDto other = (ActividadBSDto) obj;
        if (this.idActividadBS != other.idActividadBS) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.lugar, other.lugar)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
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
        return "ActividadBSDto{" + "idActividadBS=" + idActividadBS + ", descripcion=" 
                + descripcion + ", lugar=" + lugar + ", fecha=" + fecha + ", programa_id=" 
                + programa_id + ", presupuesto_id=" + presupuesto_id + ", lider_codigoUFPS=" 
                + lider_codigoUFPS + ", nombre=" + nombre + ", estado=" + estado + '}';
    }

    
    
    
    
    
    
    
    
}
