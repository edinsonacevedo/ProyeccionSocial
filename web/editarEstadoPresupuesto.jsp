<%-- 
    Document   : registrarActividad.jsp
    Created on : 27/10/2015, 01:59:48 PM
    Author     : Edinson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>

<jsp:useBean id="facade" scope="page" class="co.edu.ufps.proyeccionSocial.facade.PsocialFacade" />
<jsp:useBean id="presupuesto" scope="page" class="co.edu.ufps.proyeccionSocial.dto.PresupuestoDto" />
<jsp:setProperty name="presupuesto" property="*"/>
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
    boolean error = false;
     if( request.getParameter("estado_anterior").equalsIgnoreCase("No Asignado")){
         System.out.println("estado No Asignado");
         %>
          <script type="text/javascript"> 
            alert("El Presupuesto no ha sido asignado por el Lider correspondiente, \n\
                 aun no puedes cambiar su estado.");
            location.href="presupuesto.jsp?presupuesto=<%=presupuesto.getIdPresupuesto()%>&nomActividad=<%=request.getParameter("nomActividad")%>&actividad=<%=request.getParameter("actividad")%>";
          </script>    
        <% 
        error = true;
     }
     boolean rta = false;
     if(!error){
            String fechaPre = request.getParameter("fechaP");
            String[] fecha_pre = fechaPre.split("-");
            fechaPre = "";

            for (int i = 0 ;i < fecha_pre.length; i++ ){
                fechaPre += fecha_pre[i];
            }

            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            Date parsed = format.parse(fechaPre);
            java.sql.Date fechaPresupuesto = new java.sql.Date(parsed.getTime());

            presupuesto.setFecha(fechaPresupuesto);
         rta = facade.editarPresupuesto(presupuesto);
     }
     
     if (rta){
         %>
          <script type="text/javascript"> 
            alert("Actualizacion exitosa.");
            location.href="presupuesto.jsp?presupuesto=<%=presupuesto.getIdPresupuesto()%>&nomActividad=<%=request.getParameter("nomActividad")%>&actividad=<%=request.getParameter("actividad")%>";
          </script>    
        <% 
     }else{
         %>
          <script type="text/javascript"> 
            alert("Algo Fallo, Intente nuevamente.");
            location.href="presupuesto.jsp?presupuesto=<%=presupuesto.getIdPresupuesto()%>&nomActividad=<%=request.getParameter("nomActividad")%>&actividad=<%=request.getParameter("actividad")%>";
          </script>    
        <% 
     }
 %>
