
package co.edu.ufps.proyeccionSocial.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Edinson
 */
public class LiderDto  implements Serializable{
    
    private int codigoUFPS;
    private String nombre;
    private String cargo;
    private String correo;
    private String contraseña;

    public LiderDto() {
    }

    

    /**
     * Metodo constructor
     * @param codigoUFPS codigo del lider
     * @param nombre nombre del lider
     * @param cargo cargo del lider
     */
   
    public LiderDto(int codigoUFPS, String nombre, String cargo, String correo, String contraseña) {
        this.codigoUFPS = codigoUFPS;
        this.nombre = nombre;
        this.cargo = cargo;
        this.correo = correo;
        this.contraseña = contraseña;
    }


    /**
     * metodos get y set
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Metodo hashcode
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.codigoUFPS;
        hash = 31 * hash + Objects.hashCode(this.nombre);
        hash = 31 * hash + Objects.hashCode(this.cargo);
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
        final LiderDto other = (LiderDto) obj;
        if (this.codigoUFPS != other.codigoUFPS) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.cargo, other.cargo)) {
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
        return "LiderDto{" + "codigoUFPS=" + codigoUFPS + ", nombre=" + nombre + 
                ", cargo=" + cargo + ", correo=" + correo + '}';
    }
    
    
    
    
    
}
