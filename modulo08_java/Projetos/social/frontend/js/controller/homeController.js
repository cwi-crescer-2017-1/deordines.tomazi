modulo.controller('homeController', function ($scope, authService, usuarioService, postagemService, curtidaService, toastr) {

    let usuarioDaSessao = authService.getUsuario();

    buscarPorEmail();
    buscarAmigos();
    buscarAmigosPendentes();
    $scope.aceitar = aceitar;
    $scope.recusar = recusar;
    $scope.criar = criar;
    $scope.postagens = buscarPostagens();
    $scope.curtir = curtir;

    function buscarPorEmail() {
        usuarioService
            .buscarPorEmail()
            .then(response => {
                console.log(response.data);
                $scope.usuario = response.data;
            });
    }

    function buscarAmigos() {
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

    function aceitar(usuario) {
        debugger;
        usuarioService
            .aceitar(usuario)
            .then(response => {
                console.log(response);
            });
    }

    function recusar(usuario) {
        usuarioService
            .recusar(usuario)
            .then(response => {
                console.log(response);
            });
    }

    function criar(postagem) {
        debugger;
        postagemService
            .criar(postagem)
            .then(response => {
                console.log(response);
            });
    }

    function buscarPostagens() {
        postagemService
            .obterPostagens()
            .then(response => {
                console.log(response);
                $scope.postagens = response.data;
            });
    }

    function curtir(postagem) {
        debugger;
        curtidaService
            .curtir(postagem)
            .then(response => {
                console.log(response);
            });
    }
});