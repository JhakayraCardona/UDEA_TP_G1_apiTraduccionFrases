app.service("FraseServicio", function($http) {
    const URL = "http://localhost:8080/api/frases/";

    this.listar = () => {
        return $http.get(URL).then(respuesta => respuesta.data);
    }

    this.obtener = (id) => {
        return $http.get(`URL${id}`).then(respuesta => respuesta.data);
    }

    this.agregar = (frase) => {
        return $http.post(URL, frase).then(respuesta => respuesta.data);
    }

    this.modificar = (frase) => {
        return $http.put(URL, frase).then(respuesta => respuesta.data);
    }

    this.eliminar = (id) => {
        return $http.delete(`URL${id}`).then(respuesta => respuesta.data);
    }
});