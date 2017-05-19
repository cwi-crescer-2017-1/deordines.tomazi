var myApp = angular.module('aula02', []);

myApp.controller('Exercicio1', function ($scope) {

    $scope.imprimirDataFormatada = imprimirDataFormatada;
    // let pattern = '(\d{2}).(\d{2}).(\d{4})';

    function imprimirDataFormatada() {
        let splitData = $scope.dataInserida.split("/");
        // console.log(splitData);
        let dataFormatada = `${splitData[1]}/${splitData[0]}/${splitData[2]}`;
        // console.log(dataFormatada);
        $scope.dataObjeto = new Date(dataFormatada);
    }
});

myApp.filter('mascada', function () {
    return function (nome) {
        return nome.replace(/(nunes)/i, '$ $1 $');
    }
});

myApp.filter('formatacao', function() {
    return function(modulo) {
        return pad(modulo.id, 3) + " - " + modulo.nome.toUpperCase();
    }

    function pad(numero, digitos) {
        return Array(Math.max(digitos - String(numero).length + 1, 0)).join(0) + numero;
    }
});

myApp.controller('Exercicio2', function ($scope) {
    let instrutores = [{
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
    },
    {
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
    }
    ];

    let modulos = [];

    instrutores.forEach(function(campo) {
        campo.aula.forEach(function(aula) {
            modulos.push({ id: aula.numero, nome: aula.nome, instrutor: campo.nome })
        });
    });

    $scope.instrutores = instrutores;
    $scope.modulos = modulos;
});