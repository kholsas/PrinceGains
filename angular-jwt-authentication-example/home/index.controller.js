(function () {
    'use strict';

    angular
        .module('app')
        .controller('Home.IndexController', Controller);

    function Controller($scope, $http, $location, $localStorage) {
        var vm = fetchCatalogs;

        initController();

        function initController() {
        }


        function fetchCatalogs() {

            if (typeof $scope.pageNumber === 'undefined') {
                $scope.pageNumber = 0;
                this.pageNumber = $scope.pageNumber;
            }
            var reqURL = 'http://localhost:8090/catalogItemsByPageNumber/' + $scope.pageNumber;
            //http://169.239.180.113:8080/catalogItemsByCategory/TOP/' + $scope.pageNumber
            if ($scope.searchCriteria === 'ALL') {

            } else if ($scope.searchCriteria === 'TOPS') {
                reqURL = 'http://localhost:8090/catalogItemsByCategory/TOP/' + $scope.pageNumber;
            }

            $http.get(reqURL).then(function (response) {
                $scope.allItems = response.data;
            });
        }


        fetchCatalogs.call(this);
        $scope.previousPage = function () {
            this.pageNumber = this.pageNumber - 1;
            $scope.pageNumber = this.pageNumber;
            fetchCatalogs();
        };
        $scope.nextPage = function () {
            this.pageNumber = this.pageNumber + 1;
            $scope.pageNumber = this.pageNumber;
            fetchCatalogs();
        };
        $scope.submitForm = function () {
            console.info('logged in user is ' + $localStorage.currentUser.username);
            $http.post('http://localhost:8090/makeOrder/' + $localStorage.currentUser.username, this.allItems).success(function (data) {
                $scope.successMessage = 'Your order has been made!';
                $location.path("/myOrders");
            });
        };


        fetchCatalogs.call(this);
    }

})();