var appRoute = angular.module('CrudRoute', ['ngRoute']);

appRoute.config(function ($routeProvider) {
    $routeProvider
        .when('/templates/aula-cadastrar', {
            controller: 'AulaController',
            templateUrl: '/templates/aula-cadastrar.html'
        })
        .when('/templates/aula-editar', {
            controller: 'AulaController',
            templateUrl: '/templates/aula-editar.html'
        })
        .when('/templates/aula-excluir', {
            controller: 'AulaController',
            templateUrl: '/templates/aula-excluir.html'
        })
        .when('/templates/aula-listar', {
            controller: 'AulaController',
            templateUrl: '/templates/aula-listar.html'
        })
        .when('/templates/instrutor-cadastrar', {
            controller: 'InstrutorController',
            templateUrl: '/templates/instrutor-cadastrar.html'
        })
        .when('/templates/instrutor-editar', {
            controller: 'InstrutorController',
            templateUrl: '/templates/instrutor-editar.html'
        })
        .when('/templates/instrutor-excluir', {
            controller: 'InstrutorController',
            templateUrl: '/templates/instrutor-excluir.html'
        })
        .when('/templates/instrutor-listar', {
            controller: 'InstrutorController',
            templateUrl: '/templates/instrutor-listar.html'
        })
        .otherwise({
            redirectTo: '/index.html'
        });
});

appRoute.controller('AulaController', function($scope, $routeParams, aulaService) {

    // $scope.id = $routeParams.idUrl;
    $scope.criar = criar;
    $scope.editar = editar;
    $scope.excluir = excluir;

    // Funções internas
    // buscarAulaPorId($scope.id);
    // editar($scope.id);
    carregarListaDeAulas();

    function criar(aula) {
        aulaService.criar(aula);
        $scope.novaAula = {};
    }

    function editar(aula) {
        aulaService.editar(aula).then(response => carregarListaDeAulas());
        $scope.aulaAtual = {};
    }

    function excluir(aula) {
        aulaService.excluir(aula).then(response => carregarListaDeAulas());
    }

    function carregarListaDeAulas() {
        // $scope.aulas = listar();
        // function listar() {
        //     aulaService.listar().then(function(response) {
        //         $scope.aulas = response.data;
        //     })
        // }

        // ArrowFunction
        $scope.aulas = aulaService.listar().then(response => $scope.aulas = response.data);
    }

    // function buscarAulaPorId(id) {
    //     aulaService.buscarAulaPorId(id).then(response => $scope.aula = responde.data);
    // }
});

appRoute.controller('InstrutorController', function($scope, $routeParams, instrutorService, aulaService) {

    $scope.cadastrar = cadastrar;
    $scope.editar = editar;
    $scope.excluir = excluir;
    $scope.instrutores = carregarListaDeInstrutores();
    $scope.aulas = carregarListaDeAulas();

    function cadastrar(instrutor) {
        if (angular.isUndefined(instrutor.urlFoto) || instrutor.urlFoto === null) {
            instrutor.urlFoto = 'http://hvazone.com/sodiz/adminlte/img/unknown-user.png';
        }
        instrutorService.cadastrar(instrutor);
        $scope.novoInstrutor = {};
    }

    function editar(instrutor) {
        instrutorService.editar(instrutor).then(response => carregarListaDeInstrutores());
        $scope.instrutorAtual = {};
    }

    function excluir(instrutor) {
        instrutorService.excluir(instrutor).then(response => carregarListaDeInstrutores());
    }

    function carregarListaDeInstrutores() {
        $scope.instrutores = instrutorService.listar().then(response => $scope.instrutores = response.data);
    }

    function carregarListaDeAulas() {
        $scope.aulas = aulaService.listar().then(response => $scope.aulas = response.data);
    }

    $scope.getNomeAula = function (idAula) {
        return $scope.aulas.find(aula => aula.id === idAula);
    }

});