<%@ include file="header.jsp"%>
<%@ include file="infonav.jsp"%>


<h1 class="text-center" style="margin-top: 100px;">Login</h1>

	<div class="container" style="width: 500px; margin-top: 20px;">
		<form class="px-4 py-3" action="dispatchergenerale?action=login"
			method="post">
			<div class="mb-3">
				<label class="form-label">Email</label> <input type="email"
					class="form-control" name="email_utente" id="email" placeholder="">
			</div>
			<div class="mb-3">
				<label class="form-label">Password</label> <input type="password"
					class="form-control" name="password_utente" id="password"
					placeholder="">
			</div>
			<div class="mb-3 ">
				<button type="submit" class="btn btn-warning" style="background-color: #FDA65D;">Accedi</button>
				<a href="dispatchergenerale?action=registrazione" class="btn" style="background-color: #FDA65D;">Registrati</a>
			</div>
		</form>
	</div>


<%@ include file="infofooter.jsp"%>
<%@ include file="footer.jsp"%>
