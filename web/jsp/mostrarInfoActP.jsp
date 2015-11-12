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

        if(actP != null){
            
            %>
            <label for="nomActividadPresupuestal">Nuevo Nombre</label>
            <input class="capitalize" id="nomActividadPresupuestal" name="nomActividadPresupuestal" type="text" value="<%=actP.getNomActividadPresupuestal()%>" required>

            <label for="montoPresupuestal">Nuevo Monto Presupuestal</label>
            <input id="montoPresupuestal" name="montoPresupuestal" type="number" min="0"   value="<%=actP.getMontoPresupuestal()%>" required>

            <label for="descripcionMonto">Nueva Descripcion</label>
            <textarea id="descripcionMonto" name="descripcionMonto" class="pure-u-1 capitalize"><%=actP.getDescripcionMonto()%></textarea>

            <%
        }else{
            %>
            <label for="nomActividadPresupuestal">Nuevo Nombre</label>
            <input class="capitalize" id="nomActividadPresupuestal" name="nomActividadPresupuestal" type="text" placeholder="Nombre de la actividad" required>

            <label for="montoPresupuestal">Nuevo Monto Presupuestal</label>
            <input id="montoPresupuestal" name="montoPresupuestal" min="0" type="number" placeholder="Cantidad en Pesos" required>

            <label for="descripcionMonto">Nueva Descripcion</label>
            <textarea id="descripcionMonto" name="descripcionMonto" class="pure-u-1 capitalize"></textarea>

            <%
            
            }
%>



    