
package com.diego_kemer.porfolio.security.repositories;

import com.diego_kemer.porfolio.security.entities.Role;
import com.diego_kemer.porfolio.security.enums.RoleList;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Integer>{
    Optional<Role> findByRolName(RoleList rolName);
}
