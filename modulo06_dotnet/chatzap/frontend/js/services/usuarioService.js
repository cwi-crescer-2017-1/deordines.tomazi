modulo.factory("usuarioService", function ($http) {
    return ({
        obterUsuarios: obterUsuarios,
        enviarUsuario: enviarUsuario
    });

    function obterUsuarios() {
        return $http.get("http://localhost:56235/api/usuarios");
    }

    function enviarUsuario() {
        return $http({
            method: "post",
            url: "http://localhost:56235/api/usuarios",
            data: {
                "Nome": "Deórdines"
            }
        });
    }
});