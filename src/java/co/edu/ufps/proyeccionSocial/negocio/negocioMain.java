
package co.edu.ufps.proyeccionSocial.negocio;

/**
 *
 * @author Edinson
 */

import java.io.Serializable;
import co.edu.ufps.proyeccionSocial.dao.*;
import co.edu.ufps.proyeccionSocial.dto.*;

public class negocioMain implements Serializable{
    
    /**
     * Metodo que valida cuando un administrador inicia sesion
     * @param usuario codigo del usuario ingresado
     * @param pass contraseña ingresada
     * @return 
     */
    public boolean validarSesionAdmin(String usuario, String pass){
        boolean rta = false;
        
        AdministradorDto myAdmin = new AdminDao().consultarAdministrador(Integer.parseInt(usuario));
        
        if (myAdmin!= null && myAdmin.getContraseña().equalsIgnoreCase(pass))
            rta = true;
         
        return rta;
    
    }
    
    public boolean validarSesionLider(String usuario, String pass){
        boolean rta = false;
        
        LiderDto myLider = new LiderDao().consultarLider(Integer.parseInt(usuario));
        
        if (myLider != null && myLider.getContraseña().equalsIgnoreCase(pass))
            rta = true;
        
        return rta;
    }
    
}
