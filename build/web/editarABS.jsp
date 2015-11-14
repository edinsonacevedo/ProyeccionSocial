<%-- 
    Document   : registrarActividad.jsp
    Created on : 27/10/2015, 01:59:48 PM
    Author     : Edinson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>

<jsp:useBean id="facade" scope="page" class="co.edu.ufps.proyeccionSocial.facade.PsocialFacade" />
<jsp:useBean id="actividadBS" scope="page" class="co.edu.ufps.proyeccionSocial.dto.ActividadBSDto" />
<jsp:setProperty name="actividadBS" property="*"/>
<%
    HttpSession sesion = request.getSession();
    String usuario = (String) sesion.getAttribute("usuario");
    String rol = (String) sesion.getAttribute("rol");
    if (usuario == null || !rol.equalsIgnoreCase("administrador")){

        %>
          <script type="text/javascript"> 
          alert("Debes Iniciar Sesion como Administrador.");
          location.href="index.jsp";
          </script>    
        <%  
               
            }
                
 %>
 
 <%
    
     String fechaAct = request.getParameter("fecha_actividad");
     String[] fecha_act = fechaAct.split("-");
     fechaAct = "";
     
     for (int i = 0 ;i < fecha_act.length; i++ ){
         fechaAct += fecha_act[i];
     }
     
     SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
     Date parsed = format.parse(fechaAct);
     java.sql.Date fechaActividad = new java.sql.Date(parsed.getTime());
     
     
     String fechaAnt = request.getParameter("fecha_anterior");
     String[] fecha_ant = fechaAnt.split("-");
     fechaAnt = "";
     
     for (int i = 0 ;i < fecha_ant.length; i++ ){
         fechaAnt += fecha_ant[i];
     }
     
     Date parsed2 = format.parse(fechaAnt);
     java.sql.Date fechaAnterior = new java.sql.Date(parsed2.getTime());
     boolean error = false;
     
     java.sql.Date actual = new java.sql.Date(System.currentTimeMillis());
     
     if(fechaActividad.before(actual) && !fechaActividad.equals(fechaAnterior) 
                                            && !(fechaActividad.getYear()==actual.getYear() 
                                            && fechaActividad.getMonth()==actual.getMonth()
                                            && fechaActividad.getDay()== actual.getDay())  ){
         %>
         <script type="text/javascript"> 
            alert("Debes seleccionar una fecha valida");
         </script> 
         <%
         error = true;
    }
     
     actividadBS.setFecha(fechaActividad);
     actividadBS.setIdActividadBS(Integer.parseInt(request.getParameter("id")));
     
     if (actividadBS.getPrograma_id() == 0){
         %>
         <script type="text/javascript"> 
            alert("Debes seleccionar un Programa.");
         </script> 
         <%
         error = true;
     }
     
     if (actividadBS.getLider_codigoUFPS() == 0){
         %>
         <script type="text/javascript"> 
            alert("Debes seleccionar un Lider, en caso de no aparecer debes registrarlo.");
         </script> 
         <%
         error = true;
     }
     
     boolean rta = false;
     if (!error){
         rta = facade.editarABS(actividadBS);
     }
     
     
     if (rta){
         %>
         <script type="text/javascript"> 
            alert("se actualizo con exito.");
            location.href="actividadBienestar.jsp?actividad=<%=actividadBS.getIdActividadBS()%>";
         </script> 
         <%
         
     }else{
         %>
         <script type="text/javascript"> 
            alert("Fallo la actualizacion de la actividad, Intente nuevamente.");
            location.href="actividadBienestar.jsp?actividad=<%=actividadBS.getIdActividadBS()%>";
         </script> 
         <%
     }
 %>
