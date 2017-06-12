modulo.controller('locacaoController', function($scope, $localStorage, locacaoService, clienteService, produtoService, pacoteService, extraService) {

    $scope.locacoes = listar();
    $scope.clientes = listarClientes();
    $scope.produtos = listarProdutos();
    $scope.pacotes = listarPacotes();
    $scope.extras = listarExtras();
    $scope.criar = criar;
    $scope.devolver = devolver;
    
    function listarClientes() {
        clienteService
            .listar()
            .then(response => {
                console.log(response.data.dados);
                $scope.clientes = response.data.dados;
            })
    }

    function listarProdutos() {
        produtoService
            .listar()
            .then(response => {
                console.log(response.data.dados);
                $scope.produtos = response.data.dados;
            })
    }

    function listarPacotes() {
        pacoteService
            .listar()
            .then(response => {
                console.log(response.data.dados);
                $scope.pacotes = response.data.dados;
            })
    }

    function listarExtras() {
        extraService
            .listar()
            .then(response => {
                console.log(response.data.dados);
                $scope.extras = response.data.dados;
            })
    }

    function criar(locacao) {
        console.log(locacao.cliente.Id);
        console.log(locacao.produtoConsole.Id);
        console.log(locacao.pacote.Id);
        locacao = { IdCliente: locacao.cliente.Id, IdProdutoConsole: locacao.produtoConsole.Id, IdPacote: locacao.pacote.Id };
        console.log(locacao);
        locacaoService
            .criar(locacao)
            .then(response => {
                console.log(response.data.dados);
            })
    }

    function devolver(locacao) {
        console.log(locacao);
        console.log(locacao.pedido.Id);
        locacaoService
            .devolver(locacao.pedido)
            .then(response => {
                listar();
                console.log(response.data.dados);
            })
    }

    function listar() {
        locacaoService
            .listar()
            .then(response => {
                $scope.locacoes = response.data.dados;
            })
    }
})