modulo.factory("livroService", function($http) {

    let porta = 65018;
    let url = `http://localhost:${porta}/api/livros`;

    function listarLancamentos() {
        return $http.get(`${url}/lancamentos`);
    }

    function listarLivros() {
        return $http.get(`${url}`);
    }

    function buscarLivrosPaginados(parametros) {
        return $http({
            url: url,
            method: 'GET',
            params: parametros
        })
    }

    function buscarLancamentosPaginados(parametros) {
        return $http({
            url: `${url}/lancamentos/`,
            method: 'GET',
            params: parametros
        })
    }

    function detalharLivro(isbn) {
        return $http.get(`${url}/${isbn}`);
    }

    return ({
        listarLancamentos: listarLancamentos,
        listarLivros: listarLivros,
        buscarLivrosPaginados: buscarLivrosPaginados,
        buscarLancamentosPaginados: buscarLancamentosPaginados,
        detalharLivro: detalharLivro
    });
});