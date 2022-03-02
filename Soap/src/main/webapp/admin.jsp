
<%@ include file = "header.jsp"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "model.Utenti" %>
<% ArrayList<Utenti> listaNuoviUtenti = (ArrayList<Utenti>) request.getAttribute("nuoviutenti"); %>
<%@ include file="header.jsp"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Utenti"%>
<%ArrayList<Utenti> utentiDaInserire = (ArrayList<Utenti>) request.getAttribute("nuoviutenti"); %>

<div class="container my-3">
	<h1>Utenti da approvare</h1>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th scope="col">Nome utente</th>
				<th scope="col">Cognome utente</th>
			</tr>

			</thead>
			<%for(Utenti u : listaNuoviUtenti){ %>					
			  <td scope="col"><%= u.getNomeUtente() %></th>
			 <td scope="col"><%= u.getCognomeUtente() %></th> 
			
			<a class="btn btn-success btn-sm" role="button"><i class="bi bi-person-check-fill"></i></a>
			<a class="btn btn-danger btn-sm" role="button"><i class="bi bi-person-x-fill"></i></a></tbody>
			</tr>
		 <%}%>
			
			<tbody>			   
			</tbody>
		
		</thead>
		<tbody>
			<tr>
				<% for(Utenti u : utentiDaInserire){%>
				<td scope="col">Nome
				</th>
				<td scope="col">Cognome
				</th>

				<a class="btn btn-success btn-sm" role="button"><i
					class="bi bi-person-check-fill"></i></a>
				<a class="btn btn-danger btn-sm" role="button"><i
					class="bi bi-person-x-fill"></i></a>
		</tbody>
		</tr>
		<%}%>
		</tbody>


	</table>
</div>



<%@ include file="footer.jsp"%>