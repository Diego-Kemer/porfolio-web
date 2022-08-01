
package com.diego_kemer.porfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
@Table(name = "trabajos")
public class Trabajos implements Serializable {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
    
   private String titulo;
   private String fecha_inicio;
   private String fecha_fin;
   private String description; 
   
   @JsonBackReference(value = "user_trabajos")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "usuario_idusuario")
    private Usuario usuario;
    
  
   

    public Trabajos() {
    }

    public Trabajos(long id, String titulo, String fecha_inicio, String fecha_fin, String description, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.description = description;
        this.usuario = usuario;
    }

    
   
   
}
