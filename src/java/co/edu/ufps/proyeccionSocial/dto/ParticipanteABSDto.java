
package co.edu.ufps.proyeccionSocial.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
/**
 *
 * @author Edinson
 */
public class ParticipanteABSDto implements Serializable{
    
    private Date fecha;
    private int actividadBS_id;
    private int participante_codigoUFPS;

    public ParticipanteABSDto() {
    }

    /**
     * metodo constructor
     * @param fecha fecha enque el estudiante participa de la actividad
     * @param actividadBS_id identificador de la actividad
     * @param participante_codigoUFPS  codigo del participante
     */
    public ParticipanteABSDto(Date fecha, int actividadBS_id, int participante_codigoUFPS) {
        this.fecha = fecha;
        this.actividadBS_id = actividadBS_id;
        this.participante_codigoUFPS = participante_codigoUFPS;
    }

    /**
     * Metodos get y set
     * @return 
     */
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getActividadBS_id() {
        return actividadBS_id;
    }

    public void setActividadBS_id(int actividadBS_id) {
        this.actividadBS_id = actividadBS_id;
    }

    public int getParticipante_codigoUFPS() {
        return participante_codigoUFPS;
    }

    public void setParticipante_codigoUFPS(int participante_codigoUFPS) {
        this.participante_codigoUFPS = participante_codigoUFPS;
    }

    /**
     * Metodo hashcode
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.fecha);
        hash = 67 * hash + this.actividadBS_id;
        hash = 67 * hash + this.participante_codigoUFPS;
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
        final ParticipanteABSDto other = (ParticipanteABSDto) obj;
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (this.actividadBS_id != other.actividadBS_id) {
            return false;
        }
        if (this.participante_codigoUFPS != other.participante_codigoUFPS) {
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
        return "ParticipanteABS{" + "fecha=" + fecha + ", actividadBS_id="
                + actividadBS_id + ", participante_codigoUFPS=" + participante_codigoUFPS + '}';
    }
    
    
    
    
    
    
    
}
