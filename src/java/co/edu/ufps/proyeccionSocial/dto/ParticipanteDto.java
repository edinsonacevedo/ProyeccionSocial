
package co.edu.ufps.proyeccionSocial.dto;


import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Edinson
 */
public class ParticipanteDto implements Serializable{
    
    private int codigoUFPS;
    private String nombre;

    public ParticipanteDto() {
    }

    /**
     * Metodo constructor
     * @param codigoUFPS codigo del participante
     * @param nombre nombre del participante
     */
    public ParticipanteDto(int codigoUFPS, String nombre) {
        this.codigoUFPS = codigoUFPS;
        this.nombre = nombre;
    }

    /**
     * Metodos get y set
     * @return 
     */
    public int getCodigoUFPS() {
        return codigoUFPS;
    }

    public void setCodigoUFPS(int codigoUFPS) {
        this.codigoUFPS = codigoUFPS;
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
        hash = 53 * hash + this.codigoUFPS;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    /**
     * metodo equals
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
        final ParticipanteDto other = (ParticipanteDto) obj;
        if (this.codigoUFPS != other.codigoUFPS) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    /**
     * metodo tostring
     * @return 
     */
    @Override
    public String toString() {
        return "ParticipanteDto{" + "codigoUFPS=" + codigoUFPS + ", nombre=" + nombre + '}';
    }
    
    
    
    
    
    
    
    
}
