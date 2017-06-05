modulo.controller('DetalhamentoController', function ($scope, $routeParams, livroService) {

    let isbn = $routeParams.isbn;
    console.log(isbn);

    function obterDetalhes(isbn) {
        livroService
            .detalharLivro(isbn)
            .then(response => {
                console.log(response);
                $scope.livro = response.data.dados;
            })
    }
    obterDetalhes(isbn);
})