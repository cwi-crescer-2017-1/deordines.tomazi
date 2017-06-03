modulo.controller('LivrosController', function ($scope, $http, livroService) {
    $scope.myInterval = 3000;
    $scope.livros = [];
    listarLivros();

    $scope.parametros = {
        quantidadeTrazer: 5,
        quantidadePular: 0
    };

    $scope.buscar = function(parametros) {
        $http({
            url: 'http://localhost:65018/api/livros',
            method: 'GET',
            params: parametros
        })
        .then(response => {
            $scope.livros = response.data.dados
        })
    }

    function listarLivros() {
        livroService
            .listarLivros()
            .then(response => {
                $scope.livros = response.data.dados;
            })
    }
});