class Traduccion {
    constructor(json) {
        this.idioma = json ? new Idioma(json.idioma) : null;
        this.frase = json ? new Frase(json.frase) : null;
        this.texto = json ? json.texto : "";
    }
}