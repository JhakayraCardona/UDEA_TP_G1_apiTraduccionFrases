package traductorfrases.api.presentacion.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import traductorfrases.api.aplicacion.servicios.FraseServicio;
import traductorfrases.api.dominio.entidades.Frase;

@RestController
@RequestMapping("/api/frases")
public class FraseControlador {

    @Autowired
    private FraseServicio servicio;

    @GetMapping("/")
    public List<Frase> obtenerTodos() {
        return servicio.obtenerTodos();
    }

}
