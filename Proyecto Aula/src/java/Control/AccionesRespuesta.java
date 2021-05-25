/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Respuesta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER01
 */
public class AccionesRespuesta {
    
    public static int registrarRespuesta(Respuesta e){
        int estatus = 0;
        try{
            Connection con;
            con = ConexionRespuestas.getConnection();
            String q = "insert into empleados(nom_emp, pass_emp, email_emp, pais_emp) "
                    + "values(?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setString(1, e.getRespuesta());
            ps.setInt(2, e.getNumero());

            
            estatus = ps.executeUpdate();
            System.out.println("Registro Exitoso del Empleado");
            con.close();
        
        }catch(SQLException ed){
            System.out.println("Error al registrar al empleado");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }
    
    public static int actualizarRespuesta(Respuesta e){
        int estatus = 0;
        try{
            Connection con;
            con = ConexionRespuestas.getConnection();
            String q = "update empleados set nom_emp = ?, pass_emp = ?,"
                    + "email_emp = ?, pais_emp = ? "
                    + "where id_emp = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setString(1, e.getRespuesta());
            ps.setInt(2, e.getNumero());
            ps.setInt(5, e.getId());
            
            estatus = ps.executeUpdate();
            System.out.println("Actualizacion Exitosa del Empleado");
            con.close();
        
        }catch(SQLException ed){
            System.out.println("Error al actualizar al empleado");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }  
    
    public static Respuesta buscarEmpleadoById(int id){
        Respuesta e = new Respuesta();
        try{
            Connection con;
            con = ConexionRespuestas.getConnection();
            String q = "select * from empleados where id_emp = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                e.setId(rs.getInt(1));
                e.setRespuesta(rs.getString(2));
                e.setNumero(rs.getInt(3));
            }
            
            System.out.println("Empleado encontrado");
            con.close();
        
        }catch(SQLException ed){
            System.out.println("Error al buscar al empleado");
            System.out.println(ed.getMessage());
        
        }
        return e;
    }
    
    public static List<Respuesta> buscarAllEmpleados(){
        List<Respuesta> lista = new ArrayList<>();
        
        try{
            Connection con;
            con = ConexionRespuestas.getConnection();
            String q = "select * from empleados";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Respuesta e = new Respuesta();
                e.setId(rs.getInt(1));
                e.setRespuesta(rs.getString(2));
                e.setNumero(rs.getInt(3));
                lista.add(e);
            }
            
            System.out.println("Empleado encontrado");
            con.close();
        
        }catch(SQLException ed){
            System.out.println("Error al buscar a los empleado");
            System.out.println(ed.getMessage());
        
        }
        return lista;
    }
}
