modulo.factory('extraService', function($http) {
    
    let porta = 59655;
    let url = `http://localhost:${porta}/api/extras`;

    function listar() {
        return $http.get(`${url}`);
    }

    function criar(extra) {
        return $http({
            url: `${url}/registrar`,
            method: 'POST',
            data: extra
        });
    }

    function alugar(id, quantidade) {
        debugger;
        return $http({
            url: `${url}/alugar/${id}`,
            method: 'PUT',
            data: quantidade
        });
    }

    return ({
        listar: listar,
        criar: criar,
        alugar: alugar
    })
})