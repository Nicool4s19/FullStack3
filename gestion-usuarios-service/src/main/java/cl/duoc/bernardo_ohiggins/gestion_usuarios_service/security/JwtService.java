package cl.duoc.bernardo_ohiggins.gestion_usuarios_service.security;

import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.entities.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET = "MiClaveSuperSecretaParaJWT2026MiClaveSuperSecretaParaJWT2026";

    private static final long EXPIRATION_TIME = 86400000;

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(
                SECRET.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(Usuario usuario) {

        String rol = usuario
                .getRol()
                .getNombreRol()
                .trim()
                .toUpperCase();

        return Jwts.builder()
                .subject(usuario.getEmail())
                .claim("rol", rol)
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + EXPIRATION_TIME))
                .signWith(getKey())
                .compact();
    }

    public Claims getClaims(String token) {

        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String getEmail(String token) {
        return getClaims(token).getSubject();
    }

    public String getRole(String token) {
        return getClaims(token)
                .get("rol", String.class);
    }

    public boolean isTokenValid(String token) {

        Claims claims = getClaims(token);

        return claims.getExpiration()
                .after(new Date());
    }
}