modulo.controller('homeController', function ($scope, authService, usuarioService, toastr) {

    let usuarioDaSessao = authService.getUsuario();

    buscarPorEmail();
    buscarAmigos();
    buscarAmigosPendentes();

    function buscarPorEmail() {
        usuarioService
            .buscarPorEmail()
            .then(response => {
                console.log(response.data);
                $scope.usuario = response.data;
            });
    }

    function buscarAmigos() {
        debugger;
        usuarioService
            .obterAmigos()
            .then(response => {
                console.log(response.data);
                $scope.amigos = response.data;
            });
    }

    function buscarAmigosPendentes() {
        usuarioService
            .obterAmigosPendentes()
            .then(response => {
                console.log(response.data);
                $scope.amigosPendentes = response.data;
            });
    }
});