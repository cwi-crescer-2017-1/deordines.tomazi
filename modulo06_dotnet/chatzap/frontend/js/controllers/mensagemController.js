modulo.controller("MensagemController", function ($scope, mensagemService) {
    $scope.enviar = enviar;
    obterMensagens();

    function obterMensagens() {
        mensagemService
            .obterMensagens()
            .then(response => {
                $scope.mensagens = response.data;
            })
    }

    function enviar(mensagem) {
        mensagemService.enviar({
            "Usuario": {
                "Nome": localStorage.getItem("Nome"),
                "UrlFoto": localStorage.getItem("UrlFoto")
            },
            "Texto": mensagem.texto
        });
        $scope.novaMensagem = {};
    }
}); 