modulo.factory('curtidaService', function($http) {
    
    let porta = 9090;
    let url = `http://localhost:${porta}/api/curtida`;

    function curtir(postagem) {
        debugger;
        return $http({
            url: `${url}/postagem`,
            method: 'POST',
            data: postagem
        });
    }

    return ({
        curtir: curtir
    })
})