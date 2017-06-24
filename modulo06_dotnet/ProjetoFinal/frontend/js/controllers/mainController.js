modulo.controller('mainController', function($scope, $localStorage, $timeout, authService) {

    $scope.logout = authService.logout;

    // function consultarLocalStorage() {
    //     var values = JSON.parse(localStorage.getItem('ngStorage-usuarioLogado'));
    // }

    // console.log($scope.user);

    // if ($scope.user === null) {
    //     $scope.exibirNav = false;
    //     console.log($scope.exibirNav);
    // } else {
    //     if (values !== null) {
    //         $scope.user = values.dados;
    //         $scope.exibirNav = true;
    //     }
    // }

    $scope.botao1 = botao1;
    $scope.botao2 = botao2;

    function botao1() {
        $scope.exibirNav = true;        
        $scope.user = 'eu';
        console.log($scope.exibirNav);
    }

    function botao2() {
        $scope.user = 'Sign in';
        $scope.exibirNav = false;
        console.log($scope.exibirNav);                
    }
});