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
public interface RegistroUsuarioService {
    void preparaUsuario(Usuario usuario,String nombre,String nombreUsuario, String apPaterno,String apMaterno,String Email, String pwd);
}
