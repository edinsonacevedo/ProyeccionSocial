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
 <jsp:useBean id="presupuesto" scope="page" class="co.edu.ufps.proyeccionSocial.dto.PresupuestoDto" />

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
	<% presupuesto = facade.consultarPresupuesto(Integer.parseInt(request.getParameter("presupuesto"))); %>

	<div class="calendario">
            <h2 class="is-center" style="text-transform: uppercase">Presupuesto : <%= request.getParameter("nomActividad")%></h2>
                        
                        <form class="pure-form pure-form-stacked" style="text-align: left; ">
                            <fieldset>
                                <%
                                    String nota ="";
                                    if(presupuesto.getEstado().equalsIgnoreCase("No Asignado")){
                                        nota = ": El lider de la actividad aun no ha asignado el Prepuesto.";
                                    }
                                    if(presupuesto.getEstado().equalsIgnoreCase("Desaprobado")){
                                        nota = ": No aprobaste este Presupuesto.";
                                    }
                                    if(presupuesto.getEstado().equalsIgnoreCase("Aprobado")){
                                        nota = ": Aprobaste este Presupuesto.";
                                    }
                                    if(presupuesto.getEstado().equalsIgnoreCase("En Espera")){
                                        nota = ": Debes Aprobar o Desaprobar este presupuesto.";
                                    }
                                %>
                                <legend>Detalle Presupuesto <%=nota%></legend>

                                <div class="pure-g">
                                    <div class="pure-u-1 pure-u-md-1-3 l-box" >
                                        <label for="monto">Monto en Pesos</label>
                                        <input  id="monto" class="pure-u-20-24" value="<%=presupuesto.getMonto()%>" type="text" readonly>
                                    </div>
                                    
                                    <div class="pure-u-1 pure-u-md-1-3 l-box">
                                        <label for="fecha">Fecha de Asignado</label>
                                        <input  id="fecha" class="pure-u-23-24" value="<%=presupuesto.getFecha()%>" type="text" readonly>
                                    </div>
                                    
                                    <div class="pure-u-1 pure-u-md-1-3 l-box">
                                        <label for="estado">Estado</label>
                                        <input id="estado" class="pure-u-23-24" value="<%=presupuesto.getEstado()%>" type="text" readonly>
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                        
                        <h3 class="is-center">Actividades Presupuestales</h3>
			
                        <table class="table table-bordered" align="center"  id="actPresupuestales">
                                <thead>
                                        <tr>

                                                <th>Nombre</th>
                                                <th>Monto</th>
                                                <th>Descripción</th>
                                                <th>Monto ajustado</th>
                                                
                                        </tr>
                                </thead>

                                <tbody>

                                    <%=facade.mostrarActividadesPresupuestales(presupuesto.getIdPresupuesto())%>
                                </tbody>
                        </table>
			
		
		<form class="pure-form">
			<fieldset>
				<legend>Acciones</legend>
                                <button href="#myModalEditarPresupuesto" role="button" data-toggle="modal" type="button" class="pure-button pure-button-primary">
				<i class="fa fa-pencil-square-o"></i> Editar</button>
                                <a href="actividadBienestar.jsp?actividad=<%=request.getParameter("actividad")%>"  type="button" class="pure-button pure-button-primary">
				<i class="fa fa-angle-double-left"></i> Atras</a>
				
                                
			</fieldset>
		</form>
		
	</div>
	
	
	
	<div id="myModalEditarPresupuesto" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header is-center">
                    <h2 id="myModalLabel">Editar Presupuesto <%=request.getParameter("nomActividad")%></h2>
		</div>

		<div class="modal-body">
                        
                    <p>
                        Aqui usted puede cambiar el Aprobar o Desaprobar el Presupuesto.
                    </p>
			

			<form class="pure-form pure-form-stacked" action="editarEstadoPresupuesto.jsp" method="post">

				<label for="estado">estado</label>
				<select id="estado" name="estado" class="pure-u-1">
                                    <option value="<%=presupuesto.getEstado()%>" selected><%=presupuesto.getEstado()%></option>
                                        <option value="En Espera">En Espera</option>
                                        <!--<option value="No Asignado">No Asignado</option>-->
                                        <option value="Aprobado">Aprobado</option>
                                        <option value="Desaprobado">Desaprobado</option>
				</select>
                                    <input type="hidden" id="idPresupuesto" name="idPresupuesto" value="<%=presupuesto.getIdPresupuesto()%>">
                                    <input type="hidden" id="monto" name="monto" value="<%=presupuesto.getMonto()%>">
                                    <input type="hidden" id="estado_anterior" name="estado_anterior" value="<%=presupuesto.getEstado()%>">
                                    <input type="hidden" id="fechaP" name="fechaP" value="<%=presupuesto.getFecha()%>">
                                    
                                    <input type="hidden" id="nomActividad" name="nomActividad" value="<%=request.getParameter("nomActividad")%>">
                                    <input type="hidden" id="actividad" name="actividad" value="<%=request.getParameter("actividad")%>">
                                    


                                <label for="nota">Nota al Lider</label>
                                <textarea id="nota" name="nota"  class="pure-u-1"><%=presupuesto.getNota()%></textarea>

                                
				
				<div class="modal-footer">
					<button	class="pure-button pure-button-primary" type="submit">Guardar</button>
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
        $('#actPresupuestales').DataTable({
           
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
                },
                buttons: {
                    buttons: [ 'copy', 'csv', 'excel' ]
                }
    
            }
        } );
        
    } );
</script>
</html>
