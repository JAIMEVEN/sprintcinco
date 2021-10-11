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
public class Medicamento {
    private int id;
    private String referencia;    
    private String nombre;
    private String laboratorio;
    private String tipo;
    private double cantidad;

    public Medicamento(){
        
    }      

    public Medicamento(int id, String referencia, String nombre, String laboratorio, String tipo, double cantidad) {
        this.id = id;
        this.referencia = referencia;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }    
    
    public String ingresarMedicamento() {
        ConexionBD conexion = new ConexionBD();
        String sentencia = "INSERT INTO medicamento(referencia, nombre, laboratorio, tipo, cantidad) "
                + " VALUES ('" + this.referencia + "','" + this.nombre + "',"
                + "'" + this.laboratorio + "','" + this.tipo + "'," + this.cantidad + ");  ";
        String resultado = null;
        try {
            Statement st;
            st = conexion.con.createStatement();
            int rs;
            rs = st.executeUpdate(sentencia);
            if (rs==1) {
                //rs.close();
                resultado = "Se ingresó el medicamento con éxito";
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
    
    public String eliminarMedicamento() {
        ConexionBD conexion = new ConexionBD();
        String sentencia = "DELETE FROM `medicamento` WHERE `idmedicamento`='" + this.id + "'";
        try {
            Statement st = conexion.con.createStatement();
            int rs;
            rs = st.executeUpdate(sentencia);
            if (rs==1) {
                //rs.close();
                return "Se eliminó el medicamento con éxito";
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

    public List<Medicamento> listarMedicamento() throws SQLException {
        ConexionBD conexion = new ConexionBD();
        List<Medicamento> listaMedicamentos = new ArrayList<>();
        String sql = "select * from medicamento";
        try{
            Statement st = conexion.con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Medicamento m;
            while (rs.next()) {
                m = new Medicamento();
                m.setId(rs.getInt("idmedicamento"));
                m.setReferencia(rs.getString("referencia"));
                m.setNombre(rs.getString("nombre"));
                m.setLaboratorio(rs.getString("laboratorio"));
                m.setTipo(rs.getString("tipo"));                
                m.setCantidad(rs.getDouble("cantidad"));                
                listaMedicamentos.add(m);
            }
            rs.close();
        }catch(SQLException sqlex){            
        }catch(RuntimeException rex){
        }catch(Exception ex){            
        }        
        conexion.cerrarConexion();
        return listaMedicamentos;
    }

    //Para consultar un solo medicamento por id
    public Medicamento consultaMedicamento(String id) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        String sql = "select * from medicamento where idmedicamento=" + id ;       
        
        ResultSet rs = conexion.consultarBD(sql);
        if (rs.next()) {
            this.id = rs.getInt("idmedicamento");
            this.referencia = rs.getString("referencia");
            this.nombre = rs.getString("nombre");
            this.laboratorio = rs.getString("laboratorio");
            this.tipo = rs.getString("tipo");
            this.cantidad = rs.getDouble("cantidad");            
            conexion.cerrarConexion();
            System.out.println(this.nombre);
            return this;                         
        } else {
            conexion.cerrarConexion(); 
            return null;
        }
    }
    
    public String modificaMedicamento(int id) {
        ConexionBD conexion = new ConexionBD();
        String sentencia = "UPDATE medicamento SET referencia='" + this.referencia + "', nombre='" + this.nombre 
                + "', laboratorio='" + this.laboratorio + "', tipo='" + this.tipo + "', cantidad='" + this.cantidad 
                + "' WHERE idmedicamento=" + this.id + ";";
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
        return "Medicamento{" + "id=" + id + ", referencia=" + referencia + ", nombre=" + nombre + ", laboratorio=" + laboratorio + ", tipo=" + tipo + ", cantidad=" + cantidad + '}';
    }
}
