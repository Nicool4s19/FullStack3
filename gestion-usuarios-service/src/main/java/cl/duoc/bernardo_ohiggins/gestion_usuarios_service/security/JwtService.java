package cl.duoc.bernardo_ohiggins.gestion_usuarios_service.security;

import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.entities.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    private final String SECRET =
            "MiClaveSuperSecretaParaJWT2026MiClaveSuperSecretaParaJWT2026";

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateToken(Usuario usuario) {

        return Jwts.builder()

                .subject(usuario.getEmail())

                .claim("rol", usuario.getRol().getNombreRol())

                .issuedAt(new Date())

                .expiration(new Date(System.currentTimeMillis()+86400000))

                .signWith(getKey())

                .compact();

    }

    public Claims getClaims(String token){

        return Jwts.parser()

                .verifyWith(getKey())

                .build()

                .parseSignedClaims(token)

                .getPayload();

    }

    public String getEmail(String token){

        return getClaims(token).getSubject();

    }

}