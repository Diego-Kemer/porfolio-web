
package com.diego_kemer.porfolio.service;

import com.diego_kemer.porfolio.model.Proyecto;
import com.diego_kemer.porfolio.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyecto{
    @Autowired
    private ProyectoRepository proRep;

    @Override
    public List<Proyecto> obtenerProyectos() {
        return proRep.findAll();
    }

    @Override
    public void crearProyecto(Proyecto pro) {
        proRep.save(pro);
    }

    @Override
    public void editProyect(Proyecto pro) {
        proRep.save(pro);
    }

    @Override
    public void deleteProy(Long id){
        proRep.deleteById(id);
    }
    
}
