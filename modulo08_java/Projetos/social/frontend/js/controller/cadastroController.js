modulo.controller('cadastroController', function ($scope, usuarioService, toastr) {

    $scope.cadastrar = cadastrar;

    function cadastrar(usuario) {
        console.log(usuario);
        usuarioService
            .criar(usuario)
            .then(response => {
                console.log(response)
                $scope.cadastrar = undefined;
            });
    }
});