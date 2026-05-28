package traduccionfrases.api.aplicacion.servicios;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import traduccionfrases.api.dominio.entidades.Traduccion;
import traduccionfrases.api.dominio.entidades.TraduccionId;
import traduccionfrases.api.infraestructura.repositorios.ITraduccionRepositorio;

@Service
public class TraduccionServicio {

    @Autowired
    private ITraduccionRepositorio repositorio;

    @Autowired
    private IdiomaServicio idiomaServicio;

    @Autowired
    private FraseServicio fraseServicio;

    public List<Traduccion> listar() {
        return repositorio.findAll();
    }

    public List<Traduccion> listarPorIdioma(int idIdioma) {
        return repositorio.findByIdiomaId(idIdioma);
    }

    public List<Traduccion> listarPorFrase(int idFrase) {
        return repositorio.findByFraseId(idFrase);
    }

    public Traduccion get(int idIdioma, int idFrase) {
        TraduccionId TraduccionId = new TraduccionId(idIdioma, idFrase);
        return repositorio.findById(TraduccionId).isEmpty() ? null : repositorio.findById(TraduccionId).get();
    }

    public Traduccion actualizar(int idIdioma, int idFrase, String textoTraduccion) {
        var idioma = idiomaServicio.get(idIdioma);
        var frase = fraseServicio.get(idFrase);
        if (idioma != null && frase != null && !textoTraduccion.isEmpty()) {
            var traduccion = new Traduccion(idioma, frase, textoTraduccion);
            return repositorio.save(traduccion);
        }
        return null;
    }

    public boolean eliminar(int idIdioma, int idFrase) {
        TraduccionId TraduccionId = new TraduccionId(idIdioma, idFrase);
        try {
            repositorio.deleteById(TraduccionId);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public String traducirParrafo(String parrafo, int idIdioma) {
        if (parrafo == null || parrafo.isBlank()) {
            return "";
        }

        List<String> frases = Arrays.stream(
                parrafo.split("(?<=[.!?,])"))
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .toList();

        StringBuilder resultado = new StringBuilder();
        for (String frase : frases) {
            // Capturamos los signos que tenga al final para reponerlos luego si la BD no
            // los tiene
            String signosFinales = frase.replaceAll("[^.!?,]", "");

            String fraseParaBuscar = frase
                    .replaceAll("[\\p{Punct}]", "")
                    .trim()
                    .toLowerCase();

            var traduccion = repositorio.findByFraseTextoAndIdiomaIdNormalizado(fraseParaBuscar, idIdioma);
            if (traduccion.isPresent()) {
                var textoTraducido = traduccion.get().getTexto();
                resultado.append(textoTraducido);
                if (!textoTraducido.matches(".*[!?,.]$")) {
                    resultado.append(signosFinales);
                }
            } else {
                resultado.append(frase);
            }
            resultado.append(" ");
        }

        return resultado.toString().trim();
    }
}
