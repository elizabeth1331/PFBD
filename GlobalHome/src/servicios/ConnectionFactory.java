/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author jeremy
 */
public class ConnectionFactory {
    //Objeto Properties representa al archivo de configuraciones.
    private static final Properties properties = new Properties();
    
    //(Una sola instancia de esta clase) creamos la instancia
    private static final ConnectionFactory cf = new ConnectionFactory();
    //Constructor privado
    private ConnectionFactory(){
        String driverClass;
        System.out.println("Inicializando datos de conexión");
        try{
            //carga del archivo config/conexiion.properties
            this.properties.load(getClass().getResourceAsStream("conexion.properties"));
            driverClass = this.properties.getProperty("connection.database.driver.class");
            System.out.println("Cargando el driver.."+driverClass);
            Class.forName(driverClass);
        } catch (FileNotFoundException e){
            //lanzamos un RuntimeException porque es un error irrecuperable
            throw new RuntimeException("Archivo de configuración no encontrado",e); 
        } catch (IOException e){
            throw new RuntimeException("Error al leer el archivo de configuración",e); 
        } catch (ClassNotFoundException e){
            throw new RuntimeException("Driver no encontrado",e); 
        }
    }
    
    /*Conexión con la base de datos*/
    public static Connection getConnection(){
        String url = properties.getProperty("connection.database.url");
        System.out.println("Obteniedo la conexión");
        try{
            return DriverManager.getConnection(url,"GM_PROY_ADMIN","mg");
        } catch (SQLException e){
            throw new RuntimeException("Error al obtener la conexion de la base de datos", e);            
        }
    }
    
    /* Cierra la conexión*/
    public static void close(Connection connection){
        System.out.println("Cerrando conexión");
        try{
            if (connection != null){
                connection.close();             
            }
        } catch (SQLException e){
            System.out.println("Error al cerrar la conexión");
            e.printStackTrace();
        }
    }
    
    /*Cierra un Statement*/
    public static void close (Statement statement){
        System.out.println("Cerrando stament");
        try{
            if (statement != null)
                statement.close();
        } catch (SQLException e){
            System.out.println("Error al cerrar el statement");
            e.printStackTrace();
        }
    }
    
    /*Cierra un ResultSet*/
    public static void close(ResultSet rs){
        System.out.println("Cerrando ResultSet");
        try{
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e){
            System.out.println("Error al cerrar la conexión");
            e.printStackTrace();
        }
    }
    
}
