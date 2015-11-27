<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
    <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="A layout example that shows off a responsive product landing page.">

    <title>Proyeccion Social &ndash; Ingenieria de Sistemas &ndash; UFPS</title>

    


<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">



<!--[if lte IE 8]>
  
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-old-ie-min.css">
  
<![endif]-->
<!--[if gt IE 8]><!-->
  
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-min.css">
    
  
<!--<![endif]-->



<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">



  
    <!--[if lte IE 8]>
        <link rel="stylesheet" href="css/layouts/marketing-old-ie.css">
    <![endif]-->
    <!--[if gt IE 8]><!-->
        <link rel="stylesheet" href="css/estilos.css">
    <!--<![endif]-->
	
	<link rel="stylesheet" href="css/modal.css">
	
    </head>
<body>
    
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
 <jsp:useBean id="actividadBS" scope="page" class="co.edu.ufps.proyeccionSocial.dto.ActividadBSDto" />

<div class="header">
    <div class="home-menu pure-menu pure-menu-horizontal pure-menu-fixed">
        
        <a class="pure-menu-heading capitalize" href=""><i class="fa fa-user"> - <%=usuario%></i></a>

        <ul class="pure-menu-list">
        
            <li class="pure-menu-item"><a href="convenio.jsp" class="pure-menu-link">Convenios</a></li>
	    <li class="pure-menu-item"><a href="proyeccion.jsp" class="pure-menu-link">Proyeccion</a></li>
            <li class="pure-menu-item"><a href="reporte.jsp" class="pure-menu-link">Reportes</a></li>
            <li class="pure-menu-item"><a href="cerrarSesion.jsp" class="pure-menu-link"><i class="fa fa-sign-out"></i></a></li>
        </ul>
    </div>
</div>

        
<div class="contenido">
	<% actividadBS = facade.consultarABS(Integer.parseInt(request.getParameter("actividad"))); %>

	<div class="calendario is-center">
            <h2 class="is-center" style="text-transform: uppercase"><%= actividadBS.getNombre()%></h2>
                        
                        <form class="pure-form pure-form-stacked" style="text-align: left ">
                            <fieldset>
                                <legend>Detalle Actividad</legend>

                                <div class="pure-g">
                                    <div class="pure-u-1 pure-u-md-1-3 l-box" >
                                        <label for="lugar">Lugar</label>
                                        <input  id="lugar" class="pure-u-20-24" value="<%= actividadBS.getLugar()%>" type="text" readonly>
                                    </div>
                                    
                                    <div class="pure-u-1 pure-u-md-1-3 l-box">
                                        <label for="first-name">Fecha</label>
                                        <input  id="first-name" class="pure-u-23-24" value="<%= actividadBS.getFecha()%>" type="text" readonly>
                                    </div>
                                    
                                    <div class="pure-u-1 pure-u-md-1-3 l-box">
                                        <label for="first-name">Programa</label>
                                        <input id="first-name" class="pure-u-23-24" value="<%= actividadBS.getPrograma_id()%>" type="text" readonly>
                                    </div>
                                    <div class="pure-u-1 pure-u-md-1-3 l-box">
                                        <label for="first-name">Codigo Lider</label>
                                        <input id="first-name" class="pure-u-23-24" value="<%= actividadBS.getLider_codigoUFPS()%>" type="text" readonly>
                                    </div>
                                    <div class="pure-u-1 pure-u-md-1-3 l-box" >
                                        <label for="first-name">Estado</label>
                                        <input id="first-name" class="pure-u-23-24" value="<%= actividadBS.getEstado()%>" type="text" readonly>
                                    </div>
                                    <div class="pure-u-1 pure-u-md-1-3 l-box" >
                                        <label for="first-name">Hora</label>
                                        <input id="first-name" class="pure-u-23-24" value="<%= actividadBS.getHora()%>" type="text" readonly>
                                    </div>
                                    <div class="pure-u-1 pure-u-md-1-3 l-box">
                                        <label for="first-name">Descripcion</label>
                                        <textarea id="first-name" class="pure-u-24-24"  readonly><%= actividadBS.getDescripcion()%></textarea>
                                    </div>

                                    
                                </div>
                            </fieldset>
                        </form>
			
		
		<form class="pure-form">
			<fieldset>
				<legend>Acciones</legend>
                                <button href="#myModalEditarAct" role="button" data-toggle="modal" type="button" class="pure-button pure-button-primary">
				<i class="fa fa-pencil-square-o"></i> Editar</button>
                                
                                <a href="presupuesto.jsp?presupuesto=<%=actividadBS.getPresupuesto_id()%>&nomActividad=<%=actividadBS.getNombre()%>&actividad=<%=actividadBS.getIdActividadBS()%>" 
                                   class="pure-button pure-button-primary">
				<i class="fa fa-usd"></i> Presupuesto</a>
				
                                <!--<a href="bienestar.jsp"  type="button" class="pure-button pure-button-primary">
				<i class="fa fa-angle-double-left"></i> Atras</a>-->
				
                                
			</fieldset>
		</form>
		
	</div>
	
	
	
	<div id="myModalEditarAct" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header is-center">
			<h2 id="myModalLabel">Editar Actividad</h2>
		</div>

		<div class="modal-body">
			<p>
			Aqui usted puede editar la informacion de la actividad.	
			</p>

			<form class="pure-form pure-form-stacked" action="editarABS.jsp" method="post">

				<label for="nombre">Nombre</label>
                                <input class="mayuscula" id="nombre" name="nombre" type="text" value="<%=actividadBS.getNombre()%>" required>

                                <label for="descripcion">Descripcion</label>
                                <textarea id="descripcion" name="descripcion"  class="pure-u-1 capitalize" required><%=actividadBS.getDescripcion()%></textarea>

                                <label for="lugar">Lugar</label>
                                <input id="lugar" name="lugar" type="text" placeholder="Lugar de la actividad" value="<%=actividadBS.getLugar()%>" required>
				
				<label for="fecha">Fecha</label>
                                <input id="fecha" name="fecha_actividad" type="date" value="<%=actividadBS.getFecha()%>" required>
				
                                <input id="fecha_anterior" name="fecha_anterior" type="hidden" value="<%=actividadBS.getFecha()%>">
				<input id="id" name="id" type="hidden" value="<%=actividadBS.getIdActividadBS()%>">
				
				<label for="programa_id">Programa</label>
				<select id="programa_id" name="programa_id" class="pure-u-1">
                                    <option value="<%=actividadBS.getPrograma_id()%>" selected><%=actividadBS.getPrograma_id()%></option>
                                    <%=facade.mostrarProgramasOption()%>
				</select>
                                
                                <label for="lider_codigoUFPS">Lider</label>
				<select id="lider_codigoUFPS" name="lider_codigoUFPS"  class="pure-u-1">
                                    <option value="<%=actividadBS.getLider_codigoUFPS()%>" selected><%=actividadBS.getLider_codigoUFPS()%></option>
                                    <option value="1152935">115-Pedro</option>
				</select>
				
				<label for="estado">Estado</label>
				<select id="estado" name="estado" class="pure-u-1">
                                    <option value="<%=actividadBS.getEstado()%>"><%=actividadBS.getEstado()%></option>
                                    <option value="En Curso">En Curso</option>
                                    <option value="Inactiva">Inactiva</option>
                                    <option value="Cancelada">Cancelada</option>
                                    <option value="Terminada">Terminada</option>
				</select>
				
                                <label for="hora">Hora</label>
                                <input id="hora" name="hora"  value="<%=actividadBS.getHora()%>" type="time" required>
                               
				
				<div class="modal-footer">
					<button	class="pure-button pure-button-primary" type="submit">Guardar</button>
					<button class="pure-button" data-dismiss="modal" aria-hidden="true">Cancelar</button>
				</div>
			</form>
		</div>

		
	</div>
	
	
			<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
			<script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
    

    <div class="footer l-box-lrg is-center">
        Seminario Integrador III - II Semestre 2015
    </div>

</div>






</body>
</html>
