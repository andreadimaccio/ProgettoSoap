
<%@ page import="java.util.Date"%>
<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>

<div class=" text-center gap-2 col-6 mx-auto my-3">
<<<<<<< HEAD
=======
	<button class="btn btn my-4" type="button"
		style="background-color: #FDA65D;">Nuovo Soap-it</button>
	<button class="btn btn my-4" type="button"></button>
>>>>>>> 117c5ec573d02c3b3f9055aa7ce8f3cfd0d8c03f
	<button class="btn btn" type="button" style="background-color: #FDA65D;">Nuovo Soap-it</button>
	<button class="btn btn" type="button" style="background-color: #FDA65D;">Nuova Categoria</button>
</div>

<center>
<div class="card mb-3 soapit my-4 div" style="max-width: 18rem;">
  <div class="card-header text-white bg-primary">Header</div>
  <div class="card-body bg-primary bg-opacity-50">
    <h5 class="card-title">Primary card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.
    </p>
  </div>
</div>
<div class="card mb-3 soapit div" style="max-width: 18rem;">
  <div class="card-header text-white bg-success">Header</div>
  <div class="card-body bg-success bg-opacity-50">

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

<div class="grid ">
	<div class="card text-white bg-danger mb-3 soapit overflow-auto mx-4 my-2 g-col-3 ">
		<div class="card-header">Header</div>
		<div class="card-body">
			<h5 class="card-title">Danger card title</h5>
			<p class="card-text">Some quick example text to build on the card
				title and make up the bulk of the card's content.</p>
		</div>
	</div>

	<div class="card text-dark bg-warning mb-3 soapit overflow-auto mx-4 my-2 g-col-3 ">
		<div class="card-header">Header</div>
		<div class="card-body">
			<h5 class="card-title">Warning card title</h5>
			<p class="card-text">ake up the bulk of the card's content.</p>
		</div>
	</div>



	<div class="card text-dark mb-3 soapit overflow-auto mx-4 my-2 g-col-3 ">

		<div class="card-header sticky-top bg-success">Header</div>

		<div class="card-body bg-success bg-opacity-50">
			<h5 class="card-title">Warning card title</h5>
			<p class="card-text">ake up the bulk of the card's content.ake up
				the bulk of the card's contentake up the bulk of the card's
				contentake up the bulk of the card's contentake up the bulk of the
				card's contentake up the bulk of the card's contentake up the bulk
				of the card's contentake up the bulk of the card's content.ake up
				the bulk of the card's contentake up the bulk of the card's
				contentake up the bulk of the card's contentake up the bulk of the
				card's contentake up the bulk of the card's contentake up the bulk
				of the card's contentake up the bulk of the card's content.ake up
				the bulk of the card's contentake up the bulk of the card's
				contentake up the bulk of the card's contentake up the bulk of the
				card's contentake up the bulk of the card's contentake up the bulk
				of the card's contentake up the bulk of the card's content.ake up
				the bulk of the card's contentake up the bulk of the card's
				contentake up the bulk of the card's contentake up the bulk of the
				card's contentake up the bulk of the card's contentake up the bulk
				of the card's content</p>
		</div>
	</div>
	
	
	
	<div class="card text-dark mb-3 soapit overflow-auto mx-4 my-2 g-col-3 ">
		<div class="card-header sticky-top bg-danger">
			<div class="btn-group">
				  <button type="button" class="btn btn-sm dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
				    <span class="visually-hidden">Toggle Dropdown</span>
				  </button>
				  <ul class="dropdown-menu">
				  	<li><a class="btn btn-success btn-sm mx-1" role="button"><i class="bi bi-pencil"></i> </a> Modifica </li>
				  	<li><a class="btn btn-danger btn-sm mx-1" role="button"><i class="bi bi-trash"></i> </a> Elimina</li>
				  </ul>
			</div>
			Titolo Soap-it!Titolo Soap-it!Titolo Soap-it!Titolo Soap-it!
		</div>
		<div class="card-body bg-danger bg-opacity-50">
			<h5 class="card-title">Warning card title</h5>
			<p class="card-text">ake up the bulk of the card's content.ake up
				the bulk of the card's contentake up the bulk of the card's
				contentake up the bulk of the card's contentake up the bulk of the
				card's contentake up the bulk of the card's contentake up the bulk
				of the card's content</p>
		</div>
	</div>
	
	
	<div class="card text-dark mb-3 soapit overflow-auto mx-4 my-2 g-col-3 ">
		<div class="card-header sticky-top bg-warning">
			<div class="btn-group">
				  <button type="button" class="btn btn-sm dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
				    <span class="visually-hidden">Toggle Dropdown</span>
				  </button>
				  <ul class="dropdown-menu">
				  	<li><a class="btn btn-success btn-sm mx-1" role="button"><i class="bi bi-pencil"></i> </a> Modifica </li>
				  	<li><a class="btn btn-danger btn-sm mx-1" role="button"><i class="bi bi-trash"></i> </a> Elimina</li>
				  </ul>
			</div>
			Titolo Soap-it!Titolo Soap-it!Titolo Soap-it!Titolo Soap-it!
		</div>
		<div class="card-body bg-warning bg-opacity-50">
			<h5 class="card-title">Warning card title</h5>
			<p class="card-text">ake up the bulk of the card's content.ake up
				the bulk of the card's contentake up the bulk of the card's
				contentake up the bulk of the card's contentake up the bulk of the
				card's contentake up the bulk of the card's contentake up the bulk
				of the card's content</p>
		</div>
	</div>
	
	
	<div class="card text-dark mb-3 soapit overflow-auto mx-4 my-2 g-col-3 ">
		<div class="card-header sticky-top bg-warning">
			<div class="btn-group">
				  <button type="button" class="btn btn-sm dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
				    <span class="visually-hidden">Toggle Dropdown</span>
				  </button>
				  <ul class="dropdown-menu">
				  	<li><a class="btn btn-success btn-sm mx-1" role="button"><i class="bi bi-pencil"></i> </a> Modifica </li>
				  	<li><a class="btn btn-danger btn-sm mx-1" role="button"><i class="bi bi-trash"></i> </a> Elimina</li>
				  </ul>
			</div>
			Titolo Soap-it!Titolo Soap-it!Titolo Soap-it!Titolo Soap-it!
		</div>
		<div class="card-body bg-warning bg-opacity-50">
			<h5 class="card-title">Warning card title</h5>
			<p class="card-text">ake up the bulk of the card's content.ake up
				the bulk of the card's contentake up the bulk of the card's
				contentake up the bulk of the card's contentake up the bulk of the
				card's contentake up the bulk of the card's contentake up the bulk
				of the card's content</p>
		</div>
	</div>



<<<<<<< HEAD
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

<div class="card mb-3 soapit div" style="max-width: 18rem;">
  <div class="card-header text-white bg-info">Header</div>
  <div class="card-body bg-info bg-opacity-50">
    <h5 class="card-title">Secondary card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
  </div>
</center>

<div class="card text-white bg-success mb-3 soapit" style="max-width: 18rem;">
  <div class="card-header">Header</div>
  <div class="card-body">
    <h5 class="card-title">Success card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
  </div>
>>>>>>> 117c5ec573d02c3b3f9055aa7ce8f3cfd0d8c03f
</div>



<<<<<<< HEAD

<%@ include file="footer.jsp" %> 

=======
<%@ include file="infofooter.jsp"%>
<%@ include file="footer.jsp"%>
>>>>>>> 117c5ec573d02c3b3f9055aa7ce8f3cfd0d8c03f
