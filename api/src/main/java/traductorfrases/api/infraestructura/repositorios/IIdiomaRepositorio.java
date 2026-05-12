package traductorfrases.api.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import traductorfrases.api.dominio.entidades.Idioma;


@Repository
public interface IIdiomaRepositorio extends JpaRepository<Idioma, Integer>{

}
