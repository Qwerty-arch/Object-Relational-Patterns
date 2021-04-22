angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/productService';

     $scope.fillTable = function () {
         $http.get(contextPath + '/api/v1/products')
             .then(function (response) {
                 console.log(response);
                 $scope.ProductsList = response.data;
             });
     };
    $scope.fillTable();
});