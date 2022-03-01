<%@ include file="header.jsp"%>
<%@ include file="infonav.jsp" %>

<h1 class="text-center" style="margin-top: 100px;">Registati</h1>
<div class="container" style="width: 500px; margin-top: 20px;">
	<form class="px-4 py-3">
		<div class="mb-3">
			<label class="form-label">Nome</label> <input type="text"
				class="form-control" id="email" placeholder="">
		</div>
		<div class="mb-3">
			<label class="form-label">Cognome</label> <input type="password"
				class="form-control" id="password" placeholder="">
		</div>
		<div class="mb-3">
			<label class="form-label">Email</label> <input type="password"
				class="form-control" id="password" placeholder="">
		</div>
		<div class="mb-3">
			<label class="form-label">Password</label> <input type="password"
				class="form-control" id="password" placeholder="">
		</div>
		<div class="mb-3 ">
			<button type="submit" class="btn btn-warning" style="background-color: #FDA65D;">Registrati</button>
		</div>
	</form>

</div>


<%@ include file="infofooter.jsp"%>
<%@ include file="footer.jsp"%>