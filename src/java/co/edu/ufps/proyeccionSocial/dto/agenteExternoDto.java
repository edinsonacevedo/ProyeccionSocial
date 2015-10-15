
package co.edu.ufps.proyeccionSocial.dto;

import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author Edinson
 */
public class agenteExternoDto implements Serializable{
    
    private int idAgenteExterno;
    private String correo;
    private String comentario;

    public agenteExternoDto() {
    }

    /**
     * Metodo constructor 
     * @param idAgenteExterno identificador del agente externo
     * @param correo correo de la persona que envia el comentario
     * @param comentario comentario enviado
     */
    public agenteExternoDto(int idAgenteExterno, String correo, String comentario) {
        this.idAgenteExterno = idAgenteExterno;
        this.correo = correo;
        this.comentario = comentario;
    }

    /**
     * Metodos get y set
     * @return 
     */
    public int getIdAgenteExterno() {
        return idAgenteExterno;
    }

    public void setIdAgenteExterno(int idAgenteExterno) {
        this.idAgenteExterno = idAgenteExterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Metodo hashcode
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idAgenteExterno;
        hash = 47 * hash + Objects.hashCode(this.correo);
        hash = 47 * hash + Objects.hashCode(this.comentario);
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
        final agenteExternoDto other = (agenteExternoDto) obj;
        if (this.idAgenteExterno != other.idAgenteExterno) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.comentario, other.comentario)) {
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
        return "agenteExternoDto{" + "idAgenteExterno=" + idAgenteExterno +
                ", correo=" + correo + ", comentario=" + comentario + '}';
    }
    
    
    
    
    
    
    
}
