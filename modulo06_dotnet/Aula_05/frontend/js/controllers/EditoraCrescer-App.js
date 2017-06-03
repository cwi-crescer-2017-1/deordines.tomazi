var modulo = angular.module('EditoraCrescer-App', ['ngRoute', 'ui.bootstrap']);

modulo.config(function ($routeProvider) {
    $routeProvider
        .when('/templates/home', {
            controller: 'LivrosController',
            templateUrl: '/templates/home.html'
        })
        .otherwise('/templates/home');
});