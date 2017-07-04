modulo.factory('usuarioService', function($http) {
    
    let porta = 9090;
    let url = `http://localhost:${porta}/api/usuario`;

    function buscarPorEmail() {
        return $http.get(`${url}/buscarPorEmail`);
    }

    function buscarPorId(id) {
        return $http.get(`${url}/${id}`);
    }

    function buscarAmigosPerfilVisitado(id) {
        return $http.get(`${url}/amigosPerfilVisitado/${id}`);
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

    function adicionar(usuario) {
        return $http({
            url: `${url}/adicionar`,
            method: 'POST',
            data: usuario
        })
    }

    function aceitar(usuario) {
        return $http({
            url: `${url}/aceitar`,
            method: 'POST',
            data: usuario
        });
    }

    function recusar(usuario) {
        return $http({
            url: `${url}/recusar`,
            method: 'POST',
            data: usuario
        });
    }

    return ({
        buscarPorEmail: buscarPorEmail,
        buscarPorId: buscarPorId,
        buscarAmigosPerfilVisitado: buscarAmigosPerfilVisitado,
        criar: criar,
        obterAmigos: obterAmigos,
        obterAmigosPendentes: obterAmigosPendentes,
        adicionar: adicionar,
        aceitar: aceitar,
        recusar: recusar
    })
})