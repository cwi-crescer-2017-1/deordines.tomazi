var modulo = angular.module('chatZap-app', []);

modulo.controller('UsuarioController', function ($scope, usuarioService) {
    $scope.usuarios = {};
    $scope.enviarUsuario = enviarUsuario;
    obterUsuarios();    

    function obterUsuarios() {
        usuariosService
        .obterUsuarios()
        .then(response => {
            $scope.usuarios = response.data;
        })
    }

    function enviarUsuario() {
        usuariosService
        .enviarUsuario()
        .then(usuarios => {
            obterUsuarios();
        })
    }
});