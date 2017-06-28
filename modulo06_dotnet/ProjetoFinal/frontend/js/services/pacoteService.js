modulo.factory('pacoteService', function($http) {
    
    let porta = 59655;
    let url = `http://localhost:${porta}/api/pacotes`;

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

    function criar(pacote) {
        return $http({
            url: `${url}/registrar`,
            method: 'POST',
            data: pacote
        });
    }

    return ({
        listar: listar,
        criar: criar,
        buscarPorId: buscarPorId
    })
})