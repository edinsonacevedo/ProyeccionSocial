
package co.edu.ufps.proyeccionSocial.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.Objects;
/**
 *Clase ConvenioDto
 * @author Edinson
 */
public class ConvenioDto implements Serializable{
    
    private int idConvenio;
    private String nombre;
    private Date fecha;
    private int programa_id;
    private int entidad_id;
   // private ArrayList<ActividadPSDto> misActividadesPs = new ArrayList<ActividadPSDto>();

    public ConvenioDto() {
    }

    /**
     * Metodo Constructor
     * @param idConvenio identificador del convenio
     * @param nombre nombre del convenio
     * @param fecha fecha en que se realiza el convenio
     * @param programa_id identificador del programa
     * @param entidad_id  identificador de la entidad
     */
    public ConvenioDto(int idConvenio, String nombre, Date fecha, int programa_id, int entidad_id) {
        this.idConvenio = idConvenio;
        this.nombre = nombre;
        this.fecha = fecha;
        this.programa_id = programa_id;
        this.entidad_id = entidad_id;
    }
    
    

    /**
     * Metodos get y set
     * @return 
     */
    public int getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(int idConvenio) {
        this.idConvenio = idConvenio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getEntidad_id() {
        return entidad_id;
    }

    public void setEntidad_id(int entidad_id) {
        this.entidad_id = entidad_id;
    }
/**
    public ArrayList<ActividadPSDto> getMisActividadesPs() {
        return misActividadesPs;
    }

    public void setMisActividadesPs(ArrayList<ActividadPSDto> misActividadesPs) {
        this.misActividadesPs = misActividadesPs;
    }
**/
    /**
     * Metodo hashCode
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idConvenio;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.fecha);
        hash = 79 * hash + this.programa_id;
        hash = 79 * hash + this.entidad_id;
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
        final ConvenioDto other = (ConvenioDto) obj;
        if (this.idConvenio != other.idConvenio) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (this.programa_id != other.programa_id) {
            return false;
        }
        if (this.entidad_id != other.entidad_id) {
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
        return "ConvenioDto{" + "idConvenio=" + idConvenio + ", nombre=" 
                + nombre + ", fecha=" + fecha + ", programa_id=" + programa_id + 
                ", entidad_id=" + entidad_id + '}';
    }

    
    
    
    
    
}
