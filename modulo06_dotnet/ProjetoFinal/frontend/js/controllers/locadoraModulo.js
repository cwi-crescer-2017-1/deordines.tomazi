var modulo = angular.module('locadoraCrescerApp', ['ngRoute']);

modulo.config(function ($routeProvider) {
    $routeProvider
    .when('/cliente', {
        controller: 'clientesController',
        templateUrl: '/templates/cliente.html'
    })
    .when('/produto', {
        controller: 'produtosController',
        templateUrl: '/templates/produto.html'
    })
    .when('/extra', {
        controller: 'extrasController',
        templateUrl: '/templates/extra.html'
    })
    .when('/locacao', {
        controller: 'locacaoController',
        templateUrl: '/templates/locacao.html'
    })
})

