var appRoute = angular.module('CrudRoute', ['ngRoute', 'ngAnimate', 'toastr']);

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
            redirect: '/index.html'
        });
});

appRoute.controller('AulaController', function($scope, $routeParams, aulaService, toastr) {

    // $scope.id = $routeParams.idUrl;
    $scope.cadastrar = cadastrar;
    $scope.editar = editar;
    $scope.excluir = excluir;

    // Funções internas
    // buscarAulaPorId($scope.id);
    // editar($scope.id);
    carregarListaDeAulas();

    function cadastrar(aula) {
        if (angular.isUndefined(aula) || aula === null) {
            toastr.error('Aula inválida');
            return;
        }
        aulaService.cadastrar(aula);
        $scope.novaAula = {};
        toastr.success('Cadastro efetuado!');
    }

    function editar(aula) {
        if (angular.isUndefined(aula) || aula === null) {
            toastr.warning('Seleciona uma aula');
            return;
        }
        aulaService.editar(aula).then(response => carregarListaDeAulas());
        $scope.aulaAtual = {};
        toastr.success('Edição concluída!');
    }

    function excluir(aula) {
        aulaService.excluir(aula).then(response => carregarListaDeAulas());
        toastr.success('Cadastro removido!');

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

appRoute.controller('InstrutorController', function($scope, $routeParams, instrutorService, aulaService, toastr) {

    $scope.cadastrar = cadastrar;
    $scope.editar = editar;
    $scope.excluir = excluir;
    $scope.instrutores = carregarListaDeInstrutores();
    $scope.aulas = carregarListaDeAulas();

    function cadastrar(instrutor) {
        if (angular.isUndefined(instrutor) || instrutor === null) {
            toastr.error('Instrutor inválido');
            return;
        }
        if (angular.isUndefined(instrutor.urlFoto) || instrutor.urlFoto === null) {
            instrutor.urlFoto = 'http://hvazone.com/sodiz/adminlte/img/unknown-user.png';
        }
        instrutorService.cadastrar(instrutor);
        $scope.novoInstrutor = {};
        toastr.success('Cadastro efetuado!');
    }

    function editar(instrutor) {
        if (angular.isUndefined(instrutor) || instrutor === null) {
            toastr.warning('Selecione um instrutor');
            return;
        }
        instrutorService.editar(instrutor).then(response => carregarListaDeInstrutores());
        $scope.instrutorAtual = {};
        toastr.success('Edição concluída!');        
    }

    function excluir(instrutor) {
        instrutorService.excluir(instrutor).then(response => carregarListaDeInstrutores());
        toastr.success('Cadastro removido!');
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