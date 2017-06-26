modulo.controller('clientesController', function($scope, clienteService, authService, toastr) {

    $scope.auth = authService;
    $scope.clientes = [];

    $scope.criar = criar;
    $scope.listar = listar;    
    
    $scope.clientes = listar();
    
    function criar(cliente) {
        if (angular.isUndefined(cliente.Nome) || cliente.Nome == null ||
            angular.isUndefined(cliente.Cpf) || cliente.Cpf == null ||
            angular.isUndefined(cliente.Endereco) || cliente.Endereco == null) {
            $scope.cliente = undefined;
            toastr.error('Ação inválida.');
            return;
        }
        cliente.dataNascimento = new Date(cliente.dataNascimento).toLocaleString();
        clienteService
            .criar(cliente)
            .then(response => {
                toastr.success('Ação realizada com sucesso.');
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