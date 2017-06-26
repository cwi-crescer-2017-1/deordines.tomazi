modulo.controller('locacaoController', function($scope, $localStorage, $route, locacaoService, clienteService, produtoService, pacoteService, extraService, toastr) {

    $scope.locacoes = listar();
    $scope.clientes = listarClientes();
    $scope.produtos = listarProdutos();
    $scope.pacotes = listarPacotes();
    $scope.extras = listarExtras();
    $scope.criar = criar;
    $scope.devolver = devolver;
    $scope.buscarPorCpf = buscarPorCpf;
    $scope.limpar = limpar;

    $scope.listarDevolucao = listarDevolucao;    
    
    function listarClientes() {
        clienteService
            .listar()
            .then(response => {
                console.log(response.data.dados);
                $scope.clientes = response.data.dados;
            })
    }

    function buscarPorCpf(cpf) {
        if (angular.isUndefined(cpf) || cpf == null) {
            toastr.warning('Algo inesperado aconteceu.');
            return;
        }

        clienteService
            .buscarPorCpf(cpf)
            .then(response => {
                toastr.success('Ação realizada com sucesso.');
                console.log(response.data.dados);
                $scope.cpfCliente = undefined;
                $scope.cliente = response.data.dados;
            })
    }

    function limpar() {
        toastr.success('Ação realizada com sucesso.');
        $scope.cliente = {};
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
        if (angular.isUndefined(locacao) || locacao === null) {
            toastr.error('Ação inválida.');
            return;
        }

        // console.log(locacao.cliente.Id);
        console.log($scope.cliente.Id);        
        console.log(locacao.produtoConsole.Id);
        console.log(locacao.pacote.Id);
        // locacao = { IdCliente: locacao.cliente.Id, IdProdutoConsole: locacao.produtoConsole.Id, IdPacote: locacao.pacote.Id };
        locacao = { IdCliente: $scope.cliente.Id, IdProdutoConsole: locacao.produtoConsole.Id, IdPacote: locacao.pacote.Id };        
        console.log(locacao);
        locacaoService
            .criar(locacao)
            .then(response => {
                toastr.success('Ação realizada com sucesso.');
                console.log(response.data.dados);
                // $window.location.reload();
                $route.reload();
            })
    }

    function listarDevolucao(cpf) {
        locacaoService
            .listarDevolucao(cpf)
            .then(response => {
                toastr.success('Ação realizada com sucesso.');
                console.log(response.data.dados);
                $scope.devolucoes = response.data.dados;
            })
    }

    function devolver(locacao) {
        console.log(locacao);
        // console.log(locacao.pedido.Id);
        locacaoService
            .devolver(locacao)
            .then(response => {
                listarDevolucao(locacao.Cliente.Id);
                toastr.success('Ação realizada com sucesso.');
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