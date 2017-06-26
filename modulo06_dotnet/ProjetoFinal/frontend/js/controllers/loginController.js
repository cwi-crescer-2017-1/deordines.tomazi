modulo.controller('loginController', function ($scope, authService, toastr) {

  $scope.login = function (usuario) {

    authService.login(usuario)
      .then(
      function (response) {
        console.log(response);
        toastr.success('Login realizado com sucesso.');
      },
      function (response) {
        console.log(response);
        toastr.error('Falha ao logar.');
      });
  };

});