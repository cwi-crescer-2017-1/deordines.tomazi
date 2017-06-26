modulo.factory('locacaoService', function($http) {
    
    let porta = 59655;
    let url = `http://localhost:${porta}/api/locacao`;

    function listar() {
        return $http.get(`${url}`);
    }

    function listarDevolucao(cpf) {
        return $http.get(`${url}/${cpf}`);
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
        listarDevolucao: listarDevolucao,
        criar: criar,
        devolver: devolver
    })
})