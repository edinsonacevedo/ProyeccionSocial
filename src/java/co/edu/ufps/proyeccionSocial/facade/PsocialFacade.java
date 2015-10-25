
package co.edu.ufps.proyeccionSocial.facade;

import co.edu.ufps.proyeccionSocial.negocio.negocioMain;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
/**
 *
 * @author Edinson
 */
public class PsocialFacade implements Serializable{
    
    private negocioMain nm = new negocioMain();

    public PsocialFacade() {
    }
    
    public boolean validarSesion(String usuario, String pass, String rol){
        boolean rta = false;
        if (rol.equalsIgnoreCase("administrador"))
            return nm.validarSesionAdmin(usuario, pass);
        
        if (rol.equalsIgnoreCase("lider"))
            return nm.validarSesionLider(usuario, pass);
        
        
        return rta;
    }
            
            
    
}
