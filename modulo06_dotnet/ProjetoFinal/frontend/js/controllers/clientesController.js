modulo.controller('clientesController', function($scope, clienteService, authService) {

    $scope.auth = authService;
    $scope.clientes = [];

    $scope.criar = criar;
    $scope.listar = listar;    
    
    $scope.clientes = listar();
    
    function criar(cliente) {
        cliente.dataNascimento = new Date(cliente.dataNascimento).toLocaleString();
        debugger;
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