<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">

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
        
            <li class="pure-menu-item"><a href="convenio.jsp" class="pure-menu-link">Convenios</a></li>
	    <li class="pure-menu-item"><a href="bienestar.jsp" class="pure-menu-link">Bienestar</a></li>
            <li class="pure-menu-item"><a href="reporte.jsp" class="pure-menu-link">Reportes</a></li>
            <li class="pure-menu-item"><a href="cerrarSesion.jsp" class="pure-menu-link"><i class="fa fa-sign-out"></i></a></li>
        </ul>
    </div>
</div>



<div class="contenido">
	
	<div class="calendario">
			<h2 class="is-center">Actividades de Proyeccion</h2>
                        
                        <table class="table table-bordered" align="center"  id="bienestar">
			<thead>
				<tr>
					
					<th>Nombre</th>
					<th>Fecha</th>
					<th>Lugar</th>
					<th>Estado</th>
                                        <th>Convenio</th>
					
				</tr>
			</thead>

                        <tbody>
			
				
				
                            <%= facade.mostrarActividadesPS() %>
				
			</tbody>
		</table>
		
		<form class="pure-form">
			<fieldset>
                            <legend>Acciones</legend>

				<button href="#myModalNuevaAct" role="button" data-toggle="modal" type="button" class="pure-button pure-button-primary">
				<i class="fa fa-plus"></i> Nueva</button>
				
                                <button href="#myModalNuevoLider" role="button" data-toggle="modal" type="button" class="pure-button pure-button-primary">
				<i class="fa fa-plus"></i> Lider</button>
				
                                
			</fieldset>
		</form>
		
	</div>
	
	<div id="myModalNuevaAct" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header is-center">
			<h2 id="myModalLabel">Nueva Actividad</h2>
		</div>

		<div class="modal-body">
			<p>
                            Registre una Actividad de Proyecci�n Social indicando la siguiente informaci�n.
			</p>

			<form class="pure-form pure-form-stacked" action="registrarAPS.jsp" method="post">

				<label for="nombre">Nombre</label>
                                <input class="capitalize" id="nombre" name="nombre" type="text" placeholder="Nombre de la actividad" required>

                                <label for="descripcion">Descripcion</label>
				<textarea id="descripcion" name="descripcion"  class="pure-u-1 capitalize"></textarea>

                                <label for="lugar">Lugar</label>
				<input id="lugar" name="lugar" type="text" placeholder="Lugar de la actividad" required>
				
				<label for="fecha_actividad">Fecha</label>
				<input id="fecha_actividad" name="fecha_actividad" type="date" required>
				
				
				<label for="convenio_id">Convenio</label>
				<select id="convenio_id" name="convenio_id" class="pure-u-1">
                                    <option value="0">Seleccione:</option>
                                    <%=facade.mostrarConveniosOption()%>
				</select>
                                
                                <label for="lider_codigoUFPS">Lider</label>
				<select id="lider_codigoUFPS" name="lider_codigoUFPS" class="pure-u-1">
                                    <option value="0">Seleccione:</option>
                                    <%=facade.mostrarLideres()%>
				</select>
				
				<label for="estado">Estado</label>
				<select id="estado" name="estado" class="pure-u-1">
                                    <option value="En Curso">En curso</option>
                                    <option value="Inactiva">Inactiva</option>
                                    <option value="Cancelada">Cancelada</option>
                                    <option value="Terminada">Terminada</option>
				</select>
                                
                                <label for="hora">Hora</label>
				<input id="hora" name="hora" type="time" required>
				
				<div class="modal-footer">
					<button	class="pure-button pure-button-primary" type="submit">Registrar</button>
					<button class="pure-button" data-dismiss="modal" aria-hidden="true">Cancelar</button>
				</div>
			</form>
		</div>

		
	</div>
	
	
        <div id="myModalNuevoLider" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header is-center">
			<h2 id="myModalLabel">Nuevo Lider</h2>
		</div>

		<div class="modal-body">
			<p>
				Registre un Nuevo Lider indicado sus Datos.
			</p>

			<form class="pure-form pure-form-stacked" action="registrarLider.jsp" method="post">
                                
                                <label for="codigoUFPS">Codigo</label>
				<input id="codigoUfps" name="codigoUFPS" type="number"  placeholder="Codigo del Lider" required>

				<label for="nombre">Nombre</label>
				<input id="nombre" name="nombre" type="text" placeholder="Nombre del lider" required>

                                <label for="cargo">Cargo</label>
				<input id="cargo" name="cargo" type="text" placeholder="Cargo del lider" required>
				
				<label for="correo">Email</label>
                                <input id="correo" name="correo" type="email" placeholder="Correo del lider" required>
				
                                <label for="contrase�a">Contrase�a</label>
                                <input id="contrase�a" name="contrase�a" type="text" placeholder="numeros y letras" required>
                                
				<div class="modal-footer">
					<button	class="pure-button pure-button-primary" type="submit">Registrar</button>
					<button class="pure-button" data-dismiss="modal" aria-hidden="true">Cancelar</button>
				</div>
			</form>
		</div>

		
	</div>
                                


			

    <div class="footer l-box-lrg is-center">
        Seminario Integrador III - II Semestre 2015
    </div>

</div>


                        
	<script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
        
        




</body>
        

<script type="text/javascript">
    $(document).ready( function () {
        $('#bienestar').DataTable({
            buttons: [
                'copy', 'excel', 'pdf'
            ],
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
