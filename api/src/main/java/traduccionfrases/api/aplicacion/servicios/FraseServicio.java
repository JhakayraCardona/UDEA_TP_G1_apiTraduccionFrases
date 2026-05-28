package traduccionfrases.api.aplicacion.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import traduccionfrases.api.dominio.entidades.Frase;
import traduccionfrases.api.infraestructura.repositorios.IFraseRepositorio;

@Service
public class FraseServicio {

    @Autowired
    private IFraseRepositorio repositorio;

    public List<Frase> listar() {
        return repositorio.findAll();
    }

    public Frase get(int id) {
        return repositorio.findById(id).get();
    }

    public Frase agregar(Frase frase) {
        frase.setId(0);
        return repositorio.save(frase);
    }

    public Frase modificar(Frase frase) {
        return repositorio.findById(frase.getId()).isPresent() ? repositorio.save(frase) : null;
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
