
package com.diego_kemer.porfolio.repository;

import com.diego_kemer.porfolio.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long>{
    
}
