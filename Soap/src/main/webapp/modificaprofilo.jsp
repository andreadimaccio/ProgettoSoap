<%@ page import="java.util.ArrayList" %>
<%@ include file="header.jsp"%>
<%@ page import = "model.Utenti" %>
<% Utenti u = (Utenti)request.getSession().getAttribute("utenteLogin"); %>

<%@ include file="navbar.jsp" %>

<h1 class="text-center" style="margin-top: 100px;">Modifica dati</h1>
<div class="container" style="width: 500px; margin-top: 20px;">
	<form class="px-4 py-3" action="dispatcherutente?action=edit" method="POST">
		
		<div class="mb-3">
			<label class="form-label">Nome</label> 
			<input type="text" class="form-control" name="nome_utente" id="nome" required value="<%= u.getNomeUtente()%>">
		</div>
		
		<div class="mb-3">
			<label class="form-label">Cognome</label>
			<input type="text" class="form-control" name="cognome_utente" id="cognome" required value="<%= u.getCognomeUtente()%>">
		</div>
		
		<div class="mb-3">
			<label class="form-label">Email</label> 
			<input type="email" class="form-control" name="email_utente" id="email" required value="<%= u.getEmailUtente()%>">
		</div>
		
		<div class="mb-3">
			<label class="form-label">Password</label> 
			<input type="password" class="form-control" name="password_utente" id="password" required placeholder="Inserisci una password...">
		</div>
		
		<div class="mb-3">
			<label for="telNo">Numero di telefono (formato xxxxxxxxxx): </label>
		    <input  class="form-control" id="telNo" name="telefono_utente" type="tel" required pattern="[0-9]{10}" minlength="10" maxlength="10" value="<%= u.getTelefonoUtente() %>">
		    <span class="validity" style="display:inline"></span>
		</div>
		
		<div class="mb-3 ">
			<button type="submit" class="btn btn-warning" style="background-color: #FDA65D;" >Conferma modifiche</button>
		</div>
	</form>

</div>


<%@ include file="footerinterno.jsp"%>
<%@ include file="footer.jsp"%>
