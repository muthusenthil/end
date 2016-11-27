<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%-- <%@ include file="/WEB-INF/views/template/header.jsp"%> --%>
<head>
<style></style>
</head>
<body>
<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Cart</h1>
					<p>All the selected products in your shopping cart</p>
				</div>
			</div>
		</section>

		<section class="container" ng-app="cartApp">

			<div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">

				<div>
					<a class="btn btn-danger pull-left" ng-click="clearCart()"><span
						class="glyphicon glyphicon-remove-sign"></span> Clear Cart</a> <a
						href="<spring:url value="/addtocart/${cartId}" />"
						class="btn btn-success pull-right"><span
						class="glyphicon glyphicon-shopping-cart"></span> Check out</a>
				</div>

				<br />
				<br />
				<br />

				<table class="table table-hover">
					<tr>
						<!-- <th>Product</th>
						<th>Unit Price</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Action</th> -->
						<th>Quantity</th>
			<th>NAME</th>
			<th>DESCRIPTION</th>
			<th>PRICE</th>
			<th>CATEGORY</th>
			<th>Total Prize</th>
					</tr>
					<!-- <tr ng-repeat="item in cart.cartItems">
						<td>{{item.product.productName}}</td>
						<td>{{item.product.productPrice}}</td>
						<td>{{item.quantity}}</td>
						<td>{{item.totalPrice}}</td>
						<td><a href="#" class="label label-danger"
							ng-click="removeFromCart(item.product.productId)"><span
								class="glyphicon glyphicon-remove"></span>remove</a></td>
					</tr>
					<tr>
						<th></th>
						<th></th>
						<th>Grand Total</th>
						<th>{{calGrandTotal()}}</th>
						<th></th>
					</tr> -->
					<c:forEach items="${cartlist}" var="cart">
				<tr>
					<td>${cart.quantity}</td>
					<td>${cart.productmodel.name}</td>
					<td>${cart.productmodel.description}</td>
					<td>${cart.productmodel.price}</td>
					<td>${cart.productmodel.category}</td>
					<td>${cart.totalprice}</td>
			</tr></c:forEach>
				</table>
				</body>

				<%-- <a href="<spring:url value="/productList" />"
					class="btn btn-default">Continue Shopping</a> --%>
			</div>
		</section>

		<!-- My -->
		<script src="<c:url value="/resources/js/controller.js?v3" /> "></script>

<%-- 		<%@ include file="/WEB-INF/views/template/footer.jsp"%> --%>