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
	<!--[if lte IE 8]>
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-old-ie-min.css">
	<![endif]-->
	<!--[if gt IE 8]><!-->
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-min.css">
	<!--<![endif]-->
	
	
	
	<!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">

      // Load the Visualization API and the piechart package.
      google.load('visualization', '1.0', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
          ['Cine', 25],
          ['Videojuegos', 15],
          ['Cursos bienestar', 30],
          ['Integracion', 50],
          ['Deportes', 21]
        ]);

        // Set chart options
        var options = {'title':'Participacion en Actividades en el Ultimo Mes',
                       'width':600,
                       'height':400};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
	
	
 
</head>
<body>

<div class="header">
    <div class="home-menu pure-menu pure-menu-horizontal pure-menu-fixed">
        <a class="pure-menu-heading capitalize" href=""><i class="fa fa-user"> Usuario</i></a>
		
        <ul class="pure-menu-list">
            <li class="pure-menu-item"><a href="actividad.jsp" class="pure-menu-link">Actividades</a></li>
			<li class="pure-menu-item"><a href="plantrabajo.jsp" class="pure-menu-link">Planes</a></li>
			<li class="pure-menu-item"><a href="convenio.jsp" class="pure-menu-link">Convenios</a></li>
            <li class="pure-menu-item"><a href="index.jsp" class="pure-menu-link"><i class="fa fa-sign-out"></i></a></li>
        </ul>
    </div>
	
</div>
	
<div class="contenido">
	
	<div class="calendario">
		
		<div class="consulta">
			<form class="pure-form pure-form-stacked">
				<fieldset>
					<h3>Reportes estadisticos</h3>
					<div class="pure-g">
						<div class="pure-u-1 pure-u-md-1-3">
							<label for="first-name">Palabra Clave</label>
							<input id="first-name" class="pure-u-23-24" type="text">
						</div> 

						<div class="pure-u-1 pure-u-md-1-3">
							<label for="state">Criterio</label>
							<select id="state" class="pure-input-2-5">
								<option>Estudiantes x Actividad</option>
								<option>Por Meses</option>
								<option>IL</option>
							</select>
						</div>
						
						<div class="pure-u-1 pure-u-md-1-3">
							
						</div>
					</div>

					

					
				</fieldset>
				<button type="submit" class="pure-button pure-button-primary">Generar</button>
			</form>
		</div>
		
		<div id="chart_div" align="center"></div>
	
		
	</div>
	
	<div class="footer l-box is-center">
        Seminario Integrador III - II Semestre 2015
    </div>
		
		
		
</div>
		

</body>
</html>
