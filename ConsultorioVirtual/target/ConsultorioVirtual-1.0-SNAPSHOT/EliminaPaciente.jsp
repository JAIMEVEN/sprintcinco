<%-- 
    Document   : EliminaPaciente
    Created on : 8/10/2021, 2:46:04 p. m.
    Author     : andre
--%>

<%@page import="Logica.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Elimina Paciente</title>
    </head>
    <body>
        <h1>Eliminar Paciente</h1>
        <p>Identificacion:</p>
        <%
            Paciente p;
            p = new Paciente();
            String resultado;
            String documento;
            documento = request.getParameter("documento");
            p.setDocumento(documento);
            resultado = p.eliminarPaciente();
            out.println(resultado);
        %>
    </body>
</html>
