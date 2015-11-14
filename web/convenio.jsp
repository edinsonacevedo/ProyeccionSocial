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
 
<div class="header">
    <div class="home-menu pure-menu pure-menu-horizontal pure-menu-fixed">
        <a class="pure-menu-heading capitalize" href=""><i class="fa fa-user"> - <%=usuario%></i></a>
		

        <ul class="pure-menu-list">
            
            <li class="pure-menu-item"><a href="bienestar.jsp" class="pure-menu-link">Bienestar</a></li>
			<li class="pure-menu-item"><a href="proyeccion.jsp" class="pure-menu-link">Proyección</a></li>
			<li class="pure-menu-item"><a href="reporte.jsp" class="pure-menu-link">Reportes</a></li>
            <li class="pure-menu-item"><a href="cerrarSesion.jsp" class="pure-menu-link"><i class="fa fa-sign-out"></i></a></li>
        </ul>
    </div>
</div>



<div class="contenido">
	
	<div class="calendario">
			<h2 class="is-center">Convenios InterInstitucionales</h2>
			
			<table class="table table-bordered" align="center"  id="convenio">
			<thead>
				<tr>
					
					<th>Nombre</th>
					<th>Fecha</th>
					<th>Programa</th>
					<th>Entidad</th>
				</tr>
			</thead>

			<tbody>
			
				
                                <%= facade.mostrarConveniosTabla()%>
				
			</tbody>
		</table>
		
		<form class="pure-form">
			<fieldset>
				<legend>Acciones</legend>

				<button href="#myModalNuevoConv" role="button" data-toggle="modal" type="button" class="pure-button pure-button-primary">
				<i class="fa fa-plus"></i> Nuevo</button>
				<button href="#myModalEditarConv" role="button" data-toggle="modal" type="button" class="pure-button pure-button-primary">
				<i class="fa fa-pencil-square-o"></i> Editar</button>
				<button href="#myModalNuevaEnt" role="button" data-toggle="modal" type="button" class="pure-button pure-button-primary">
				<i class="fa fa-plus"></i> Entidad</button>
			</fieldset>
		</form>
		
	</div>
	
	<div id="myModalNuevoConv" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header is-center">
			<h2 id="myModalLabel">Nuevo Convenio</h2>
		</div>

		<div class="modal-body">
			<p>
				Registre un nuevo convenio indicando la siguiente informacion, Recuerde que 
                                la Entidad debe haberse registrado con anterioridad.
			</p>

			<form class="pure-form pure-form-stacked" action="registrarConvenio.jsp" method="post">

				<label for="nombre">Nombre del Convenio</label>
				<input id="nombre" name="nombre" type="text" placeholder="Nombre de la actividad" required>

				<label for="fecha_convenio">Fecha</label>
				<input id="fecha_convenio" name="fecha_convenio" type="date" required>
				
				
				<label for="programa_id">Programa</label>
				<select id="programa_id" name="programa_id" class="pure-u-1">
                                    <option value="0">Seleccione:</option>
                                    <%=facade.mostrarProgramasOption()%>
				</select>
                                
                                <label for="entidad_id">Entidad</label>
				<select id="entidad_id" name="entidad_id" class="pure-u-1">
                                    <option value="0">Seleccione:</option>
                                    <%=facade.mostrarEntidadesOption()%>
				</select>
			
				<div class="modal-footer">
					<button	class="pure-button pure-button-primary" type="submit">Registrar</button>
					<button class="pure-button" data-dismiss="modal" aria-hidden="true">Cancelar</button>
				</div>
			</form>
		</div>

		
	</div>
	
	<div id="myModalEditarConv" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header is-center">
			<h2 id="myModalLabel">Editar Convenio</h2>
		</div>

		<div class="modal-body">
			<p>
				Actualize la informacion relacionada con un convenio.
			</p>

                        <form class="pure-form pure-form-stacked" name="editarConvenio" action="editarConvenio.jsp" method="post">
                                
                            
                                <label for="idConvenio">Convenio</label>
                                <select id="idConvenio" name="idConvenio" onchange="mostrarInfoConvenio()" class="pure-u-1">
                                    <option value="0" selected>Seleccione:</option>
                                    <%=facade.mostrarConveniosOption()%>
					
				</select>
                                <script type="text/javascript" src="js/general.js">
                                    
                                </script>
                                <div id="divInfoConvenio">
                                    <label for="nombre">Nombre del Convenio</label>
                                    <input id="nombre" name="nombre" type="text" placeholder="Nombre de la actividad" required>

                                    <label for="fecha_convenio">Fecha</label>
                                    <input id="fecha_convenio" name="fecha_convenio" type="date" required>
                                    <input id="fecha_anterior" name="fecha_anterior" type="hidden" value="<%=
                                            new java.sql.Date(System.currentTimeMillis())%>" required>
                                    

                                    <label for="programa_id">Programa</label>
                                    <select id="programa_id" name="programa_id" class="pure-u-1">
                                        <option value="0" selected>Seleccione:</option>
                                        <%=facade.mostrarProgramasOption()%>
                                    </select>

                                    <label for="entidad_id">Entidad</label>
                                    <select id="entidad_id" name="entidad_id" class="pure-u-1">
                                        <option value="0" selected>Seleccione:</option>
                                        <%= facade.mostrarEntidadesOption()%>
                                    </select>
                                </div>
				<div class="modal-footer">
					<button	class="pure-button pure-button-primary" type="submit">Guardar</button>
					<button class="pure-button" data-dismiss="modal" aria-hidden="true">Cancelar</button>
				</div>
			</form>
		</div>

		
	</div>
    
        <div id="myModalNuevaEnt" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header is-center">
			<h2 id="myModalLabel">Nueva Entidad</h2>
		</div>

		<div class="modal-body">
			<p>
				Registre una Entidad indicando su Nombre y direccion.
			</p>

			<form class="pure-form pure-form-stacked" action="registrarEntidad.jsp" method="post">
                                
                                
				<label for="nombre">Nombre</label>
                                <input class="capitalize" id="nombre" name="nombre" type="text" placeholder="Nombre de la Entidad" required>
                                
                                <label for="direccion">Dirección</label>
				<input id="direccion" name="direccion" type="text" placeholder="Ej: cll 5 # 3-55" required>
                                
				
				<div class="modal-footer">
					<button	class="pure-button pure-button-primary" type="submit">Registrar</button>
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
        $('#convenio').DataTable({
            buttons: [
                'copy', 'excel', 'pdf'
            ],
            language: {
                processing:     "Procesando...",
                search:         "Buscar:",
                lengthMenu:     "Mostrar _MENU_ Convenios",
                info:           "Mostrando de _START_ a _END_ de _TOTAL_ Convenios",
                infoEmpty:      "Mostrando de 0 a 0 de 0 Convenios",
                infoFiltered:   "(Filtrado de _MAX_ Convenios en Total.)",
                infoPostFix:    "",
                loadingRecords: "Cargando...",
                zeroRecords:    "No se encontraron Convenios =(.",
                emptyTable:     "No Hay Convenios Disponibles.",
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
