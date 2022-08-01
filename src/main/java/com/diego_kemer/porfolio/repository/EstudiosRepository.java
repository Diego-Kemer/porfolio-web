
package com.diego_kemer.porfolio.repository;

import com.diego_kemer.porfolio.model.Estudios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudiosRepository extends JpaRepository<Estudios, Long>{
    
}
