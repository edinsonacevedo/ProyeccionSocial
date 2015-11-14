<%-- 
    Document   : mostrarInfoActP
    Created on : 11/11/2015, 04:30:08 PM
    Author     : Edinson
--%>

<%@page import="co.edu.ufps.proyeccionSocial.dto.ConvenioDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="facade" scope="page" class="co.edu.ufps.proyeccionSocial.facade.PsocialFacade" />

<%
	//Thread.sleep(5000);
        ConvenioDto conv = facade.consultarConvenio(Integer.parseInt(request.getParameter("idConvenio")));

        if(conv != null){
            
            %>
            <label for="nombre">Nombre del Convenio</label>
            <input id="nombre" name="nombre" type="text" value="<%=conv.getNombre()%>" required>

            <label for="fecha_convenio">Fecha</label>
            <input id="fecha_convenio" name="fecha_convenio" type="date" value="<%=conv.getFecha()%>" required>
            <input id="fecha_anterior" name="fecha_anterior"  type="hidden" value="<%=conv.getFecha()%>">

            <label for="programa_id">Programa</label>
            <select id="programa_id" name="programa_id" class="pure-u-1" >
                <option value="0">Seleccione:</option>
                <option value="<%=conv.getPrograma_id()%>" selected> <%=conv.getPrograma_id()%> - </option>
                <%=facade.mostrarProgramasOption()%>
            </select>

            <label for="entidad_id">Entidad</label>
            <select id="entidad_id" name="entidad_id" class="pure-u-1">
                <option value="0">Seleccione:</option>
                <option value="<%=conv.getEntidad_id()%>" selected><%=conv.getEntidad_id()%> - </option>
                <%= facade.mostrarEntidadesOption()%>
            </select>
            <%
        }else{
            %>
            <label for="nombre">Nombre del Convenio</label>
            <input id="nombre" name="nombre" type="text" placeholder="Nombre de la actividad" required>

            <label for="fecha_convenio">Fecha</label>
            <input id="fecha_convenio" name="fecha_convenio" type="date" required>
            <input id="fecha_anterior" name="fecha_anterior" type="hidden" value="<%=
                                            new java.sql.Date(System.currentTimeMillis())%>" required>


            <label for="programa_id">Programa</label>
            <select id="programa_id" name="programa_id" class="pure-u-1">
                <option value="0">Seleccione:</option>
                <%=facade.mostrarProgramasOption()%>
            </select>

            <label for="entidad_id">Entidad</label>
            <select id="entidad_id" name="entidad_id" class="pure-u-1">
                <option value="0">Seleccione:</option>
                <%= facade.mostrarEntidadesOption()%>
            </select>
            <%
            
            }
%>



    