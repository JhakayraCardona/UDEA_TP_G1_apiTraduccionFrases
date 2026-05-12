package traductorfrases.api.dominio.entidades;

public class TraduccionId {

    private int idioma;
    private int frase;

    public TraduccionId() {
    }

    public TraduccionId(int idioma, int frase) {
        this.idioma = idioma;
        this.frase = frase;
    }

    public int getIdioma() {
        return idioma;
    }

    public void setIdioma(int idioma) {
        this.idioma = idioma;
    }

    public int getFrase() {
        return frase;
    }

    public void setFrase(int frase) {
        this.frase = frase;
    }

}
