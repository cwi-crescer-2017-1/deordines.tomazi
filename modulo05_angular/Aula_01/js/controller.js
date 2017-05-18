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

myApp.controller('Exercicio2', function($scope) {
    let pokemons = [
        {id: '001', nome: 'Bulbasaur', tipo: 'Veneno/Grama'},
        {id: '002', nome: 'Ivysaur', tipo: 'Veneno/Grama'},
        {id: '003', nome: 'Venusaur', tipo: 'Veneno/Grama'},
        {id: '004', nome: 'Charmander', tipo: 'Fogo'},
        {id: '005', nome: 'Charmeleon', tipo: 'Fogo'},
        {id: '006', nome: 'Charizard', tipo: 'Fogo/Voador'},
        {id: '007', nome: 'Squirtle', tipo: 'Água'},
        {id: '008', nome: 'Wartortle', tipo: 'Água'},
        {id: '009', nome: 'Blastoise', tipo: 'Água'},

        {id: '', nome: 'Pidgey', tipo: 'Normal/Voador'},
        {id: '', nome: 'Geodude', tipo: 'Pedra/Terra'},
        {id: '', nome: 'Abra', tipo: 'Psíquico'},
        {id: '', nome: 'Lapras', tipo: 'Água/Gelo'},
        {id: '', nome: 'Bellsprout', tipo: 'Grama/Veneno'}
    ];

    $scope.pokemons = pokemons;
});