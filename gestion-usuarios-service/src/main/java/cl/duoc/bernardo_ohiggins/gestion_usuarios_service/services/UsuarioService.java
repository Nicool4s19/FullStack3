package cl.duoc.bernardo_ohiggins.gestion_usuarios_service.services;

import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.entities.Direccion;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.entities.Rol;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.entities.Usuario;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.requests.CrearUsuarioRequest;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.requests.LoginRequest;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.repositories.DireccionRepository;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.repositories.RolRepository;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.models.responses.LoginResponse;
import cl.duoc.bernardo_ohiggins.gestion_usuarios_service.security.JwtService;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final DireccionRepository direccionRepository;
    private final JwtService jwtService;

    public UsuarioService(
        UsuarioRepository usuarioRepository,
        RolRepository rolRepository,
        DireccionRepository direccionRepository,
        JwtService jwtService
) {
    this.usuarioRepository = usuarioRepository;
    this.rolRepository = rolRepository;
    this.direccionRepository = direccionRepository;
    this.jwtService = jwtService;
}

    public Usuario crear(CrearUsuarioRequest request) {
        Rol rol = rolRepository.findById(request.getIdRol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        Direccion direccion = direccionRepository.findById(request.getIdDireccion())
                .orElseThrow(() -> new RuntimeException("Dirección no encontrada"));

        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .segundoNombre(request.getSegundoNombre())
                .apellido(request.getApellido())
                .segundoApellido(request.getSegundoApellido())
                .rut(request.getRut())
                .email(request.getEmail())
                .telefono(request.getTelefono())
                .password(request.getPassword())
                .activo(true)
                .rol(rol)
                .direccion(direccion)
                .build();

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario actualizar(Long id, CrearUsuarioRequest request) {
        Usuario usuario = buscarPorId(id);

        Rol rol = rolRepository.findById(request.getIdRol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        Long idDireccion = request.getIdDireccion();

if (idDireccion == null) {
    idDireccion = 1L;
}

Direccion direccion = direccionRepository.findById(idDireccion)
        .orElseThrow(() -> new RuntimeException("Dirección no encontrada"));

        usuario.setNombre(request.getNombre());
        usuario.setSegundoNombre(request.getSegundoNombre());
        usuario.setApellido(request.getApellido());
        usuario.setSegundoApellido(request.getSegundoApellido());
        usuario.setRut(request.getRut());
        usuario.setEmail(request.getEmail());
        usuario.setTelefono(request.getTelefono());
        usuario.setPassword(request.getPassword());
        usuario.setRol(rol);
        usuario.setDireccion(direccion);

        return usuarioRepository.save(usuario);
    }

    public void eliminar(Long id) {
        Usuario usuario = buscarPorId(id);
        usuarioRepository.delete(usuario);
    }

    public LoginResponse login(LoginRequest request) {

    Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));

    if (!usuario.getPassword().equals(request.getPassword())) {
        throw new RuntimeException("Credenciales inválidas");
    }

    String token = jwtService.generateToken(usuario);

    return new LoginResponse(
            token,
            usuario.getRol().getNombreRol()
    );
}
    
}
