
package co.edu.ufps.proyeccionSocial.negocio;

/**
 *
 * @author Edinson
 */

import java.io.Serializable;
import java.util.ArrayList;
import co.edu.ufps.proyeccionSocial.dao.*;
import co.edu.ufps.proyeccionSocial.dto.*;
import co.edu.ufps.proyeccionSocial.util.conexion.ServicioEmail;
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
                
            rta += "<td><a href=\"actividadBienestar.jsp?actividad="+a.getIdActividadBS()+"\" class=\"capitalize\">"+a.getNombre()+"</a></td>\n"+
                    "<td >"+a.getFecha()+"</td>\n"+
                    "<td>"+a.getLugar().toLowerCase()+"</td>\n"+
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
            return "";
        
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
                
            rta += "<td class=\"capitalize\">"+a.getNomActividadPresupuestal()+"</a></td>\n"+
                    "<td>"+a.getMontoPresupuestal()+"</td>\n"+
                    "<td>"+a.getDescripcionMonto().toLowerCase()+"</td>\n"+
                    "<td>"+a.getMontoEjecutado()+"</td>\n"+
                    "</tr>\n";
        }
        
        
        return rta;
    }
    
    /**
     * lista las actividades presupuestales para ser mostradas en un select
     * @param idPresupuesto
     * @return 
     */
    public String listarActividadesPresupuestales(int idPresupuesto){
        String rta = "";
        
        ArrayList<ActividadPresupuestalDto> AP = new ActividadPresupuestalDao().cargarActividadesPresupuestales(idPresupuesto);
        
        if (AP.isEmpty())
            return "";
        
      
        for (ActividadPresupuestalDto a: AP){
            
            rta += "<option value=\""+a.getIdActPresupuestal()+"\">"+a.getIdActPresupuestal()+" - "+a.getNomActividadPresupuestal()+"</option>\n";
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
            return "";
        
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
                
            rta += "<td><a href=\"actividadAsignadaP.jsp?actividad="+a.getIdActividadPS()+"\" class=\"capitalize\">"+a.getNombre()+"</a></td>\n"+
                    "<td>"+a.getFecha()+"</td>\n"+
                    "<td>"+a.getLugar().toLowerCase()+"</td>\n"+
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
                
            rta += "<td><a href=\"actividadAsignadaB.jsp?actividad="+a.getIdActividadBS()+"\" class=\"capitalize\">"+a.getNombre()+"</a></td>\n"+
                    "<td>"+a.getFecha()+"</td>\n"+
                    "<td>"+a.getLugar().toLowerCase()+"</td>\n"+
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
    
    /**
     * consulta una actividad presupuestal dado su id
     * @param idActividad
     * @return 
     */
    public ActividadPresupuestalDto consultarActPresupuestal(int idActividad){
        return new ActividadPresupuestalDao().consultarActividadPresupuestal(idActividad);
    }
    /**
     * edita la info de una actividad presupuestal
     * @param actividadPresupuestal
     * @return 
     */
    public boolean editarActividadPresupuestal(ActividadPresupuestalDto actividadPresupuestal){
        boolean rta = false;
        
        ActividadPresupuestalDto act = new ActividadPresupuestalDao().
                consultarActividadPresupuestal(actividadPresupuestal.getIdActPresupuestal());
        
        PresupuestoDto presupuesto = new PresupuestoDao().consultarPresupuestoDao(act.getIdPresupuesto());
        double montoPresupuesto = presupuesto.getMonto();
       
        if (act.getMontoPresupuestal() > actividadPresupuestal.getMontoPresupuestal()){
            montoPresupuesto = montoPresupuesto - (act.getMontoPresupuestal() - actividadPresupuestal.getMontoPresupuestal());
        }else{
            montoPresupuesto = montoPresupuesto + (actividadPresupuestal.getMontoPresupuestal() - act.getMontoPresupuestal());
        
        }
        
        presupuesto.setMonto(montoPresupuesto);
        
        boolean rtap = new PresupuestoDao().actualizarPresupuesto(presupuesto);
        
        if (rtap) {
            
            rta = new ActividadPresupuestalDao().actualizarActividadPresupuestal(actividadPresupuestal);
        }
        
        
        return rta;
    }
    
    /**
     * ejecuta el monto de una actividad presupuestal
     * @param actividadPresupuestal
     * @return 
     */
    public boolean ejecutarActividadPresupuestal(ActividadPresupuestalDto actividadPresupuestal){
        boolean rta = false;
        
        rta = new ActividadPresupuestalDao().ejecutarActividadPresupuestal(actividadPresupuestal);
        
        return rta;
    }
    
    /**
     * Borra una actividad presupuestal y actualiza el monto del presupuesto.
     * @param idActPresupuestal
     * @param idPresupuesto
     * @return 
     */
    public boolean borrarActividadPresupuestal(int idActPresupuestal, int idPresupuesto){
        
        ActividadPresupuestalDto actp = new ActividadPresupuestalDao().consultarActividadPresupuestal(idActPresupuestal);
        boolean rta = new ActividadPresupuestalDao().borrarActividadPresupuestal(idActPresupuestal);
        boolean r = false;
        if (rta) {
            
            PresupuestoDto p = new PresupuestoDao().consultarPresupuestoDao(idPresupuesto);
            p.setMonto(p.getMonto()-actp.getMontoPresupuestal());
            if(p.getMonto()==0){
                p.setEstado("No Asignado");
                p.setFecha(null);
            }
            
            r = new PresupuestoDao().actualizarPresupuesto(p);
        }
        
        return (rta && r);
    }
    
    /**
     * registra un nueva entidad
     * @param entidad
     * @return 
     */
    public boolean registrarEntidad(EntidadDto entidad){
        return new EntidadDao().registrarEntidadDao(entidad);
    }
    
    /**
     * contatena las entidades en opciones para ser mostradas en un select
     * @return 
     */
    public String mostrarEntidades(){
        String rta = "";
        
        ArrayList<EntidadDto> entidades = new EntidadDao().cargarEntidadesDao();
        
        for(EntidadDto e : entidades){
            
            rta += "<option value=\""+e.getIdEntidad()+"\">"+e.getIdEntidad()+"-"+e.getNombre()+"</option>\n";
            
        }
        
        return rta;
    }
    
    /**
     * Registra un nuevo convenio
     * @param convenio
     * @return 
     */
    public boolean registrarConvenio(ConvenioDto convenio){
        return new ConvenioDao().registrarConvenioDao(convenio);
    }
    
    /**
     * Muestra los convenios en formato tabla
     * @return 
     */
    public String mostrarConveniosTabla(){
        
        String rta = "";
        
        ArrayList<ConvenioDto> convenios = new ConvenioDao().cargarConveniosDao();
        
        if (!convenios.isEmpty()) {
            
            for (ConvenioDto c : convenios) {
                
                rta += "<tr>\n"
                    +"<td>"+c.getNombre()+"</td>\n"
                    +"<td>"+c.getFecha()+"</td>\n"
                    +"<td>"+new ProgramaDao().consultarProgramaDao(c.getPrograma_id()).getNombre()+"</td>\n"
                    +"<td>"+new EntidadDao().consultarEntidadDao(c.getEntidad_id()).getNombre()+"</td>\n"
                +"</tr>\n";
            }
        }
        
        return rta;
    }
    
    /**
     * Muestra los programas en formato option de un select
     * @return 
     */
    public String mostrarProgramasOption(){
        
        String rta = "";
        
        ArrayList<ProgramaDto> programas = new ProgramaDao().cargarProgramasDao();
        
        for(ProgramaDto p : programas){
            
            rta += "<option value=\""+p.getIdPrograma()+"\">"+p.getIdPrograma()+" - "+p.getNombre()+"</option>\n";
            
        }
        
        return rta;
    }
    
    /**
     * Lista todos los convenios en formato opcion dde un select
     * @return 
     */
    public String mostrarConveniosOption(){
        String rta = "";
        
        ArrayList<ConvenioDto> convenios = new ConvenioDao().cargarConveniosDao();
        
        for (ConvenioDto convenio : convenios) {
            
            rta += "<option value=\""+convenio.getIdConvenio()+"\">"+convenio.getIdConvenio()+" - "+convenio.getNombre()+"</option>\n";
            
        }
        
        return rta;
        
    }
    
    /**
     * consulta un convenio por su id
     * @param idConvenio
     * @return 
     */
    public ConvenioDto consultarConvenio(int idConvenio){
        return new ConvenioDao().consultarConvenioDao(idConvenio);
    }
    
    /**
     * actualiza la informacion de un convenio
     * @param convenio
     * @return 
     */
    public boolean editarConvenio(ConvenioDto convenio){
        
        return new ConvenioDao().actualizarConvenioDao(convenio);
    }
    
    public String mostrarActividadesPS(){
        String rta = "";
        
        ArrayList<ActividadPSDto> Aps = new ActividadPSDao().cargarActividadesPSDao();
        
        if (Aps.isEmpty())
            return "";
        
        String n = "<tr class=\"pure-table-odd\">\n";
        boolean x = false;
        for (ActividadPSDto a: Aps){
            if (x){
                rta += n;
                x = false;
            }else{
                 rta += "<tr>\n";
                 x = true;
            }
                
            rta += "<td><a href=\"actividadProyeccion.jsp?actividad="+a.getIdActividadPS()+"\" class=\"capitalize\">"+a.getNombre()+"</a></td>\n"+
                    "<td >"+a.getFecha()+"</td>\n"+
                    "<td>"+a.getLugar().toLowerCase()+"</td>\n"+
                    "<td>"+a.getEstado()+"</td>\n"+
                    "<td>"+new ConvenioDao().consultarConvenioDao(a.getConvenio_id()).getNombre()+"</td>\n"+
                    "</tr>\n";
        }
        
        
        return rta;
    }
    
    
    /**
     * Registra una actividad de proyeccion social
     * @param actividadPS
     * @param presupuesto
     * @return 
     */
    public boolean registrarAPS(ActividadPSDto actividadPS, PresupuestoDto presupuesto){
        boolean rta = false;
        presupuesto.setEstado("No Asignado");
        
        int presupuesto_id = new PresupuestoDao().registrarPresupuestoDao(presupuesto);
        
        if (presupuesto_id == 0)
            return rta;
        
        actividadPS.setPresupesto_id(presupuesto_id);
        
        if (new ActividadPSDao().registrarActividadPSDao(actividadPS)){
            rta = true;
        }else{
            boolean r = new PresupuestoDao().eliminarPresupuestoDao(presupuesto_id);
                    
        }
        
        return rta;
            
    }
    
    /**
     * Consulta una actividad de proyeccion
     * dado su id
     * @param idAPS
     * @return 
     */
    public ActividadPSDto consultarAPS(int idAPS){
        return new ActividadPSDao().consultarActividadPSDao(idAPS);
    }
    
    /***
     * Actualiza la informacion de una 
     * actividad de proyeccioin social
     * @param actividadPS
     * @return 
     */
    public boolean editarAPS(ActividadPSDto actividadPS){
        return new ActividadPSDao().actualizarActividadPSDao(actividadPS);
    }
    
    /**
     * Envia un mensaje al de contacto
     * @param nombre
     * @param correo
     * @param mensaje 
     */
    public void enviarMensajeContacto( String nombre, String correo, String mensaje){
        String cMensaje = "Nombre : "+nombre+"\n";
                cMensaje += "Mensaje : "+mensaje+"\n";
                cMensaje += "Contacto : "+correo+"\n";
        ServicioEmail e = new ServicioEmail("mensajespsocial@gmail.com", "ingsistemas");
        e.enviarEmail("contactopsocial@gmail.com", "Mensaje de Contacto", cMensaje);
    }
    
    /**
     * Muestra las actividades de proyeccion y bienestar en formato calendario
     * @return 
     */
    public String mostrarActividadesCalendario(){
        ArrayList<ActividadBSDto> actBienestar = new ActividadBSDao().cargarActividadesBSDao();
        ArrayList<ActividadPSDto> actProyeccion = new ActividadPSDao().cargarActividadesPSDao();
        
        String rta = "";
        
        for (ActividadPSDto ap : actProyeccion) {
            if (ap.getEstado().equalsIgnoreCase("En Curso")) {
               rta += "<div data-role=\"day\" data-day=\""+this.eliminarCeros(""+ap.getFecha())+"\">\n"
		      +"<div data-role=\"event\" data-name=\""+ap.getNombre()+"\" data-start=\"Hora\" data-end=\""+ap.getHora()+"\" data-location=\"Lugar - "+ap.getLugar()+"\"></div>\n"
                  +"</div>\n"; 
            }
           
        }
        
        for (ActividadBSDto ab : actBienestar) {
            if (ab.getEstado().equalsIgnoreCase("En Curso")) {
                 rta += "<div data-role=\"day\" data-day=\""+this.eliminarCeros(""+ab.getFecha())+"\">\n"
		      +"<div data-role=\"event\" data-name=\""+ab.getNombre()+"\" data-start=\"Hora\" data-end=\""+ab.getHora()+"\" data-location=\"Lugar - "+ab.getLugar()+"\"></div>\n"
                  +"</div>\n";
            }
           
            
        }
         System.out.println(rta);
        return rta;
    }
    
    /**
     * Elimina los ceros a la izquierda 
     * del mes y el dia 
     * @param anio
     * @param mes
     * @param dia
     * @return la fecha sin ceros "ej. (AAAAMMDD)20151105 --> 2015115"
     */
    private String eliminarCeros(String f){
        String r[] = f.split("-");
                
        String rta = r[0];
        int mes = Integer.parseInt(r[1]);
        int dia = Integer.parseInt(r[2]);
        if(mes < 10){
            String mm = ""+mes;
            char m[] = mm.toCharArray();
            rta += m[1];
        }else{
            rta += mes;
        }
        
        if(dia < 10){
            String dd = ""+dia;
            char d[] = dd.toCharArray();
            rta += d[0];
        }else{
            rta += dia;
        }
       
        return rta;
    }
}
