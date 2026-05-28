package traduccionfrases.api.dominio.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "frase")
public class Frase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "frase_id_seq")
    @SequenceGenerator(name = "frase_id_seq", sequenceName = "frase_id_seq", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Column(name = "texto", length = 255, nullable = false, unique = true)
    private String texto;

    public Frase() {
    }

    public Frase(int id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    
}
