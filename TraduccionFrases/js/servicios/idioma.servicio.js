app.service("IdiomaServicio", function ($http) {
    const URL = "http://localhost:8080/api/idiomas/";

    this.listar = () => {
        return $http.get(URL).then(respuesta => respuesta.data);
    };

    this.obtener = (id) => {
        return $http.get(`${URL}${id}`).then(respuesta => respuesta.data);
    };

    this.agregar = (idioma) => {
        return $http.post(URL, idioma).then(respuesta => respuesta.data);
    };

    this.modificar = (idioma) => {
        return $http.put(URL, idioma).then(respuesta => respuesta.data);
    };

    this.eliminar = (id) => {
        return $http.delete(`${URL}${id}`).then(respuesta => respuesta.data);
    };
});