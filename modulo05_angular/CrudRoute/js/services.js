appRoute.factory('aulaService', function($http) {

    let urlBase = `http://localhost:3000/aula/`;

    function getTodasAsAulas() {
        return $http.get(urlBase);
    }

    function getAulaPorId(id) {
        return $http.get(`${urlBase}/${id}`);
    }

    function criar(aula) {
        aula.id = ++idAulaAux;
        aula.push(angular.copy(aula));
    }

    function atualizar(aula) {
        return $http.put(`${urlBase}/${aula.id}`, aula);
    }

    return {
        list: getTodasAsAulas,
        findById: getAulaPorId,
        update: atualizar,
        create: criar
    }

});

appRoute.factory('instrutorService', function($http) {

    let urlBase = `http://localhost:3000/instrutor/`;

    function getTodosOsIntrutores() {
        return $http.get(urlBase);
    }

    function getInstrutorPorId(id) {
        return $http.get(`${urlBase}/${id}`);
    }

    function criar(instrutor) {
        instrutor.id = ++idInstrutorAux;
        instrutor.push(angular.copy(instrutor));
    }

    function atualizar(instrutor) {
        return $http.put(`${urlBase}/${instrutor.id}`, instrutor);
    }

    return {
        list: getTodosOsIntrutores,
        findById: getInstrutorPorId,
        update: atualizar,
        create: criar
    }
});