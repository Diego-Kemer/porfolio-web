
package com.diego_kemer.porfolio.repository;

import com.diego_kemer.porfolio.model.Trabajos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajosRepository extends JpaRepository<Trabajos, Long>{
    
}
