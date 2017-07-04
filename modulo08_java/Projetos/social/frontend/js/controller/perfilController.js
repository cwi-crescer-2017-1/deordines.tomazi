modulo.controller('perfilController', function ($scope, $routeParams, authService, usuarioService, toastr) {

    let id = $routeParams.id;

    buscarPorId(id);
    $scope.amigos = buscarAmigos(id);
    $scope.usuarioLogado = usuarioLogado;
    $scope.adicionar = adicionar;

    function usuarioLogado(email) {
        if (email !== authService.getUsuario().username) {
            return true;
        }
    }

    function buscarPorId(id) {
        usuarioService
            .buscarPorId(id)
            .then(response => {
                console.log(response.data);
                $scope.usuario = response.data;
            });
    }

    function buscarAmigos(id) {
        usuarioService
            .buscarAmigosPerfilVisitado(id)
            .then(response => {
                console.log(response.data);
                $scope.amigos = response.data;
            });
    }

    function adicionar(usuario) {
        usuarioService
            .adicionar(usuario)
            .then(response => {
                console.log(response.data);
            })
    }
});