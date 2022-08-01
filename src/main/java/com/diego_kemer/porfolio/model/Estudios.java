
package com.diego_kemer.porfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
@Table(name = "estudios")
public class Estudios{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   
   private String titulo;
   private String fecha_inicio;
   private String fecha_fin;
   private String modalidad;

    public Estudios() {
    }
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "usuario_idusuario")
    @JsonBackReference(value = "user_estudios")
    private Usuario usuario;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "institucion_id")
    //@JsonManagedReference(value = "insti_estudios")
    private Institucion institucion;

    public Estudios(long id, String titulo, String fecha_inicio, String fecha_fin, Usuario usuario, String modalidad, Institucion institucion) {
        this.id = id;
        this.titulo = titulo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.usuario = usuario;
        this.modalidad = modalidad;
        this.institucion = institucion;
    }

    
   

    
   
    
   
}
