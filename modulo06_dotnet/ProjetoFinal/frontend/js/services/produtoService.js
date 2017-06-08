modulo.factory('produtoService', function($http) {
    
    let porta = 59655;
    let url = `http://localhost:${porta}/api/produtosConsole`;

    function listar() {
        return $http.get(`${url}`);
    }

    function criar(produto) {
        return $http({
            url: `${url}/registrar`,
            method: 'POST',
            data: produto
        });
    }

    return ({
        listar: listar,
        criar: criar
    })
})