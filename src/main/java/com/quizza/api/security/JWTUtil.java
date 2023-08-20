package com.quizza.api.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    private String secret = "blogify-secret";


    public String generateToken(Integer id) throws IllegalArgumentException, JWTCreationException {

        return JWT.create()
                .withSubject("User Details")
                .withClaim("id", id)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 864000000))
                .withIssuer("blogify")
                .sign(Algorithm.HMAC512(secret));


    }

    public String validateTokenAndRetriveSubject(String token) {

        JWTVerifier verifier = JWT.require(Algorithm.HMAC512(secret))
                .withSubject("User Details")
                .withIssuer("blogify")
                .build();

        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("id").asInt().toString();

    }


}