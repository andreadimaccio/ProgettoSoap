<%@ include file="header.jsp"%>
<%@ include file="infonav.jsp"%>

<h1 class="text-center" style="margin-top: 100px;">Registrazione</h1>
<div class="container" style="width: 500px; margin-top: 20px;">
	<form class="px-4 py-3"
		action="dispatchergenerale?action=registrazione" method="post">
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
				class="form-control" name="password_utente" id="password"
				placeholder="">
		</div>
		<div class="mb-3">
			<label for="telefono_utente">Enter a telephone number (in the form xxxxxxxxxx): </label>
		    <input  class="form-control" id="telefono_utente" name="telefono_utente" type="tel" required pattern="[0-9]{10}" minlength="10" maxlength="10">
		    <span class="validity"></span>
		</div>
			<button type="submit" class="btn btn-warning" style="background-color: #FDA65D;" >
			Registrati</button>
	</form>

</div>


<%@ include file="infofooter.jsp"%>
<%@ include file="footer.jsp"%>
