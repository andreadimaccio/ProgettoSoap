

<%@ page import="java.util.ArrayList" %>
<%@ include file="header.jsp"%>

<%
	int id = Integer.parseInt(request.getParameter("edit"));
	ArrayList<User> lista = GestioneLogin.userlist == null ? GestioneLogin.DB.leggiUsers() : GestioneLogin.userlist;
	User editUser = null;
	for(User user : lista) {
		if(user.getId() == id) {
			editUser = user;
			break;
		}
	}
%>

<% if(editUser != null) { %>
<div class="container my-3">
	<h1>Modifica profilo</h1>
	<form action="gestionerubrica?edit=<%=editUser.getId() %>" method="POST">
		<div class="mb-3">
			<label for="name" class="form-label">Nome</label> <input type="text"
				name="nome_utente" class="form-control" id="name" value="<%= editUser.getName() %>">
		</div>
		<div class="mb-3">
			<label for="cognome" class="form-label">Cognome</label> <input
				type="text" name="cognome_utente" class="form-control" id="lastname" value="<%= editUser.getLastname() %>">
		</div>
		<div class="mb-3">
			<label for="email" class="form-label">Email</label> <input
				type="email" name="email_utente" class="form-control" id="email" value="<%= editUser.getEmail() %>">
		</div>
		<div class="mb-3">
			<label for="telefono" class="form-label">Telefono</label> <input
				type="tel" name="telefono_utente" class="form-control" id="telefono" value="<%= editUser.getEmail() %>">
		</div>
		<div class="mb-3">
			<label for="password" class="form-label">Password</label> <input
				type="password" name="password_utente" class="form-control" id="password" value="<%= editUser.getPhone() %>">
		</div>
		<div class="mb-3">
			<button type="submit" class="btn btn-primary form-control">Modifica</button>
		</div>
	</form>
</div>



<%@ include file="footer.jsp"%>