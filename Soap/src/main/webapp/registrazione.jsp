<%@ include file="header.jsp"%>
<%@ include file="infonav.jsp"%>

<h1 class="text-center" style="margin-top: 100px;">Registrati</h1>
<div class="container" style="width: 500px; margin-top: 20px;">
	<form class="px-4 py-3" action="dispatchergenerale?action=registrazione" method="post" >
		<div class="mb-3">
			<label class="form-label">Nome</label> <input type="text"
				class="form-control" name="nome_utente" id="email" placeholder="">
		</div>
		<div class="mb-3">
			<label class="form-label">Cognome</label> <input type="text"
				class="form-control" name="cognome_utente" id="email" placeholder="">
		</div>
		<div class="mb-3">
			<label class="form-label">Email</label> <input type="email"
				class="form-control" name="email_utente" id="email" placeholder="">
		</div>
		<div class="mb-3">
			<label class="form-label">Password</label> <input type="password"
				class="form-control" name="password_utente" id="password" placeholder="">
		</div>
		<div class="mb-3 ">
			<button type="submit" class="btn btn-warning" style="background-color: #FDA65D;" >
			<a href="dispatchergenerale?action=login">Login</a></button>
		</div>
	</form>

</div>


<%@ include file="infofooter.jsp"%>
<%@ include file="footer.jsp"%>