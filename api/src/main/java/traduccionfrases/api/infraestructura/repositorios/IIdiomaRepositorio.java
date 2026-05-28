package traduccionfrases.api.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import traduccionfrases.api.dominio.entidades.Idioma;

@Repository
public interface IIdiomaRepositorio extends JpaRepository<Idioma, Integer> {

    
}
