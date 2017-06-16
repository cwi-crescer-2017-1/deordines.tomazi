modulo.factory('clienteService', function($http) {
    
    let porta = 59655;
    let url = `http://localhost:${porta}/api/clientes`;

    function listar() {
        return $http.get(`${url}`);
    }

    function buscarPorCpf(cpf) {
        return $http.get(`${url}/buscarcpf/${cpf}`);
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
        criar: criar,
        buscarPorCpf
    })
})