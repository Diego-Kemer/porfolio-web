
package com.diego_kemer.porfolio.security.jwt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint{
    
    //Este método es para cuando un usuario ntenta realizar una acción para la cual no está autorizado
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) throws  IOException, ServletException{
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado");
    }
}

