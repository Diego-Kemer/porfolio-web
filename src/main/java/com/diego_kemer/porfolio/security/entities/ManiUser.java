
package com.diego_kemer.porfolio.security.entities;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//Esta clase nos permite identificar la autoridad en este caso a traves del rol
//Nos permite restringir ciertas acciones dependiendo del rol
public class ManiUser  implements UserDetails{
    private String userName;
    private String password;
   

    public ManiUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
       
    }
    
    public static  ManiUser build(User user){
        return new ManiUser(user.getUserName(), user.getPassword());
    }

    

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    
    
}
