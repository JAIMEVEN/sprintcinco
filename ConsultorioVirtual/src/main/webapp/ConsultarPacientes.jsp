<%-- 
    Document   : ConsultarPacientes
    Created on : 7/10/2021, 9:24:58 p. m.
    Author     : andre
--%>

<%@page import="java.util.List"%>
<%@page import="Logica.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="Estilos.css" rel="stylesheet" type="text/css"/> <!--agregamos el archivo css Estilos.css-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Pacientes</title>
    </head>
    <body>
        <h1>Consultorio Virtual</h1>
        <div id="header">            
                <ul class="nav">
                    <li><a href="Index.jsp">Inicio</a></li>
                    <li><a href="">Paciente</a>
                        <ul>
                            <li><a href="Paciente.jsp">Registrar Paciente</a></li>
                            <li><a href="ConsultarPacientes.jsp">Consultar Pacientes</a></li>
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
        <center><h2>Consultar Pacientes</h2></center>        
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
                    <%  Paciente p;
                        p = new Paciente();
                        List<Paciente> pacientes = p.listarPacientes();
                        out.println("Cantidad de Registros: "+pacientes.size());
                        for (int i=0;i<pacientes.size();i++)
                        {
                            out.println("<tr>");
                            out.println("<td>"+pacientes.get(i).getId()+"</td>");
                            out.println("<td>"+pacientes.get(i).getNombres()+"</td>");
                            out.println("<td>"+pacientes.get(i).getApellidos()+"</td>");
                            out.println("<td>"+pacientes.get(i).getTipoDoc()+"</td>");
                            out.println("<td>"+pacientes.get(i).getDocumento()+"</td>");
                            out.println("<td>"+pacientes.get(i).getGenero()+"</td>");
                            out.println("<td>"+pacientes.get(i).getTelefono()+"</td>");
                            out.println("<td>"+pacientes.get(i).getEmail()+"</td>");
                            out.println("</tr>");
                        }
                    %>                    
                </tr>                
            </tbody>
        </table>       
    </body>
</html>
