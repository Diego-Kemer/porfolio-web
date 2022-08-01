
package com.diego_kemer.porfolio.service;

import com.diego_kemer.porfolio.model.Institucion;
import com.diego_kemer.porfolio.repository.InstitucionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitucionService implements IInstitucion{
    @Autowired
    private InstitucionRepository instiRep;
    
    @Override
    public List<Institucion> verInstituciones() {
        return instiRep.findAll();
    }

    @Override
    public void crearInstitucion(Institucion insti) {
        instiRep.save(insti);
    }

    @Override
    public void eliminarInstitucion(Long id) {
        instiRep.deleteById(id);
    }

    @Override
    public Institucion verInstitucion(Long id) {
        return instiRep.findById(id).orElse(null);
    }

    @Override
    public void editInstitucion(Institucion insti) {
        instiRep.save(insti);
    }
    
}
