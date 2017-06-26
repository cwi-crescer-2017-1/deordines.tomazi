modulo.controller('relatorioController', function($scope, relatorioService, toastr) {
    
    var valorTotal = 0;

    $scope.relatorioMensal = [];
    $scope.relatorioAtraso = [];
    $scope.relatorioAtraso = listarRelatorioAtraso();
    
    $scope.listarRelatorioMensal = listarRelatorioMensal;

    function listarRelatorioMensal(data) {
        if (angular.isUndefined(data) || data === null) {
            toastr.error('Ação inválida.');
        }
        var dataRelatorio = data.data.toJSON().replace(/T.*/, "");
        relatorioService
            .listarRelatorioMensal(dataRelatorio)
            .then(response => {
                if (response.data.dados.length === 0) {
                    toastr.info('Sem relatórios no tempo informado.');
                } else {
                    toastr.success('Ação realizada com sucesso.');
                }
                console.log(response.data.dados);
                $scope.relatorioMensal = response.data.dados;
                
                for(value of $scope.relatorioMensal) {
                    valorTotal += value.ValorFinal;
                }

                $scope.valorTotal = valorTotal;
            })
    }

    function listarRelatorioAtraso() {
        relatorioService
            .listarRelatorioAtraso()
            .then(response => {
                toastr.success('Ação realizada com sucesso.');
                console.log(response.data.dados);
                $scope.relatorioAtraso = response.data.dados;
            })
    }
})