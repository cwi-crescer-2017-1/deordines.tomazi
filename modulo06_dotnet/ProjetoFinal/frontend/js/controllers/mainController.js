modulo.controller('mainController', function($scope, $window, $localStorage, $timeout, authService) {

    var values = {};

    $scope.logout = logout;

    consultarLocalStorage();
    $scope.isAutenticado = authService.isAutenticado();
    $scope.isGerente = isGerente();
    $scope.isFuncionario = isFuncionario();
    
    function isGerente() {
        if (values !== null && values.Permissao === 'gerente') {
            return true;
        }
    }
    
    function isFuncionario() {
        if (values !== null && values.Permissao == 'funcionario') {
            return true;
        }
    }

    function logout() {
        localStorage.clear();
        authService.logout;
        $window.location.reload();
    }
    
    function consultarLocalStorage() {
        values = JSON.parse(localStorage.getItem('ngStorage-usuarioLogado'));
        console.log(values);
        if (values !== null) {
            $scope.user = values.dados;
        }
    }

    // $scope.botao1 = botao1;
    // $scope.botao2 = botao2;

    // function botao1() {
    //     $scope.exibirNav = true;        
    //     $scope.user = 'eu';
    //     console.log($scope.exibirNav);
    // }

    // function botao2() {
    //     $scope.user = 'Sign in';
    //     $scope.exibirNav = false;
    //     console.log($scope.exibirNav);                
    // }
});