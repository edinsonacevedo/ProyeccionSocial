<%@page import="org.jboss.weld.bean.builtin.FacadeInjectionPoint"%>
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
	
        
        <!--<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">-->
        <!-- DataTables CSS -->
        <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.10/css/jquery.dataTables.css">
        <!-- jQuery -->
        <!--<script type="text/javascript" charset="utf8" src="//code.jquery.com/jquery-1.10.2.min.js"></script>-->
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>


        <!-- DataTables -->
        <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.10/js/jquery.dataTables.js"></script>
</head>
<body>
 
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

        
<div class="header">
    <div class="home-menu pure-menu pure-menu-horizontal pure-menu-fixed">
        
        <a class="pure-menu-heading capitalize" href=""><i class="fa fa-user"> - <%=usuario%></i></a>

        <ul class="pure-menu-list">
            <li class="pure-menu-item"><a href="cerrarSesion.jsp" class="pure-menu-link"><i class="fa fa-sign-out"></i></a></li>
        </ul>
    </div>
</div>



<div class="contenido">
	
	<div class="calendario">
			<h2 class="is-center">Actividades Asignadas</h2>
			
                        <table class="table table-bordered" id="asignadasLider" align="center">
			<thead>
				<tr>
					
					<th>Nombre</th>
					<th>Fecha</th>
					<th>Lugar</th>
					<th>Estado</th>
					
				</tr>
			</thead>

			<tbody>
			
                            <%=facade.mostrarAsignadasLider(Integer.parseInt(usuario))%>
			</tbody>
		</table>
		
		<!--<form class="pure-form">
			<fieldset>
				<legend>Acciones</legend>

				<button href="#myModalNuevaAct" role="button" data-toggle="modal" type="button" class="pure-button pure-button-primary">
				<i class="fa fa-plus"></i> Nueva</button>
				<button href="#myModalEditarAct" role="button" data-toggle="modal" type="button" class="pure-button pure-button-primary">
				<i class="fa fa-pencil-square-o"></i> Editar</button>
                                <button href="#myModalNuevoParticipante" role="button" data-toggle="modal" type="button" class="pure-button pure-button-primary">
				<i class="fa fa-plus"></i> Participante</button>
				<!--<button href="#myModalBorrarAct" role="button" data-toggle="modal" type="button" class="pure-button pure-button-primary" >
				<i class="fa fa-eraser"></i> Borrar</button>
			</fieldset>
		</form>-->
		
	</div>
	
	<div id="myModalNuevoParticipante" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header is-center">
			<h2 id="myModalLabel">Nuevo Participante</h2>
		</div>

		<div class="modal-body">
			<p>
				<!--<This modal is launched by including <em>just</em> the <code>modal.css</code> and <code>modal.js</code> 
				file from Bootstrap, and including Pure to drive all low-level styles. The result is a fully-functional Modal u
				sing just a fraction of the CSS.-->
			</p>

			<form class="pure-form pure-form-stacked" action="lider.jsp" method="post">
                                
                                <label for="codigoUFPS">Codigo del Participante</label>
				<input id="codigoUfps" name="codigoUFPS" type="number" placeholder="ej: 1150512" required>
                                
				<label for="nombre">Nombre</label>
				<input id="nombre" name="nombre" type="text" placeholder="Nombre del Participante" required>

                                <!--<label for="descripcion">Descripcion</label>
				<textarea id="descripcion" name="breve descripcion"  class="pure-u-1"></textarea>

                                <label for="lugar">Lugar</label>
				<input id="lugar" name="lugar" type="text" placeholder="Lugar de la actividad" required>
				
				<label for="fecha">Fecha</label>
				<input id="fecha" name="fecha" type="date" required>
				
				
				<label for="programa">Programa</label>
				<select id="programa" name="programa" class="pure-u-1">
					<option></option>
                                        <option value="115">Ingenieria de Sistemas UFPS</option>
				</select>
                                <label for="lider_codigoUFPS">Lider</label>
				<select id="lider_codigoUFPS" name="lider_codigoUFPS" class="pure-u-1">
					<option></option>
                                        <option value="1152935">1152935-Pedro</option>
				</select>
				
				<label for="estado">Estado</label>
				<select id="estado" name="estado" class="pure-u-1">
                                    <option value="en_curso">En curso</option>
                                    <option value="inactiva">Inactiva</option>
                                    <option value="cancelada">Cancelada</option>
                                    <option value="terminada">Terminada</option>
				</select>
				
                                <label for="monto">Monto Presupuesto</label>
				<input id="monto" name="monto" type="text" placeholder="Cantidad en Pesos" required>
				
				<label for="fecha_asignado">Fecha Asignado</label>
				<input id="fecha_asignado" name="fecha_asignado" type="date" required>-->
                                
				<div class="modal-footer">
					<button	class="pure-button pure-button-primary" type="submit">Registrar</button>
					<button class="pure-button" data-dismiss="modal" aria-hidden="true">Cancelar</button>
				</div>
			</form>
		</div>

		
	</div>
	
	<div id="myModalEditarAct" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header is-center">
			<h2 id="myModalLabel">Editar Actividad</h2>
		</div>

		<div class="modal-body">
			<p>
				<!--<This modal is launched by including <em>just</em> the <code>modal.css</code> and <code>modal.js</code> 
				file from Bootstrap, and including Pure to drive all low-level styles. The result is a fully-functional Modal u
				sing just a fraction of the CSS.-->
			</p>

			<form class="pure-form pure-form-stacked" action="actividad.html" method="post">

				<label for="nombre">Nombre</label>
				<input id="nombre" name="nombre" type="text" placeholder="Nombre de la actividad" required>

                                <label for="descripcion">Descripcion</label>
				<textarea id="descripcion" name="breve descripcion"  class="pure-u-1"></textarea>

                                <label for="lugar">Lugar</label>
				<input id="lugar" name="lugar" type="text" placeholder="Lugar de la actividad" required>
				
				<label for="fecha">Fecha</label>
				<input id="fecha" name="fecha" type="date" required>
				
				
				<!--<label for="programa">Programa</label>
				<select id="programa" name="programa" class="pure-u-1">
					<option></option>
                                        <option value="115">Ingenieria de Sistemas UFPS</option>
				</select>-->
                                
                                <label for="lider_codigoUFPS">Lider</label>
				<select id="lider_codigoUFPS" name="lider_codigoUFPS" class="pure-u-1">
					<option></option>
                                        <option value="1152935">1152935-Pedro</option>
				</select>
				
				<label for="estado">Estado</label>
				<select id="estado" name="estado" class="pure-u-1">
                                    <option value="en_curso">En curso</option>
                                    <option value="inactiva">Inactiva</option>
                                    <option value="cancelada">Cancelada</option>
                                    <option value="terminada">Terminada</option>
				</select>
				
                                <label for="monto">Monto Presupuesto</label>
				<input id="monto" name="monto" type="text" placeholder="Cantidad en Pesos" required>
				
				<!--<label for="fecha_asignado">Fecha Asignado</label>
				<input id="fecha_asignado" name="fecha_asignado" type="date" required>-->
				
				<div class="modal-footer">
					<button	class="pure-button pure-button-primary" type="submit">Guardar</button>
					<button class="pure-button" data-dismiss="modal" aria-hidden="true">Cancelar</button>
				</div>
			</form>
		</div>

		
	</div>
	
	<div id="myModalBorrarAct" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header is-center">
			<h2 id="myModalLabel"><i class="fa fa-exclamation-triangle"></i> Advertencia</h2>
		</div>

		<div class="modal-body">
			<p>
				<!--<This modal is launched by including <em>just</em> the <code>modal.css</code> and <code>modal.js</code> 
				file from Bootstrap, and including Pure to drive all low-level styles. The result is a fully-functional Modal u
				sing just a fraction of the CSS.-->
			</p>

			<form class="pure-form pure-form-stacked" action="actividad.html" method="post">
				<h3 class="is-center">¿ Desea Eliminar esta Actividad?</h3>
				
				
				<div class="modal-footer">
					<button	class="pure-button pure-button-primary" type="submit">Aceptar</button>
					<button class="pure-button" data-dismiss="modal" aria-hidden="true">Cancelar</button>
				</div>
			</form>
		</div>

		
	</div>

			
			<script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
    

    <div class="footer l-box-lrg is-center">
        Seminario Integrador III - II Semestre 2015
    </div>

</div>


</body>

<script type="text/javascript">
    $(document).ready( function () {
        $('#asignadasLider').DataTable({
           
            language: {
                processing:     "Procesando...",
                search:         "Buscar:",
                lengthMenu:     "Mostrar _MENU_ Actividades",
                info:           "Mostrando de _START_ a _END_ de _TOTAL_ Actividades",
                infoEmpty:      "Mostrando de 0 a 0 de 0 Actividades",
                infoFiltered:   "(Filtrado de _MAX_ Actividades en Total.)",
                infoPostFix:    "",
                loadingRecords: "Cargando...",
                zeroRecords:    "No se encontraron Actividades =(.",
                emptyTable:     "No Hay Actividades Disponibles.",
                paginate: {
                    first:      "Primera",
                    previous:   "Anterior",
                    next:       "Siguiente",
                    last:       "Ultima"
                },
                aria: {
                    sortAscending:  ": Ordenar ascendente",
                    sortDescending: ": Ordenar descendente"
                }
    
            }
        } );
        
    } );
</script>
</html>
