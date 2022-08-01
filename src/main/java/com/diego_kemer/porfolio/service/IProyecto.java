
package com.diego_kemer.porfolio.service;

import com.diego_kemer.porfolio.model.Proyecto;
import java.util.List;


public interface IProyecto {
    public List<Proyecto> obtenerProyectos();
    
    public void crearProyecto(Proyecto pro);
    
    public void editProyect(Proyecto pro);
    
    public void deleteProy(Long id);
}
