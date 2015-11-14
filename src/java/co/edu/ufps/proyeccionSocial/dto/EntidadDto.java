
package co.edu.ufps.proyeccionSocial.dto;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Objects;



/**
 * clase EntidadDto
 * @author Edinson
 */
public class EntidadDto implements Serializable{
    
    private int idEntidad;
    private String nombre;
    private String direccion;
    //private ArrayList<ConvenioDto> misConvenios = new ArrayList<ConvenioDto>();
    
    /**
     * constructor por defecto
     */
    public EntidadDto() {
    }
    /**
     * metodo constructor
     * @param idEntidad identificador de la entidad
     * @param nombre nombre de la entidad
     * @param direccion direccion de la entidad
     */
    public EntidadDto(int idEntidad, String nombre, String direccion) {
        this.idEntidad = idEntidad;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    /**
     * 
     * Metodos get y set 
     */
    public int getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
/**
    public ArrayList<ConvenioDto> getMisConvenios() {
        return misConvenios;
    }

    public void setMisConvenios(ArrayList<ConvenioDto> misConvenios) {
        this.misConvenios = misConvenios;
    }
**/
    /**
     * Mrtodo hashcode
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idEntidad;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.direccion);
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
        final EntidadDto other = (EntidadDto) obj;
        if (this.idEntidad != other.idEntidad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
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
        return "EntidadDto{" + "idEntidad=" + idEntidad + ", nombre=" + nombre + ", direccion=" + direccion + '}';
    }

    
    
    
    
    
    
    
    
    
    
}



