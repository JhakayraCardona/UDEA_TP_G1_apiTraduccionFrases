package traduccionfrases.api.presentacion.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import traduccionfrases.api.aplicacion.servicios.FraseServicio;
import traduccionfrases.api.dominio.entidades.Frase;

@RestController
@RequestMapping("/api/frases")
@CrossOrigin(origins = "*")
public class FraseControlador {

    @Autowired
    private FraseServicio servicio;

    @GetMapping("/")
    public List<Frase> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Frase obtener(@PathVariable int id) {
        return servicio.get(id);
    }

    @PostMapping("/")
    public Frase agregar(@RequestBody Frase frase) {
        return servicio.agregar(frase);
    }

    @PutMapping("/")
    public Frase modificar(@RequestBody Frase frase) {
        return servicio.modificar(frase);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable int id) {
        return servicio.eliminar(id);
    }

}
