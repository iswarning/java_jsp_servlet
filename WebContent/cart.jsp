<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cart Page</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
	<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css' />
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class='container'>
		<div class='row'>
			<div class='col-md-12'>
				<table class='table table-striped'>
					<thead>
						<tr>
							<th>ProId</th>
							<th>ProName</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
					<c:if test="${message }"><span class='alert alert-success'>${message }</span></c:if>
					<c:forEach items="${listOD}" var="o">
						<tr>
							<td>${o.getProductId()}</td>
							<td>${o.getProductName()}</td>
							<td>${o.getPrice()}</td>
							<form action='cart' method='post'>
								<td><input type='number' value="${o.getQuantity()}" name='qty'/></td>
								<td>
									<input type='hidden' value='update' name='action'/>
									<input type='hidden' value='${o.getProductId()}' name='proId'/>
									<button type='submit' class='btn btn-primary'><i class="fas fa-pencil-alt"></i></button>
									<a href="cart?action=remove&id=${o.getId()}" class='btn btn-danger'><i class="fas fa-trash-alt"></i>
									</a>
								</td>
							</form>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<form action='order' method='post'>
					<button type='submit' class='btn btn-warning'>Order</button>
				</form>
			</div>
		</div>
	</div>
	
	
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>