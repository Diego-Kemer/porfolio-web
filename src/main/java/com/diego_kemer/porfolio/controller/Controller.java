
package com.diego_kemer.porfolio.controller;

import static com.diego_kemer.porfolio.VarGlob.SECRET;
import static com.diego_kemer.porfolio.VarGlob.US;
import com.diego_kemer.porfolio.model.Estudios;
import com.diego_kemer.porfolio.model.Institucion;
import com.diego_kemer.porfolio.model.Proyecto;
import com.diego_kemer.porfolio.model.Trabajos;
import com.diego_kemer.porfolio.model.Us;
import com.diego_kemer.porfolio.model.Usuario;
import com.diego_kemer.porfolio.service.IEstudios;
import com.diego_kemer.porfolio.service.IInstitucion;
import com.diego_kemer.porfolio.service.IProyecto;
import com.diego_kemer.porfolio.service.ITrabajos;
import com.diego_kemer.porfolio.service.IUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://diego-kemer-cd785.web.app")
public class Controller {
    
    @Autowired
    private IEstudios estI;
    @Autowired
    private IInstitucion instI;
    @Autowired
    private IProyecto proyI;
    @Autowired
    private ITrabajos trab;
    @Autowired 
    private IUsuario userI;
    
    @PostMapping("/login")
    public String guardarEstudio(@RequestBody Us user){
        if ("DiegoKFacundo".equals(user.password) && "DiegoKemer".equals(user.name)) {
            return "true";
        } else {
            return "false";
        }
    }
    //Rutas para los estudios
    @GetMapping("/estudios")
    public List<Estudios> verEstudios(){
        return estI.verEstudios();
    }
    @PostMapping("/estudio")
    public void guardarEstudio(@RequestBody Estudios est){
        estI.crearEstudio(est);
    }
    @DeleteMapping("/estudio/{id}")
    public void eliminarEstudio(@PathVariable Long id){
        estI.eliminarEstudios(id);
    }
    @GetMapping("/estudio/{id}")
    public Estudios verEstudio(@PathVariable Long id){
        return estI.verEstudio(id);
    }
    @PutMapping("/estudio")
    public void editEstudio(@RequestBody Estudios est){
        estI.editEstudio(est);
    }
    
    //Rutas para la clase Institucion
    @GetMapping("/instituciones")
    public List<Institucion> verInstituciones(){
        return instI.verInstituciones();
    }
    @PostMapping("/institucion")
    public Institucion agregarInstitucion(@RequestBody Institucion insti){
        instI.crearInstitucion(insti);
        return insti;
    }
    @DeleteMapping("/institucion/{id}")
    public void eliminarInstitucion(@PathVariable Long id){
        instI.eliminarInstitucion(id);
    }
    @GetMapping("/institucion/{id}")
    public Institucion verInstitucion(@PathVariable Long id){
        return instI.verInstitucion(id);
    }
    @PutMapping("/institucion")
    public void editEstudio(@RequestBody Institucion inst){
        instI.editInstitucion(inst);
    }
    
    //Rutas para la clase Proyecto
    @GetMapping("/proyectos")
    public List<Proyecto> verproyectos(){
        return proyI.obtenerProyectos();
    }
    @PostMapping("/proyecto")
    public void agregarproyectos(@RequestBody Proyecto proy){
        proyI.crearProyecto(proy);
    }
    @DeleteMapping("/proyecto/{id}")
    public void eliminarProyecto(@PathVariable Long id){
        proyI.deleteProy(id);
    }
    @PutMapping("/proyecto")
    public void editProyecto(@RequestBody Proyecto proy){
        proyI.editProyect(proy);
    }
    

    
    //Rutas para la clase Trabajos
    @GetMapping("/trabajos")
    public List<Trabajos> verTrabajos(){
        return trab.verTrabajos();
    }
    @PostMapping("/trabajo")
    public void crearTrabajo(@RequestBody Trabajos job){
        trab.agregarTrabajo(job);
    }
    @DeleteMapping("trabajo/{id}")
    public void eliminarTrabajo(@PathVariable Long id){
        trab.eliminarTrabajo(id);
    }
    @GetMapping("/trabajo/{id}")
    public Trabajos verTrabajo(@PathVariable Long id){
        return trab.verTrabajo(id);
    }
    @PutMapping("/trabajo")
    public void editEstudio(@RequestBody Trabajos tr){
        trab.editTrabajo(tr);
    }
    
    //Rutas para la clase Usuario
    @PostMapping("/usuario")
    public void crearUsuario(@RequestBody Usuario user){
        userI.crearUsuario(user);
    }
    @GetMapping("/usuario/{id}")//(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
    public Usuario verUsuario(@PathVariable Long id){
        return userI.verUsuario(id);
    }
    @PutMapping("/usuario")
    public void editEstudio(@RequestBody Usuario user){
        userI.editUsuario(user);
    }
}
