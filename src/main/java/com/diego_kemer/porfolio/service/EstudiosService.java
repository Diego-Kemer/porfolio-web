
package com.diego_kemer.porfolio.service;

import com.diego_kemer.porfolio.model.Estudios;
import com.diego_kemer.porfolio.repository.EstudiosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudiosService implements IEstudios{
    private Estudios editado;
    @Autowired
    private EstudiosRepository estRep;

    @Override
    public List<Estudios> verEstudios() {
        return estRep.findAll();
    }

    @Override
    public void crearEstudio(Estudios est) {
        estRep.save(est);
    }

    @Override
    public void eliminarEstudios(Long id) {
        estRep.deleteById(id);
    }

    @Override
    public Estudios verEstudio(Long id) {
        return estRep.findById(id).orElse(null);
    }

    @Override
    public void editEstudio(Estudios est) {
        estRep.save(est); 
    }
    
}
