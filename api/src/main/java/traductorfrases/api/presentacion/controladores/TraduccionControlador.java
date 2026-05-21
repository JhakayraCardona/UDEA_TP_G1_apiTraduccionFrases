package traductorfrases.api.presentacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import traductorfrases.api.aplicacion.servicios.TraduccionServicio;

@RestController
@RequestMapping("/api/traduccion")
public class TraduccionControlador {

    @Autowired
    private TraduccionServicio servicio;

    @GetMapping("/parrafo")
    public String traducirParrafo(@RequestParam String parrafo, @RequestParam int idIdioma) {
        return servicio.traducirParrafo(parrafo, idIdioma);
    }

}
