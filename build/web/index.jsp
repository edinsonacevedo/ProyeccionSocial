<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
    <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="A layout example that shows off a responsive product landing page.">



    <title>Proyección Social &ndash; Ingeniería de Sistemas &ndash; UFPS</title>



	<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">

    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-min.css">
  
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">

	<link rel="stylesheet" href="css/estilos.css">
    
	<link rel="stylesheet" href="css/modal.css">

</head>
<body>

			<div id="myModalInicioSesion" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-header is-center">

					<h1 id="myModalLabel">Proyección Social</h1>

				</div>

				<div class="modal-body">
					<p>
						<!--<This modal is launched by including <em>just</em> the <code>modal.css</code> and <code>modal.js</code> 
						file from Bootstrap, and including Pure to drive all low-level styles. The result is a fully-functional Modal u
						sing just a fraction of the CSS.-->
					</p>

					<form class="pure-form pure-form-stacked" action="actividad.jsp" method="post">
						<legend>Digite su Usuario y Contraseña para iniciar sesion.</legend>

						<label for="usuario">Usuario</label>
						<input id="usuario" name="usuario" type="text" placeholder="Nombre del usuario" required>

						<label for="pass">Contraseña</label>
						<input id="pass" name="pass" type="password" placeholder="Contraseña de usuario" required>
						

                                                <label for="rol">Tipo de usuario</label>
                                                <select class="input" name="rol">
                                                    <option value="administrador">Administrador</option>
                                                    <option value="docente">Docente</option>
                                                    <option value="estudiante">Estudiante</option>
                                                </select>

						
						<div class="modal-footer">
							<button	class="pure-button pure-button-primary" type="submit">Iniciar</button>
							<button class="pure-button" data-dismiss="modal" aria-hidden="true">Cancelar</button>
						</div>
					</form>
				</div>

				
			</div>

			<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
			<script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>


<div class="header">
    <div class="home-menu pure-menu pure-menu-horizontal pure-menu-fixed">

        <a class="pure-menu-heading" href="index.html">Proyección Social</a>


        <ul class="pure-menu-list">
            <li class="pure-menu-item">
				<a class="pure-menu-link" href="#myModalInicioSesion" role="button" data-toggle="modal">
					<i class="fa fa-sign-in"></i>
				</a>
			</li>
        </ul>
    </div>
</div>

			



<div class="splash-container">

    <div class="splash">
        <!--<h1 class="splash-head">Ingenieria de Sistemas UFPS</h1>-->
		 <div class=" is-center pure-u-1">
            <a href="http://ingsistemas.ufps.edu.co/">
				<img class="pure-img-responsive"  width="700" src="img/logo-horizontal.png">
			</a>
		</div>
        <p class="splash-subhead">
            Universidad Francisco de Paula Santander
        </p>
        <p>
            <!-- <a href="http://purecss.io" class="pure-button pure-button-primary">Get Started</a>-->
        </p>
    </div>
</div>

<div class="content-wrapper">
    <div class="content">
        <!--<h2 class="content-head is-center"></h2>-->

        <div class="pure-g">
            <div class="l-box pure-u-1 pure-u-md-1-2 pure-u-lg-1-4">

                <h3 class="content-subhead">
					<a href="">
						<i class="fa fa-hand-o-right"></i>Proyecto Social
					</a>
                </h3>
                <p>
                    Propicia y establece procesos permanentes de interacción e integración con diferentes
					entidades regionales.
                </p>
            </div>
            <div class="l-box pure-u-1 pure-u-md-1-2 pure-u-lg-1-4">
                <h3 class="content-subhead">
                    <a href="">
						<i class="fa fa-users"></i>Bienestar Social
					</a>
                </h3>
                <p>
                    Actividades destinados a la complementación de las diferentes habilidades, y factores que
					participan en la calidad de la vida de las personas de nuestro Programa educativo.
                </p>
            </div>
            <div class="l-box pure-u-1 pure-u-md-1-2 pure-u-lg-1-4">
                <h3 class="content-subhead">
                    
                    <a href="calendario.jsp">
						<i class="fa fa-calendar"></i>Calendario de Actividades
					</a>
                </h3>
                <p>

                    Aquí usted puede conocer los eventos y actividades a realizarse proximamente dentro del marco de la Proyección 

					y el Bienestar social de nuestro Programa.
                </p>
            </div>
            <div class="l-box pure-u-1 pure-u-md-1-2 pure-u-lg-1-4">
                <h3 class="content-subhead">
                   
                    <a href="convenios.jsp">
						<i class="fa fa-check"></i>Convenios
					</a>
                </h3>
                <p>
                    Conozca la diferentes entidades que han realizado un convenio con el Programa.
                </p>
            </div>
        </div>
    </div>

    <!--<div class="ribbon l-box-lrg pure-g">
        <div class="l-box-lrg is-center pure-u-1 pure-u-md-1-2 pure-u-lg-2-5">
            <img class="pure-img-responsive" alt="File Icons" width="300" src="img/logo.png">
        </div>
        <div class="pure-u-1 pure-u-md-1-2 pure-u-lg-3-5">

            <h2 class="content-head content-head-ribbon">Programa de Ingenieria de Sistemas</h2>

            <p>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                consequat. Duis aute irure dolor.
            </p>
        </div>
    </div>-->

    <div class="content content-white">

        <h2 class="content-head is-center">Tu Opinión es Importante</h2>


        <div class="pure-g">
            <div class="l-box-lrg pure-u-1 pure-u-md-2-5">
                <form class="pure-form pure-form-stacked">
                    <fieldset>
						
						
							<label for="nombre">Nombre</label>
							<input id="nombre" name="nombre" type="text" placeholder="escriba su nombre" required>
							
							

							<label for="email">Email</label>
							<input id="email" type="email" placeholder="escriba su email" required>

							<label for="mensaje">Mensaje</label>
							<textarea id="mensaje" name="mensaje" class="pure-u-1" cols="53" rows="4" placeholder="escriba su mensaje" required></textarea>
							<br>
                        <button type="submit" class="pure-button">Enviar</button>
                    </fieldset>
                </form>
            </div>

            <div class="l-box-lrg pure-u-1 pure-u-md-3-5">

				<h4>Envíenos su mensaje</h4>
                <p>
                    Lo invitamos a que nos escriba sus comentarios, dudas e inquietudes 
					junto con su nombre y dirección de correo electrónico a través de éste formulario.
                </p>
				
				<h4>Contáctenos</h4>
                <p>
                    Programa de Ingeniería de Sistemas.<br>

					Acreditado de Alta Calidad Resolución No.15757 M.E.N.<br>
					Av Gran Colombia No. 12E-96 Barrio Colsag. Cúcuta - Colombia<br>
					(057) 5776655 ext 201-203<br>
					ingsistemas@ufps.edu.co
                </p>

                
            </div>
        </div>

    </div>

    <div class="footer l-box is-center">
        Seminario Integrador III - II Semestre 2015
    </div>

</div>






</body>
</html>
