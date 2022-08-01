
package com.diego_kemer.porfolio.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "usuario")
public class Usuario {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idusuario;
    private String name;
    private String lastname;
    private String profesion;
    private String nacionalidad;
    private String sobre_mi;
    private String nivel;
    private int edad;
    private String foto_portada;

    public Usuario() {
    }
    
    @OneToMany(mappedBy = "usuario")
    //@JsonManagedReference(value = "user_estudios")
    private List<Estudios> estudios;
    
    @OneToMany(mappedBy = "usuario")
    //@JsonManagedReference(value = "user_proyectos")
    private List<Proyecto> proyectos;
    
    //@JsonManagedReference(value = "user_trabajos"
    @OneToMany(mappedBy = "usuario")
    private List<Trabajos> trabajos;

    public Usuario(long idusuario, String name, String lastname, String profesion, String nacionalidad, String sobre_mi, String nivel, int edad, List<Estudios> estudios, List<Trabajos> trabajos) {
        this.idusuario = idusuario;
        this.name = name;
        this.lastname = lastname;
        this.profesion = profesion;
        this.nacionalidad = nacionalidad;
        this.sobre_mi = sobre_mi;
        this.nivel = nivel;
        this.edad = edad;
        this.estudios = estudios;
        this.trabajos = trabajos;
    }

    
    
    
   
   
}
