/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Usuario;

/**
 *
 * @author jeremy
 */
public interface UsuarioDAO {
    public boolean buscarUsuario(Usuario usuario);
    public void registrarUsuario(Usuario usuario);
    public Usuario loggearUsuarios(Usuario usuario);
}
