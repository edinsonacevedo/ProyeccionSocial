package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html lang=\"es\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("<meta name=\"description\" content=\"A layout example that shows off a responsive product landing page.\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <title>Proyección Social &ndash; Ingeniería de Sistemas &ndash; UFPS</title>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<link rel=\"stylesheet\" href=\"http://yui.yahooapis.com/pure/0.6.0/pure-min.css\">\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://yui.yahooapis.com/pure/0.6.0/grids-responsive-min.css\">\n");
      out.write("  \n");
      out.write("\t<link rel=\"stylesheet\" href=\"http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css\">\n");
      out.write("\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/estilos.css\">\n");
      out.write("    \n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/modal.css\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\t\t\t<div id=\"myModalInicioSesion\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n");
      out.write("\t\t\t\t<div class=\"modal-header is-center\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t<h1 id=\"myModalLabel\">Proyección Social</h1>\n");
      out.write("\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\n");
      out.write("\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t<!--<This modal is launched by including <em>just</em> the <code>modal.css</code> and <code>modal.js</code> \n");
      out.write("\t\t\t\t\t\tfile from Bootstrap, and including Pure to drive all low-level styles. The result is a fully-functional Modal u\n");
      out.write("\t\t\t\t\t\tsing just a fraction of the CSS.-->\n");
      out.write("\t\t\t\t\t</p>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<form class=\"pure-form pure-form-stacked\" action=\"actividad.jsp\" method=\"post\">\n");
      out.write("\t\t\t\t\t\t<legend>Digite su Usuario y Contraseña para iniciar sesion.</legend>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<label for=\"usuario\">Usuario</label>\n");
      out.write("\t\t\t\t\t\t<input id=\"usuario\" name=\"usuario\" type=\"text\" placeholder=\"Nombre del usuario\" required>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<label for=\"pass\">Contraseña</label>\n");
      out.write("\t\t\t\t\t\t<input id=\"pass\" name=\"pass\" type=\"password\" placeholder=\"Contraseña de usuario\" required>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\n");
      out.write("                                                <label for=\"rol\">Tipo de usuario</label>\n");
      out.write("                                                <select class=\"input\" name=\"rol\">\n");
      out.write("                                                    <option value=\"administrador\">Administrador</option>\n");
      out.write("                                                    <option value=\"docente\">Docente</option>\n");
      out.write("                                                    <option value=\"estudiante\">Estudiante</option>\n");
      out.write("                                                </select>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<div class=\"modal-footer\">\n");
      out.write("\t\t\t\t\t\t\t<button\tclass=\"pure-button pure-button-primary\" type=\"submit\">Iniciar</button>\n");
      out.write("\t\t\t\t\t\t\t<button class=\"pure-button\" data-dismiss=\"modal\" aria-hidden=\"true\">Cancelar</button>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t<script src=\"http://code.jquery.com/jquery-1.9.1.js\"></script>\n");
      out.write("\t\t\t<script src=\"http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"header\">\n");
      out.write("    <div class=\"home-menu pure-menu pure-menu-horizontal pure-menu-fixed\">\n");
      out.write("\n");
      out.write("        <a class=\"pure-menu-heading\" href=\"index.html\">Proyección Social</a>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <ul class=\"pure-menu-list\">\n");
      out.write("            <li class=\"pure-menu-item\">\n");
      out.write("\t\t\t\t<a class=\"pure-menu-link\" href=\"#myModalInicioSesion\" role=\"button\" data-toggle=\"modal\">\n");
      out.write("\t\t\t\t\t<i class=\"fa fa-sign-in\"></i>\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\t\t\t</li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\t\t\t\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"splash-container\">\n");
      out.write("\n");
      out.write("    <div class=\"splash\">\n");
      out.write("        <!--<h1 class=\"splash-head\">Ingenieria de Sistemas UFPS</h1>-->\n");
      out.write("\t\t <div class=\" is-center pure-u-1\">\n");
      out.write("            <a href=\"http://ingsistemas.ufps.edu.co/\">\n");
      out.write("\t\t\t\t<img class=\"pure-img-responsive\"  width=\"700\" src=\"img/logo-horizontal.png\">\n");
      out.write("\t\t\t</a>\n");
      out.write("\t\t</div>\n");
      out.write("        <p class=\"splash-subhead\">\n");
      out.write("            Universidad Francisco de Paula Santander\n");
      out.write("        </p>\n");
      out.write("        <p>\n");
      out.write("            <!-- <a href=\"http://purecss.io\" class=\"pure-button pure-button-primary\">Get Started</a>-->\n");
      out.write("        </p>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"content-wrapper\">\n");
      out.write("    <div class=\"content\">\n");
      out.write("        <!--<h2 class=\"content-head is-center\"></h2>-->\n");
      out.write("\n");
      out.write("        <div class=\"pure-g\">\n");
      out.write("            <div class=\"l-box pure-u-1 pure-u-md-1-2 pure-u-lg-1-4\">\n");
      out.write("\n");
      out.write("                <h3 class=\"content-subhead\">\n");
      out.write("\t\t\t\t\t<a href=\"\">\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-hand-o-right\"></i>Proyecto Social\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("                </h3>\n");
      out.write("                <p>\n");
      out.write("                    Propicia y establece procesos permanentes de interacción e integración con diferentes\n");
      out.write("\t\t\t\t\tentidades regionales.\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"l-box pure-u-1 pure-u-md-1-2 pure-u-lg-1-4\">\n");
      out.write("                <h3 class=\"content-subhead\">\n");
      out.write("                    <a href=\"\">\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-users\"></i>Bienestar Social\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("                </h3>\n");
      out.write("                <p>\n");
      out.write("                    Actividades destinados a la complementación de las diferentes habilidades, y factores que\n");
      out.write("\t\t\t\t\tparticipan en la calidad de la vida de las personas de nuestro Programa educativo.\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"l-box pure-u-1 pure-u-md-1-2 pure-u-lg-1-4\">\n");
      out.write("                <h3 class=\"content-subhead\">\n");
      out.write("                    \n");
      out.write("                    <a href=\"calendario.jsp\">\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-calendar\"></i>Calendario de Actividades\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("                </h3>\n");
      out.write("                <p>\n");
      out.write("\n");
      out.write("                    Aquí usted puede conocer los eventos y actividades a realizarse proximamente dentro del marco de la Proyección \n");
      out.write("\n");
      out.write("\t\t\t\t\ty el Bienestar social de nuestro Programa.\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"l-box pure-u-1 pure-u-md-1-2 pure-u-lg-1-4\">\n");
      out.write("                <h3 class=\"content-subhead\">\n");
      out.write("                   \n");
      out.write("                    <a href=\"convenios.jsp\">\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-check\"></i>Convenios\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("                </h3>\n");
      out.write("                <p>\n");
      out.write("                    Conozca la diferentes entidades que han realizado un convenio con el Programa.\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!--<div class=\"ribbon l-box-lrg pure-g\">\n");
      out.write("        <div class=\"l-box-lrg is-center pure-u-1 pure-u-md-1-2 pure-u-lg-2-5\">\n");
      out.write("            <img class=\"pure-img-responsive\" alt=\"File Icons\" width=\"300\" src=\"img/logo.png\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"pure-u-1 pure-u-md-1-2 pure-u-lg-3-5\">\n");
      out.write("\n");
      out.write("            <h2 class=\"content-head content-head-ribbon\">Programa de Ingenieria de Sistemas</h2>\n");
      out.write("\n");
      out.write("            <p>\n");
      out.write("                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n");
      out.write("                tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n");
      out.write("                quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n");
      out.write("                consequat. Duis aute irure dolor.\n");
      out.write("            </p>\n");
      out.write("        </div>\n");
      out.write("    </div>-->\n");
      out.write("\n");
      out.write("    <div class=\"content content-white\">\n");
      out.write("\n");
      out.write("        <h2 class=\"content-head is-center\">Tu Opinión es Importante</h2>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"pure-g\">\n");
      out.write("            <div class=\"l-box-lrg pure-u-1 pure-u-md-2-5\">\n");
      out.write("                <form class=\"pure-form pure-form-stacked\">\n");
      out.write("                    <fieldset>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<label for=\"nombre\">Nombre</label>\n");
      out.write("\t\t\t\t\t\t\t<input id=\"nombre\" name=\"nombre\" type=\"text\" placeholder=\"escriba su nombre\" required>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<label for=\"email\">Email</label>\n");
      out.write("\t\t\t\t\t\t\t<input id=\"email\" type=\"email\" placeholder=\"escriba su email\" required>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<label for=\"mensaje\">Mensaje</label>\n");
      out.write("\t\t\t\t\t\t\t<textarea id=\"mensaje\" name=\"mensaje\" class=\"pure-u-1\" cols=\"53\" rows=\"4\" placeholder=\"escriba su mensaje\" required></textarea>\n");
      out.write("\t\t\t\t\t\t\t<br>\n");
      out.write("                        <button type=\"submit\" class=\"pure-button\">Enviar</button>\n");
      out.write("                    </fieldset>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"l-box-lrg pure-u-1 pure-u-md-3-5\">\n");
      out.write("\n");
      out.write("\t\t\t\t<h4>Envíenos su mensaje</h4>\n");
      out.write("                <p>\n");
      out.write("                    Lo invitamos a que nos escriba sus comentarios, dudas e inquietudes \n");
      out.write("\t\t\t\t\tjunto con su nombre y dirección de correo electrónico a través de éste formulario.\n");
      out.write("                </p>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<h4>Contáctenos</h4>\n");
      out.write("                <p>\n");
      out.write("                    Programa de Ingeniería de Sistemas.<br>\n");
      out.write("\n");
      out.write("\t\t\t\t\tAcreditado de Alta Calidad Resolución No.15757 M.E.N.<br>\n");
      out.write("\t\t\t\t\tAv Gran Colombia No. 12E-96 Barrio Colsag. Cúcuta - Colombia<br>\n");
      out.write("\t\t\t\t\t(057) 5776655 ext 201-203<br>\n");
      out.write("\t\t\t\t\tingsistemas@ufps.edu.co\n");
      out.write("                </p>\n");
      out.write("\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"footer l-box is-center\">\n");
      out.write("        Seminario Integrador III - II Semestre 2015\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}