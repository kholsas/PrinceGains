(function () {
    'use strict';

    angular
        .module('app')
        .controller('Register.FormController', Controller);

    function Controller($scope, $localStorage, $http) {
        var vm = this;
        vm.processRegistration = processRegistration;
        initController();

        function initController() {

        }

        function processRegistration() {
            console.info('About to register user');
            console.info(vm.username);
            console.info(vm.firstname);
            console.info(vm.surname);
            console.info(vm.email);
            console.info(vm.password);
        }

    }

})();