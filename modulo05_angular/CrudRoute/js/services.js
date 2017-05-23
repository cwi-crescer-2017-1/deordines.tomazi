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
    //     return $http.get(`${url}/${id}`);
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

    let url = `http://localhost:3000/instrutor/`;

    function getTodosOsIntrutores() {
        return $http.get(url);
    }

    function getInstrutorPorId(id) {
        return $http.get(`${url}/${id}`);
    }

    function criar(instrutor) {
        instrutor.id = ++idInstrutorAux;
        instrutor.push(angular.copy(instrutor));
    }

    function atualizar(instrutor) {
        return $http.put(`${url}/${instrutor.id}`, instrutor);
    }

    return {
        list: getTodosOsIntrutores,
        findById: getInstrutorPorId,
        update: atualizar,
        create: criar
    }
});