<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <script src='<spring:url value="/static/js/jquery.js"/>'></script>
    <script src='<spring:url value="/static/js/jquery.min.js"/>'></script>
    <script src='<spring:url value="/static/js/bootstrap.min.js"/>'></script>
    <script src='<spring:url value="/static/js/bootstrap.js"/>'></script>
    <script src='<spring:url value="/static/js/listview.js"/>'></script>


    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/bootstrap-theme.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/bootstrap-theme.min.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/listview.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/buttons.css' />" rel="stylesheet"></link>


    <link rel="stylesheet" type="text/css"
          href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css"/>


    <title>Prince Gains</title>
</head>
<body>
Dear <strong>${user}</strong>, Welcome to Home Page.
<a href="<c:url value="/logout" />">Logout</a>


<div class="form-group">


    <div class="container">

        <div class="content">
            <c:if test="${numberOfItemsAdded != null}">
                <div class="alert alert-success">
                    <p>${numberOfItemsAdded} items added to your Shopping Basket</p>
                </div>
            </c:if>
            <div class="well well-sm">
                <strong>Display</strong>

                <div class="btn-group">
                    <a href="#" id="list" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th-list">
            </span>List</a> <a href="#" id="grid" class="btn btn-default btn-sm"><span
                        class="glyphicon glyphicon-th"></span>Grid</a>
                </div>
            </div>

            <form:form method="POST" modelAttribute="catalog">
                <form:hidden path="id"/>
                <form:hidden path="category"/>
                <form:hidden path="name"/>
                <form:hidden path="orderItems"/>

                <div id="products" class="row list-group">
                    <c:forEach var="orderItem" items="${catalog.orderItems}">

                        <div class="item  col-xs-4 col-lg-4">
                            <div class="thumbnail">
                                <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>

                                <div class="caption">
                                    <h4 class="group inner list-group-item-heading">
                                            ${orderItem.name}</h4>

                                    <p class="group inner list-group-item-text">
                                            ${orderItem.description}
                                    </p>

                                    <div class="row">
                                        <div class="col-xs-12 col-md-6">
                                            <p class="lead">
                                                R ${orderItem.price}</p>
                                        </div>
                                        <div class="col-xs-12 col-md-6">
                                            <label for="${orderItem.id}" class="btn btn-primary">Add to Cart <input
                                                    type="checkbox" id="${orderItem.id}" name="orderItem.addedToCart"
                                                    class="badgebox"><span class="badge">&check;</span></label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

                <div class="row">
                    <div class="form-group">
                        <div class="col-sm-12 pull-right">
                        </div>
                        <div class="col-sm-2 pull-right">

                            <input type="submit"
                                   class="btn btn-default btn-block btn-primary"
                                   value="Next" name="action" formmethod="POST"
                                   formaction="confirmList"/>

                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
