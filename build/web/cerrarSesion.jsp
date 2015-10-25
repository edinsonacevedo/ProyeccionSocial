<%-- 
    Document   : cerrarSesion
    Created on : 24/10/2015, 07:38:30 PM
    Author     : Edinson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <%
            HttpSession sesionU = request.getSession();
            sesionU.invalidate();
            response.sendRedirect("index.jsp");
            %>
            
    </body>
</html>
