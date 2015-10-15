
package co.edu.ufps.proyeccionSocial.dto;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
/**
 *
 * @author Edinson
 */
public class ParticipanteAPSDto implements Serializable{
    
    private Date fecha;
    private int actividadPS_id;
    private int participante_codigoUFPS;

    public ParticipanteAPSDto() {
    }

    /**
     * Metodo constructor
     * @param fecha fecha en que participa de la actividad
     * @param actividadPS_id identificador de la actividad
     * @param participante_codigoUFPS codigo del participante
     */
    public ParticipanteAPSDto(Date fecha, int actividadPS_id, int participante_codigoUFPS) {
        this.fecha = fecha;
        this.actividadPS_id = actividadPS_id;
        this.participante_codigoUFPS = participante_codigoUFPS;
    }

    /**
     * metodos get y set
     * @return 
     */
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getActividadPS_id() {
        return actividadPS_id;
    }

    public void setActividadPS_id(int actividadPS_id) {
        this.actividadPS_id = actividadPS_id;
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
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.fecha);
        hash = 23 * hash + this.actividadPS_id;
        hash = 23 * hash + this.participante_codigoUFPS;
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
        final ParticipanteAPSDto other = (ParticipanteAPSDto) obj;
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (this.actividadPS_id != other.actividadPS_id) {
            return false;
        }
        if (this.participante_codigoUFPS != other.participante_codigoUFPS) {
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
        return "ParticipanteAPS{" + "fecha=" + fecha + ", actividadPS_id=" 
                + actividadPS_id + ", participante_codigoUFPS=" + participante_codigoUFPS + '}';
    }
    
    
    
    
    
    
}
