<%@page import="com.emergentes.gestion.Lista"%>
<%
    Lista cal = (Lista) request.getAttribute("miObjetoCalificacion");
    String tit = (String) request.getAttribute("titulo");
    String btn = (String) request.getAttribute("boton");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="estilos.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1><%= tit %></h1>
        <div class="form-container" >
            <form action="MainServlet" method="post">
                <input type="hidden" name="txtId" value="<%= cal.getId() %>"  />
                <label>Nombre del estudiante: <input type="text" name="txtNombre" value="<%= cal.getNombre() %>" /></label><br><br>
                <label>Primer parcial 30 pts.: <input class="nota" type="text" name="txtP1" value="<%= cal.getP1()%>" /></label><br><br>
                <label>Segundo parcial 30 pts.: <input class="nota" type="text" name="txtP2" value="<%= cal.getP2()%>" /></label><br><br>
                <label>Examen Final 40 pts.: <input class="nota" type="text" name="txtEf" value="<%= cal.getEf()%>" /></label><br><br>
                <input type="submit" class="registro" name="" value="<%= btn %>" />
            </form>
        </div>
        
    </body>
</html>