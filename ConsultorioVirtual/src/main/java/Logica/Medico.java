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
public class Medico {
    private int id;
    private String tipoDoc;
    private String documento;
    private String nombre;
    private String primerApellido;
    private String genero;
    private int idH;

    public Medico() {
    }

    public Medico(int id, String tipoDoc, String documento, String nombre, String primerApellido, String genero, int idH) {
        this.id = id;
        this.tipoDoc = tipoDoc;
        this.documento = documento;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.genero = genero;
        this.idH = idH;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdH() {
        return idH;
    }

    public void setIdH(int idH) {
        this.idH = idH;
    }
    
    public String ingresarMedico() {
        ConexionBD conexion = new ConexionBD();
        String sentencia = "INSERT INTO medico(tipoDoc, documento, nombre, primerApellido, genero, idHorario) "
                + " VALUES ('" + this.tipoDoc + "','" + this.documento + "',"
                + "'" + this.nombre + "','" + this.primerApellido + "','" + this.genero + "',"
                + "'" + this.idH + "');  ";
        String resultado = null;
        try {
            Statement st;
            st = conexion.con.createStatement();
            int rs;
            rs = st.executeUpdate(sentencia);
            if (rs==1) {
                //rs.close();
                resultado = "Se ingresó el médico con éxito";
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

    public String eliminarMedico() {
        ConexionBD conexion = new ConexionBD();
        String sentencia = "DELETE FROM `medico` WHERE `documento`='" + this.documento + "'";
        try {
            Statement st = conexion.con.createStatement();
            int rs;
            rs = st.executeUpdate(sentencia);
            if (rs==1) {
                //rs.close();
                return "Se eliminó el médico con éxito";
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

    public List<Medico> listarMedicos() throws SQLException {
        ConexionBD conexion = new ConexionBD();
        List<Medico> listaMedicos = new ArrayList<>();
        String sentencia = "select * from medico";
        try{
            Statement st = conexion.con.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            Medico m;
            while (rs.next()) {
                m = new Medico();
                m.setId(rs.getInt("idpaciente"));
                m.setTipoDoc(rs.getString("tipoDoc"));
                m.setDocumento(rs.getString("documento"));
                m.setNombre(rs.getString("nombre"));
                m.setPrimerApellido(rs.getString("primerApellido"));
                m.setGenero(rs.getString("genero"));
                m.setIdH(rs.getInt("idH"));                
                listaMedicos.add(m);
            }
            rs.close();
        }catch(SQLException sqlex){            
        }catch(RuntimeException rex){
        }catch(Exception ex){            
        }        
        conexion.cerrarConexion();
        return listaMedicos;
    }
    
    //Para consultar un solo medico por documento
    public Medico consultaMedico(String identificacion) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        String sql = "select * from medico where documento=" + identificacion ;       
        
        ResultSet rs = conexion.consultarBD(sql);
        if (rs.next()) {
            this.id = rs.getInt("idpaciente");
            this.tipoDoc = rs.getString("tipoDoc");
            this.documento = rs.getString("documento");
            this.nombre = rs.getString("nombre");
            this.primerApellido = rs.getString("primerApellido");
            this.genero = rs.getString("genero");
            this.idH = rs.getInt("idH");
            conexion.cerrarConexion();
            System.out.println(this.nombre);
            return this;                          
        } else {
            conexion.cerrarConexion(); 
            return null;
        }
    }
    
    public String modificaMedico(String documento) {
        ConexionBD conexion = new ConexionBD();
        String sentencia = "UPDATE medico SET tipoDoc='" + this.tipoDoc + "', nombre='" + this.nombre + "', primerApellido='" 
                + this.primerApellido + "', genero='" + this.genero + "', idHorario='" + this.idH + "' WHERE documento=" + this.documento + ";";
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
        return "Paciente{" + "id=" + id + ", tipoDoc=" + tipoDoc + ", documento=" + documento + ", nombre=" + nombre 
                + ", primerApellido=" + primerApellido + ", genero=" + genero + ", idHorario=" + idH + '}';
    }
}


