app.controller("FraseControlador", function($scope, FraseServicio) {
    $scope.frases = [];

    $scope.inicializar = () => {
        FraseServicio.listar().then(frasesJSON => {
            console.log("respuesta recibida: "+frasesJSON)
            $scope.frases = frasesJSON.map( fraseJSON => new Frase(fraseJSON));
        } );
    }

    $scope.inicializar();
});