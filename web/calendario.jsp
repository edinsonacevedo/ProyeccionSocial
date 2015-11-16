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

    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-min.css">

	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">

    <link rel="stylesheet" href="css/estilos.css">
	
	<link  rel="stylesheet" href="css/calendar.css">
	
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>

	<script src="js/calendar.js"></script>
 
</head>
<body>

    <jsp:useBean id="facade" scope="page" class="co.edu.ufps.proyeccionSocial.facade.PsocialFacade"/>

<div class="header">
    <div class="home-menu pure-menu pure-menu-horizontal pure-menu-fixed">
        <a class="pure-menu-heading" href="index.jsp">Proyeccion Social</a>

        <ul class="pure-menu-list">
            <li class="pure-menu-item"><a href="index.jsp" class="pure-menu-link"><i class="fa fa-angle-double-left"></i> Volver</i></a></li>
        </ul>
    </div>
</div>



<div class="contenido">
	
	<div class="calendario">
            <br>
		<h1>Agenda de Eventos</h1>

                <div class="calendar"  data-color="normal">
			
			<!--
                        <div data-role="day" data-day="20151116">
				<div data-role="event" data-name="Socializacion Maestrias UniNorte" data-start="3.00 pm" data-end="6.00 pm" data-location="UFPS"></div>
			</div> -->
                        <%=facade.mostrarActividadesCalendario()%>
		</div>
		
		
	</div>
		
	<br>

    <div class="footer l-box-lrg is-center">
        Seminario Integrador III - II Semestre 2015
    </div>

</div>


<script>
	var yy;
	var calendarArray =[];
	var monthOffset = [6,7,8,9,10,11,0,1,2,3,4,5];
	var monthArray = [["ENE","Enero"],["FEB","Febrero"],["MAR","Marzo"],["ABR","Abril"],["MAY","Mayo"],["JUN","Junio"],["JUL","Julio"],["AGO","Agosto"],["SEP","Septiembre"],["OCT","Octubre"],["NOV","Noviembre"],["DIC","Diciembre"]];
	var letrasArray = ["L","M","Mi","J","V","S","D"];
	var dayArray = ["7","1","2","3","4","5","6"];
	$(document).ready(function() {
		$(document).on('click','.calendar-day.have-events',activateDay);
		$(document).on('click','.specific-day',activatecalendar);
		$(document).on('click','.calendar-month-view-arrow',offsetcalendar);
		$(window).resize(calendarScale);
		$(".calendar").calendar({
			"2013910": {
				"Mulberry Festival": {
					start: "9.00",
					end: "9.30",
					location: "London"
				}
			}
		});
		calendarSet();
		calendarScale();
		});
</script>
	
</body>
</html>
