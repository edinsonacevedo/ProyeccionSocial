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

<div class="header">
    <div class="home-menu pure-menu pure-menu-horizontal pure-menu-fixed">
        
        <a class="pure-menu-heading capitalize" href=""><i class="fa fa-user"> Usuario</i></a>

        <ul class="pure-menu-list">
            <li class="pure-menu-item"><a href="convenio.jsp" class="pure-menu-link">Convenios</a></li>
			<li class="pure-menu-item"><a href="plantrabajo.jsp" class="pure-menu-link">Planes</a></li>
            <li class="pure-menu-item"><a href="reporte.jsp" class="pure-menu-link">Reportes</a></li>
            <li class="pure-menu-item"><a href="index.jsp" class="pure-menu-link"><i class="fa fa-sign-out"></i></a></li>
        </ul>
    </div>
</div>



<div class="contenido">
	
	<div class="calendario">
			<h2 class="is-center">Actividades</h2>
			
			<table class="pure-table" align="center">
			<thead>
				<tr>
					<th></th>
					<th>Nombre</th>
					<th>Fecha</th>
					<th>Lugar</th>
					<th>Estado</th>
					<!--<th>Acciones</th>-->
				</tr>
			</thead>

			<tbody>
			
				<tr>
					<td><input id="option-three" type="radio" name="optionsRadios" value="option2"></td>
					<td><a href="">Integracion</a></td>
					<td>16/09/2015</td>
					<td>centro recreativo</td>
					<td>en curso</td>
					<!--<td>
						<a href=""><i class="fa fa-pencil-square-o"></i></a>
						<a href="" ><i class="fa fa-eraser"></i></a>
					</td>-->
				</tr>
				<tr class="pure-table-odd">
					<td><input id="option-three" type="radio" name="optionsRadios" value="option2"></td>
					<td><a href="">Integracion</a></td>
					<td>16/09/2015</td>
					<td>centro recreativo</td>
					<td>en curso</td>
					<!--<td>
						<a href=""><i class="fa fa-pencil-square-o"></i></a>
						<a href="" ><i class="fa fa-eraser"></i></a>
					</td>-->
				</tr>
				<tr>
					<td><input id="option-three" type="radio" name="optionsRadios" value="option2"></td>
					<td><a href="">Integracion</a></td>
					<td>16/09/2015</td>
					<td>centro recreativo</td>
					<td>en curso</td>
					<!--<td>
						<a href=""><i class="fa fa-pencil-square-o"></i></a>
						<a href="" ><i class="fa fa-eraser"></i></a>
					</td>-->
				</tr>
				<tr class="pure-table-odd">
					<td><input id="option-three" type="radio" name="optionsRadios" value="option2"></td>
					<td><a href="">Integracion</a></td>
					<td>16/09/2015</td>
					<td>centro recreativo</td>
					<td>en curso</td>
					<!--<td>
						<a href=""><i class="fa fa-pencil-square-o"></i></a>
						<a href="" ><i class="fa fa-eraser"></i></a>
					</td>-->
				</tr>
				<tr>
					<td><input id="option-three" type="radio" name="optionsRadios" value="option2"></td>
					<td><a href="">Integracion</a></td>
					<td>16/09/2015</td>
					<td>centro recreativo</td>
					<td>en curso</td>
					<!--<td>
						<a href=""><i class="fa fa-pencil-square-o"></i></a>
						<a href="" ><i class="fa fa-eraser"></i></a>
					</td>-->
				</tr>
				<tr class="pure-table-odd">
					<td><input id="option-three" type="radio" name="optionsRadios" value="option2"></td>
					<td><a href="">Integracion</a></td>
					<td>16/09/2015</td>
					<td>centro recreativo</td>
					<td>en curso</td>
					<!--<td>
						<a href=""><i class="fa fa-pencil-square-o"></i></a>
						<a href="" ><i class="fa fa-eraser"></i></a>
					</td>-->
				</tr>

				
			</tbody>
		</table>
		
		<form class="pure-form">
			<fieldset>
				<legend>Acciones</legend>

				<button href="#myModalNuevaAct" role="button" data-toggle="modal" type="button" class="pure-button pure-button-primary">
				<i class="fa fa-plus"></i> Nueva</button>
				<button href="#myModalEditarAct" role="button" data-toggle="modal" type="button" class="pure-button pure-button-primary">
				<i class="fa fa-pencil-square-o"></i> Editar</button>
				<button href="#myModalBorrarAct" role="button" data-toggle="modal" type="button" class="pure-button pure-button-primary" >
				<i class="fa fa-eraser"></i> Borrar</button>
			</fieldset>
		</form>
		
	</div>
	
	<div id="myModalNuevaAct" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header is-center">
			<h2 id="myModalLabel">Nueva Actividad</h2>
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

				<label for="fecha">Fecha</label>
				<input id="fecha" name="fecha" type="date" required>
				
				<label for="lugar">Lugar</label>
				<input id="lugar" name="lugar" type="text" placeholder="Lugar de la actividad" required>
				
				<label for="plan">Plan de Trabajo</label>
				<select id="plan" name="plan" class="pure-u-1">
					<option></option>
					<option>opcion 1</option>
				</select>
				
				<label for="estado">Estado</label>
				<select id="estado" name="estado" class="pure-u-1">
					<option></option>
					<option>opcion 1</option>
				</select>
				
				<label for="descripcion">Descripcion</label>
				<textarea id="descripcion" name="descripcion"  class="pure-u-1"></textarea>
				
				
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

				<label for="fecha">Fecha</label>
				<input id="fecha" name="fecha" type="date" required>
				
				<label for="lugar">Lugar</label>
				<input id="lugar" name="lugar" type="text" placeholder="Lugar de la actividad" required>
				
				<label for="plan">Plan de Trabajo</label>
				<select id="plan" name="plan" class="pure-u-1">
					<option></option>
					<option>opcion 1</option>
				</select>
				
				<label for="estado">Estado</label>
				<select id="estado" name="estado" class="pure-u-1">
					<option></option>
					<option>opcion 1</option>
				</select>
				
				<label for="descripcion">Descripcion</label>
				<textarea id="descripcion" name="descripcion"  class="pure-u-1"></textarea>
				
				
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
				<h3 class="is-center">� Desea Eliminar esta Actividad?</h3>
				
				
				<div class="modal-footer">
					<button	class="pure-button pure-button-primary" type="submit">Aceptar</button>
					<button class="pure-button" data-dismiss="modal" aria-hidden="true">Cancelar</button>
				</div>
			</form>
		</div>

		
	</div>

			<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
			<script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
    

    <div class="footer l-box is-center">
        Seminario Integrador III - II Semestre 2015
    </div>

</div>






</body>
</html>
