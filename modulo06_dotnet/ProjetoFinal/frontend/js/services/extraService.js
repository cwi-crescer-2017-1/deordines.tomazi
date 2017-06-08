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

    function alugar(extra) {
        debugger;
        return $http({
            url: `${url}/alugar`,
            method: 'PUT',
            data: extra
        });
    }

    function devolver(extra) {
        return $http({
            url: `${url}/devolver`,
            method: 'PUT',
            data: extra
        });
    }

    return ({
        listar: listar,
        criar: criar,
        alugar: alugar,
        devolver: devolver
    })
})