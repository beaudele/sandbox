<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>AngularJS $http Example</title>
<style>
.username.ng-valid {
	background-color: lightgreen;
}

.username.ng-dirty.ng-invalid-required {
	background-color: red;
}

.username.ng-dirty.ng-invalid-minlength {
	background-color: yellow;
}

.email.ng-valid {
	background-color: lightgreen;
}

.email.ng-dirty.ng-invalid-required {
	background-color: red;
}

.email.ng-dirty.ng-invalid-email {
	background-color: yellow;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body ng-app="myApp" class="ng-cloak">
	<!-- Navigation -->
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="navbar-header">
			<a class="navbar-brand" ui-sref="#">AngularUI Router</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a ui-sref="user_registration_form">User Registration
					Form</a></li>
			<li><a ui-sref="user_list">List of Users</a></li>
		</ul>
	</nav>
	<!-- Main content -->
	<div class="generic-container">
		<div ui-view="">
			<!-- Content will be injected here -->
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.17/angular-ui-router.min.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/routes.js' />"></script>
	<script src="<c:url value='/static/js/service/user_service.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/user_controller.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/user_edit_controller.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/user_create_controller.js' />"></script>
</body>
</html>