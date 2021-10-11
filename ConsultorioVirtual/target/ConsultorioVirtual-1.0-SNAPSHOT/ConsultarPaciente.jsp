<%-- 
    Document   : ConsultarPaciente
    Created on : 1/10/2021, 5:10:20 p. m.
    Author     : andre
--%>

<%@page import="Logica.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="Estilos.css" rel="stylesheet" type="text/css"/> <!--agregamos el archivo css Estilos.css-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ConsultarPaciente</title>
    </head>
    <body>
        <h1>Consultorio Virtual</h1>
        <div id="header">            
                <ul class="nav">
                    <li><a href="Index.jsp">Inicio</a></li>
                    <li><a href="">Paciente</a>
                        <ul>
                            <li><a href="Paciente.jsp">Registrar Paciente</a></li>
                            <li><a href="ConsultarPaciente.jsp">Consultar Paciente</a></li>
                            <li><a href="ActualizarPaciente.jsp">Actualizar Paciente</a></li>
                            <li><a href="EliminarPaciente.jsp">Eliminar Paciente</a></li>
                        </ul>
                    </li>
                    <li><a href="">Médico</a>
                        <ul>
                            <li><a href="Medico.jsp">Registrar Médico</a></li>
                            <li><a href="ConsultarMedico.jsp">Consultar Médico</a></li>
                        </ul>
                    </li>
                    <li><a href="">Medicamentos</a>
                        <ul>
                            <li><a href="Medicamento.jsp">Registrar Medicamento</a></li>
                            <li><a href="ConsultarMedicamento.jsp">Consultar Medicamento</a></li>
                        </ul>
                    </li>               
                                
                </ul>
        </div>        
        <br/><br/> 
        <br/><br/>        
        <center><h2>Consultar Paciente</h2></center> 
        <br/>
        <form class="form" action="IngresarPaciente.jsp" method="post">
            Digite documento a consultar:
            <br/><br/>
            <input type="text" name="documento"> 
            <br/>
            <p><input type="submit" value="Enviar"></p>
        </form>
        <br/><br/>
        <table class="centrar"> <!-- Crear tabla -->
            <thead> <!-- encabezados de la tabla -->
                <th>IdPaciente</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>TipoDocumento</th>
                <th>Documento</th>
                <th>Genero</th>
                <th>Telefono</th>
                <th>Email</th>
            </thead>
            <tbody> <!-- cuerpo de la tabla -->
                <tr> <!-- Filas de la tabla -->
                    <%  Paciente p = new Paciente();
                        Paciente paciente = new Paciente();
                        String documento = "1097147258";
                        paciente = p.consultaPaciente(documento);
                        if(!p.equals(null))
                        {
                            out.println("<tr>");
                            out.println("<td>"+p.getId()+"</td>");
                            out.println("<td>"+p.getNombres()+"</td>");
                            out.println("<td>"+p.getApellidos()+"</td>");
                            out.println("<td>"+p.getTipoDoc()+"</td>");
                            out.println("<td>"+p.getDocumento()+"</td>");
                            out.println("<td>"+p.getGenero()+"</td>");
                            out.println("<td>"+p.getTelefono()+"</td>");
                            out.println("<td>"+p.getEmail()+"</td>");
                            out.println("</tr>");
                        }
                    %>                    
                </tr>                
            </tbody>
        </table>        
    </body>
</html>
