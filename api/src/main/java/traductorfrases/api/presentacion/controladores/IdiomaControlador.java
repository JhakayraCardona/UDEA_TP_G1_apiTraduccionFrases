package traductorfrases.api.presentacion.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import traductorfrases.api.aplicacion.servicios.IdiomaServicio;
import traductorfrases.api.dominio.entidades.Idioma;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/idiomas")
public class IdiomaControlador {

    @Autowired
    private IdiomaServicio servicio;

    @GetMapping("/")
    public List<Idioma> obtenerTodos() {
        return servicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Idioma obtener(@PathVariable int id) {
        return servicio.obtener(id);
    }

    @PostMapping("/")
    public Idioma agregar(@RequestBody Idioma idioma) {
        return servicio.agregar(idioma);
    }

    @PutMapping("/")
    public Idioma modificar(@RequestBody Idioma idioma) {
        return servicio.modificar(idioma);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable int id) {
        return servicio.eliminar(id);
    }

}
