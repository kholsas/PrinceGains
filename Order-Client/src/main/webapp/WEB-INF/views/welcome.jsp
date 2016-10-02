<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>


<head>
    <link rel="shortcut icon" type="image/x-icon" href="img/logo.jpg"/>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Online Catalog">
    <meta name="author" content="Kholofelo Maloma">
    <meta name="owner" content="Prince Of Gains">

    <title>Prince Of Gains</title>

    <!-- Bootstrap Core CSS -->
    <link href="static/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="static/css/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="static/css/sb-admin-2.css" rel="stylesheet">


    <link href="static/css/listview.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="static/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- jQuery -->
    <script src="static/js/jquery.js"></script>
    <script src="static/js/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/js/bootstrap.js"></script>
    <script src="static/js/listview.js"></script>

</head>
<body>


<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <!--<img src="img/logo.jpg" alt="Prince Of Gains" style="width:304px;height:228px;">-->

            <a class="navbar-brand" href="#home">Prince Of Gains</a>
        </div>
        <!-- /.navbar-header -->

        <ul class="nav navbar-top-links navbar-right">
            <!-- /.dropdown -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-tasks">
                    <li>
                        <a href="#">
                            <div>
                                <p>
                                    <strong>Task 1</strong>
                                    <span class="pull-right text-muted">40% Complete</span>
                                </p>

                                <div class="progress progress-striped active">
                                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40"
                                         aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                        <span class="sr-only">40% Complete (success)</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">
                            <div>
                                <p>
                                    <strong>Task 2</strong>
                                    <span class="pull-right text-muted">20% Complete</span>
                                </p>

                                <div class="progress progress-striped active">
                                    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20"
                                         aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                        <span class="sr-only">20% Complete</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">
                            <div>
                                <p>
                                    <strong>Task 3</strong>
                                    <span class="pull-right text-muted">60% Complete</span>
                                </p>

                                <div class="progress progress-striped active">
                                    <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60"
                                         aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                        <span class="sr-only">60% Complete (warning)</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">
                            <div>
                                <p>
                                    <strong>Task 4</strong>
                                    <span class="pull-right text-muted">80% Complete</span>
                                </p>

                                <div class="progress progress-striped active">
                                    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80"
                                         aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                        <span class="sr-only">80% Complete (danger)</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a class="text-center" href="#">
                            <strong>See All Tasks</strong>
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </li>
                </ul>
                <!-- /.dropdown-tasks -->
            </li>
            <!-- /.dropdown -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-alerts">
                    <li>
                        <a href="#">
                            <div>
                                <i class="fa fa-comment fa-fw"></i> New Comment
                                <span class="pull-right text-muted small">4 minutes ago</span>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">
                            <div>
                                <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                <span class="pull-right text-muted small">12 minutes ago</span>
                            </div>
                        </a>
                    </li>

                </ul>
                <!-- /.dropdown-alerts -->
            </li>
            <!-- /.dropdown -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#userProfile"><i class="fa fa-user fa-fw"></i> User Profile</a>
                    </li>
                    <li><a href="#settings"><i class="fa fa-gear fa-fw"></i> Settings</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="#login"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                    </li>
                </ul>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
        <!-- /.navbar-top-links -->

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="sidebar-search">
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                        <!-- /input-group -->
                    </li>

                    <li>
                        <a href="#all-departments" g-click="active='home'" class="home"><i class="fa fa-bars fa-fw"></i>
                            All Categories<span
                                    class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#tops" ng-click="getTops()">Tops</a>
                            </li>
                            <li>
                                <a href="#bottoms">Bottoms</a>
                            </li>
                            <li>
                                <a href="#bottoms">Underwear</a>
                            </li>
                            <li>
                                <a href="#bottoms">Accessories</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>

                    <li>
                        <a href="#myOrders"><i class="fa fa-edit fa-fw"></i> My Orders</a>
                    </li>
                    <li>
                        <a href="#contact" ng-click="active='contact'" class="contact"><i
                                class="fa fa-envelope-o  fa-fw"></i> Contact Seller</a>
                    </li>
                    <li>
                        <a href="#about" ng-click="active='about'" class="about"><i class="fa fa-question fa-fw"></i>
                            About Prince Of Gains</a>
                    </li>
                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>

    <div id="page-wrapper">

        <!-- /.row -->
        <div class="row">

            <div class="jumbotron text-center">
                <div class="container" ng-controller="mainController">
                    <div class="well well-sm">
                        <strong>Display</strong>

                        <div class="btn-group">
                            <a href="#list" id="list" class="btn btn-default btn-sm"><span
                                    class="glyphicon glyphicon-th-list">
            </span>List</a> <a href="#" id="grid" class="btn btn-default btn-sm"><span
                                class="glyphicon glyphicon-th"></span>Grid</a>
                        </div>
                    </div>
                    <form ng-submit='submitForm()'>
                        <div id="products" class="row list-group {{extraClass}}" ng-repeat="mapItem in allItems">
                            <div class="item  {{extraClass}}   col-xs-4 col-lg-4"
                                 ng-repeat="catalogItem in mapItem track by $index">
                                <div class="list-group-item">
                                    <img class="group list-group-image"
                                         height="250px"
                                         src="http://localhost:8090/img/{{catalogItem.stockItem.imageFileName}}"
                                         alt="img"/>

                                    <div class="caption">
                                        <h4 class="group inner list-group-item-heading">
                                            {{catalogItem.stockItem.name}}</h4>

                                        <label class="group inner list-group-item-text">
                                            {{catalogItem.stockItem.description}}</label>

                                        <div class="row">
                                            <div class="col-xs-12 col-md-6">
                                                <p class="lead">
                                                    R {{catalogItem.stockItem.price}}</p>
                                            </div>
                                            <div class="col-md-4">
                                                <input name="quantity" class="form-control"
                                                       ng-model="catalogItem.quantity"
                                                       type="number"/>
                                            </div>
                                            <div class="col-md-3 panel-info">
                                                R {{catalogItem.quantity * catalogItem.stockItem.price}}
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row panel-footer btn-group btn-default">
                            <div class="col-xs-3 col-md-2 pull-left">
                                <a ng-click="previousPage()" class="-anchor">Prev</a>
                            </div>
                            <div class="col-xs-1 col-md-1">
                                [{{pageNumber}}]
                            </div>
                            <div class="col-xs-3 col-md-2 pull-left">
                                <a ng-click="nextPage()" class="-anchor">Next</a>
                            </div>
                            <div class="col-xs-4 col-md-3 pull-right">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>

                        </div>
                    </form>

                </div>
            </div>
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->


<!-- Metis Menu Plugin JavaScript -->
<script src="static/js/metisMenu.min.js"></script>

<!-- Morris Charts JavaScript -->
<script src="static/js/raphael.min.js"></script>
<script src="static/js/morris.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="static/js/sb-admin-2.js"></script>

</body>
</html>
