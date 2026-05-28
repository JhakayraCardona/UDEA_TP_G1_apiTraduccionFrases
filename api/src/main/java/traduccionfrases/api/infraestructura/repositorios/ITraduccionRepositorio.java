package traduccionfrases.api.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import traduccionfrases.api.dominio.entidades.Traduccion;
import traduccionfrases.api.dominio.entidades.TraduccionId;

@Repository
public interface ITraduccionRepositorio extends JpaRepository<Traduccion, TraduccionId> {

    Optional<Traduccion> findByFraseTextoAndIdiomaId(
            String textoFrase,
            int idIdioma);

    // Consulta personalizada para limpiar los datos antes de comparar
    @Query("SELECT t FROM Traduccion t WHERE " +
           "LOWER(REPLACE(REPLACE(REPLACE(t.frase.texto, '.', ''), '?', ''), '¿', '')) = :textoLimpio " +
           "AND t.idioma.id = :idIdioma")
    Optional<Traduccion> findByFraseTextoAndIdiomaIdNormalizado(
        @Param("textoLimpio") String textoLimpio, 
        @Param("idIdioma") int idIdioma
    );

    public List<Traduccion> findByIdiomaId(int idIdioma);

    public List<Traduccion> findByFraseId(int idFrase);
}
