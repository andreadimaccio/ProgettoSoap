<%@page import="java.util.ArrayList"%>
<%@ include file="header.jsp"%>



<div class="container my-3">
	<h1>Il mio profilo</h1>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th scope="col">Nome</th>
				<th scope="col">Cognome</th>
				<th scope="col">Telefono</th>
				<th scope="col">Email</th>
				<th scope="col">Password</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
		<td>Nome</td>
		<td>Cognome</td>
		<td>Telefono</td>
		<td>Email</td>
		<td>Password</td>
		
		<a class="btn btn-warning btn-sm" href="" role="button"><i class="bi bi-pencil-fill"></i></a>	
		
		</tbody>
	</table>
	<br>
	<br>
	
	<h2>I miei Soap-it</h2>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Titolo</th>
				<th scope="col">Categoria</th>
				<th scope="col">Data di inserimento</th>
				<th scope="col">Data promemoria</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
		
			<tr>
				<th scope="row"></th>
				<td>Nome</td>
				<td>Categoria</td>
				<td>DataInserimento</td>
				<td>DataPromemoria</td>
				<td>
					<a class="btn btn-danger btn-sm" href="" role="button"><i class="bi bi-trash3-fill"></i></a>
					<a class="btn btn-warning btn-sm" href="" role="button"><i class="bi bi-pencil-fill"></i></a>
				
				</td>
			</tr>
		
		</tbody>
	</table>
	
</div>	
	



<%@ include file="footer.jsp"%>