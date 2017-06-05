var modulo = angular.module('EditoraCrescer-App', ['ngRoute', 'auth', 'ui.bootstrap']);

modulo.config(function ($routeProvider) {
    $routeProvider
        .when('/home', {
            controller: 'LivrosController',
            templateUrl: '/templates/home.html'
        })
        .when('/detalhamento/:isbn', {
            controller: 'DetalhamentoController',
            templateUrl: '/templates/detalhamento.html'
        })
        .when('/administrativo', {
            controller: 'AdministrativoController',
            templateUrl: '/templates/administrativo.html'
        })
        .otherwise('/home');
});