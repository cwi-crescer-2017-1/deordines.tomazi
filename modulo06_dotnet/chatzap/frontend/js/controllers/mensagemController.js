modulo.controller("MensagemController", function ($scope, mensagemService, $timeout) {

    $scope.enviar = enviar;

    $scope.intervalFuction = function() {
        $timeout(function() {
            obterMensagens();
            $scope.intervalFuction();
        }, 1000)
    };

    $scope.intervalFuction();

    function obterMensagens() {
        mensagemService
            .obterMensagens()
            .then(response => {
                $scope.mensagens = response.data;
            })
    }

    $scope.usuario = { Nome: localStorage.getItem('Nome'), UrlFoto: localStorage.getItem('UrlFoto') };

    function enviar(mensagem) {
        mensagem.Usuario = $scope.usuario;
        mensagem.Texto = mensagem.texto;
        mensagemService.enviar(mensagem);
        $scope.novaMensagem = {};
    }
}); 