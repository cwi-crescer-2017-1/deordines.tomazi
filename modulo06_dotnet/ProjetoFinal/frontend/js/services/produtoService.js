modulo.factory('produtoService', function($http) {
    
    let porta = 59655;
    let url = `http://localhost:${porta}/api/produtosConsole`;

    function listar() {
        return $http.get(`${url}`);
    }

    function buscarPorId(id) {
        return $http({
            url: `${url}/${id}`,
            method: 'GET',
            data: id
        });
    }

    function criar(produto) {
        return $http({
            url: `${url}/registrar`,
            method: 'POST',
            data: produto
        });
    }

    function alugar(id) {
        return $http({
            url: `${url}/alugar/${id}`,
            method: 'PUT',
            data: id
        });
    }

    function devolver(id) {
        return $http({
            url: `${url}/devolver/${id}`,
            method: 'PUT',
            data: id
        });
    }

    return ({
        listar: listar,
        criar: criar,
        alugar: alugar,
        devolver: devolver,
        buscarPorId: buscarPorId
    })
})