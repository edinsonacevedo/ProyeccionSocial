<%-- 
    Document   : registrarActP
    Created on : 2/11/2015, 03:50:41 PM
    Author     : Lenovo
--%>

<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
            HttpSession sesion = request.getSession();
            String usuario = (String) sesion.getAttribute("usuario");
            String rol = (String) sesion.getAttribute("rol");
            if (usuario == null || !rol.equalsIgnoreCase("lider")){
                
                %>
                  <script type="text/javascript"> 
                  alert("Debes Iniciar Sesion como Lider.");
                  location.href="index.jsp";
                  </script>    
                <%  
               
            }
                
        %>
 <jsp:useBean id="facade" scope="page" class="co.edu.ufps.proyeccionSocial.facade.PsocialFacade" />
 <jsp:useBean id="actividadPresupuestal" scope="page" class="co.edu.ufps.proyeccionSocial.dto.ActividadPresupuestalDto" />
 <jsp:setProperty name="actividadPresupuestal" property="*"/>

 <%
            java.sql.Date actual = new Date(System.currentTimeMillis());
            
            boolean rta = false;
            if (!request.getParameter("estado_ant").equalsIgnoreCase("Aprobado")){
                rta = facade.registrarActividadPresupuestal(actividadPresupuestal, actual );
                
                %>
                  <script type="text/javascript"> 
                  alert("El presupuesto ya fue aprobado, por tanto no puedes hacer modificaciones.");
                  location.href="presupuestoL.jsp?presupuesto=<%=actividadPresupuestal.getIdPresupuesto()%>&nomActividad=<%=request.getParameter("nomActividad")%>&actividad=<%=request.getParameter("actividad")%>";
                  </script>    
                <% 
            }
             
            if (!rta){
                %>
                  <script type="text/javascript"> 
                  alert("Algo fallo, Intentalo Nuevamente.");
                  location.href="presupuestoL.jsp?presupuesto=<%=actividadPresupuestal.getIdPresupuesto()%>&nomActividad=<%=request.getParameter("nomActividad")%>&actividad=<%=request.getParameter("actividad")%>";
                  </script>    
                <%  
            }else{
                %>
                  <script type="text/javascript"> 
                  alert("Registro exitoso.");
                  location.href="presupuestoL.jsp?presupuesto=<%=actividadPresupuestal.getIdPresupuesto()%>&nomActividad=<%=request.getParameter("nomActividad")%>&actividad=<%=request.getParameter("actividad")%>";
                  </script>    
                <% 
            }
 %>