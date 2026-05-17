package cl.duoc.bernardo_ohiggins.reuniones_citaciones.controller;

import cl.duoc.bernardo_ohiggins.reuniones_citaciones.models.entities.CitacionApoderado;
import cl.duoc.bernardo_ohiggins.reuniones_citaciones.models.requests.CitacionApoderadoRequest;
import cl.duoc.bernardo_ohiggins.reuniones_citaciones.services.CitacionApoderadoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citaciones")
public class CitacionApoderadoController {

    private final CitacionApoderadoService service;

    public CitacionApoderadoController(CitacionApoderadoService service) {
        this.service = service;
    }

    @PostMapping
    public CitacionApoderado guardar(@Valid @RequestBody CitacionApoderadoRequest request) {
        return service.guardar(request);
    }

    @GetMapping
    public List<CitacionApoderado> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public CitacionApoderado buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public CitacionApoderado editar(@PathVariable Long id, @Valid @RequestBody CitacionApoderadoRequest request) {
        return service.editar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}