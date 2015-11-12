<%-- 
    Document   : editarActP
    Created on : 11/11/2015, 07:25:14 PM
    Author     : Edinson
--%>

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

<%@page import="co.edu.ufps.proyeccionSocial.dto.ActividadPresupuestalDto"%>
<jsp:useBean id="facade" scope="page" class="co.edu.ufps.proyeccionSocial.facade.PsocialFacade" />

 <%
            
            ActividadPresupuestalDto actividadPresupuestal = new ActividadPresupuestalDto(Integer.parseInt(request.getParameter("idActPresupuestal")),
                    "", 0, "", Integer.parseInt(request.getParameter("idPresupuesto")), Integer.parseInt(request.getParameter("montoEjecutado")));
           
            boolean rta = false;
            if (request.getParameter("estado_ant").equalsIgnoreCase("Aprobado") && actividadPresupuestal.getIdActPresupuestal() != 0){
                rta = facade.ejecutarActividadPresupuestal(actividadPresupuestal);
                
               
            }else{
                if(actividadPresupuestal.getIdActPresupuestal() == 0){
                    %>
                        <script type="text/javascript"> 
                        alert("Selecciona una Actividad Presupuestal.");
                        location.href="presupuestoL.jsp?presupuesto=<%=actividadPresupuestal.getIdPresupuesto()%>&nomActividad=<%=request.getParameter("nomActividad")%>&actividad=<%=request.getParameter("actividad")%>";
                        </script>    
                    <% 
                }else{
                 %>
                  <script type="text/javascript"> 
                  alert("El presupuesto no ha sido Aprobado, por tanto aun no puedes Ejecutar presupuesto.");
                  location.href="presupuestoL.jsp?presupuesto=<%=actividadPresupuestal.getIdPresupuesto()%>&nomActividad=<%=request.getParameter("nomActividad")%>&actividad=<%=request.getParameter("actividad")%>";
                  </script>    
                <% 
                }
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
                  alert("Ejecucion exitosa.");
                  location.href="presupuestoL.jsp?presupuesto=<%=actividadPresupuestal.getIdPresupuesto()%>&nomActividad=<%=request.getParameter("nomActividad")%>&actividad=<%=request.getParameter("actividad")%>";
                  </script>    
                <% 
            }
 %>