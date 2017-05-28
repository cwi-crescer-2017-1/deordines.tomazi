modulo.factory("mensagemService", function ($http) {

    let url = "http://localhost:56235/api/mensagens";

    function obterMensagens() {
        return $http.get(url);
    }

    function enviar(mensagem) {
        return $http.post(url, mensagem);
    }

    return ({
        obterMensagens: obterMensagens,
        enviar: enviar
    });
}); 