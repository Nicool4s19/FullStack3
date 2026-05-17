package cl.duoc.bernardo_ohiggins.reuniones_citaciones.controller;

import cl.duoc.bernardo_ohiggins.reuniones_citaciones.models.entities.BitacoraReuniones;
import cl.duoc.bernardo_ohiggins.reuniones_citaciones.models.requests.BitacoraReunionesRequest;
import cl.duoc.bernardo_ohiggins.reuniones_citaciones.services.BitacoraReunionesService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reuniones")
public class BitacoraReunionesController {

    private final BitacoraReunionesService service;

    public BitacoraReunionesController(BitacoraReunionesService service) {
        this.service = service;
    }

    @PostMapping
    public BitacoraReuniones guardar(@Valid @RequestBody BitacoraReunionesRequest request) {
        return service.guardar(request);
    }

    @GetMapping
    public List<BitacoraReuniones> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public BitacoraReuniones buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public BitacoraReuniones editar(@PathVariable Long id, @Valid @RequestBody BitacoraReunionesRequest request) {
        return service.editar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}