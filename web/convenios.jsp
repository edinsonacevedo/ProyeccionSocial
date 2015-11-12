<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
    <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="A layout example that shows off a responsive product landing page.">

    <title>Proyeccion Social &ndash; Ingenieria de Sistemas &ndash; UFPS</title>

    

<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" 
href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
<script type="text/javascript" 
src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" 
src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-old-ie-min.css">
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-min.css">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
<link rel="stylesheet" href="css/estilos.css">

<script type="text/javascript" src="buttons/js/dataTables.buttons.js"></script>
<script type="text/javascript" src="buttons/js/buttons.flash.js"></script>
<script type="text/javascript" src="buttons/js/buttons.html5.js"></script>
<script type="text/javascript" src="buttons/js/buttons.print.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
<script type="text/javascript" src="//cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js"></script>
<script type="text/javascript" src="//cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js"></script>

<link rel="stylesheet" href="datatables/media/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="buttons/css/buttons.dataTables.min.css">
 




</head>
<body>
<script type="text/javascript" language="javascript" class="init">
    
    $(document).ready( function () {
        $('#convenios').DataTable({
            select : true, 
            buttons: [ 'copy', 'csv', 'excel', 'pdf', 'print' ],
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

    
<div class="header">
    <div class="home-menu pure-menu pure-menu-horizontal pure-menu-fixed">
        <a class="pure-menu-heading" href="index.jsp">Proyeccion Social</a>

        <ul class="pure-menu-list">
            
            <li class="pure-menu-item"><a href="index.jsp" class="pure-menu-link"><i class="fa fa-angle-double-left"></i> Volver</a></li>
        </ul>
    </div>
</div>



<div class="contenido">
    
	<div class="calendario">
            
		<h2>Nuestros Convenios</h2>
                
                <table class="table table-striped table-bordered display nowrap" align="center" width="100%"  id="convenios">
			<thead>
				<tr>
					<th>Fecha de Convenio</th>
					<th>Entidad</th>
					<th>Descripcion</th>
				</tr>
			</thead>

			<tbody>
				<tr >
					<td>10/09/2015</td>
					<td>Colegio Pepito Perez</td>
					<td>colegio publico ubicado en la comuna 10</td>
				</tr>
				<tr>
					<td>10/09/2015</td>
					<td>Fundacion fundacion</td>
					<td>dedicada a la atencion de la tercera edad</td>
				</tr>
				<tr>
					<td>10/09/2015</td>
					<td>Hogar infantil mmmmmm</td>
					<td>es ta es una descripcion</td>
				</tr>
				<tr>
					<td>10/09/2015</td>
					<td>entidad vvvvvv</td>
					<td>descripcion de la entidad</td>
					
				</tr>
				<tr>
					<td>10/09/2015</td>
					<td>clinica gggggg</td>
					<td>esta es la descripcion</td>
				</tr>
                                <tr>
					<td>10/09/2015</td>
					<td>clinica gggggg</td>
					<td>esta es la descripcion</td>
				</tr>
                                <tr>
					<td>10/09/2015</td>
					<td>clinica gggggg</td>
					<td>esta es la descripcion</td>
				</tr>
                                <tr>
					<td>10/09/2015</td>
					<td>clinica gggggg</td>
					<td>esta es la descripcion</td>
				</tr>
                                <tr>
					<td>10/09/2015</td>
					<td>clinica gggggg</td>
					<td>esta es la descripcion</td>
				</tr>
                                <tr>
					<td>10/09/2015</td>
					<td>clinica gggggg</td>
					<td>esta es la descripcion</td>
				</tr>
                                <tr>
					<td>10/09/2015</td>
					<td>clinica gggggg</td>
					<td>esta es la descripcion</td>
				</tr>
                                <tr>
					<td>10/09/2015</td>
					<td>clinica gggggg</td>
					<td>esta es la descripcion</td>
				</tr>
                                <tr>
					<td>10/09/2015</td>
					<td>clinica gggggg</td>
					<td>esta es la descripcion</td>
				</tr>
                                <tr>
					<td>10/09/2015</td>
					<td>clinica gggggg</td>
					<td>esta es la descripcion</td>
				</tr>
                                <tr>
					<td>10/09/2015</td>
					<td>clinica gggggg</td>
					<td>esta es la descripcion</td>
				</tr>
                                <tr>
					<td>10/09/2015</td>
					<td>clinica gggggg</td>
					<td>esta es la descripcion</td>
				</tr>
                                <tr>
					<td>10/09/2015</td>
					<td>clinica gggggg</td>
					<td>esta es la descripcion</td>
				</tr>
                             

				
			</tbody>
		</table>
		<br>
	</div>
	
    <div class="footer l-box-lrg is-center">
        Seminario Integrador III - II Semestre 2015
    </div>

</div>

</body>


</html>