modulo.factory("usuarioService", function ($http) {

    let url = "http://localhost:56235/api/usuarios";

    function obterUsuarios() {
        return $http.get(url);
    }

    function enviarUsuario(usuario) {
        return $http.post(url, usuario);
    }

    return ({
        obterUsuarios: obterUsuarios,
        enviarUsuario: enviarUsuario
    });
});