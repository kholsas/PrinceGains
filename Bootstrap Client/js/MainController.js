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
        });
});

// create the controller and inject Angular's $scope
scotchApp.controller('mainController', function ($scope, $http) {

    $http.get('http://localhost:8080/mainCatalog').then(function (response) {
         $scope.catalogItemDTOs = response.data.catalogItemDTOs;
    });
    // create a message to display in our view
    $scope.message = 'This is the catalog page!';
});

scotchApp.controller('aboutController', function ($scope) {
    $scope.message = 'Look! I am an about page.';
});

scotchApp.controller('contactController', function ($scope) {
    $scope.message = 'Contact us! ';
});

scotchApp.controller('myOrdersController', function ($scope) {
    $scope.message = 'You do not have any new orders';
});