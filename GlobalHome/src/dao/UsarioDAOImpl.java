/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import servicios.ConnectionFactory;

/**
 *
 * @author jeremy
 */
public class UsarioDAOImpl implements UsuarioDAO{

    //Consulta para obtener un usuario con los datos del que se va a registrar para validar si ya existe.
    private static final String querySelectUsrExist = "select u.usuario_id, u.nombre_usuario, u.nombre, u.ap_paterno,"
            + "u.ap_materno, u.email, u.password from usuario u where u.nombre_usuario = ? and u.email = ?";
    
    private static final String querySelectUsrLogin = "select u.usuario_id, u.nombre_usuario, u.nombre, u.ap_paterno,"
            + "u.ap_materno, u.email, u.password from usuario u where u.nombre_usuario = ? and u.password = ?";
    
    
    private static final String queryCreaUsuario = "insert into usuario"
            + "(usuario_id,nombre_usuario,nombre,ap_paterno,ap_materno,email,password) values (?,?,?,?,?,?,?)";
  
    
    @Override
    public boolean buscarUsuario(Usuario usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con;
        int contadorRegistros=0;
        con = ConnectionFactory.getConnection();
        try{
            ps = con.prepareStatement(querySelectUsrExist);
            ps.setString(1,usuario.getNombreUsuario());
            ps.setString(2,usuario.getEmail());
            //ejecutamos la consulta
            ps.executeQuery();
            if(rs != null){
                while(rs.next()){
                    contadorRegistros++;
                }
            }else{
                return false;
            }
        }catch (SQLException e){
            System.out.println("Error al obtener los datos del usuario");
            e.printStackTrace();
            return false;
        }finally {
            ConnectionFactory.close(ps);
            ConnectionFactory.close(rs);
            ConnectionFactory.close(con);
            
        }
        
        if(contadorRegistros > 0){
            System.out.println("El usuario ya a sido registrado");
            return true;
        }else{
            System.out.println("El usuario no se puede registrar");
            return false;
        }
        
                
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        int i = 10;
        try{
            ps = con.prepareStatement(queryCreaUsuario);
            System.out.println("Insertando los datos del usuario en la BD");
            ps.setInt(1,i+1);
            ps.setString(2,usuario.getNombreUsuario());
            ps.setString(3,usuario.getNombre());
            ps.setString(4,usuario.getApPaterno());          
            ps.setString(5,usuario.getApMaterno());
            ps.setString(6,usuario.getEmail());
            ps.setString(7,usuario.getPwd());
            ps.executeUpdate();
            ps.clearParameters();
        }catch(SQLException e){
            System.out.println("Error al insertar el usuario");
            e.printStackTrace();          
        } finally {
            ConnectionFactory.close(ps);
            ConnectionFactory.close(con);
        }
    }

    @Override
    public Usuario loggearUsuarios(Usuario usuario) {
        
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int index;
        //Establecemos la conneccion a la base de datos
        conn = ConnectionFactory.getConnection();
        //Consulta
        try{
            //Indicamos la sentencia sql
            ps = conn.prepareStatement(querySelectUsrLogin);
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getPwd());
            rs = ps.executeQuery();
            //llenamos nuestra lista con los resultados de la consulta
            if(rs.next()){
                    usuario = new Usuario();
                    //Este indice es para obtener los valores de las columnas las columnas
            index = 1;
            usuario.setUsuarioID(rs.getLong(index++));
            usuario.setNombreUsuario(rs.getString(index++));
            usuario.setNombre(rs.getString(index++));
                    usuario.setApPaterno(rs.getString(index++));
                    usuario.setApMaterno(rs.getString(index++));
                    usuario.setEmail(rs.getString(index++));
                    usuario.setPwd(rs.getString(index++));
                    System.out.println(usuario.getNombreUsuario());
            }else{
                usuario.setPwd(null);
                usuario.setNombreUsuario(null);
            }
            
        } catch (SQLException e){
            System.out.println("Error al obtener los datos del actor.");
            e.printStackTrace();
        } finally{
            ConnectionFactory.close(ps);
            ConnectionFactory.close(rs);
            ConnectionFactory.close(conn);
        }
            
            return new Usuario();
    }
        
        
}
    