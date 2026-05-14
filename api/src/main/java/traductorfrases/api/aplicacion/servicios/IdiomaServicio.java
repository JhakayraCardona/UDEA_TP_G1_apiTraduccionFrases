package traductorfrases.api.aplicacion.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import traductorfrases.api.dominio.entidades.Idioma;
import traductorfrases.api.infraestructura.repositorios.IIdiomaRepositorio;

@Service
public class IdiomaServicio {

    @Autowired
    IIdiomaRepositorio repositorio;

    public List<Idioma> obtenerTodos() {
        return repositorio.findAll(Sort.by("nombre"));
    }

    public Idioma obtener(int id) {
        return repositorio.findById(id).get();
    }

    public Idioma agregar(Idioma idioma) {
        idioma.setId(0);
        return repositorio.save(idioma);
    }

    public Idioma modificar(Idioma idioma) {
        return repositorio.findById(idioma.getId()).isPresent() ? repositorio.save(idioma) : null;
    }

    public boolean eliminar(int id) {
        if (repositorio.findById(id).isPresent()) {
            try {
                repositorio.deleteById(id);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

}
