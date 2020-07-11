package com.sinacolada.tiki.security.jwt;

import java.util.Date;

import com.sinacolada.tiki.security.user.UserDetailsAdapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class JwtUtils {

    @Value("${tiki.app.jwtSecret}")
    private String jwtSecret;

    @Value("${tiki.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication) {
        UserDetailsAdapter userPrincipal = (UserDetailsAdapter) authentication.getPrincipal();
        return Jwts.builder().setSubject(userPrincipal.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }

    public String getUserNameFromJwtToken(String jwtToken) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtToken).getBody().getSubject();
    }

    public boolean validateJwtToken(String jwtToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

}
