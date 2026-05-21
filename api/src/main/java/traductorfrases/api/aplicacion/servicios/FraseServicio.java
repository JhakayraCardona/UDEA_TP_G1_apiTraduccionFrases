package traductorfrases.api.aplicacion.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import traductorfrases.api.dominio.entidades.Frase;
import traductorfrases.api.infraestructura.repositorios.IFraseRepositorio;

@Service
public class FraseServicio {

    @Autowired
    private IFraseRepositorio repositorio;

    public List<Frase> obtenerTodos(){
        return repositorio.findAll();
    }

}
