<%@ include file="header.jsp"%>

<div class="container my-3">
	<h1>Utenti da approvare</h1>
	<table class="table table-striped table-hover">
		<thead >
			<tr>
				<th scope="col">Nome utente</th>
				<th scope="col">Cognome utente</th>
			</tr>
			</thead>
			<tbody>
			<tr>
			 	<td scope="col">Nome</th>
				<td scope="col">Cognome</th>
			
			<a class="btn btn-success btn-sm" role="button"><i class="bi bi-person-check-fill"></i></a>
			<a class="btn btn-danger btn-sm" role="button"><i class="bi bi-person-x-fill"></i></a></tbody>
			</tr>
			</tbody>
		
	</table>
</div>



<%@ include file="footer.jsp"%>