
<%@page import="java.util.Date"%>
<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>

<div class=" text-center gap-2 col-6 mx-auto my-3">
	<button class="btn btn" type="button"
		style="background-color: #FDA65D;">Nuovo Soap-it</button>
	<button class="btn btn" type="button"
		style="background-color: #FDA65D;">Nuova Categoria</button>
</div>


<<<<<<< HEAD
<html>
<head>
<title></title>
</head>
<body>
	<center>
		<h3>Data e ora di oggi</h3>
	</center>
	<%
         Date date = new Date();
         out.print( "<h3 align = \"center\">" +date.toString()+"</h3>");
      %>
</body>
</html>


<div id="main-container">
	<div class="card text-white bg-primary mb-3" style="max-width: 18rem;">
		<div class="card-header">Lavoro</div>
		<div class="card-body">
			<h5 class="card-title">Colloquio</h5>
			<p class="card-text">Colloquio con Elis 14.30</p>
		</div>
	</div>
	<div class="card text-white bg-secondary mb-3"
		style="max-width: 18rem;">
		<div class="card-header">Header</div>
		<div class="card-body">
			<h5 class="card-title">Secondary card title</h5>
			<p class="card-text">Some quick example text to build on the card
				title and make up the bulk of the card's content.</p>
		</div>
	</div>
	<div class="card text-white bg-success mb-3" style="max-width: 18rem;">
		<div class="card-header">Header</div>
		<div class="card-body">
			<h5 class="card-title">Success card title</h5>
			<p class="card-text">Some quick example text to build on the card
				title and make up the bulk of the card's content.</p>
		</div>
		</div>
</div>
=======

<div class="card text-white mb-3 soapit" style="max-width: 18rem;">
  <div class="card-header bg-primary">Lavoro</div>
  <div class="card-body" style="background-color :#FDA65D">
    <h5 class="card-title">Colloquio</h5>
    <p class="card-text">Colloquio con Elis 14.30</p>
  </div>
</div>
<div class="card text-white mb-3 soapit" style="max-width: 18rem;">
  <div class="card-header" style="background-color :#FDA65D">Header</div>
  <div class="card-body bg-primary">
    <h5 class="card-title">Secondary card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
  </div>
</div>
<div class="card text-white bg-success mb-3 soapit" style="max-width: 18rem;">
  <div class="card-header">Header</div>
  <div class="card-body">
    <h5 class="card-title">Success card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
  </div>
</div>


>>>>>>> 6c662bcfb4842a93d213c2ad7e407557ef91a43d


<%-- <%@ include file="infofooter.jsp"%>
<%@ include file="footer.jsp"%> --%>
