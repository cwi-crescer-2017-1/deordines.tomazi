var myApp = angular.module('Crud', []);

myApp.controller('MainController', function($scope) {
    $scope.aulas = [];
    let idAulaAux = 0;

    $scope.aulas = [{id: 0, nome:'a'}, {id: 1, nome:'b'}, {id: 2, nome:'c'}, {id: 3, nome:'d'}, {id: 4, nome: 'e'}];

    $scope.adicionarAula = function(novoNome) {
        if (angular.isUndefined(novoNome) || novoNome === null) {
            console.log('Undefined or null');
            return;
        } else if ($scope.aulas.length != 0) {
            let nomes = $scope.aulas.map(aula => aula.nome);
            if (nomes.some(n => n === novoNome)) {
                console.log('Aula já cadastrada.'); //TODO: informar no html.
                toastr.warning('Aula já cadastrada');
                $scope.novaAula = {};
                return;
            }
        }
        
        if ($scope.FormularioAula.$valid) {
            $scope.aulas.push({id: idAulaAux, nome: novoNome});
            $scope.novaAula = {};
            idAulaAux++;
            console.log($scope.aulas);
            toastr.success('Aula cadastrada com sucesso');
        }
    }

    $scope.alterarAula = function(id, novoNome) {
        if (angular.isUndefined(novoNome) || novoNome === null) {
            toastr.warning('Insira um novo nome');
            return;
        }
        toastr.success('Alteração efetuada com sucesso');
        console.log(id);
        console.log(novoNome);
        $scope.aulas[id].nome = novoNome;
        $scope.alterarAulaId = {};
        $scope.novoNome = {};
    }

    // Mil tretas
    $scope.excluirAula = function(aulaExcluida) {
        if (angular.isUndefined(aulaExcluida) || aulaExcluida === null) {
            toastr.warning('Selecione uma aula');
            return;
        }
        toastr.success('Aula excluída com sucesso');
        // console.log(id);
        // if (angular.isUndefined(id) || id === null) {
        //     return;
        // }
        // $scope.aulas.splice($scope.aulas.findIndex(x => x.id === id), 1);
        // $scope.excluirAulaId = null;
        $scope.aulas = $scope.aulas.filter(aula => aula.id !== aulaExcluida.id);
    }

    $scope.instrutores = [];
    let idInstrutoresAux = 0;

    $scope.instrutores = [
    {id: 0,                            
    nome: 'Deórdines',
    sobrenome: 'Tomazi',
    idade: 23,
    email: 'deordines.tomazi@cwi.com.br',
    dandoAula: true,
    aula: [{id: 1, nome: 'oi'}, {id: 4, nome: 'a'}]}];

    $scope.adicionarInstrutor = function() {
        let nomes = $scope.instrutores.map(instrutor => instrutor.nome);
        let emails = $scope.instrutores.map(instrutor => instrutor.email);

        if (nomes.some(n => n === $scope.novoInstrutor.nome)) {
            toastr.warning('Instrutor já cadastrado');
            console.log('Instrutor já cadastrado');
            $scope.novoInstrutor = {};
            return;
        } else if (emails.some(e => e === $scope.novoInstrutor.email)) {
            toastr.warning('Email já cadastrado');
            console.log('Email já cadastrado');
            $scope.novoInstrutor = {};
            return;
        }

        if ($scope.FormularioInstrutor.$valid) {
            toastr.success('Instrutor cadastrado com sucesso');
            $scope.instrutores.push(Object.assign({id: idInstrutoresAux}, angular.copy($scope.novoInstrutor)));
            console.log(angular.copy($scope.novoInstrutor));
            $scope.novoInstrutor = {};
            idInstrutoresAux++;
            console.log($scope.instrutores);
        }
    }

    $scope.alterarInstrutor = function(instrutor) {
        // if (angular.isUndefined(instrutorAtual.novoNome) || instrutorAtual.novoNome === null) {
        //     return;
        // }
        // console.log(instrutorId);
        // console.log(instrutorAtual.id);
        // console.log($scope.instrutores[instrutorId]);

        if ($scope.FormularioInstrutor.$valid) {
            $scope.instrutores[instrutor.id] = instrutor;
            $scope.instrutorAtual = {};
        } else {
            // incluir validações no html
        }
    }

    $scope.excluirInstrutor = function(instrutorExcluido) {
        if (instrutorExcluido.dandoAula) {
            console.log('O instrutor selecionado não pode ser excluído.');
            return;
        }
        $scope.instrutores = $scope.instrutores.filter(instrutor => instrutor.id !== instrutorExcluido.id);
    }
});