
package com.diego_kemer.porfolio.security.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LogiUser {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    
    
}
