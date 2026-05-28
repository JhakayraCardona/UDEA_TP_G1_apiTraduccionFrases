package traduccionfrases.api.dominio.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "idioma")
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "idioma_id_seq")
    @SequenceGenerator(name = "idioma_id_seq", sequenceName = "idioma_id_seq", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Column(name = "idioma", length = 100, nullable = false, unique = true)
    private String nombre;

    public Idioma() {
    }

    public Idioma(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

}
