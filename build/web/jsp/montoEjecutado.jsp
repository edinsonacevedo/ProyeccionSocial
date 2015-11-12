<%-- 
    Document   : mostrarInfoActP
    Created on : 11/11/2015, 04:30:08 PM
    Author     : Edinson
--%>

<%@page import="co.edu.ufps.proyeccionSocial.dto.ActividadPresupuestalDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="facade" scope="page" class="co.edu.ufps.proyeccionSocial.facade.PsocialFacade" />

<%
	//Thread.sleep(5000);
        ActividadPresupuestalDto actP = facade.consultarActPresupuestal(Integer.parseInt(request.getParameter("idActPresupuestal")));
        
        if (actP != null){
            %>
            <label for="montoEjecutado">Monto Ejecutado</label>
            <input id="montoEjecutado" name="montoEjecutado" min="0" type="number" max="<%=actP.getMontoPresupuestal()%>" value="<%=actP.getMontoEjecutado()%>" required>

            <%
            
        }else{
            %>
            <label for="montoEjecutado">Monto Ejecutado</label>
            <input id="montoEjecutado" name="montoEjecutado" min="0" type="number" required>
                                
            <%
        }


%>
                                


 