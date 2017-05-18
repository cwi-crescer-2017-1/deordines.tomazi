var myApp = angular.module('aula01', []);

myApp.controller('Exemplo1', function($scope) {
    $scope.nomeDoCampo;
});

myApp.controller('Exercicio1', function($scope) {
    $scope.pokemon = { };
    $scope.pokemon.nome = 'Bulbasaur';
    $scope.pokemon.tipo = 'Veneno/Grama';

    // Funciona da mesma forma
    // $scope.pokemon = {nome: '', tipo: ''};

    // Não funciona
    // $scope.pokemon = {nome, tipo};
})

myApp.controller('Exemplo2', function($scope) {
    let pokemons = [
        $scope.pokemons = {nome: 'Pokemon 1', tipo: 'Tipo 1'},
        $scope.pokemons = {nome: 'Pokemon 2', tipo: 'Tipo 2'},
        $scope.pokemons = {nome: 'Pokemon 3', tipo: 'Tipo 3'},
        $scope.pokemons = {nome: 'Pokemon 4', tipo: 'Tipo 4'},
        $scope.pokemons = {nome: 'Pokemon 5', tipo: 'Tipo 5'}
    ];

    $scope.pokemons = pokemons;
});