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
 <jsp:useBean id="actividadPS" scope="page" class="co.edu.ufps.proyeccionSocial.dto.ActividadPSDto" />

<div class="header">
    <div class="home-menu pure-menu pure-menu-horizontal pure-menu-fixed">
        
        <a class="pure-menu-heading capitalize" href=""><i class="fa fa-user"> - <%=usuario%></i></a>

        <ul class="pure-menu-list">
            <li class="pure-menu-item"><a href="cerrarSesion.jsp" class="pure-menu-link"><i class="fa fa-sign-out"></i></a></li>
        </ul>
    </div>
</div>

        
<div class="contenido">
	<% actividadPS = facade.consultarAPS(Integer.parseInt(request.getParameter("actividad"))); %>

	<div class="calendario">
            <h2 class="is-center" style="text-transform: uppercase"><%= actividadPS.getNombre()%></h2>
                        
                        <form class="pure-form pure-form-stacked" style="text-align: left; ">
                            <fieldset>
                                <legend>Detalle Actividad</legend>

                                <div class="pure-g">
                                    <div class="pure-u-1 pure-u-md-1-3 l-box" >
                                        <label for="lugar">Lugar</label>
                                        <input  id="lugar" class="pure-u-20-24" value="<%= actividadPS.getLugar()%>" type="text" readonly>
                                    </div>
                                    
                                    <div class="pure-u-1 pure-u-md-1-3 l-box">
                                        <label for="first-name">Fecha</label>
                                        <input  id="first-name" class="pure-u-23-24" value="<%= actividadPS.getFecha()%>" type="text" readonly>
                                    </div>
                                    
                                    <div class="pure-u-1 pure-u-md-1-3 l-box">
                                        <label for="first-name">Convenio</label>
                                        <input id="first-name" class="pure-u-23-24" value="<%=actividadPS.getConvenio_id()%>-<%=facade.consultarConvenio(actividadPS.getConvenio_id()).getNombre()%>" type="text" readonly>
                                    </div>
                                    <div class="pure-u-1 pure-u-md-1-3 l-box">
                                        <label for="first-name">Codigo Lider</label>
                                        <input id="first-name" class="pure-u-23-24" value="<%= actividadPS.getLider_codigoUFPS()%>" type="text" readonly>
                                    </div>
                                    <div class="pure-u-1 pure-u-md-1-3 l-box" >
                                        <label for="first-name">Estado</label>
                                        <input id="first-name" class="pure-u-23-24" value="<%= actividadPS.getEstado()%>" type="text" readonly>
                                    </div>
                                    <div class="pure-u-1 pure-u-md-1-3 l-box">
                                        <label for="first-name">Descripcion</label>
                                        <textarea id="first-name" class="pure-u-24-24"  readonly><%= actividadPS.getDescripcion()%></textarea>
                                    </div>

                                    
                                </div>
                            </fieldset>
                        </form>
			
		
		<form class="pure-form">
			<fieldset>
				<legend>Acciones</legend>
                                <!--<button href="#myModalEditarAct" role="button" data-toggle="modal" type="button" class="pure-button pure-button-primary">
				<i class="fa fa-pencil-square-o"></i> Editar</button>-->
                                
                                <a href="presupuestoL.jsp?presupuesto=<%=actividadPS.getPresupesto_id()%>&nomActividad=<%=actividadPS.getNombre()%>&actividad=<%=actividadPS.getIdActividadPS()%>" 
                                   class="pure-button pure-button-primary">
				<i class="fa fa-usd"></i> Presupuesto</a>
				
                                <a href="lider.jsp"  type="button" class="pure-button pure-button-primary">
				<i class="fa fa-angle-double-left"></i> Atras</a>
				
                                
			</fieldset>
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
