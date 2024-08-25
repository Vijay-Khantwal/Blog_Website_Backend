package com.backend.blog_project.Services;

import com.backend.blog_project.Repositories.User_Repository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.expiration-time}")
    private long jwtExpiration;

    @Autowired
    User_Repository user_repository;


    public String generateToken(String username, String password) {
        Map<String,Object> claims = new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+ jwtExpiration))
                .and()
                .signWith(getKey())
                .compact();
    }

    private SecretKey getKey() {
         byte[] keyBytes = Decoders.BASE64.decode(secretKey);
         return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token) {

        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims,T> claimResolver) {
        Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);

    }

    private Claims extractAllClaims(String token) {

        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        final Date lastLogout = user_repository.findByUsername(userDetails.getUsername()).getJwt_logOut_Time();
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token) && !isUserLoggedOut(token,lastLogout));
    }

    private boolean isUserLoggedOut(String token,Date lastLogout) {
        if(lastLogout == null){
            return false;
        }
        return extractIssuedAt(token).before(lastLogout);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }

    private Date extractIssuedAt(String token){
        return extractClaim(token,Claims::getIssuedAt);
    }
}
