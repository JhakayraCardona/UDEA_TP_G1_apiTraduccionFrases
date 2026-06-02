app.controller("TraduccionFrasesControlador", function($scope) {

    $scope.vistaActual = "";
    $scope.cambiarVista = (vista) => {
        $scope.vistaActual = vista;
    }
});