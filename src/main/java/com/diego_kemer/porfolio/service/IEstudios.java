
package com.diego_kemer.porfolio.service;

import com.diego_kemer.porfolio.model.Estudios;
import java.util.List;


public interface IEstudios {
    public List<Estudios> verEstudios();
    
    public void crearEstudio(Estudios est);
    
    public void eliminarEstudios(Long id);
    
    public Estudios verEstudio(Long id);
    
    public void editEstudio(Estudios est);
}
