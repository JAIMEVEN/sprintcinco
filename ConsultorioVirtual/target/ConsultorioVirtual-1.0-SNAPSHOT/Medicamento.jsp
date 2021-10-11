<%-- 
    Document   : Medicamento
    Created on : 1/10/2021, 5:10:20 p. m.
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="Estilos.css" rel="stylesheet" type="text/css"/> <!--agregamos el archivo css Estilos.css-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medicamento</title>
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
        <center><h2>Registrar Medicamentos</h2></center>  
        <br/>
        <form class="form" action="IngresaMedicamento.jsp" method="post">
            Nombre Madicamento
            <input type="text" name="nombre"> 
            <br/>
            Referencia
            <input type="text" name="referencia">
            <br/>
            Laboratorio
            <input type="text" name="laboratorio">
            <br/>                
            Tipo de Medicamento
            <select name="tipoMed">
              <option value="seleccione" selected>Seleccione
              <option value="jarabe">Jarabe
              <option value="capsula">Capsula
              <option value="ampolleta">Ampolleta
              <option value="tableta">Tableta                           
            </select>   
            <br/>            
            Cantidad
            <input type="text" name="cantidad">
            <br/> 
            <p><input type="submit" value="Enviar"></p>
        </form>
    </body>
</html>
