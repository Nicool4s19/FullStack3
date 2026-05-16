package Bernardo_Ohiggins.mural_calendario.servicies;

import Bernardo_Ohiggins.mural_calendario.models.entities.CalendarioEstudiantil;
import Bernardo_Ohiggins.mural_calendario.models.entities.MuralDigital;
import Bernardo_Ohiggins.mural_calendario.models.requests.CalendarioRequest;
import Bernardo_Ohiggins.mural_calendario.models.requests.MuralRequest;
import java.util.List;

public interface PortalService {
    List<MuralDigital> listarNoticias();
    MuralDigital guardarNoticia(MuralRequest request);
    
    List<CalendarioEstudiantil> listarEventos();
    CalendarioEstudiantil guardarEvento(CalendarioRequest request);
}