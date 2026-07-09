package cl.duoc.bernardo_ohiggins.gestion_usuarios_service.security;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        return http

                .csrf(csrf -> csrf.disable())

                .cors(Customizer.withDefaults())

                .sessionManagement(session -> session.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS))

                .formLogin(form -> form.disable())

                .httpBasic(basic -> basic.disable())

                .exceptionHandling(exceptions -> exceptions

                        .authenticationEntryPoint(
                                (request, response, exception) -> response.sendError(
                                        HttpServletResponse.SC_UNAUTHORIZED,
                                        "Token ausente, inválido o vencido"))

                        .accessDeniedHandler(
                                (request, response, exception) -> response.sendError(
                                        HttpServletResponse.SC_FORBIDDEN,
                                        "No tienes permisos para realizar esta acción")))

                .authorizeHttpRequests(authorize -> authorize

                        .requestMatchers(
                                HttpMethod.OPTIONS,
                                "/**")
                        .permitAll()

                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/usuarios/login")
                        .permitAll()

                        .requestMatchers(
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/v3/api-docs/**",
                                "/error")
                        .permitAll()

                        .requestMatchers(
                                "/api/usuarios/**",
                                "/api/roles/**")
                        .hasRole("ADMIN")

                        .anyRequest()
                        .authenticated())

                .addFilterBefore(
                        jwtFilter,
                        UsernamePasswordAuthenticationFilter.class)

                .build();
    }
}