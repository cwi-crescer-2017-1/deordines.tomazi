modulo.factory("livroService", function($http) {

    let porta = 65018;
    let url = `http://localhost:${porta}/api/`;

    function listarLivros() {
        return $http.get(`${url}/livros`);
    }

    return ({
        listarLivros: listarLivros
    });
});