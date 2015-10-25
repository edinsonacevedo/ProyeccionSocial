<%-- 
    Document   : validarSesion
    Created on : 21/10/2015, 09:44:59 AM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<jsp:useBean id="facade" scope="page" class="co.edu.ufps.proyeccionSocial.facade.PsocialFacade" />
<%-- usuario,pass, rol--%>

<%
 String usuario = request.getParameter("usuario");
 String pass = request.getParameter("pass");
 String rol = request.getParameter("rol");

%>

<%
  boolean rta = facade.validarSesion(usuario, pass, rol);
              
              if(rta){
                  HttpSession sesion=request.getSession();
                  sesion.setAttribute("usuario",usuario);
                  sesion.setAttribute("rol",rol);
                  if (rol.equalsIgnoreCase("administrador"))
                      response.sendRedirect("bienestar.jsp");  
                  if (rol.equalsIgnoreCase("lider"))
                      response.sendRedirect("lider.jsp");
              }else{
                  %>
                  <script type="text/javascript"> 
                  alert("Algo Fallo... Verifique el Usuario y Contraseña");
                  location.href="index.jsp";
                  </script>  
                  <%
                
              }   
 %>