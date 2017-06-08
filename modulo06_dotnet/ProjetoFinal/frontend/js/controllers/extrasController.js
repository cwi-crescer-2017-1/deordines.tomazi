modulo.controller('extrasController', function($scope, extraService) {

    $scope.extras = [];

    $scope.criar = criar;
    $scope.listar = listar;
    $scope.alugar = alugar;
    $scope.devolver = devolver;

    $scope.extra = {};

    $scope.extras = listar();
    
    function criar(extra) {
        extraService
            .criar(extra)
            .then(response => {
                console.log(response.data.dados);
            })
    }

    function listar() {
        extraService
            .listar()
            .then(response => {
                console.log(response.data.dados);
                $scope.extras = response.data.dados;
            })
    }

    function alugar(extra) {
        extraService
            .alugar(extra)
            .then(response => {
                listar();
                console.log(response.data.dados);
            })
    }

    function devolver(extra) {
        extraService
            .devolver(extra)
            .then(response => {
                listar();
                console.log(response.data.dados);
            })
    }
})