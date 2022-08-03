
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
    private Collection<? extends GrantedAuthority> authorities;

    public ManiUser(String userName, String password, Collection<? extends GrantedAuthority> authorities) {
        this.userName = userName;
        this.password = password;
        this.authorities = authorities;
    }
    
    public static  ManiUser build(User user){
        List<GrantedAuthority> authoritys = user.getRoles().stream().map(role -> new  SimpleGrantedAuthority(role.getRolName().name())).collect(Collectors.toList());
        return new ManiUser(user.getUserName(), user.getPassword(), authoritys);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return authorities;
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
    
    
}
