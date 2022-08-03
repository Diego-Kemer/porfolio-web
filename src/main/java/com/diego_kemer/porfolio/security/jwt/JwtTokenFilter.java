
package com.diego_kemer.porfolio.security.jwt;

import com.diego_kemer.porfolio.security.services.UserDetaListService;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;


public class JwtTokenFilter extends OncePerRequestFilter{
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);
    
    @Autowired
    private JwtProvides jwtProvides;
    @Autowired
    private UserDetaListService userDetailsServiceImpl;

    
    
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException{
        try {
            String token = getToken(req);
            if (token != null && jwtProvides.validateToken(token)) {
                String userName = jwtProvides.getUserNameFromToken(token);
                UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(userName);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        filterChain.doFilter(req, res);
    }
    
    //Método que intercepta las peticiones http y les añade el token
    //Debemos quitarle la palabra Bearer del header y validarlo
    
    private String getToken(HttpServletRequest req){
        String header = req.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer")) 
            return header.replace("Bearer", "");
            return null;
    }
    
}


