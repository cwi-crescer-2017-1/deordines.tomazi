modulo.factory('postagemService', function($http) {
    
    let porta = 9090;
    let url = `http://localhost:${porta}/api/postagem`;

    function criar(postagem) {
        return $http({
            url: `${url}`,
            method: 'POST',
            data: postagem
        });
    }

    function obterPostagens() {
        return $http.get(`${url}`);
    }
    
    return ({
        criar: criar,
        obterPostagens: obterPostagens
    })
})