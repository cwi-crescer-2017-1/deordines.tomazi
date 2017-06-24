modulo.factory('relatorioService', function($http) {
    
    let porta = 59655;
    let url = `http://localhost:${porta}/api/relatorios`;

    function listarRelatorioAtraso() {
        return $http.get(`${url}/atraso`);
    }

    function listarRelatorioMensal(data) {
        return $http.get(`${url}/mensal/${data}`)
    }

    return ({
        listarRelatorioMensal: listarRelatorioMensal,
        listarRelatorioAtraso: listarRelatorioAtraso
    })
})