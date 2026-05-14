package cl.duoc.bernardo_ohiggins.mensajeria_service.controller;

import cl.duoc.bernardo_ohiggins.mensajeria_service.models.entities.Mensaje;
import cl.duoc.bernardo_ohiggins.mensajeria_service.models.requests.CrearMensajeRequest;
import cl.duoc.bernardo_ohiggins.mensajeria_service.services.MensajeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeController {

    private final MensajeService mensajeService;

    public MensajeController(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    @PostMapping
    public Mono<ResponseEntity<Mensaje>> crear(@Valid @RequestBody CrearMensajeRequest request) {
        return Mono.fromCallable(() -> mensajeService.crear(request))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @GetMapping
    public Flux<Mensaje> listar() {
        return Flux.defer(() -> Flux.fromIterable(mensajeService.listar()))
                .subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Mensaje>> buscarPorId(@PathVariable Long id) {
        return Mono.fromCallable(() -> mensajeService.buscarPorId(id))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @GetMapping("/remitente/{idRemitente}")
    public Flux<Mensaje> buscarPorRemitente(@PathVariable Long idRemitente) {
        return Flux.defer(() -> Flux.fromIterable(mensajeService.buscarPorRemitente(idRemitente)))
                .subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping("/destinatario/{idDestinatario}")
    public Flux<Mensaje> buscarPorDestinatario(@PathVariable Long idDestinatario) {
        return Flux.defer(() -> Flux.fromIterable(mensajeService.buscarPorDestinatario(idDestinatario)))
                .subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping("/destinatario/{idDestinatario}/no-leidos")
    public Flux<Mensaje> buscarNoLeidosPorDestinatario(@PathVariable Long idDestinatario) {
        return Flux.defer(() -> Flux.fromIterable(mensajeService.buscarNoLeidosPorDestinatario(idDestinatario)))
                .subscribeOn(Schedulers.boundedElastic());
    }

    @PutMapping("/{id}/leido")
    public Mono<ResponseEntity<Mensaje>> marcarComoLeido(@PathVariable Long id) {
        return Mono.fromCallable(() -> mensajeService.marcarComoLeido(id))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> eliminar(@PathVariable Long id) {
        return Mono.fromRunnable(() -> mensajeService.eliminar(id))
                .subscribeOn(Schedulers.boundedElastic())
                .thenReturn(ResponseEntity.noContent().build());
    }
}