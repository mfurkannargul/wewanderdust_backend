package com.wewanderdust.wewanderdust;

import java.util.Base64;
import java.security.Key;
import io.jsonwebtoken.security.Keys;

public class JwtSecretKeyGenerator {
    public static void main(String[] args) {
        Key secretKey = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        System.out.println("Your generated secret key: " + encodedKey);
    }
}
