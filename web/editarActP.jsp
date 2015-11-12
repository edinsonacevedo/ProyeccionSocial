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


<jsp:useBean id="facade" scope="page" class="co.edu.ufps.proyeccionSocial.facade.PsocialFacade" />
 <jsp:useBean id="actividadPresupuestal" scope="page" class="co.edu.ufps.proyeccionSocial.dto.ActividadPresupuestalDto" />
 <jsp:setProperty name="actividadPresupuestal" property="*"/>

 <%
            
            
            boolean rta = false;
            if (!request.getParameter("estado_ant").equalsIgnoreCase("Aprobado") && actividadPresupuestal.getIdActPresupuestal() != 0){
                rta = facade.editarActividadPresupuestal(actividadPresupuestal);
                
               
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
                  alert("El presupuesto ya fue aprobado, por tanto no puedes hacer modificaciones.");
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
                  alert("Registro exitoso.");
                  location.href="presupuestoL.jsp?presupuesto=<%=actividadPresupuestal.getIdPresupuesto()%>&nomActividad=<%=request.getParameter("nomActividad")%>&actividad=<%=request.getParameter("actividad")%>";
                  </script>    
                <% 
            }
 %>