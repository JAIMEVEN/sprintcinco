<%-- 
    Document   : Proceso Medicamento
    Created on : 1/10/2021, 9:37:22 p. m.
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos Medicamento</title>
    </head>
    <body>
        <%
   /*podemos leer los datos del request a una variable*/
   /*String edad=(String)request.getParameter("edad");
   String prefieres=(String)request.getParameter("preferencia");*/
   String cantidad=(String)request.getParameter("cantidad");
   out.print("el nombre del medicamento es "+request.getParameter("nombre"));
   out.print("<br/>");
   out.print("la referencia es "+request.getParameter("referencia"));
   out.print("<br/>");
   out.print("Del laboratorio "+request.getParameter("laboratorio"));
   out.print("<br/>");
   out.print("el tipo es "+request.getParameter("tipoMed"));
   out.print("<br/>");
   out.print("la cantidad es "+cantidad);
   out.print("<br/>");
   /*podemos usar los datos directamente desde el request*/
   out.print("Ingresado Medicamento "+ request.getParameter("nombre").toString().toUpperCase());
 %>
    </body>
</html>
