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

myApp.controller('Exercicio1', function($scope) {
    let instrutores = [{nome: '', sobrenome: '', idade: '', email: '', jaDeuAula: '', disciplina: ''}];
    $scope.instrutores = instrutores;

    let disciplinas = ['OO', 'HTML e CSS', 'Javascript', 'AngularJS', 'Banco de Dados I'];
    $scope.disciplinas = disciplinas;

    $scope.adicionar = function(nome, sobrenome, idade, email, jaDeuAula, disciplina) {
        console.log(nome);
        console.log(sobrenome);
        console.log(idade);
        console.log(email);
        console.log(jaDeuAula);
        console.log(disciplina);
        $scope.instrutores.push({nome, sobrenome, idade, email, jaDeuAula, disciplina});//aulasMinistradas.push(aulasMinistrada);
    }
});