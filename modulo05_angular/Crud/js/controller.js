var myApp = angular.module('Crud', []);

myApp.controller('aula', function($scope) {
    $scope.aulas = [];
    let id = 0;

    $scope.adicionar = function(nome) {
        let nomes = $scope.aulas.map(aula => aula.nome);
        if (nomes.some(n => n === nome)) {
            console.log('Aula já cadastrada.'); //TODO: informar no html.
            return;
        }

        if ($scope.FormularioAula.$valid) {
            $scope.aulas.push({id, nome});
            $scope.novaAula = { };
            id++;
        }
    }

    $scope.alterar = function(id, novoNome) {
        console.log(id);
        console.log(novoNome);
        $scope.aulas[id].nome = novoNome;
        $scope.novoNome = '';
    }

    $scope.excluir = function(id) {
        console.log(id);
        if (angular.isUndefined(id) || id === null)
            return;

        $scope.aulas.splice(id, 1);
    }
});