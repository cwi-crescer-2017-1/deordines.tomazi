modulo.controller('LivrosController', function ($scope, livroService) {
    $scope.livros = {};
    $scope.livros = listarLivros();

    function listarLivros() {
        livroService
            .listarLivros()
            .then(response => {
                $scope.livros = response.data;
            })
    }
});