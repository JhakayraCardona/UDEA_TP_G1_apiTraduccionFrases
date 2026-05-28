package traduccionfrases.api.dominio.dtos;


public class TraduccionDTO {
    
    private int idIdioma;
    private int idFrase;
    private String textoTraduccion;

    // Constructor vacío obligatorio para que Jackson pueda serializar el JSON
    public TraduccionDTO() {
    }

    public TraduccionDTO(int idIdioma, int idFrase, String textoTraduccion) {
        this.idIdioma = idIdioma;
        this.idFrase = idFrase;
        this.textoTraduccion = textoTraduccion;
    }

    // Getters y Setters
    public int getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(int idIdioma) {
        this.idIdioma = idIdioma;
    }

    public int getIdFrase() {
        return idFrase;
    }

    public void setIdFrase(int idFrase) {
        this.idFrase = idFrase;
    }

    public String getTextoTraduccion() {
        return textoTraduccion;
    }

    public void setTextoTraduccion(String textoTraduccion) {
        this.textoTraduccion = textoTraduccion;
    }
}