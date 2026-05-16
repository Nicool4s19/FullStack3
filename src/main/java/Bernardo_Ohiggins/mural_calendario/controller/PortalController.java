package Bernardo_Ohiggins.mural_calendario.controller;

import Bernardo_Ohiggins.mural_calendario.models.entities.CalendarioEstudiantil;
import Bernardo_Ohiggins.mural_calendario.models.entities.MuralDigital;
import Bernardo_Ohiggins.mural_calendario.models.requests.CalendarioRequest;
import Bernardo_Ohiggins.mural_calendario.models.requests.MuralRequest;
import Bernardo_Ohiggins.mural_calendario.servicies.PortalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/portal")
@Tag(name = "Portal Informativo Estudiantil", description = "Endpoints de control para Mural y Calendario")
@CrossOrigin(origins = "*")
public class PortalController {

    private final PortalService portalService;

    public PortalController(PortalService portalService) {
        this.portalService = portalService;
    }

    // --- MURAL DIGITAL ENDPOINTS ---

    @Operation(summary = "Listar todas las publicaciones del mural")
    @GetMapping("/mural")
    public ResponseEntity<List<MuralDigital>> getAllNoticias() {
        return ResponseEntity.ok(portalService.listarNoticias());
    }

    @Operation(summary = "Crear una nueva publicación en el mural")
    @PostMapping("/mural")
    public ResponseEntity<MuralDigital> createNoticia(@Valid @RequestBody MuralRequest request) {
        MuralDigital nuevaNoticia = portalService.guardarNoticia(request);
        return new ResponseEntity<>(nuevaNoticia, HttpStatus.CREATED);
    }

    // --- CALENDARIO ESTUDIANTIL ENDPOINTS ---

    @Operation(summary = "Listar todos los eventos del calendario")
    @GetMapping("/calendario")
    public ResponseEntity<List<CalendarioEstudiantil>> getAllEventos() {
        return ResponseEntity.ok(portalService.listarEventos());
    }

    @Operation(summary = "Crear un nuevo evento en el calendario")
    @PostMapping("/calendario")
    public ResponseEntity<CalendarioEstudiantil> createEvento(@Valid @RequestBody CalendarioRequest request) {
        CalendarioEstudiantil nuevoEvento = portalService.guardarEvento(request);
        return new ResponseEntity<>(nuevoEvento, HttpStatus.CREATED);
    }
}