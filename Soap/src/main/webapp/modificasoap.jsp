<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Postit"%>
<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>

<% 

private Postit s 

%>


<form action="GestioneEditSoap?=<%= idPostit %>" method="POST">
	<div class="mb-3">
		<label for="nome" class="form-label">Inserire nuovo nome per
			il SOAP-it</label> <input type="text" name="nome" class="form-control"
			id="nome" value="<%= s.getTitoloPostit() %>">
	</div>
	<div class="mb-3">
		<label for="categoria" class="form-label">Categoria</label> <select
			class="form-select" name="categoria" id="categoria"
			required="required">

			<option selected class="bianco" value="bianco">Nessuna
				categoria</option>
			<option class="rosso" value="rosso">Lavoro</option>
			<option class="rosa" value="rosa">Relazione</option>
			<option class="azzurro" value="azzurro">Salute</option>
			<option class="arancione" value="arancione">Sport</option>
			<option class="verde" value="verde">Svago</option>
			<option class="giallo" value="giallo">Varie</option>

		</select>
	</div>
	<div class="mb-3">
		<label for="note" class="form-label">Note</label> <input type="text"
			name="testo_postit" class="form-control" id="testo_postit"
			value="<%= s.getTestoPostit() %>">

	</div>
	<div class="mb-3">
		<label for="data_promemoria">Inserisci una data :</label> <input
			type="date" id="data_promemoria" name="data_promemoria"
			min="<%= LocalDate.now() %>">
	</div>


	<div class="mb-3">
		<button type="submit" class="btn btn-primary form-control">Modifica
			Soap-it</button>
	</div>

</form>

<%@ include file="footer.jsp"%>
