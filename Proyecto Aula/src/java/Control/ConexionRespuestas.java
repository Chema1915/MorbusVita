/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ACER01
 */
public class ConexionRespuestas {
    
     public static Connection getConnection(){
        String url, userName, password;
        
        url = "jdbc:mysql://localhost/ProyectoAula";
        userName = "root";
        password = "22mayo2004";
        
        Connection con = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(url, userName, password);
            
            System.out.println("Conexion Exitosa con la BD");
        
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar la BD");
            System.out.println(e.getMessage());
        
        }
        return con;
    }
    
}
