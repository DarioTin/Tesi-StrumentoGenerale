package com.dariotintore.backend.Service;

import com.dariotintore.backend.Entity.Token;
import com.dariotintore.backend.Repository.TokenRepository;
import com.dariotintore.backend.Utils.ResponseHelper;
import io.jsonwebtoken.Jwts;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;

@Transactional
@Service
public class TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    public String generateToken(String email) {
        Instant now = Instant.now();

        String jwt = Jwts.builder().setSubject(email).setAudience("token-generation")
                .claim("1d20", new Random().nextInt(20) + 1).setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(1, ChronoUnit.MINUTES))).compact();
        Token t = new Token(email, jwt);
        saveToken(t);
        return jwt;
    }

    public Token saveToken(Token tok) {
        if (checkTokenAlreadyExists(tok.getEmail())) {
            deleteToken(tok.getEmail());
        }
        return tokenRepository.save(tok);
    }

    public boolean checkTokenAlreadyExists(String email) {
        return tokenRepository.checkTokenAlreadyExists(email) >= 1;
    }

    public boolean deleteToken(String email) {
        tokenRepository.deleteByEmail(email);
        return true;
    }

    public ResponseEntity<JSONObject> validateToken(String email, String token) {
        if (tokenRepository.validateToken(email, token) > 0) {
            return ResponseHelper.buildOkResponse("Token validated");
        } else {
            return ResponseHelper.buildForbiddenResponse("Token not valid");
        }
    }

}
