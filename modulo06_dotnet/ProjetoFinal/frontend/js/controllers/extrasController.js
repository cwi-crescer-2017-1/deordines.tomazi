modulo.controller('extrasController', function($scope, extraService) {

    $scope.extras = [];

    $scope.criar = criar;
    $scope.listar = listar;
    $scope.alugar = alugar;

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

    function alugar(id, quantidade) {
        extraService
        .alugar(id, quantidade)
        .the(response => {
            console.log(response.data.dados);
        })
    }
})