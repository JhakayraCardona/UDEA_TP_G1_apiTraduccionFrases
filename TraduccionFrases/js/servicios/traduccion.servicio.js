app.service('TraduccionServicio', function ($http) {
    const URL = 'http://localhost:8080/api/traducciones/';

    this.listarPorFrase = (idFrase) => {
        return $http.get(`${URL}frase/${idFrase}`).then(respuesta => respuesta.data);
    };

    this.guardar = (traduccionDTO) => {
        return $http.post(`${URL}guardar`, traduccionDTO).then(respuesta => respuesta.data);
    };

    this.eliminar = (idIdioma, idFrase) => {
        return $http.delete(`${URL}eliminar/${idIdioma}/${idFrase}`).then(respuesta => respuesta.data);
    };

});