
package com.diego_kemer.porfolio.security.jwt;

import com.diego_kemer.porfolio.security.entities.ManiUser;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvides {
    //Logger para mostrar los errores
    private final static Logger logger = LoggerFactory.getLogger(JwtProvides.class);
    
    //Clave para verificar el token
    @Value("${jwt.secret}")
    private String secret;
    
    //Tiempo base de expiración
    @Value("${jwt.expiration}")
    private int expiration;
    
    //Esta función genera el token en base a los parámetros establecidos
    //Controlamos cualquier error que pueda surgir con el token
    public String generateToken(Authentication authentication){
        ManiUser maniUser = (ManiUser) authentication.getPrincipal();
        return Jwts.builder().setSubject(maniUser.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration *1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    
    //Funcion que permite obtener el nombre de usuario con el token
    public String getUserNameFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
    //Funcion que permite validar nuestro token con la firma secreta
    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Token mal formado");
        }catch (UnsupportedJwtException e) {
            logger.error("Token no soportado");
        }catch (ExpiredJwtException e) {
            logger.error("Token expirado");
        }catch (IllegalArgumentException e) {
            logger.error("Token vacio");
        }
        catch (SignatureException e) {
            logger.error("Fail en la firma");
        }
        return false;
    }
}
