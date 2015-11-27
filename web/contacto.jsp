<%-- 
    Document   : contacto
    Created on : 15/11/2015, 03:50:06 PM
    Author     : Edinson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="facade" scope="page" class="co.edu.ufps.proyeccionSocial.facade.PsocialFacade"/>
    
<%
    facade.enviarMensajeContacto(request.getParameter("nombre"), request.getParameter("email"), 
            request.getParameter("mensaje"));
    if(true){
    %>
    <script>
        alert("Gracias por contactarse, Muy pronto recibira una respuesta.");
        location.href="index.jsp";
    </script>
  <%  
  }
%>