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
        .when('/tops', {
            templateUrl: 'pages/home.html',
            controller: 'topsController'
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

// create the controller and inject Angular's $scope
scotchApp.controller('mainController', function ($scope, $http, $location) {

    function fetchCatalogs() {

        if (typeof $scope.pageNumber === 'undefined') {
            $scope.pageNumber = 0;
            this.pageNumber = $scope.pageNumber;
        }
        var reqURL = 'http://169.239.180.113:8090/catalogItemsByPageNumber/' + $scope.pageNumber;
        //http://169.239.180.113:8080/catalogItemsByCategory/TOP/' + $scope.pageNumber
        if($scope.searchCriteria === 'ALL') {

        }else if($scope.searchCriteria === 'TOPS'){
             reqURL = 'http://169.239.180.113:8090/catalogItemsByCategory/TOP/' + $scope.pageNumber;
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

        $http.post('http://169.239.180.113:8090/makeOrder', this.allItems).success(function (data) {
            $scope.successMessage = 'Your order has been made!';
            $location.path("/myOrders");
        });
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

scotchApp.controller('topsController', function ($scope, $http) {
    $scope.searchCriteria = 'TOPS';
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
