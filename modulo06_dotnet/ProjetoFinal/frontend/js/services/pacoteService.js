modulo.factory('pacoteService', function($http) {
    
    let porta = 59655;
    let url = `http://localhost:${porta}/api/pacotes`;

    function listar() {
        return $http.get(`${url}`);
    }

    function criar(cliente) {
        return $http({
            url: `${url}/registrar`,
            method: 'POST',
            data: cliente
        });
    }

    return ({
        listar: listar,
        criar: criar
    })
})