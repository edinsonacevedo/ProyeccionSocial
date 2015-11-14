<%-- 
    Document   : registrarEntidad.jsp
    Created on : 27/10/2015, 01:59:48 PM
    Author     : Edinson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<jsp:useBean id="facade" scope="page" class="co.edu.ufps.proyeccionSocial.facade.PsocialFacade" />
<jsp:useBean id="entidad" scope="page" class="co.edu.ufps.proyeccionSocial.dto.EntidadDto" />
<jsp:setProperty name="entidad" property="*"/>
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
   
    boolean rta = facade.registrarEntidad(entidad);
    
    if(!rta){
        %>
          <script type="text/javascript"> 
          alert("Fallo el Registro de la Entidad, Intente Nuevamente.");
          location.href="convenio.jsp";
          </script>    
        <% 
    }else{
        %>
          <script type="text/javascript"> 
          alert("La entidad <%=entidad.getNombre()%> se registro con exito.");
          location.href="convenio.jsp";
          </script>    
        <% 
    }
 %>
 
 
