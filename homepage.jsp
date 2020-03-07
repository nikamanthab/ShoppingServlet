<%@ page import="java.util.*" %>
<html>
<head>
	<style type="text/css">
		.cart{
			float:left;
			border: 2px solid red;
			height: 500px;
			width: 45%;
			background-color: lightgreen;
		}
		.itemscart{
			background-color: pink;
			float: right;
		}
	</style>
</head>
<body>
<h1>Shopping Area</h1>
<%= "Welcome "+(String)request.getAttribute("user") %>  

<h1>Cart</h1>
<form action="buy" method="get"
	class="cart" ondrop="drop(event)" ondragover="allowDrop(event)">
	<input type="submit" value="buy"><br>
</form>
	
<div  class="cart itemscart">
	<img id="milk" ondragstart="drag(event)"  src="img/milk.jpg" width="50px" draggable="true">
	<img id="popcorn" ondragstart="drag(event)"  src="img/popcorn.jpg" width="50px" draggable="true">
</div>

<script type="text/javascript">
		function allowDrop(ev) {ev.preventDefault();}
		function drag(ev) {
			console.log("drag triggered");
			ev.dataTransfer.setData("text", ev.target.id);
		}
		function drop(ev) {
			console.log("drop triggered");
			ev.preventDefault();
			var data = ev.dataTransfer.getData("text");
			var value = 0;
			
			if(data === "popcorn"){value = 50;}
			if(data === "milk"){value = 25;}
			
			var inp = document.createElement("input");
			inp.name = data;
			inp.type = "text";
			inp.value = "";
			
			p = document.createElement("p");
			br = document.createElement("br");
			p.innerHTML = data+" - enter quantity:";
			ev.target.appendChild(document.getElementById(data));
			ev.target.appendChild(p);
			ev.target.appendChild(inp);
			ev.target.appendChild(br);

		}
</script>

</body>
</html>
