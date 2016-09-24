// create the module and name it scotchApp
var scotchApp = angular.module('PrinceOfGains', ['ngRoute']);

// configure our routes
scotchApp.config(function ($routeProvider) {
    $routeProvider

        // route for the home page
        .when('/', {
            templateUrl: 'pages/home.html',
            controller: 'mainController'
        })
        .when('/list', {
            templateUrl: 'pages/home.html',
            controller: 'listController'
        })
        .when('/home', {
            templateUrl: 'pages/home.html',
            controller: 'mainController'
        })

        // route for the about page
        .when('/about', {
            templateUrl: 'pages/about.html',
            controller: 'aboutController'
        })
        // route for the My Orders page
        .when('/myOrders', {
            templateUrl: 'pages/myOrders.html',
            controller: 'myOrdersController'
        })

        // route for the contact page
        .when('/contact', {
            templateUrl: 'pages/contact.html',
            controller: 'contactController'
        })
        //checkout controller
        .when('/checkout', {
            templateUrl: 'pages/checkout.html',
            controller: 'checkOutController'
        });
});

scotchApp.controller('listFormController', function ($scope, $http, $location) {
    $scope.submitForm = function () {

        $http.post('http://localhost:8080/makeOrder', this.catalogItemDTOs).success(function (data) {
            $scope.successMessage = 'Your order has been made!';
            $location.path("/myOrders");
        });
    };
});

// create the controller and inject Angular's $scope
scotchApp.controller('mainController', function ($scope, $http) {

    function fetchCatalogs() {

        if (typeof $scope.pageNumber === 'undefined') {
            $scope.pageNumber = 0;
            this.pageNumber = $scope.pageNumber;
        }
        $http.get('http://localhost:8080/catalogItemsByPageNumber/' + $scope.pageNumber).then(function (response) {
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
    // create a message to display in our view
    $scope.message = 'This is the catalog page!';
});

// create the controller and inject Angular's $scope
scotchApp.controller('listController', function ($scope, $location) {

    // create a message to display in our view
    $scope.message = 'This is the catalog page!';
    $scope.extraClass = 'list-group-item';
});

scotchApp.controller('aboutController', function ($scope) {
    $scope.message = 'This is the About Prince of Gains page';
});


scotchApp.controller('contactController', function ($scope) {
    $scope.message = 'Contact us! ';
});

scotchApp.controller('myOrdersController', function ($scope) {
    $scope.message = 'You do not have any new orders';
});
