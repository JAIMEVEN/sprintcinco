<%-- 
    Document   : Medico
    Created on : 1/10/2021, 5:12:59 p. m.
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="Estilos.css" rel="stylesheet" type="text/css"/> <!--agregamos el archivo css Estilos.css-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medico</title>
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
        <center><h2>Registrar Médico</h2></center> 
        <br/>
        <form class="form" action="IngresaMedico.jsp" method="post">
            Tipo de Documento:
            <select name="tipoDoc">
              <option value="seleccione" selected>Seleccione
              <option value="RC">RC
              <option value="TI">TI
              <option value="CC">CC
              <option value="CE">CE
              <option value="PT">PT              
            </select>   
            <br/>
            Documento
            <input type="text" name="documento">
            <br/>     
            Nombres:
            <input type="text" name="nombres"> 
            <br/>
            Apellidos:
            <input type="text" name="apellidos">
            <br/>            
            Género  
            <br/>
            Femenino<input type="Radio" name="genero" value= "Femenino">            
            Masculino<input type="Radio" name= "genero"value="Masculino">      
            <br/>
            Horario:
            <select name="horario">
              <option value="seleccione" selected>Seleccione                           
            </select>   
            <p><input type="submit" value="Enviar"></p>
        </form>
    </body>
</html>
