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
    <link href="<c:url value='/static/css/modern-business.css' />" rel="stylesheet"></link>


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
            <c:if test="${errorMessage != null}">
                <div class="alert alert-warning">
                    <p>${errorMessage} </p>
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

            <form:form method="POST" modelAttribute="catalog" action="${userActionUrl}">
                <form:hidden path="id"/>
                <form:hidden path="name"/>
                <form:hidden path="description"/>
                <%--<form:hidden path="orderItems"/>--%>

                <div id="products" class="row list-group">
                    <c:forEach var="catalogItem" items="${catalog.catalogItems}" varStatus="status">
                        <%--<c:set var="catalog" scope="session" value="catalogItems[${status.index}]"/>--%>

                        <div class="item  col-xs-4 col-lg-4">
                            <div class="thumbnail">
                                <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>

                                <div class="caption">
                                    <h4 class="group inner list-ggroup-item-heading">
                                            ${catalogItem.stockItem.name}</h4>
                                    <form:hidden path="catalogItems[${status.index}].stockItem.name"/>


                                    <p class="group inner list-group-item-text">
                                            ${catalogItem.stockItem.description}
                                        <form:hidden path="catalogItems[${status.index}].stockItem.description"/>
                                    </p>

                                    <div class="row">
                                        <div class="col-xs-12 col-md-3">
                                            <div class="form-group">
                                                <label for="quantity">Quantity</label>
                                                <form:input type="text" class="form-control" id="quantity"
                                                            path="catalogItems[${status.index}].quantity"/>
                                            </div>
                                            <div class="panel-body">
                                                <span class="price"><sup>R </sup> ${catalogItem.stockItem.price}<sup>*</sup></span>
                                                <form:hidden path="catalogItems[${status.index}].stockItem.price"/>
                                                <span class="period">Once off</span>
                                            </div>

                                        </div>

                                    </div>
                                    <div class="row">
                                        <div class="col-xs-12 col-md-3">
                                            <p class="lead">
                                                    ${catalogItem.numberAvailable} Available
                                            </p>

                                            <p class="lead">
                                                    ${catalogItem.numberSold} Sold
                                            </p>
                                            <form:hidden path="catalogItems[${status.index}].numberAvailable"/>
                                            <form:hidden path="catalogItems[${status.index}].numberSold"/>

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
                                   formaction="confirmOrderItemList"/>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
