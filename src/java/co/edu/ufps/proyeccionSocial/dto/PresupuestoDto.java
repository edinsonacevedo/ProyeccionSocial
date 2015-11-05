
package co.edu.ufps.proyeccionSocial.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
/**
 *
 * @author Edinson
 */
public class PresupuestoDto implements Serializable{
    
    private int idPresupuesto;
    private double monto;
    private Date fecha;
    private String estado; //Aprobado, Desaprobado, En Espera, No Asignado
    private String nota;

    public PresupuestoDto() {
    }

    /**
     * Metodo constructor
     * @param idPresupuesto identificador del presupuesto
     * @param monto cantidad de dinero presupuestada
     * @param fecha fecha en que se asigna el presupuesto
     * @param estado eatdo del presupuesto ( Aprobado, Desaprobado, En espera)
     * @param nota nota que el administrador envia al lider encargado de la actividad
     */
    public PresupuestoDto(int idPresupuesto, double monto, Date fecha, String estado, String nota) {
        this.idPresupuesto = idPresupuesto;
        this.monto = monto;
        this.fecha = fecha;
        this.estado = estado;
        this.nota = nota;
    }

    /**
     * Metodos get y set
     * @return 
     */
    public int getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(int idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
    
    
    

    /**
     * Metodo hashcode
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idPresupuesto;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.monto) ^ (Double.doubleToLongBits(this.monto) >>> 32));
        hash = 23 * hash + Objects.hashCode(this.fecha);
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
        final PresupuestoDto other = (PresupuestoDto) obj;
        if (this.idPresupuesto != other.idPresupuesto) {
            return false;
        }
        if (Double.doubleToLongBits(this.monto) != Double.doubleToLongBits(other.monto)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    /**
     * Metodo tostring
     * @return 
     */
    @Override
    public String toString() {
        return "PresupuestoDto{" + "idPresupuesto=" + idPresupuesto +
                ", monto=" + monto + ", fecha=" + fecha + ", estado=" + estado+", nota=" + nota+'}';
    }
    
    
    
    
    
    
    
    
}
