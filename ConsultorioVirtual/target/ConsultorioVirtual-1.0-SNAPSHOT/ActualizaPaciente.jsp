<%-- 
    Document   : ActualizarPaciente
    Created on : 7/10/2021, 2:46:48 p. m.
    Author     : andre
--%>

<%@page language="java" %>
<%@page import="Logica.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualiza Paciente</title>
    </head>
    <body>
        <h1>Actualiza Paciente</h1>
        <b>Identificacion: </b>
        <%
            Paciente p;
            p = new Paciente();
            int id;
            String nombres;
            String apellidos;
            String tipoDoc;
            String documento;
            String genero;
            String telefono;
            String email;
            String resultado;            
            nombres = request.getParameter("nombres");
            apellidos = request.getParameter("apellidos");
            tipoDoc = request.getParameter("tipoDoc");
            documento = request.getParameter("documento");
            genero = request.getParameter("genero");
            telefono = request.getParameter("telefono");
            email = request.getParameter("email");            
            p.setNombres(nombres);
            p.setApellidos(apellidos);
            p.setTipoDoc(tipoDoc);
            p.setDocumento(documento);
            p.setGenero(genero);
            p.setTelefono(telefono);
            p.setEmail(email);
            resultado = p.modificaPaciente(documento);
            out.println(resultado);
        %>
    </body>
</html>
