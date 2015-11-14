<%-- 
    Document   : registrarActividad.jsp
    Created on : 27/10/2015, 01:59:48 PM
    Author     : Edinson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>

<jsp:useBean id="facade" scope="page" class="co.edu.ufps.proyeccionSocial.facade.PsocialFacade" />
<jsp:useBean id="convenio" scope="page" class="co.edu.ufps.proyeccionSocial.dto.ConvenioDto" />
<jsp:setProperty name="convenio" property="*"/>
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
    
     String fechaConv = request.getParameter("fecha_convenio");
     String[] fecha_conv = fechaConv.split("-");
     fechaConv = "";
     
     for (int i = 0 ;i < fecha_conv.length; i++ ){
         fechaConv += fecha_conv[i];
     }
     
     SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
     Date parsed = format.parse(fechaConv);
     java.sql.Date fechaConvenio = new java.sql.Date(parsed.getTime());
     
     
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
     
     if(convenio.getIdConvenio() == 0){
         %>
         <script type="text/javascript"> 
            alert("Debes seleccionar un Convenio.");
         </script> 
         <%
         error = true;
    }
     
     if(fechaConvenio.before(actual) && !fechaConvenio.equals(fechaAnterior) 
                                            && !(fechaConvenio.getYear()==actual.getYear() 
                                            && fechaConvenio.getMonth()==actual.getMonth()
                                            && fechaConvenio.getDay()== actual.getDay())  ){
         %>
         <script type="text/javascript"> 
            alert("Debes seleccionar una fecha valida");
         </script> 
         <%
         error = true;
    }
     
     convenio.setFecha(fechaConvenio);
     //actividadBS.setIdActividadBS(Integer.parseInt(request.getParameter("id")));
     
     if (convenio.getPrograma_id() == 0){
         %>
         <script type="text/javascript"> 
            alert("Debes seleccionar un Programa.");
         </script> 
         <%
         
         error = true;
     }
     
     if (convenio.getEntidad_id() == 0){
         %>
         <script type="text/javascript"> 
            alert("Debes seleccionar una entidad, en caso de no aparecer debes registrarla.");
         </script> 
         <%
         error = true;
     }
     
     boolean rta = false;
     if (!error){
         rta = facade.editarConvenio(convenio);
     }
     
     
     if (rta){
         %>
         <script type="text/javascript"> 
            alert("El convenio se actualizo con exito.");
            location.href="convenio.jsp";
         </script> 
         <%
         
     }else{
         %>
         <script type="text/javascript"> 
            alert("Fallo la actualizacion del convenio, Intente nuevamente.");
            location.href="convenio.jsp";
         </script> 
         <%
     }
 %>
