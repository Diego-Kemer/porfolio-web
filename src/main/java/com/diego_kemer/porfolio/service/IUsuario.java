
package com.diego_kemer.porfolio.service;

import com.diego_kemer.porfolio.model.Usuario;


public interface IUsuario {
    public void crearUsuario(Usuario user);
    
    public Usuario verUsuario(Long id);
    
    public void editUsuario(Usuario user);
    
}
