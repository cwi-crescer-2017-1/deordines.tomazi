var myApp = angular.module('aula03', []);

myApp.controller('MainController', function ($scope) {
    $scope.nome = 'Olá,';

    let nomes = ['Bernardo', 'Nunes', 'PHP', 'Zanatta'];
    $scope.nomes = nomes;

    $scope.incluir = function(novoNome) {
        console.log(`Novo nome: ${novoNome}`);

        if ($scope.meuFormulario.$invalid) {
            console.log('Formulário inválido');
            console.log($scope.meuFormulario.$error);
            return;
        }

        console.log($scope.meuFormulario);
        $scope.nomes.push(novoNome);
    }
});