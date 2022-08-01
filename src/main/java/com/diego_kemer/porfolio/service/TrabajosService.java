
package com.diego_kemer.porfolio.service;

import com.diego_kemer.porfolio.model.Trabajos;
import com.diego_kemer.porfolio.repository.TrabajosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrabajosService implements ITrabajos{
    @Autowired
    private TrabajosRepository trabRep;

    @Override
    public List<Trabajos> verTrabajos() {
        return trabRep.findAll();
    }

    @Override
    public void agregarTrabajo(Trabajos trab) {
        trabRep.save(trab);
    }

    @Override
    public void eliminarTrabajo(Long id) {
        trabRep.deleteById(id);
    }

    @Override
    public Trabajos verTrabajo(Long id) {
        return trabRep.findById(id).orElse(null);
    }

    @Override
    public void editTrabajo(Trabajos trab) {
        trabRep.save(trab);
    }
    
}
