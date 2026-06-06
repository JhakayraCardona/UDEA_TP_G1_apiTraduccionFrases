app.controller("FraseControlador", function ($scope, FraseServicio, TraduccionServicio, IdiomaServicio) {
    $scope.frases = [];
    $scope.fraseSeleccionada = null;
    $scope.frmFrase = {};
    $scope.frmTraduccion = {};
    $scope.traduccionesFiltradas = [];
    $scope.idiomas = [];

    $scope.inicializar = () => {
        FraseServicio.listar().then(frasesJSON => {
            $scope.frases = frasesJSON.map(fraseJSON => new Frase(fraseJSON));
        });
        IdiomaServicio.listar().then(idiomasJSON => {
            $scope.idiomas = idiomasJSON.map(idiomaJSON => new Idioma(idiomaJSON));
        });
    }

    $scope.seleccionarFrase = (frase) => {
        $scope.fraseSeleccionada = frase;
        $scope.cargarTraduccionesFrase(frase.id);
        $scope.frmTraduccion = { idFrase: frase.id, idIdioma: 0, textoTraduccion: "" };
    }

    $scope.editarFrase = (frase) => {
        $scope.frmFrase = angular.copy(frase);
    }

    $scope.eliminarFrase = (id) => {
        if (confirm("¿Deseas eliminar esta frase? Se perderán sus traducciones.")) {
            FraseServicio.eliminar(id).then((respuesta) => {
                if (respuesta) {
                    $scope.inicializar();
                    $scope.fraseSeleccionada = null;
                }
                else {
                    alert("No se pudo eliminar la frase");
                }
            });
        }
    }

    $scope.guardarFrase = () => {
        var fraseGuardar = new Frase($scope.frmFrase);

        if ($scope.frmFrase.id) {
            FraseServicio.modificar(fraseGuardar).then(() => {
                $scope.inicializar();
            });
        }
        else {
            FraseServicio.agregar(fraseGuardar).then(() => {
                $scope.inicializar();
            });
        }
        $scope.frmFrase = {};
    }

    $scope.limpiarFrase = () => {
        $scope.frmFrase = {};
    }



    /********** Traducciones  **********/

    $scope.cargarTraduccionesFrase = (idFrase) => {
        TraduccionServicio.listarPorFrase(idFrase).then(data => {
            $scope.traduccionesFiltradas = data.map(t => new Traduccion(t));
        });
    }

    $scope.editarTraduccion = (traduccion) => {
        $scope.frmTraduccion = {
            idFrase: traduccion.frase.id,
            idIdioma: traduccion.idioma.id,
            textoTraduccion: traduccion.texto
        }
    }

    $scope.eliminarTraduccion = (idIdioma, idFrase) => {
        TraduccionServicio.eliminar(idIdioma, idFrase).then(() => {
            $scope.cargarTraduccionesDeFrase($scope.fraseSeleccionada.id);
        });
    }

    $scope.guardarTraduccion = () => {
        TraduccionServicio.guardar($scope.frmTraduccion).then(() => {
            alert("guardando");
            $scope.cargarTraduccionesFrase($scope.fraseSeleccionada.id);
            $scope.frmTraduccion.idIdioma = 0;
            $scope.frmTraduccion.textoTraduccion = "";
        });
    }

    $scope.inicializar();
});