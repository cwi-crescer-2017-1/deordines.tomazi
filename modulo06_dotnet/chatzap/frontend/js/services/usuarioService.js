modulo.factory("usuarioService", function ($http) {

    let url = "http://localhost:56235/api/usuarios";

    function obterUsuarios() {
        return $http.get(url);
    }

    function registrar(usuario) {
        return $http.post(url, usuario)
    }

    return ({
        obterUsuarios: obterUsuarios,
        registrar: registrar
    });
});