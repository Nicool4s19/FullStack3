package cl.duoc.bernardo_ohiggins.gestion_usuarios_service.controller;

import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.entities.Usuario;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.requests.CrearUsuarioRequest;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.requests.LoginRequest;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.responses.LoginResponse;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://full-stack3-front.vercel.app"
})
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioSerive) {
        this.usuarioService = usuarioSerive;
    }

    @PostMapping
    public Mono<ResponseEntity<Usuario>> crear(@Valid @RequestBody CrearUsuarioRequest request) {
        return Mono.fromCallable(() -> usuarioService.crear(request))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @GetMapping
    public Flux<Usuario> listar() {
        return Flux.defer(() -> Flux.fromIterable(usuarioService.listar()))
                .subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Usuario>> buscarPorId(@PathVariable Long id) {
        return Mono.fromCallable(() -> usuarioService.buscarPorId(id))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Usuario>> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody CrearUsuarioRequest request
    ) {
        return Mono.fromCallable(() -> usuarioService.actualizar(id, request))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> eliminar(@PathVariable Long id) {
        return Mono.fromRunnable(() -> usuarioService.eliminar(id))
                .subscribeOn(Schedulers.boundedElastic())
                .thenReturn(ResponseEntity.noContent().build());
    }

    @PostMapping("/login")
public Mono<ResponseEntity<LoginResponse>> login(@Valid @RequestBody LoginRequest request) {

    return Mono.fromCallable(() -> usuarioService.login(request))
            .subscribeOn(Schedulers.boundedElastic())
            .map(ResponseEntity::ok);
}
}
