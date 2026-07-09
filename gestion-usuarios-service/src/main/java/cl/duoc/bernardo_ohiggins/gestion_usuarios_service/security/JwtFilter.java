package cl.duoc.bernardo_ohiggins.gestion_usuarios_service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null
                || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authorizationHeader.substring(7);

        try {

            Claims claims = jwtService.getClaims(token);

            String email = claims.getSubject();

            String rolClaim = claims.get("rol", String.class);

            if (email != null
                    && rolClaim != null
                    && SecurityContextHolder
                            .getContext()
                            .getAuthentication() == null) {

                String rol = normalizarRol(rolClaim);

                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(
                        "ROLE_" + rol);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        email,
                        null,
                        List.of(authority));

                authentication.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request));

                SecurityContextHolder
                        .getContext()
                        .setAuthentication(authentication);
            }

        } catch (
                JwtException
                | IllegalArgumentException exception) {
            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(request, response);
    }

    private String normalizarRol(String rol) {

        String valor = rol
                .trim()
                .toUpperCase(Locale.ROOT);

        if (valor.startsWith("ROLE_")) {
            valor = valor.substring(5);
        }

        return switch (valor) {
            case "ADMINISTRADOR" -> "ADMIN";
            case "DOCENTE" -> "PROFESOR";
            case "ESTUDIANTE" -> "ALUMNO";
            case "USUARIO" -> "USER";
            default -> valor;
        };
    }
}