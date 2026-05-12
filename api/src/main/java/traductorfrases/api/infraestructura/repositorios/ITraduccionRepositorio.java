package traductorfrases.api.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import traductorfrases.api.dominio.entidades.Traduccion;
import traductorfrases.api.dominio.entidades.TraduccionId;

@Repository
public interface ITraduccionRepositorio extends JpaRepository<Traduccion, TraduccionId> {

}
