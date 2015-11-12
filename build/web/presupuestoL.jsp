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
 <jsp:useBean id="presupuesto" scope="page" class="co.edu.ufps.proyeccionSocial.dto.PresupuestoDto" />

<div class="header">
    <div class="home-menu pure-menu pure-menu-horizontal pure-menu-fixed">
        
        <a class="pure-menu-heading capitalize" href=""><i class="fa fa-user"> - <%=usuario%></i></a>

        <ul class="pure-menu-list">
        
            
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
                                        nota = ": Debes asignar un presupuesto para que el Administrador lo apruebe.";
                                    }
                                    if(presupuesto.getEstado().equalsIgnoreCase("Desaprobado")){
                                        nota = ": El administrtador desaprobo el presupuesto, puedes modificarlo para que este los apruebe.";
                                    }
                                    if(presupuesto.getEstado().equalsIgnoreCase("Aprobado")){
                                        nota = ": Tu presupuesto ha sido aprobado por el administrador.";
                                    }
                                    if(presupuesto.getEstado().equalsIgnoreCase("En Espera")){
                                        nota = ": Espera a que el administrador apruebe o desapruebe el Presupuesto.";
                                    }
                                %>
                                <legend>Detalle Presupuesto <%=nota%></legend>

                                <div class="pure-g">
                                    <div class="pure-u-1 pure-u-md-1-4 l-box" >
                                        <label for="monto">Monto en Pesos</label>
                                        <input  id="monto" class="pure-u-20-24" value="<%=presupuesto.getMonto()%>" type="text" readonly>
                                    </div>
                                    
                                    <div class="pure-u-1 pure-u-md-1-4 l-box">
                                        <label for="fecha">Fecha de Asignado</label>
                                        <input  id="fecha" class="pure-u-23-24" value="<%=presupuesto.getFecha()%>" type="text" readonly>
                                    </div>
                                    
                                    <div class="pure-u-1 pure-u-md-1-4 l-box">
                                        <label for="estado">Estado</label>
                                        <input id="estado" class="pure-u-23-24" value="<%=presupuesto.getEstado()%>" type="text" readonly>
                                    </div>
                                    
                                    <div class="pure-u-1 pure-u-md-1-4 l-box">
                                        <label for="nota">Nota del Administrador</label>
                                        <textarea id="nota" class="pure-u-24-24"  readonly><%=presupuesto.getNota()%></textarea>
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
                                                <th>Monto Ejecutado</th>
                                                
                                        </tr>
                                </thead>

                                <tbody>

                                    <%=facade.mostrarActividadesPresupuestales(presupuesto.getIdPresupuesto())%>
                                </tbody>
                        </table>
			
		
		<form class="pure-form">
			<fieldset>
                            <legend>Acciones Actividad Presupuestal</legend>
                                <button href="#myModalNuevaActP" role="button" data-toggle="modal" type="button" class="pure-button pure-button-primary">
				<i class="fa fa-plus"></i> Nueva</button>
                                <button href="#myModalEditarActP" role="button" data-toggle="modal" type="button" class="pure-button pure-button-primary">
				<i class="fa fa-pencil-square-o"></i> Editar</button>
                                <button href="#myModalEjecutarP" role="button" data-toggle="modal" type="button" class="pure-button pure-button-primary">
				<i class="fa fa-check-square-o"></i> Ejecutar</button>
                                <button href="#myModalBorrarActP" role="button" data-toggle="modal" type="button" class="pure-button pure-button-primary">
				<i class="fa fa-eraser"></i> Borrar</button>    
			</fieldset>
		</form>
		
	</div>
	
	
	
	<div id="myModalNuevaActP" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header is-center">
			<h2 id="myModalLabel">Nueva Actividad Presupuestal</h2>
		</div>

		<div class="modal-body">
			<p>
                            Registre una Actividad Presupuestal indicando lo siguiente.
			</p>

			<form class="pure-form pure-form-stacked" action="registrarActP.jsp" method="post">

				<label for="nomActividadPresupuestal">Nombre</label>
                                <input class="capitalize" id="nomActividadPresupuestal" name="nomActividadPresupuestal" type="text" placeholder="Nombre de la actividad" required>

                                <label for="montoPresupuestal">Monto Presupuestal</label>
                                <input id="montoPresupuestal" name="montoPresupuestal" type="number" placeholder="Cantidad en Pesos" required>

                                <label for="descripcionMonto">Descripcion</label>
                                <textarea id="descripcionMonto" name="descripcionMonto" class="pure-u-1 capitalize"></textarea>
                                
                                <input type="hidden" id="idPresupuesto" name="idPresupuesto" value="<%=presupuesto.getIdPresupuesto()%>">
                                <input type="hidden" id="nomActividad" name="nomActividad" value="<%=request.getParameter("nomActividad")%>">
                                <input type="hidden" id="actividad" name="actividad" value="<%=request.getParameter("actividad")%>">
                                <input type="hidden" id="estado_ant" name="estado_ant" value="<%=presupuesto.getEstado()%>">
                                <div class="modal-footer">
					<button	class="pure-button pure-button-primary" type="submit">Registrar</button>
					<button class="pure-button" data-dismiss="modal" aria-hidden="true">Cancelar</button>
				</div>
			</form>
		</div>

		
	</div>
         
        <div id="myModalEditarActP" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header is-center">
			<h2 id="myModalLabel">Editar Actividad Presupuestal</h2>
		</div>

		<div class="modal-body">
			<p>
                           Puedes editar las actividades presupuestales siempre y cuando el presupuesto no haya sido 
                           Aprobado.
			</p>

                        <form class="pure-form pure-form-stacked" action="editarActP.jsp" name="editarActP" method="post" >
                                
                                <label for="idActPresupuestal">Actividad Presupuestal</label>
                                <select id="idActPresupuestal" name="idActPresupuestal" class="pure-u-1" onchange="mostrarInfoActP()">
                                    <option value="0" selected>Seleccione:</option>
                                    <%=
                                            facade.listarActPresupuestales(presupuesto.getIdPresupuesto())
                                    %>
				</select>
                                <script type="text/javascript" src="js/general.js">
                                    
                                </script>
                                
                                <div id="divInfoActP">
                                    <label for="nomActividadPresupuestal">Nuevo Nombre</label>
                                    <input class="capitalize" id="nomActividadPresupuestal" name="nomActividadPresupuestal" type="text" placeholder="Nombre de la actividad" required>

                                    <label for="montoPresupuestal">Nuevo Monto Presupuestal</label>
                                    <input id="montoPresupuestal" name="montoPresupuestal" type="number" placeholder="Cantidad en Pesos" required>

                                    <label for="descripcionMonto">Nueva Descripcion</label>
                                    <textarea id="descripcionMonto" name="descripcionMonto" class="pure-u-1 capitalize"></textarea>
                                </div>
                                
                                <input type="hidden" id="idPresupuesto" name="idPresupuesto" value="<%=presupuesto.getIdPresupuesto()%>">
                                <input type="hidden" id="nomActividad" name="nomActividad" value="<%=request.getParameter("nomActividad")%>">
                                <input type="hidden" id="actividad" name="actividad" value="<%=request.getParameter("actividad")%>">
                                <input type="hidden" id="estado_ant" name="estado_ant" value="<%=presupuesto.getEstado()%>">
                               
                                
                                <div class="modal-footer">
					<button	class="pure-button pure-button-primary" type="submit">Guardar</button>
					<button class="pure-button" data-dismiss="modal" aria-hidden="true">Cancelar</button>
				</div>
			</form>
		</div>
	
	</div>
                                
        <div id="myModalEjecutarP" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header is-center">
			<h2 id="myModalLabel">Ejecutar Actividad Presupuestal</h2>
		</div>

		<div class="modal-body">
			<p>
                           Tenga el cuenta que el presupuesto debe haberse Aprobado y que el monto ejecutado 
                           no debe supuerar el monto designado para la Actividad presupuestal.
			</p>

                        <form class="pure-form pure-form-stacked" action="ejecutarMonto.jsp" name="ejecutarMonto" method="post">
                                
                                <label for="idActPresupuestal">Actividad Presupuestal</label>
                                <select id="idActPresupuestal" name="idActPresupuestal" class="pure-u-1" onchange="mostrarMontoEjecutado()">
                                    <option value="0" selected>Seleccione:</option>
                                    <%=
                                            facade.listarActPresupuestales(presupuesto.getIdPresupuesto())
                                    %>
				</select>
                                
                                <div id="divMontoAjustado">
                                    <label for="montoEjecutado">Monto Ejecutado</label>
                                    <input id="montoEjecutado" name="montoEjecutado" type="number" required>
                                </div>
				
				<input type="hidden" id="idPresupuesto" name="idPresupuesto" value="<%=presupuesto.getIdPresupuesto()%>">
                                <input type="hidden" id="nomActividad" name="nomActividad" value="<%=request.getParameter("nomActividad")%>">
                                <input type="hidden" id="actividad" name="actividad" value="<%=request.getParameter("actividad")%>">
                                <input type="hidden" id="estado_ant" name="estado_ant" value="<%=presupuesto.getEstado()%>">
                               
                                
                                <div class="modal-footer">
					<button	class="pure-button pure-button-primary" type="submit">Guardar</button>
					<button class="pure-button" data-dismiss="modal" aria-hidden="true">Cancelar</button>
				</div>
			</form>
		</div>

		
	</div>
                                
        <div id="myModalBorrarActP" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header is-center">
			<h2 id="myModalLabel">Borrar Actividad Presupuestal</h2>
		</div>

		<div class="modal-body">
			<p>
                           Puedes eliminar actividades presupuestales siempre y cuando el presupuesto no haya sido 
                           Aprobado.
			</p>

                        <form class="pure-form pure-form-stacked" action="borrarActP.jsp"  method="post" >
                                
                                <label for="idActPresupuestal">Actividad Presupuestal</label>
                                <select id="idActPresupuestal" name="idActPresupuestal" class="pure-u-1">
                                    <option value="0" selected>Seleccione:</option>
                                    <%=
                                            facade.listarActPresupuestales(presupuesto.getIdPresupuesto())
                                    %>
				</select>
                                
                                
                                <input type="hidden" id="idPresupuesto" name="idPresupuesto" value="<%=presupuesto.getIdPresupuesto()%>">
                                <input type="hidden" id="nomActividad" name="nomActividad" value="<%=request.getParameter("nomActividad")%>">
                                <input type="hidden" id="actividad" name="actividad" value="<%=request.getParameter("actividad")%>">
                                <input type="hidden" id="estado_ant" name="estado_ant" value="<%=presupuesto.getEstado()%>">
                               
                                
                                <div class="modal-footer">
					<button	class="pure-button pure-button-primary" type="submit">Borrar</button>
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
                info:           "Mostrando de _START_ a _END_ de _TOTAL_ Actividades Presupuestales",
                infoEmpty:      "Mostrando de 0 a 0 de 0 Actividades Presupuestales",
                infoFiltered:   "(Filtrado de _MAX_ Actividades en Total.)",
                infoPostFix:    "",
                loadingRecords: "Cargando...",
                zeroRecords:    "No se encontraron Actividades Presupuestales =(.",
                emptyTable:     "No Hay Actividades Presupuestales registradas.",
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
