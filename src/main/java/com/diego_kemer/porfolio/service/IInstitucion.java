
package com.diego_kemer.porfolio.service;

import com.diego_kemer.porfolio.model.Institucion;
import java.util.List;


public interface IInstitucion {
    public List<Institucion> verInstituciones();
    
    public void crearInstitucion(Institucion insti);
    
    public void eliminarInstitucion(Long id);
    
    public Institucion verInstitucion(Long id);
    
    public void editInstitucion(Institucion insti);
}
