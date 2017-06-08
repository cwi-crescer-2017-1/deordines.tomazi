modulo.controller('produtosController', function($scope, produtoService) {

    $scope.produtos = {};

    $scope.criar = criar;
    $scope.listar = listar;    
    
    $scope.produtos = listar();
    
    function criar(novoProduto) {
        produtoService
            .criar(novoProduto)
            .then(response => {
                console.log(response.data.dados);
            })
    }

    function listar() {
        produtoService
            .listar()
            .then(response => {
                console.log(response.data.dados);
                $scope.produtos = response.data.dados;
            })
    }
})