
package co.edu.ufps.proyeccionSocial.negocio;

/**
 *
 * @author Edinson
 */

import java.io.Serializable;
import java.util.ArrayList;
import co.edu.ufps.proyeccionSocial.dao.*;
import co.edu.ufps.proyeccionSocial.dto.*;
import java.sql.Date;

public class negocioMain implements Serializable{

    public negocioMain() {
    }
    
    
    
    
    /**
     * Metodo que valida cuando un administrador inicia sesion
     * @param usuario codigo del usuario ingresado
     * @param pass contraseña ingresada
     * @return false, si los datos no concuerdad y true, si el usuario y la contraseña 
     * coinciden
     */
    public boolean validarSesionAdmin(String usuario, String pass){
        boolean rta = false;
        
        AdministradorDto myAdmin = new AdminDao().consultarAdministrador(Integer.parseInt(usuario));
        
        if (myAdmin!= null && myAdmin.getContraseña().equalsIgnoreCase(pass))
            rta = true;
         
        return rta;
    
    }
    
    /**
     * Metodo que valida cuando un lider inicia sesion
     * @param usuario codigo del usuario ingresado
     * @param pass contraseña ingresada
     * @return false, si los datos no concuerdad y true, si el usuario y la contraseña 
     * coinciden
     */
    public boolean validarSesionLider(String usuario, String pass){
        boolean rta = false;
        
        LiderDto myLider = new LiderDao().consultarLider(Integer.parseInt(usuario));
        
        if (myLider != null && myLider.getContraseña().equalsIgnoreCase(pass))
            rta = true;
        
        return rta;
    }
    
    /**
     * Metodo que Registra una nuva actividad de bienestar social y su respectivo presupuecto.
     * @param actividadBS
     * @param presupuesto
     * @return true, si todo sale bien y false, si algo falla.
     */ 
    public boolean registrarABS(ActividadBSDto actividadBS, PresupuestoDto presupuesto){
        boolean rta = false;
        presupuesto.setEstado("No Asignado");
        
        int presupuesto_id = new PresupuestoDao().registrarPresupuestoDao(presupuesto);
        
        if (presupuesto_id == 0)
            return rta;
        
        actividadBS.setPresupuesto_id(presupuesto_id);
        
        if (new ActividadBSDao().registrarActividadBS(actividadBS)){
            rta = true;
        }else{
            boolean r = new PresupuestoDao().eliminarPresupuestoDao(presupuesto_id);
                    
        }
        
        return rta;
            
    }
    
    /**
     * Metodo que concatena todas las actividades de bienestar social en un string
     * con el formatos para ser mostradas en una tabla 
     * @return 
     */
    public String mostrarActividadesBS(){
        String rta = "";
        
        ArrayList<ActividadBSDto> Abs = new ActividadBSDao().cargarActividadesBSDao();
        
        if (Abs.isEmpty())
            return "No existen Actividades Registradas";
        
        String n = "<tr class=\"pure-table-odd\">\n";
        boolean x = false;
        for (ActividadBSDto a: Abs){
            if (x){
                rta += n;
                x = false;
            }else{
                 rta += "<tr>\n";
                 x = true;
            }
                
            rta += "<td><a href=\"actividadBienestar.jsp?actividad="+a.getIdActividadBS()+"\" class=\"mayuscula\">"+a.getNombre()+"</a></td>\n"+
                    "<td>"+a.getFecha()+"</td>\n"+
                    "<td>"+a.getLugar()+"</td>\n"+
                    "<td>"+a.getEstado()+"</td>\n"+
                    "</tr>\n";
        }
        /**<tr class="pure-table-odd">
                <td><input id="opcionABS" type="radio" name="opcionABS" value="option2"></td>
                <td><a href="">Integracion</a></td>
                <td>16/09/2015</td>
                <td>centro recreativo</td>
                <td>en curso</td>
        </tr>**/
        
        return rta;
    }
    
    /**
     * Metodo que consulta una actividad de bienestar social por su id
     * @param idAABS id de la actividad a consultar
     * @return objeto de tipo ActividadBSDto con la la info de la actividad consultada
     */
    public ActividadBSDto consultarABS(int idAABS){
        return new ActividadBSDao().consultarActividadBS(idAABS);
    }
    
    /**
     * Metodo que edita la info de una actividad de bienestar social
     * @param actividadBS
     * @return true, si se actualizada la info sin incoveniente y false, si sucede lo contrario
     */
    public boolean editarABS(ActividadBSDto actividadBS){
        return new ActividadBSDao().actualizarActividad(actividadBS);
    }
    
    /**
     * consulta un presuouesto dado su id
     * @param idPresupuesto
     * @return 
     */
    public PresupuestoDto consultarPresupuesto(int idPresupuesto){
        return new PresupuestoDao().consultarPresupuestoDao(idPresupuesto);
    }
    
    /**
     * muestra las actividades presupuestales asignadas a un presupuesto
     * en formato de tabla
     * @param idPresupuesto
     * @return 
     */
    public String mostrarActividadesPresupuestales(int idPresupuesto){
        String rta = "";
        
        ArrayList<ActividadPresupuestalDto> AP = new ActividadPresupuestalDao().cargarActividadesPresupuestales(idPresupuesto);
        
        if (AP.isEmpty())
            return "No existen Actividades Presupuestales";
        
        String n = "<tr class=\"pure-table-odd\">\n";
        boolean x = false;
        for (ActividadPresupuestalDto a: AP){
            if (x){
                rta += n;
                x = false;
            }else{
                 rta += "<tr>\n";
                 x = true;
            }
                
            rta += "<td>"+a.getNomActividadPresupuestal()+"</a></td>\n"+
                    "<td>"+a.getMontoPresupuestal()+"</td>\n"+
                    "<td>"+a.getDescripcionMonto()+"</td>\n"+
                    "</tr>\n";
        }
        
        
        return rta;
    }
    
    /**
     * Edita la info de un presupuesto
     * @param presupuesto
     * @return 
     */
    public boolean editarPresupuesto(PresupuestoDto presupuesto){
        return new PresupuestoDao().actualizarPresupuesto(presupuesto);
    }
    
    /**
     * muestra en formato tabla las actividades asignadas a un lider
     * @param codlider
     * @return 
     */
    public String mostrarActAsignadasLider(int codlider){
        String rta = "";
        
        ArrayList<ActividadBSDto> AB = new ActividadBSDao().asignadasLiderDao(codlider);
        ArrayList<ActividadPSDto> AP = new ActividadPSDao().asignadasLiderDao(codlider);
        
        if (AP.isEmpty() && AB.isEmpty())
            return "No existen Actividades Presupuestales";
        
        String n = "<tr class=\"pure-table-odd\">\n";
        boolean x = false;
        for (ActividadPSDto a: AP){
            if (x){
                rta += n;
                x = false;
            }else{
                 rta += "<tr>\n";
                 x = true;
            }
                
            rta += "<td><a href=\"actividadAsignadaP.jsp?actividad="+a.getIdActividadPS()+"\" class=\"mayuscula\">"+a.getNombre()+"</a></td>\n"+
                    "<td>"+a.getFecha()+"</td>\n"+
                    "<td>"+a.getLugar()+"</td>\n"+
                    "<td>"+a.getEstado()+"</td>\n"+
                    "</tr>\n";
        }
        
        for (ActividadBSDto a: AB){
            if (x){
                rta += n;
                x = false;
            }else{
                 rta += "<tr>\n";
                 x = true;
            }
                
            rta += "<td><a href=\"actividadAsignadaB.jsp?actividad="+a.getIdActividadBS()+"\" class=\"mayuscula\">"+a.getNombre()+"</a></td>\n"+
                    "<td>"+a.getFecha()+"</td>\n"+
                    "<td>"+a.getLugar()+"</td>\n"+
                    "<td>"+a.getEstado()+"</td>\n"+
                    "</tr>\n";
        }
        
        
        return rta;
    }
    
    /**
     * registra un lider
     * @param lider
     * @return 
     */
    public boolean registrarLider(LiderDto lider){
        return  new LiderDao().registrarliderDao(lider);
    }
    
    /**
     * muestra los lideres en gormato opcion de un select
     * @return 
     */
    public String mostrarLideres(){
        String rta = "";
        
        ArrayList<LiderDto> lideres = new LiderDao().cargarLideresDao();
        
        for(LiderDto l : lideres){
            
            rta += "<option value=\""+l.getCodigoUFPS()+"\">"+l.getCodigoUFPS()+"-"+l.getNombre()+"</option>\n";
            
        }
        
        return rta;
    }
    
    public boolean registrarActividadPresupuestal(ActividadPresupuestalDto actividadP, Date actual){
        
        boolean rta = false;
        boolean rta2 = false;
        
        rta = new ActividadPresupuestalDao().registrarActividadPresupuestal(actividadP);
        
        if (rta){
            PresupuestoDto p = new PresupuestoDao().consultarPresupuestoDao(actividadP.getIdPresupuesto());
            p.setFecha(actual);
            p.setMonto(p.getMonto()+actividadP.getMontoPresupuestal());
            p.setEstado("En espera");
            rta2 = new PresupuestoDao().actualizarPresupuesto(p);
        }
        
        if (!rta2){
            
            //eliminar actividad presupuestal
        }
        
        return (rta && rta2);
        
    }
    
}
