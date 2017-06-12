modulo.factory('locacaoService', function($http) {
    
    let porta = 59655;
    let url = `http://localhost:${porta}/api/locacao`;

    function listar() {
        return $http.get(`${url}`);
    }

    function criar(locacao) {
        return $http({
            url: `${url}`,
            method: 'POST',
            data: locacao
        });
    }

    function devolver(locacao) {
        console.log(locacao);
        return $http({
            url: `${url}/devolver`,
            method: 'PUT',
            data: locacao
        })
    }

    return ({
        listar: listar,
        criar: criar,
        devolver: devolver
    })
})