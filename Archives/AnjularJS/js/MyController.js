var application = angular.module('MyRegistrationLetter', []);

application.controller('RegistrationController', function ($scope, $http) {
    $http.get("http://localhost:8080/catalogs").
        then(function (response) {

            $scope.sender = 'Senior Web Developer';

            $scope.customer = response.customer;

        });
    $scope.lessonName = 'Angular JS ';
});