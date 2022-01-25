package com.example.demo.security;

import com.example.demo.model.Constants;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JwtTokenUtil implements Serializable {

    private static final Logger LOGGER = LogManager.getLogger(JwtTokenUtil.class);

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {

        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(Constants.SIGNING_KEY.getBytes())
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(Authentication authentication) {
        final String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).
                        collect(Collectors.joining(","));
        SecretKey key = new SecretKeySpec(Constants.SIGNING_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        return Jwts.builder().
                setSubject(authentication.getName())
                .claim("scopes", authorities)
                .signWith(key)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()
                        + Constants.ACCESS_TOKEN_VALIDITY_SECONDS))
                .compact();

    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(Constants.SIGNING_KEY).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            LOGGER.info("Invalid JWT signature trace: {0}", e);
        } catch (MalformedJwtException e) {
            LOGGER.info("Invalid JWT token trace: {0}", e);
        } catch (ExpiredJwtException e) {
            LOGGER.info("Expired JWT token trace: {0}", e);
        } catch (UnsupportedJwtException e) {
            LOGGER.info("Unsupported JWT token trace: {0}", e);
        } catch (IllegalArgumentException e) {
            LOGGER.info("JWT token compact of handler are invalid trace: {0}", e);
        }
        return false;
    }

    public Authentication getAuthentication(final String token) {
        final Claims claims = getClaims(token);

        final Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(Constants.AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        User user = new User(claims.getSubject(), "", authorities);

        return new UsernamePasswordAuthenticationToken(user, "", authorities);
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Constants.SIGNING_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
