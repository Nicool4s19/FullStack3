package cl.duoc.bernardo_ohiggins.gestion_usuarios_service.controller;

import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.entities.Rol;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.requests.CrearRolRequest;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.services.RolService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "http://localhost:5173")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @PostMapping
    public Mono<ResponseEntity<Rol>> crear(@Valid @RequestBody CrearRolRequest request) {
        return Mono.fromCallable(() -> rolService.crear(request))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @GetMapping
    public Flux<Rol> listar() {
        return Flux.defer(() -> Flux.fromIterable(rolService.listar()))
                .subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Rol>> buscarPorId(@PathVariable Long id) {
        return Mono.fromCallable(() -> rolService.buscarPorId(id))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

}
