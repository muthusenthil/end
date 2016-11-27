<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@include file="/WEB-INF/views/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container">
		<h2>PAYMENT</h2>
		<hr>
		<p>Please choose the Payment Method</p>
		<form:form method="POST">
			<label class="radio-inline"> <input type="radio"
				name="optradio">Cash On Delivery
			</label> <br> <label class="radio-inline"> <input type="radio"
				name="optradio">NetBanking
			</label> <br> <label class="radio-inline"> <input type="radio"
				name="optradio">Credit/Debit Card
			</label> <br>
			
		<input name="_eventId_submit" style=color:black type="submit" value="submit"/>
		</form:form>
		<%-- <a href="<c:url value="success"/>"><button type="button"
				class="btn btn-success">Submit</button></a> --%>
	</div>
	
	 <%@include file="/WEB-INF/views/footer.jsp"%> 
</body>
</html>