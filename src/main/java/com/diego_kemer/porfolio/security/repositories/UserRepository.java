
package com.diego_kemer.porfolio.security.repositories;

import com.diego_kemer.porfolio.security.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String>{
    Optional<User> findByUserName(String userName);
    boolean existsByUserName(String userName);
}
