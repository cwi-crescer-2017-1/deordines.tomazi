var modulo = angular.module('chatZap-app', []);

modulo.controller('UsuarioController', function ($scope, usuarioService) {
    $scope.usuarios = {};
    $scope.registrar = registrar;
    obterUsuarios();    

    function obterUsuarios() {
        usuarioService
            .obterUsuarios()
            .then(response => {
                $scope.usuarios = response.data;
            })
    }

    function registrar(usuario) {
        localStorage.setItem('Nome', usuario.nome);
        localStorage.setItem('UrlFoto', usuario.urlFoto);
        usuarioService.registrar(usuario);
    }
}); 