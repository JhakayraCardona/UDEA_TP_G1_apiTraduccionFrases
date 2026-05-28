package traduccionfrases.api.presentacion.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import traduccionfrases.api.aplicacion.servicios.TraduccionServicio;
import traduccionfrases.api.dominio.dtos.TraduccionDTO;
import traduccionfrases.api.dominio.entidades.Traduccion;

@RestController
@RequestMapping("/api/traducciones")
@CrossOrigin(origins = "*") // Permite la comunicación directa con AngularJS
public class TraduccionControlador {

    @Autowired
    private TraduccionServicio servicio;

    // 1. Traducir un párrafo segmentando por frases
    @GetMapping("/parrafo")
    public String traducirParrafo(@RequestParam String texto, @RequestParam int idIdioma) {
        return servicio.traducirParrafo(texto, idIdioma);
    }

    // 2. Listar todas las traducciones registradas en el sistema
    @GetMapping("/")
    public List<Traduccion> listar() {
        return servicio.listar();
    }

    // 3. Listar traducciones específicas filtradas por Idioma
    @GetMapping("/idioma/{idIdioma}")
    public List<Traduccion> listarPorIdioma(@PathVariable int idIdioma) {
        return servicio.listarPorIdioma(idIdioma);
    }

    // 4. Listar traducciones específicas de una sola frase base
    @GetMapping("/frase/{idFrase}")
    public List<Traduccion> listarPorFrase(@PathVariable int idFrase) {
        return servicio.listarPorFrase(idFrase);
    }

    // 5. Obtener una única traducción mediante su llave compuesta
    @GetMapping("/buscar")
    public Traduccion obtener(@RequestParam int idIdioma, @RequestParam int idFrase) {
        return servicio.get(idIdioma, idFrase);
    }

    // 6. Crear o actualizar una traducción
    @PostMapping("/guardar")
    public Traduccion actualizar(@RequestBody TraduccionDTO dto) {
        // Extraemos los datos limpiamente desde el objeto DTO
        return servicio.actualizar(
                dto.getIdIdioma(),
                dto.getIdFrase(),
                dto.getTextoTraduccion());
    }

    // 7. Eliminar una traducción específica por su combinación única de idioma y
    // frase
    @DeleteMapping("/eliminar/{idIdioma}/{idFrase}")
    public boolean eliminar(@PathVariable int idIdioma, @PathVariable int idFrase) {
        return servicio.eliminar(idIdioma, idFrase);
    }
}