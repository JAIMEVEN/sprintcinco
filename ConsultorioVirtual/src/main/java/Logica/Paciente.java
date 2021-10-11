/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Persistencia.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class Paciente {
    private int id;
    private String tipoDoc;
    private String documento;
    private String nombres;
    private String apellidos;
    private String genero;
    private String telefono;
    private String email;

    public Paciente() {
    }

    public Paciente(int id, String tipoDoc, String documento, String nombres, String apellidos, String genero, String telefono, String email) {
        this.id = id;
        this.tipoDoc = tipoDoc;
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.genero = genero;
        this.telefono = telefono;
        this.email = email;
    } 
        
    public Paciente getPaciente(String documento) throws SQLException {
        this.documento = documento;
        return this.getPaciente(documento);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }   
    
    public String ingresarPaciente() {
        ConexionBD conexion = new ConexionBD();
        String sentencia = "INSERT INTO paciente(tipoDoc, documento, nombres, apellidos, genero, telefono, email) "
                + " VALUES ('" + this.tipoDoc + "','" + this.documento + "',"
                + "'" + this.nombres + "','" + this.apellidos + "','" + this.genero + "',"
                + "'" + this.telefono + "','" + this.email + "');  ";
        String resultado = null;
        try {
            Statement st;
            st = conexion.con.createStatement();
            int rs;
            rs = st.executeUpdate(sentencia);
            if (rs==1) {
                //rs.close();
                resultado = "Se ingresó el paciente con éxito";
            } else {
                resultado = "No se ingresó el registro";
            }
        } catch (SQLException sqlex) {
            resultado = sentencia+" "+sqlex.toString();
        } catch (RuntimeException rex) {
            resultado = rex.toString();
        } catch (Exception ex) {
            resultado = "Otra excepción"+ex;
        }
        return resultado;
    }

    public String eliminarPaciente() {
        ConexionBD conexion = new ConexionBD();
        String sentencia = "DELETE FROM `paciente` WHERE `documento`='" + this.documento + "'";
        try {
            Statement st = conexion.con.createStatement();
            int rs;
            rs = st.executeUpdate(sentencia);
            if (rs==1) {
                //rs.close();
                return "Se eliminó el paciente con éxito";
            } else {
                return "No se pudo eliminar el registro";
            }
        } catch (SQLException sqlex) {
            return sentencia+sqlex.toString();
        } catch (RuntimeException rex) {
            return rex.toString();
        } catch (Exception ex) {
            return "Otra excepción"+ex;
        }
        //return this;
    }   

    public List<Paciente> listarPacientes() throws SQLException {
        ConexionBD conexion = new ConexionBD();
        List<Paciente> listaPacientes = new ArrayList<>();
        String sentencia = "select * from paciente";
        try{
            Statement st = conexion.con.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            Paciente p;
            while (rs.next()) {
                p = new Paciente();
                p.setId(rs.getInt("idpaciente"));
                p.setTipoDoc(rs.getString("tipoDoc"));
                p.setDocumento(rs.getString("documento"));
                p.setNombres(rs.getString("nombres"));
                p.setApellidos(rs.getString("apellidos"));
                p.setGenero(rs.getString("genero"));
                p.setTelefono(rs.getString("telefono"));
                p.setEmail(rs.getString("email"));
                listaPacientes.add(p);
            }
            rs.close();
        }catch(SQLException sqlex){            
        }catch(RuntimeException rex){
        }catch(Exception ex){            
        }        
        conexion.cerrarConexion();
        return listaPacientes;
    }
    
    //Para consultar un solo paciente por documento
    public Paciente consultaPaciente(String identificacion) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        String sql = "select * from paciente where documento=" + identificacion ;       
        
        ResultSet rs = conexion.consultarBD(sql);
        if (rs.next()) {
            this.id = rs.getInt("idpaciente");
            this.tipoDoc = rs.getString("tipoDoc");
            this.documento = rs.getString("documento");
            this.nombres = rs.getString("nombres");
            this.apellidos = rs.getString("apellidos");
            this.genero = rs.getString("genero");
            this.telefono = rs.getString("telefono");
            this.email = rs.getString("email");
            conexion.cerrarConexion();
            System.out.println(this.nombres);
            return this;                          
        } else {
            conexion.cerrarConexion(); 
            return null;
        }
    }
    
    public String modificaPaciente(String documento) {
        ConexionBD conexion = new ConexionBD();
        String sentencia = "UPDATE paciente SET nombres='" + this.nombres + "', apellidos='" + this.apellidos + "', tipoDoc='" 
                + this.tipoDoc + "', genero='" + this.genero + "', telefono='" + this.telefono + "', email='" + this.email 
                + "' WHERE documento=" + this.documento + ";";
        String resultado = null;
        try {
            Statement st = conexion.con.createStatement();
            int rs = st.executeUpdate(sentencia);
            if (rs==1) {                
                resultado = "Se actualizaron los datos con éxito";
            } else {
                resultado = "No se actualizó el registro";
            }
        } catch (SQLException sqlex) {    
            resultado = sentencia+" "+sqlex.toString();
        } catch (RuntimeException rex) {
            resultado = rex.toString();
        } catch (Exception ex) { 
            resultado = "Otra excepción"+ex;
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", tipoDoc=" + tipoDoc + ", documento=" + documento + ", nombres=" + nombres + ", apellidos=" + apellidos + ", genero=" + genero + ", telefono=" + telefono + ", email=" + email + '}';
    }
}
