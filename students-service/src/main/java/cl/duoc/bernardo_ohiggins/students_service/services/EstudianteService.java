package cl.duoc.bernardo_ohiggins.students_service.services;

import cl.duoc.bernardo_ohiggins.students_service.models.entities.*;
import cl.duoc.bernardo_ohiggins.students_service.models.requests.*;
import cl.duoc.bernardo_ohiggins.students_service.repositories.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;
    private final MatriculaRepository matriculaRepository;
    private final HojaVidaRepository hojaVidaRepository;
    private final AntecedenteMedicoRepository antecedenteMedicoRepository;
    private final AntecedenteAcademicoRepository antecedenteAcademicoRepository;
    private final AntecedenteApoderadoRepository antecedenteApoderadoRepository;

    public EstudianteService(
            EstudianteRepository estudianteRepository,
            MatriculaRepository matriculaRepository,
            HojaVidaRepository hojaVidaRepository,
            AntecedenteMedicoRepository antecedenteMedicoRepository,
            AntecedenteAcademicoRepository antecedenteAcademicoRepository,
            AntecedenteApoderadoRepository antecedenteApoderadoRepository
    ) {
        this.estudianteRepository = estudianteRepository;
        this.matriculaRepository = matriculaRepository;
        this.hojaVidaRepository = hojaVidaRepository;
        this.antecedenteMedicoRepository = antecedenteMedicoRepository;
        this.antecedenteAcademicoRepository = antecedenteAcademicoRepository;
        this.antecedenteApoderadoRepository = antecedenteApoderadoRepository;
    }

    public Estudiante crearEstudiante(CrearEstudianteRequest request) {
        Estudiante estudiante = Estudiante.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .rut(request.getRut())
                .fechaNacimiento(request.getFechaNacimiento())
                .estado(request.getEstado() != null ? request.getEstado() : "ACTIVO")
                .idUsuario(request.getIdUsuario())
                .build();

        return estudianteRepository.save(estudiante);
    }

    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Estudiante buscarEstudiantePorId(Long id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    public Matricula crearMatricula(CrearMatriculaRequest request) {
        Estudiante estudiante = buscarEstudiantePorId(request.getIdEstudiante());

        Matricula matricula = Matricula.builder()
                .estadoMatricula(request.getEstadoMatricula() != null ? request.getEstadoMatricula() : "ACTIVA")
                .fechaMatricula(LocalDate.now())
                .estudiante(estudiante)
                .build();

        return matriculaRepository.save(matricula);
    }

    public List<Matricula> listarMatriculas() {
        return matriculaRepository.findAll();
    }

    public HojaVidaEstudiante crearHojaVida(CrearHojaVidaRequest request) {
        Estudiante estudiante = buscarEstudiantePorId(request.getIdEstudiante());

        HojaVidaEstudiante hojaVida = HojaVidaEstudiante.builder()
                .fechaCreacion(LocalDate.now())
                .observacionesGenerales(request.getObservacionesGenerales())
                .estudiante(estudiante)
                .build();

        return hojaVidaRepository.save(hojaVida);
    }

    public HojaVidaEstudiante buscarHojaVidaPorEstudiante(Long idEstudiante) {
        return hojaVidaRepository.findByEstudianteIdEstudiante(idEstudiante)
                .orElseThrow(() -> new RuntimeException("Hoja de vida no encontrada"));
    }

    public AntecedenteMedico crearAntecedenteMedico(CrearAntecedenteMedicoRequest request) {
        Estudiante estudiante = buscarEstudiantePorId(request.getIdEstudiante());

        AntecedenteMedico antecedente = AntecedenteMedico.builder()
                .enfermedad(request.getEnfermedad())
                .alergias(request.getAlergias())
                .medicamentos(request.getMedicamentos())
                .tipoSangre(request.getTipoSangre())
                .observaciones(request.getObservaciones())
                .estudiante(estudiante)
                .build();

        return antecedenteMedicoRepository.save(antecedente);
    }

    public AntecedenteAcademico crearAntecedenteAcademico(CrearAntecedenteAcademicoRequest request) {
        Estudiante estudiante = buscarEstudiantePorId(request.getIdEstudiante());

        AntecedenteAcademico antecedente = AntecedenteAcademico.builder()
                .anio(request.getAnio())
                .promedioFinal(request.getPromedioFinal())
                .observaciones(request.getObservaciones())
                .estudiante(estudiante)
                .build();

        return antecedenteAcademicoRepository.save(antecedente);
    }

    public AntecedenteApoderado crearAntecedenteApoderado(CrearAntecedenteApoderadoRequest request) {
        Estudiante estudiante = buscarEstudiantePorId(request.getIdEstudiante());

        AntecedenteApoderado antecedente = AntecedenteApoderado.builder()
                .nombre(request.getNombre())
                .ocupacion(request.getOcupacion())
                .nivelEducacional(request.getNivelEducacional())
                .relacionEstudiante(request.getRelacionEstudiante())
                .telefono(request.getTelefono())
                .correo(request.getCorreo())
                .observaciones(request.getObservaciones())
                .estudiante(estudiante)
                .build();

        return antecedenteApoderadoRepository.save(antecedente);
    }
}