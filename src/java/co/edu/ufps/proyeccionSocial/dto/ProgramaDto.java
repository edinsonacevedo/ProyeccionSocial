
package co.edu.ufps.proyeccionSocial.dto;

import java.io.Serializable;
import java.util.Objects;


/**
 *
 * @author Lenovo
 */
public class ProgramaDto implements Serializable{
    
    private int idPrograma;
    private String nombre;

    public ProgramaDto() {
    }

    /**
     * Metodo constructor
     * @param idPrograma identificador del programa
     * @param nombre nombre del programa
     */
    public ProgramaDto(int idPrograma, String nombre) {
        this.idPrograma = idPrograma;
        this.nombre = nombre;
    }

    /**
     * metodos get y set
     * @return 
     */
    public int getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo hashcode
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.idPrograma;
        hash = 67 * hash + Objects.hashCode(this.nombre);
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
        final ProgramaDto other = (ProgramaDto) obj;
        if (this.idPrograma != other.idPrograma) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    /**
     * metodo toString
     * @return 
     */
    @Override
    public String toString() {
        return "ProgramaDto{" + "idPrograma=" + idPrograma + ", nombre=" + nombre + '}';
    }
    
    
    
    
    
}
