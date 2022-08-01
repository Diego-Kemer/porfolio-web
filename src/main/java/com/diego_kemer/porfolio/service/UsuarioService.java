
package com.diego_kemer.porfolio.service;

import com.diego_kemer.porfolio.model.Usuario;
import com.diego_kemer.porfolio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuario{
    @Autowired
    private UsuarioRepository userRep;

    @Override
    public void crearUsuario(Usuario user) {
        userRep.save(user);
    }

    @Override
    public Usuario verUsuario(Long id) {
        return userRep.findById(id).orElse(null);
    }

    @Override
    public void editUsuario(Usuario user) {
        userRep.save(user);
    }
    
}
