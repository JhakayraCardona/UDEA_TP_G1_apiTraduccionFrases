package traductorfrases.api.aplicacion.servicios;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import traductorfrases.api.infraestructura.repositorios.ITraduccionRepositorio;

@Service
public class TraduccionServicio {

    @Autowired
    private ITraduccionRepositorio repositorio;

    public String traducirParrafo(String parrafo, int idIdioma) {
        if (parrafo == null || parrafo.isBlank()) {
            return "";
        }

        List<String> frases = Arrays.stream(
                parrafo.split("[.!?,]+"))
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .toList();

        StringBuilder resultado = new StringBuilder();
        for (String frase : frases) {
            var traduccion = repositorio.findByFraseTextoAndIdiomaId(frase, idIdioma);

            if (traduccion.isPresent()) {
                resultado.append(traduccion.get().getTexto());
            } else {
                resultado.append(frase);
            }
            resultado.append(" ");
        }

        return resultado.toString();
    }
}
