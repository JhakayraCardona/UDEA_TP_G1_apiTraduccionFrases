app.controller("IdiomaControlador", function ($scope, IdiomaServicio) {
    $scope.idiomas = [];
    $scope.frmIdioma = {};

    $scope.inicializar = () => {
        IdiomaServicio.listar().then(idiomasJSON => {
            $scope.idiomas = idiomasJSON.map(idiomaJSON => new Idioma(idiomaJSON));
        });
    }

    $scope.editar = (idioma) => {
        $scope.frmIdioma = angular.copy(idioma);
    }

    $scope.eliminar = (id) => {
        if (confirm("¿Está seguro de eliminar este idioma?")) {
            IdiomaServicio.eliminar(id).then(() => $scope.inicializar());
        }
    }

    $scope.guardar = () => {
        var idiomaGuardar = new Idioma($scope.frmIdioma);

        if ($scope.frmIdioma.id) {
            IdiomaServicio.modificar(idiomaGuardar).then(() => $scope.inicializar());
        }
        else {
            IdiomaServicio.agregar(idiomaGuardar).then(() => $scope.inicializar());
        }
        $scope.frmIdioma = {};
    }

    $scope.limpiarFrmIdioma = () => {
        $scope.frmIdioma = {};
    }

    $scope.inicializar();
});
