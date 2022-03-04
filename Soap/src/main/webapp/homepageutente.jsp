<%@page import="java.util.ArrayList"%>
<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>
<%@ page import = "model.Utenti" %>
<% Utenti u = (Utenti)request.getSession().getAttribute("utenteLogin"); %>
<div class="container my-3">
	<div class="d-grid gap-2 d-md-flex justify-content-md-end"></div>
	<thead>
		<ul class="list-group">
			<h2>
				<li class="list-group-item" aria-current="true"
					style="background-color: #FDA65D;">Il mio profilo</li>
			</h2>
			<label>Nome</label><li class="list-group-item"><%= u.getNomeUtente() %></li>
			<label>Cognome</label><li class="list-group-item"><%= u.getCognomeUtente() %></li>
			<label>Email</label><li class="list-group-item"><%= u.getEmailUtente() %></li>
			<label>Telefono</label><li class="list-group-item"><%= u.getTelefonoUtente() %></li>
		</ul>
		<div class="d-grid gap-2 d-md-flex justify-content-md-end ">
			<a href="dispatcherutente?action=edit"><button class="btn btn me-md-2 my-2" type="button"
				style="background-color: #FDA65D;">Modifica profilo</button></a>
		</div>
	</thead>
	<br> <br> <br> <br>
	<h2 class="list-group-item" aria-current="true"
		style="background-color: #FDA65D;">Soap-it del giorno</h2>
	<table class="table bg-opacity-50">
		<thead>
			<tr>
				<th scope="col"></th>
				<th scope="col">Titolo</th>
				<th scope="col">Categoria</th>
				<th scope="col">Data di inserimento</th>
				<th scope="col">Data di promemoria</th>
				<td><a class="btn btn-danger btn-sm" href="" role="button"><i
						class="bi bi-trash3-fill"></i></a> <a class="btn btn btn-sm" href=""
					role="button" style="background-color: #FDA65D;"><i
						class="bi bi-pencil-fill"></i></a></td>
		</thead>
		<tbody>
			<tr>
				<th scope="row">1</th>
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
			</tr>
			<tr>
				<th scope="row">3</th>
				<td colspan="2"></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
	<%@ include file="footer.jsp"%>
