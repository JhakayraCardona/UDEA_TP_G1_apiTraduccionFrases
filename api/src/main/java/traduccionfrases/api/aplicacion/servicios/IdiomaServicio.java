package traduccionfrases.api.aplicacion.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import traduccionfrases.api.dominio.entidades.Idioma;
import traduccionfrases.api.infraestructura.repositorios.IIdiomaRepositorio;

@Service
public class IdiomaServicio {

    @Autowired
    private IIdiomaRepositorio repositorio;

    public List<Idioma> listar() {
        return repositorio.findAll();
    }

    public Idioma get(int id) {
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
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
