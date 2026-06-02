class Frase {
    constructor(json) {
        this.id = json ? (json.id || 0) : 0;
        this.texto = json ? json.texto : "";
    }
}