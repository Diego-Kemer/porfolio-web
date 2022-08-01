
package com.diego_kemer.porfolio.service;

import com.diego_kemer.porfolio.model.Trabajos;
import java.util.List;


public interface ITrabajos {
    public List<Trabajos> verTrabajos();
    
    public void agregarTrabajo(Trabajos trab);
    
    public void eliminarTrabajo(Long id);
    
    public Trabajos verTrabajo(Long id);
    
    public void editTrabajo(Trabajos trab);
}
