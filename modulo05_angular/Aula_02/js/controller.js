var myApp = angular.module('aula02', []);

myApp.controller('Exercicio1', function ($scope) {

    $scope.imprimirDataFormatada = imprimirDataFormatada;

    function imprimirDataFormatada() {
        $scope.dataObjeto = new Date($scope.dataInserida);
    }
});

myApp.filter('mascada', function () {
    return function (nome) {
        // if (nome === 'Nunes')
            // return '$ Nunes $';
            return nome.replace('Nunes', '$ { Nunes } $');
        // else
            // return nome;
    }
})

myApp.controller('Exercicio2', function ($scope) {

    let instrutores = [{
        nome: 'Bernardo',
        aula: [{
            numero: 1,
            nome: 'OO'
        },
        {
            numero: 4,
            nome: 'Javascript'
        }
        ]
    },
    {
        nome: 'Nunes',
        aula: [{
            numero: 2,
            nome: 'Banco de Dados I'
        }]
    },
    {
        nome: 'Pedro (PHP)',
        aula: [{
            numero: 3,
            nome: 'HTML e CSS'
        }]
    },
    {
        nome: 'Zanatta',
        aula: [{
            numero: 5,
            nome: 'AngularJS'
        }]
    }
    ];

    $scope.instrutores = instrutores;
})