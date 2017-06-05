modulo.controller('LivrosController', function ($scope, livroService) {
    $scope.lancamentos = [];
    $scope.livrosFiltrados = [];
    $scope.detalhes = [];
    $scope.currentPage = 1;
    $scope.numPerPage = 12;
    $scope.maxSize = 5;

    $scope.lancamentos = listarLancamentos();

    function listarLancamentos() {
        livroService
            .listarLancamentos()
            .then(response => {
                console.log(response.data.dados);
                $scope.lancamentos = response.data.dados;
            })
    }

    // https://stackoverflow.com/questions/10816073/how-to-do-paging-in-angularjs
    $scope.listarLivros = function() {
        $scope.livros = [];
        livroService
            .listarLivros()
            .then(response => {
                console.log(response);
                $scope.livros = response.data.dados;
                $scope.quantidadeTotal = $scope.livros.length;
            })
    }
    $scope.listarLivros();
  
    $scope.$watch('currentPage + numPerPage', function() {
        var begin = (($scope.currentPage - 1) * $scope.numPerPage), end = begin + $scope.numPerPage;
        $scope.livrosFiltrados = $scope.livros.slice(begin, end);
    });
});