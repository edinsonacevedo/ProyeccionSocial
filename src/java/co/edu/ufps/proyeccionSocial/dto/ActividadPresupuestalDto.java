/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.proyeccionSocial.dto;

import java.util.Objects;

/**
 *
 * @author Edinson
 */
public class ActividadPresupuestalDto {
    
    private int idActPresupuestal;
    private String nomActividadPresupuestal;
    private int montoPresupuestal;
    private String descripcionMonto;
    private int idPresupuesto;

    public ActividadPresupuestalDto() {
    }

  

    /**
     * crea una nueva actividad presupuestal con todos sus atributos
     * @param idActPresupuestal
     * @param nomActividadPresupuestal
     * @param montoPresupuestal
     * @param descripcionMonto
     * @param idPresupuesto 
     */
    public ActividadPresupuestalDto(int idActPresupuestal, String nomActividadPresupuestal, int montoPresupuestal, String descripcionMonto, int idPresupuesto) {
        this.idActPresupuestal = idActPresupuestal;
        this.nomActividadPresupuestal = nomActividadPresupuestal;
        this.montoPresupuestal = montoPresupuestal;
        this.descripcionMonto = descripcionMonto;
        this.idPresupuesto = idPresupuesto;
    }

    /**
     * Metodo get y set
     * @return 
     */
    public int getIdActPresupuestal() {
        return idActPresupuestal;
    }

    public void setIdActPresupuestal(int idActPresupuestal) {
        this.idActPresupuestal = idActPresupuestal;
    }

    public String getNomActividadPresupuestal() {
        return nomActividadPresupuestal;
    }

    public void setNomActividadPresupuestal(String nomActividadPresupuestal) {
        this.nomActividadPresupuestal = nomActividadPresupuestal;
    }

    public int getMontoPresupuestal() {
        return montoPresupuestal;
    }

    public void setMontoPresupuestal(int montoPresupuestal) {
        this.montoPresupuestal = montoPresupuestal;
    }

    public String getDescripcionMonto() {
        return descripcionMonto;
    }

    public void setDescripcionMonto(String descripcionMonto) {
        this.descripcionMonto = descripcionMonto;
    }

    public int getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(int idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    /**
     * Metod hashcode
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idActPresupuestal;
        hash = 67 * hash + Objects.hashCode(this.nomActividadPresupuestal);
        hash = 67 * hash + this.montoPresupuestal;
        hash = 67 * hash + Objects.hashCode(this.descripcionMonto);
        hash = 67 * hash + this.idPresupuesto;
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
        final ActividadPresupuestalDto other = (ActividadPresupuestalDto) obj;
        if (this.idActPresupuestal != other.idActPresupuestal) {
            return false;
        }
        if (!Objects.equals(this.nomActividadPresupuestal, other.nomActividadPresupuestal)) {
            return false;
        }
        if (this.montoPresupuestal != other.montoPresupuestal) {
            return false;
        }
        if (!Objects.equals(this.descripcionMonto, other.descripcionMonto)) {
            return false;
        }
        if (this.idPresupuesto != other.idPresupuesto) {
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
        return "ActividadPresupuestal{" + "idActPresupuestal=" + idActPresupuestal +
                ", nomActividadPresupuestal=" + nomActividadPresupuestal + 
                ", montoPresupuestal=" + montoPresupuestal + ", descripcionMonto=" + descripcionMonto + 
                ", idPresupuesto=" + idPresupuesto + '}';
    }
    
    
    
    
    
    
    
    
    
}
