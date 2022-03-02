
<%@ include file = "header.jsp"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "model.Utenti" %>
<% ArrayList<Utenti> listaNuoviUtenti = (ArrayList<Utenti>) request.getAttribute("nuoviutenti"); %>
<<<<<<< HEAD
=======
<%@ include file="header.jsp"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Utenti"%>
<%ArrayList<Utenti> utentiDaInserire = (ArrayList<Utenti>) request.getAttribute("nuoviutenti"); %>

>>>>>>> cce3b7081cc0933bf43eec8653928388d017f356
<div class="container my-3">
	<h1>Utenti da approvare</h1>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th scope="col">Nome utente</th>
				<th scope="col">Cognome utente</th>
			</tr>
<<<<<<< HEAD
			</thead>						
=======

			</thead>
<<<<<<< HEAD
			<tbody>
=======
			<%for(Utenti u : listaNuoviUtenti){ %>					
			  <td scope="col"><%= u.getNomeUtente() %></th>
			 <td scope="col"><%= u.getCognomeUtente() %></th> 
>>>>>>> 117c5ec573d02c3b3f9055aa7ce8f3cfd0d8c03f
			
			
			<% for(Utenti u : utentiDaInserire){%>	
			<tr>						
			 	<td scope="col"><%= u.getNomeUtente() %></th>
				<td scope="col"><%= u.getCognomeUtente() %></th>
			<a class="btn btn-success btn-sm" role="button"><i class="bi bi-person-check-fill"></i></a>
			<a class="btn btn-danger btn-sm" role="button"><i class="bi bi-person-x-fill"></i></a></tbody>
			</tr>
		 <%}%>
			
			<tbody>			   
			</tbody>
		
		</thead>
>>>>>>> cce3b7081cc0933bf43eec8653928388d017f356
		<tbody>
			<tr>
				<% for(Utenti u : listaNuoviUtenti){%>				
				<td scope="col"><%= u.getNomeUtente() %></th>
				<td scope="col"><%= u.getCognomeUtente() %></th>				
				<a class="btn btn-success btn-sm" role="button"><i
					class="bi bi-person-check-fill"></i></a>
				<a class="btn btn-danger btn-sm" role="button"><i
					class="bi bi-person-x-fill"></i></a>
		</tbody>
		</tr>
		<%}%>
		</tbody>
<<<<<<< HEAD
=======


>>>>>>> cce3b7081cc0933bf43eec8653928388d017f356
	</table>
</div>



<%@ include file="footer.jsp"%>