var modulo = angular.module('redeSocialApp', ['ngRoute', 'ngAnimate', 'ngStorage', 'auth', 'ui.bootstrap', 'toastr']);

modulo.constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    //urlUsuario: 'http://10.99.3.24/AutDemo.WebApi/api/acessos/usuario',
    urlUsuario: 'http://localhost:9090/api/usuario',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/home',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/login'
});

modulo.config(function ($routeProvider) {
    $routeProvider
    .when('/login', {
        controller: 'loginController',
        templateUrl: '/templates/login.html'
    })
    .when('/cadastro', {
        controller: 'cadastroController',
        templateUrl: '/templates/cadastro.html'
    })
    .when('/home', {
        controller: 'homeController',
        templateUrl: '/templates/home.html'
    })
    .when('/perfil/:id', {
        controller: 'perfilController',
        templateUrl: '/templates/perfil.html'
    })
    .otherwise('/login');
});

modulo.config(function (toastrConfig) {
    angular.extend(toastrConfig, {
    autoDismiss: false,
    containerId: 'toast-container',
    maxOpened: 0,    
    newestOnTop: true,
    positionClass: 'toast-top-right',
    preventDuplicates: false,
    preventOpenDuplicates: true,
    target: 'body',
    timeOut: 2000
  });
})