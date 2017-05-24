appRoute.factory('aulaService', function($http) {

    let url = 'http://localhost:3000/aula/';

    function criar(aula) {
        return $http.post(`${url}`, aula);
    }

    function editar(aula) {
        return $http.put(`${url}${aula.id}`, aula);
    }

    function excluir(aula) {
        return $http.delete(`${url}${aula.id}`);
    }

    function listar() {
        return $http.get(url);
    }

    // function buscarAulaPorId(id) {
    //     return $http.get(`${url}${id}`);
    // }

    return {
        criar: criar,
        editar: editar,
        excluir: excluir,
        listar: listar
        // buscarAulaPorId: buscarAulaPorId
    }
});

appRoute.factory('instrutorService', function($http) {

    let url = 'http://localhost:3000/instrutor/';

    function criar(instrutor) {
        return $http.post(url, instrutor);
    }

    function editar(instrutor) {
        return $http.put(`${url}${instrutor.id}`, instrutor);
    }

    function excluir(instrutor) {
        return $http.delete(`${url}${instrutor.id}`);
    }

    function listar() {
        return $http.get(url);
    }

    // function buscarInstrutorPorId(id) {
    //     return $http.get(`${url}${id}`);
    // }

    return {
        criar: criar,
        editar: editar,
        excluir: excluir,
        listar: listar
    }
});