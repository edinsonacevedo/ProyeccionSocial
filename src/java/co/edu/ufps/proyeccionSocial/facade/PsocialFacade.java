
package co.edu.ufps.proyeccionSocial.facade;

import co.edu.ufps.proyeccionSocial.negocio.negocioMain;
import co.edu.ufps.proyeccionSocial.dto.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
/**
 *
 * @author Edinson
 */
public class PsocialFacade implements Serializable{
    
    private final negocioMain nm;

    public PsocialFacade() {
        nm = new negocioMain();
    }
    
    /**
     * Metodo que valida el inicio de sesion de un usuario
     * @param usuario identificacion del usuario
     * @param pass contraseña del usuario
     * @param rol   rol seleccionado por el usuario
     * @return false, si no se puede validar la sesion y true, si el usuario y la conraseña coinciden
     * 
     */
    public boolean validarSesion(String usuario, String pass, String rol){
        boolean rta = false;
        if (rol.equalsIgnoreCase("administrador"))
            return nm.validarSesionAdmin(usuario, pass);
        
        if (rol.equalsIgnoreCase("lider"))
            return nm.validarSesionLider(usuario, pass);
        
        
        return rta;
    }
    
    /**
     * Metodo para registrar una nueva actividad de bienestar social y su correspondiente
     * presupuesto.
     * @param actividadBS
     * @param presupuesto
     * @return 
     */
    public boolean registrarABS(ActividadBSDto actividadBS, PresupuestoDto presupuesto){
        return nm.registrarABS(actividadBS, presupuesto);
    }
    
    /**
     * Metodo que muestra las actividades de bienestar social
     * @return String con  las actividades para ser mostradas  en una tabla
     */
    public String mostrarActividadesBS(){
        return nm.mostrarActividadesBS();
    }
    
    /**
     * Consulta una actividad de bienstar social dado du id
     * @param idABS
     * @return 
     */
    public ActividadBSDto consultarABS( int idABS){
        return nm.consultarABS(idABS);
    }
    
    /**
     * Actualiza la info de una actividad de bienestar social
     * @param actividadBSDto
     * @return 
     */
    public boolean editarABS(ActividadBSDto actividadBSDto){
        return nm.editarABS(actividadBSDto);
    }
    
    /**
     * consultar un presupuesto dado su id
     * @param idPresupuesto
     * @return 
     */
    public PresupuestoDto consultarPresupuesto(int idPresupuesto){
        return nm.consultarPresupuesto(idPresupuesto);
    }
    
    /**
     * muestra las actividades asignadas a un presupuesto dado su id
     * @param idPresupuesto
     * @return 
     */
    public String mostrarActividadesPresupuestales(int idPresupuesto){
        return nm.mostrarActividadesPresupuestales(idPresupuesto);
    }
    
    /**
     * edita la info de un presupuesto
     * @param presupuesto
     * @return 
     */
    public boolean editarPresupuesto(PresupuestoDto presupuesto){
        return nm.editarPresupuesto(presupuesto);
    }
         
    /**
     * muestra las actividades asignadas a un lider
     * @param codLider
     * @return 
     */
    public String mostrarAsignadasLider(int codLider){
        return nm.mostrarActAsignadasLider(codLider);
    }
    
    /**
     * registra un nuevo lider
     * @param lider
     * @return 
     */
    public boolean registrarLider(LiderDto lider){
        return nm.registrarLider(lider);
    }
    
    /**
     * muestra los liders registrados en formato opcion 
     * @return 
     */
    public String mostrarLideres(){
        return nm.mostrarLideres();
    }
     
    /**
     * registra una actividad presupuestal
     * @param actividadP
     * @param actual
     * @return 
     */
    public boolean registrarActividadPresupuestal(ActividadPresupuestalDto actividadP, Date actual){
        return nm.registrarActividadPresupuestal(actividadP, actual);
    }
    
}
