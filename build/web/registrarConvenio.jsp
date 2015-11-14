<%-- 
    Document   : registrarConvenio.jsp
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
    
    
     String fechaCon = request.getParameter("fecha_convenio");
     String[] fecha_con = fechaCon.split("-");
     fechaCon = "";
     
     for (int i = 0 ;i < fecha_con.length; i++ ){
         fechaCon += fecha_con[i];
     }
     
     SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
     Date parsed = format.parse(fechaCon);
     java.sql.Date fechaConvenio = new java.sql.Date(parsed.getTime());
     
     
     java.sql.Date actual = new java.sql.Date(System.currentTimeMillis());
     
     boolean error = false;
   
     
     if(fechaConvenio.before(actual) && !(fechaConvenio.getYear()==actual.getYear() 
                                            && fechaConvenio.getMonth()==actual.getMonth()
                                            && fechaConvenio.getDay()== actual.getDay())){
         %>
         <script type="text/javascript"> 
            alert("Debes seleccionar una fecha valida");
         </script> 
         <%
         error = true;
    }
     
     convenio.setFecha(fechaConvenio);
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
            alert("Debes seleccionar una Entidad, en caso de no aparecer debes registrarla.");
         </script> 
         <%
         error = true;
     }
     
   
   
     
     boolean rta = false;
     if (!error){
         rta = facade.registrarConvenio(convenio);
     }
     
     
     if (rta){
         %>
         <script type="text/javascript"> 
            alert("Registro exitoso.");
            location.href="convenio.jsp";
         </script> 
         <%
         
     }else{
         %>
         <script type="text/javascript"> 
            alert("Fallo el registro del Convenio, Intente nuevamente.");
            location.href="convenio.jsp";
         </script> 
         <%
     }
 %>
