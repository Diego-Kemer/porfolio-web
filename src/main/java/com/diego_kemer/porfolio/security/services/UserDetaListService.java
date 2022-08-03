
package com.diego_kemer.porfolio.security.services;

import com.diego_kemer.porfolio.security.entities.ManiUser;
import com.diego_kemer.porfolio.security.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetaListService implements UserDetailsService{
    private final UserService userService;
    
    @Autowired
    public UserDetaListService(UserService userService) {
        this.userService = userService;
    }
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        User user = userService.getByUserName(userName).get();
        return ManiUser.build(user);
    }
}
