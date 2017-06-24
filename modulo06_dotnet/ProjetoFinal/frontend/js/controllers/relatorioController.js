modulo.controller('relatorioController', function($scope, relatorioService) {

    $scope.relatorioMensal = [];
    $scope.relatorioAtraso = [];
    $scope.relatorioAtraso = listarRelatorioAtraso();
    
    $scope.listarRelatorioMensal = listarRelatorioMensal;

    function listarRelatorioMensal(data) {
        var dataRelatorio = data.data.toJSON().replace(/T.*/, "");
        relatorioService
            .listarRelatorioMensal(dataRelatorio)
            .then(response => {
                console.log(response.data.dados);
                $scope.relatorioMensal = response.data.dados;
            })
    }

    function listarRelatorioAtraso() {
        relatorioService
            .listarRelatorioAtraso()
            .then(response => {
                console.log(response.data.dados);
                $scope.relatorioAtraso = response.data.dados;
            })
    }
})