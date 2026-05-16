package Bernardo_Ohiggins.mural_calendario.servicies;

import Bernardo_Ohiggins.mural_calendario.models.entities.CalendarioEstudiantil;
import Bernardo_Ohiggins.mural_calendario.models.entities.MuralDigital;
import Bernardo_Ohiggins.mural_calendario.models.requests.CalendarioRequest;
import Bernardo_Ohiggins.mural_calendario.models.requests.MuralRequest;
import Bernardo_Ohiggins.mural_calendario.repositories.CalendarioEstudiantilRepository;
import Bernardo_Ohiggins.mural_calendario.repositories.MuralDigitalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PortalServiceImpl implements PortalService {

    private final MuralDigitalRepository muralRepository;
    private final CalendarioEstudiantilRepository calendarioRepository;

    public PortalServiceImpl(MuralDigitalRepository muralRepository, CalendarioEstudiantilRepository calendarioRepository) {
        this.muralRepository = muralRepository;
        this.calendarioRepository = calendarioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MuralDigital> listarNoticias() {
        return muralRepository.findAll();
    }

    @Override
    @Transactional
    public MuralDigital guardarNoticia(MuralRequest request) {
        MuralDigital noticia = new MuralDigital();
        noticia.setTitulo(request.getTitulo());
        noticia.setContenido(request.getContenido());
        noticia.setAutor(request.getAutor());
        return muralRepository.save(noticia);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CalendarioEstudiantil> listarEventos() {
        return calendarioRepository.findAll();
    }

    @Override
    @Transactional
    public CalendarioEstudiantil guardarEvento(CalendarioRequest request) {
        CalendarioEstudiantil evento = new CalendarioEstudiantil();
        evento.setEvento(request.getEvento());
        evento.setDescripcion(request.getDescripcion());
        evento.setFechaInicio(request.getFechaInicio());
        
        // Si no se define una fecha de término del evento, se asume que finaliza el mismo día de inicio
        if (request.getFechaFin() == null) {
            evento.setFechaFin(request.getFechaInicio());
        } else {
            evento.setFechaFin(request.getFechaFin());
        }
        
        evento.setCategoria(request.getCategoria());
        return calendarioRepository.save(evento);
    }
}