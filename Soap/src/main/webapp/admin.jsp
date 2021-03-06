<%@ include file = "header.jsp"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "model.Utenti" %>
<%@ include file ="navbarAdmin.jsp" %>

<% ArrayList<Utenti> listaNuoviUtenti = (ArrayList<Utenti>) request.getAttribute("nuoviutenti"); %>
<div class="container my-3">
	<h1>Utenti da approvare</h1>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th scope="col">Nome utente</th>
				<th scope="col">Cognome utente</th>
				<th scope="col"></th>
			</tr>
			</thead>						
			<%for(Utenti u : listaNuoviUtenti){ %>					
			  <td scope="col"><%= u.getNomeUtente() %></th>
			 <td scope="col"><%= u.getCognomeUtente() %></th>
			 <td>
			<a class="btn btn-success btn-sm" role="button" href="DispatcherInfo?aggiungi=<%=u.getIdUtente()%>"><i class="bi bi-person-check-fill"></i></a>
			<a class="btn btn-danger btn-sm" role="button" href="DispatcherInfo?rifiuta=<%=u.getIdUtente()%>"><i class="bi bi-person-x-fill"></i></a>
			</tbody>
			</td> 
			</tr>
			<%}%>		
			<tbody>																	
			<a class="nav-link" href="dispatcherutente?action=logout">Logout</a></li>	   						
		</tbody>
	</table>
</div>

<%@ include file ="footerAdmin.jsp"%>
<%@ include file="footer.jsp"%>
