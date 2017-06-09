var modulo = angular.module('locadoraCrescerApp', ['ngRoute', 'ngStorage', 'auth']);

modulo.constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    //urlUsuario: 'http://10.99.3.24/AutDemo.WebApi/api/acessos/usuario',
    urlUsuario: 'http://localhost:59655/api/acessos/usuario',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/cliente',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/home'
});

modulo.config(function ($routeProvider) {
    $routeProvider
    .when('/login', {
        controller: 'loginController',
        templateUrl: '/templates/login.html'
    })
    .when('/home', {
        controller: 'homeController',
        templateUrl: '/templates/home.html'
    })
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
    .otherwise('/login');
})