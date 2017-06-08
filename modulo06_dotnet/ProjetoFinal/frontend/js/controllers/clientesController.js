modulo.controller('clientesController', function($scope, clienteService) {

    $scope.clientes = [];

    $scope.criar = criar;
    $scope.listar = listar;    
    
    $scope.clientes = listar();
    
    function criar(cliente) {
        clienteService
            .criar(cliente)
            .then(response => {
                console.log(response.data.dados);
            })
    }

    function listar() {
        clienteService
            .listar()
            .then(response => {
                console.log(response.data.dados);
                $scope.clientes = response.data.dados;
            })
    }
})