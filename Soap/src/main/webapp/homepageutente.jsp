<%@page import="java.util.ArrayList"%>
<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>

<div class="container my-3">
	<h1>Il mio profilo</h1>
	<div class="d-grid gap-2 d-md-flex justify-content-md-end">
		<button class="btn btn me-md-2" type="button" style="background-color: #FDA65D;">Modifica profilo</button>
	</div>
	<thead>
		<ul class="list-group list-group-flush">
			<li class="list-group-item">Nome</li>
			<li class="list-group-item">Cognome</li>
			<li class="list-group-item">Email</li>
			<li class="list-group-item">Telefono</li>
		</ul>
	</thead>
	<br> <br> <br> <br>
	<h2>Soap-it del giorno</h2>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Titolo</th>
				<th scope="col">Categoria</th>
				<th scope="col">Data di inserimento</th>
				<th scope="col">Data di promemoria</th>
				<td><a class="btn btn-danger btn-sm" href="" role="button"><i
						class="bi bi-trash3-fill"></i></a> <a class="btn btn btn-sm"
					href="" role="button" style="background-color: #FDA65D;"><i class="bi bi-pencil-fill"></i></a></td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">1</th>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">2</th>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th scope="row">3</th>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
	<%@ include file="footer.jsp"%>
