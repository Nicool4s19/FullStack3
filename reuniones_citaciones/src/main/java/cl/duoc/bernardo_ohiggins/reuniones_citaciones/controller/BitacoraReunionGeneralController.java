package cl.duoc.bernardo_ohiggins.reuniones_citaciones.controller;

import cl.duoc.bernardo_ohiggins.reuniones_citaciones.models.entities.BitacoraReunionGeneral;
import cl.duoc.bernardo_ohiggins.reuniones_citaciones.models.requests.BitacoraReunionGeneralRequest;
import cl.duoc.bernardo_ohiggins.reuniones_citaciones.services.BitacoraReunionGeneralService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bitacora-general")
public class BitacoraReunionGeneralController {

    private final BitacoraReunionGeneralService service;

    public BitacoraReunionGeneralController(BitacoraReunionGeneralService service) {
        this.service = service;
    }

    @PostMapping
    public BitacoraReunionGeneral guardar(@Valid @RequestBody BitacoraReunionGeneralRequest request) {
        return service.guardar(request);
    }

    @GetMapping
    public List<BitacoraReunionGeneral> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public BitacoraReunionGeneral buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public BitacoraReunionGeneral editar(@PathVariable Long id, @Valid @RequestBody BitacoraReunionGeneralRequest request) {
        return service.editar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}