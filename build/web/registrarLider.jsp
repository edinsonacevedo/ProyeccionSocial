<%-- 
    Document   : registrarLider
    Created on : 2/11/2015, 01:06:46 PM
    Author     : Edinson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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

<jsp:useBean id="facade" scope="page" class="co.edu.ufps.proyeccionSocial.facade.PsocialFacade" />
<jsp:useBean id="lider" scope="page" class="co.edu.ufps.proyeccionSocial.dto.LiderDto" />
<jsp:setProperty name="lider" property="*"/>

<%
       if (facade.registrarLider(lider)){
           %>
                  <script type="text/javascript"> 
                  alert("Registro Exitoso.");
                  location.href="bienestar.jsp";
                  </script>    
                <%
       }else{
           %>
                  <script type="text/javascript"> 
                  alert("Algo Fallo, intente nuevamente.");
                  location.href="index.jsp";
                  </script>    
                <%
           
           
}
%>
