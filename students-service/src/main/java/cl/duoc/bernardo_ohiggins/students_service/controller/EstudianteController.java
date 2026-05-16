package cl.duoc.bernardo_ohiggins.students_service.controller;

import cl.duoc.bernardo_ohiggins.students_service.models.entities.*;
import cl.duoc.bernardo_ohiggins.students_service.models.requests.*;
import cl.duoc.bernardo_ohiggins.students_service.services.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping("/estudiantes")
    public Mono<ResponseEntity<Estudiante>> crearEstudiante(@Valid @RequestBody CrearEstudianteRequest request) {
        return Mono.fromCallable(() -> estudianteService.crearEstudiante(request))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @GetMapping("/estudiantes")
    public Flux<Estudiante> listarEstudiantes() {
        return Flux.defer(() -> Flux.fromIterable(estudianteService.listarEstudiantes()))
                .subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping("/estudiantes/{id}")
    public Mono<ResponseEntity<Estudiante>> buscarEstudiantePorId(@PathVariable Long id) {
        return Mono.fromCallable(() -> estudianteService.buscarEstudiantePorId(id))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @PostMapping("/matriculas")
    public Mono<ResponseEntity<Matricula>> crearMatricula(@Valid @RequestBody CrearMatriculaRequest request) {
        return Mono.fromCallable(() -> estudianteService.crearMatricula(request))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @GetMapping("/matriculas")
    public Flux<Matricula> listarMatriculas() {
        return Flux.defer(() -> Flux.fromIterable(estudianteService.listarMatriculas()))
                .subscribeOn(Schedulers.boundedElastic());
    }

    @PostMapping("/hojas-vida")
    public Mono<ResponseEntity<HojaVidaEstudiante>> crearHojaVida(@Valid @RequestBody CrearHojaVidaRequest request) {
        return Mono.fromCallable(() -> estudianteService.crearHojaVida(request))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @GetMapping("/hojas-vida/estudiante/{idEstudiante}")
    public Mono<ResponseEntity<HojaVidaEstudiante>> buscarHojaVidaPorEstudiante(@PathVariable Long idEstudiante) {
        return Mono.fromCallable(() -> estudianteService.buscarHojaVidaPorEstudiante(idEstudiante))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @PostMapping("/antecedentes-medicos")
    public Mono<ResponseEntity<AntecedenteMedico>> crearAntecedenteMedico(
            @Valid @RequestBody CrearAntecedenteMedicoRequest request
    ) {
        return Mono.fromCallable(() -> estudianteService.crearAntecedenteMedico(request))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @PostMapping("/antecedentes-academicos")
    public Mono<ResponseEntity<AntecedenteAcademico>> crearAntecedenteAcademico(
            @Valid @RequestBody CrearAntecedenteAcademicoRequest request
    ) {
        return Mono.fromCallable(() -> estudianteService.crearAntecedenteAcademico(request))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }

    @PostMapping("/antecedentes-apoderado")
    public Mono<ResponseEntity<AntecedenteApoderado>> crearAntecedenteApoderado(
            @Valid @RequestBody CrearAntecedenteApoderadoRequest request
    ) {
        return Mono.fromCallable(() -> estudianteService.crearAntecedenteApoderado(request))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ResponseEntity::ok);
    }
}