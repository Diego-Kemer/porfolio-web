
package com.diego_kemer.porfolio.security.dto;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NewUser {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    private Set<String> roles = new HashSet<>();

    public NewUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    
    
}
