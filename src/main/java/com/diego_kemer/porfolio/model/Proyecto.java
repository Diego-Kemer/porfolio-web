
package com.diego_kemer.porfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String descrption;
    private String foto_portada;
    private String foto_uno;
    private String foto_dos;
    private String url;
    private String git_hub;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "usuario_idusuario")
    @JsonBackReference(value = "user_proyectos")
    private Usuario usuario;

    public Proyecto() {
    }

    public Proyecto(long id, String name, String descrption, String foto_portada, String foto_uno, String foto_dos, Usuario usuario) {
        this.id = id;
        this.name = name;
        this.descrption = descrption;
        this.foto_portada = foto_portada;
        this.foto_uno = foto_uno;
        this.foto_dos = foto_dos;
        this.usuario = usuario;
    }

    
    
    
    
}
