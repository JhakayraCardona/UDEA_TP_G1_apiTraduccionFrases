package traductorfrases.api.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import traductorfrases.api.dominio.entidades.Frase;

@Repository
public interface IFraseRepositorio extends JpaRepository<Frase, Integer>{

}
