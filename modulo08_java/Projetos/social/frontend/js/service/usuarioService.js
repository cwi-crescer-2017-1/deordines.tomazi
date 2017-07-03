modulo.factory('usuarioService', function($http) {
    
    let porta = 9090;
    let url = `http://localhost:${porta}/api/usuario`;

    // function buscarPorEmail(email) {
    //     return $http.get(`${url}/buscarPorEmail?email=${email}`);
    // }

    function buscarPorEmail() {
        return $http.get(`${url}/buscarPorEmail`);
    }

    function obterAmigos() {
        return $http.get(`${url}/amigos`);
    }

    function obterAmigosPendentes() {
        return $http.get(`${url}/amigosPendentes`);        
    }

    function criar(usuario) {
        return $http({
            url: `${url}`,
            method: 'POST',
            data: usuario
        });
    }

    return ({
        buscarPorEmail: buscarPorEmail,
        criar: criar,
        obterAmigos: obterAmigos,
        obterAmigosPendentes: obterAmigosPendentes
    })
})