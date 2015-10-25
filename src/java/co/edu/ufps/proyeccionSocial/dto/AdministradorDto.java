
package co.edu.ufps.proyeccionSocial.dto;

import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author Edinson
 */
public class AdministradorDto {
    
    private int codUFPS;
    private String nombre;
    private String correo;
    private String contraseña;

    public AdministradorDto() {
    }



    

    /**
     * Metodo constructor
     * @param codUFPS codigo del administrador
     * @param nombre nombre del administrador
     */
      public AdministradorDto(int codUFPS, String nombre, String correo, String contraseña) {
        this.codUFPS = codUFPS;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }



    /**
     * Metodos get y set
     * @return 
     */
      
        public int getCodUFPS() {    
        return codUFPS;
    }

    public void setCodUFPS(int codUFPS) {
        this.codUFPS = codUFPS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        int hash = 3;
        hash = 59 * hash + this.codUFPS;
        hash = 59 * hash + Objects.hashCode(this.nombre);
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
        final AdministradorDto other = (AdministradorDto) obj;
        if (this.codUFPS != other.codUFPS) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AdministradorDto{" + "codUFPS=" + codUFPS + ", nombre=" + nombre + ", correo=" + correo + '}';
    }

    
    
    
    
}
