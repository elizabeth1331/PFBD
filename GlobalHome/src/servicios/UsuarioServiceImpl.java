/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Usuario;
/**
 *
 * @author jeremy
 */
public class UsuarioServiceImpl implements UsuarioService{
 
    @Override
    public void preparaUsuario(Usuario usuario,String nombre,String nombreUsuario, String apPaterno,String apMaterno,String email, String pwd) {
        //Con este método pasamos los datos de la interfaz al objeto Usuario.
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setNombre(nombre);
        usuario.setApPaterno(apPaterno);
        usuario.setApMaterno(apMaterno);
        usuario.setEmail(email);
        usuario.setPwd(pwd);
    }   

    @Override
    public void preparaLoggUsuario(Usuario usuario, String nombreUsuario, char[] pass) {
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setPwd(new String(pass));
    }

 
    
}
