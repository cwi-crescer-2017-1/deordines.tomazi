var myApp = angular.module('aula02', []);

myApp.controller('Exercicio1', function($scope) {

    $scope.imprimirDataFormatada = imprimirDataFormatada;

    function imprimirDataFormatada() {
        $scope.dataObjeto = new Date($scope.dataInserida);
    }
});