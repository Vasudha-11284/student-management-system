package com.example.lms.service;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.*;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String key;
    public String generateToken(String username){
        String token=
             Jwts.builder()
                 .setSubject(username)
                 .setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
                 .signWith(Keys.hmacShaKeyFor(key.getBytes()))
                 .compact();
                 return token;
    }
}
