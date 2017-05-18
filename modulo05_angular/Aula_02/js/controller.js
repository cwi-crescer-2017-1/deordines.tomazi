var myApp = angular.module('aula02', []);

myApp.controller('Exercicio1', function($scope) {

    $scope.converterData = converterData;

    function converterData() {
        let pattern = '\(\d{2}\\d{2}\\d{4}';
        let replace = '$1.$2.$3';
        let dataFormatada = $scope.dataInserida.replace(pattern, replace);

        $scope.dataObjeto = new Date(dataInserida);
    }
});