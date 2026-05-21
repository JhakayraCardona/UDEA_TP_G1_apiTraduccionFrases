package traductorfrases.api.infraestructura.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import traductorfrases.api.dominio.entidades.Traduccion;
import traductorfrases.api.dominio.entidades.TraduccionId;

@Repository
public interface ITraduccionRepositorio extends JpaRepository<Traduccion, TraduccionId> {


    public Optional<Traduccion> findByFraseTextoAndIdiomaId(String texto, int idIdioma);
}
