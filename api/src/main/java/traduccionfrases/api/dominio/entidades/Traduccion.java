package traduccionfrases.api.dominio.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@IdClass(TraduccionId.class)
@Table(name = "traduccion")
public class Traduccion {

    @Id
    @ManyToOne
    @JoinColumn(name = "ididioma", referencedColumnName = "id")
    private Idioma idioma;

    @Id
    @ManyToOne
    @JoinColumn(name = "idfrase", referencedColumnName = "id")
    private Frase frase;

    @Column(name = "texto", length = 255, nullable = false)
    private String texto;

    public Traduccion() {
    }

    public Traduccion(Idioma idioma, Frase frase, String texto) {
        this.idioma = idioma;
        this.frase = frase;
        this.texto = texto;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Frase getFrase() {
        return frase;
    }

    public void setFrase(Frase frase) {
        this.frase = frase;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    

}
