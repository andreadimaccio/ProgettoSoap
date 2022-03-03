<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>

<div class="container my-3">
	<h1>Nuova Categoria</h1>
	<form action="/GestioneCategorie" method="POST">
		<div class="mb-3">
			<label for="categoria" class="form-label">Nome Categoria</label> <br>
			<input type="text" name="nome_categoria" id="categoria"
				required="required">
		</div>
		<div class="mb-3">
			<label for="colore_categoria" class="form-label">Seleziona il
				colore</label>

			<div class="mb-3">
				<input type="color" style="width: 120px;" name="colore_categoria"
					id="colore_categoria">
			</div>
		</div>


		<div class="mb-3">
			<button type="submit" class="btn btn-primary form-control">Crea
				categoria</button>
		</div>

	</form>
</div>

<%@ include file="footer.jsp"%>