
package com.diego_kemer.porfolio.repository;

import com.diego_kemer.porfolio.model.Institucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitucionRepository extends JpaRepository<Institucion, Long>{
    
}
