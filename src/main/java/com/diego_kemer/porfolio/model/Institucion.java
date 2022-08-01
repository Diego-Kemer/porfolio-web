
package com.diego_kemer.porfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "institucion")
public class Institucion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String logo;
    private String provincia;
    private String localidad;
    
    
    @OneToMany(mappedBy = "institucion")
    @JsonBackReference(value = "insti_estudios")
    private List<Estudios> estudios;

    
    
    
    public Institucion() {
    }

    public Institucion(long id, String name, String logo, String provincia, String localidad, List<Estudios> estudios) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.provincia = provincia;
        this.localidad = localidad;
        this.estudios = estudios;
    }

    

    

    
   
    
}
