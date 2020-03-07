<%@ page import="java.util.*" %>
<html>
<head>
	<style type="text/css">
		.parent{
			text-align: center;
		}
		.bill{
			border-radius: 5px;
			border: 2px solid green;
			background-color: lightgreen;
			padding:10px;
			margin:10px;
			width:500px;
			align-content: center;
			display: inline-block
		}
	</style>
</head>
<body>
	<div class="parent">
	<div class="bill">
		<h1>Bill</h1>
		<%= "Milk Cost:" +(String)request.getAttribute("milk")+"*25" %><br>
		<%= "Popcorn Cost:" +(String)request.getAttribute("popcorn")+"*50" %><br>
		<b><%= "Total Amount: "+(String)request.getAttribute("totalamount") %>  </b>

		<form action="confirm" method="get">
			<input type="submit" value="Confirm">
		</form>

	</div>
	</div>
</body>
</html>
