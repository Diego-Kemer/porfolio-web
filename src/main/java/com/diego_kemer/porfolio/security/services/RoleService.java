
package com.diego_kemer.porfolio.security.services;

import com.diego_kemer.porfolio.security.entities.Role;
import com.diego_kemer.porfolio.security.enums.RoleList;
import com.diego_kemer.porfolio.security.repositories.RoleRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {
    
    private final RoleRepository roleRepository;
    
    @Autowired
    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }
    
    public Optional<Role> getByRoleName(RoleList rolName){
        return roleRepository.findByRolName(rolName);
    }
    
}
