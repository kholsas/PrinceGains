(function () {
    'use strict';

    angular
        .module('app')
        .controller('Profile.MyOrders', Controller);

    function Controller($scope, $localStorage, $http) {
        var vm = this;

        initController();

        function initController() {
            console.info('Fetching user orders');
            $http.get('http://localhost:8090/getOrdersFor/' + $localStorage.currentUser.username).then(function (response) {
                $scope.orders = response.data;
            });
        }
    }

})();