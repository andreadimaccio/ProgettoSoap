<%@page import="java.time.LocalDate"%>
<%@page import="model.Categorie"%>
<%@page import="java.util.ArrayList"%>

<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>

<h1 class="text-center" style="margin-top: 100px;">Nuovo SOAP-it</h1>
<div class="container" style="width: 300px; margin-top: 20px;">
	<form action="dispatchersoap?action=aggiungisoap" method="Post">
		<div class="mb-3">
			<label class="form-label">Titolo</label> <input type="text"
				class="form-control" name="titolo_postit" id="titolo_postit"
				required="required">
		</div>
		<div class="mb-3">
			<label for="categoria" class="form-label">Categoria</label> <select
				class="form-select" name="categoria_postit" id="categoria"
				required="required">	
				<option selected class="bianco" value="7">Nessuna
				categoria</option>
				<option class="rosso" value="1">Lavoro</option>
				<option class="rosa" value="2">Relazione</option>
				<option class="azzurro" value="3">Salute</option>
				<option class="verde" value="5">Svago</option>
				<option class="giallo" value="6">Varie</option>
				<option class="arancione" value="4">Sport</option>						
			</select>
		</div>
		<div class="mb-3"> <label class="form-label">Testo Soap-it</label> 
			<textarea class="form-control" name="testo_postit" id="testo_postit" required="required" rows="3"></textarea>
		</div>		
		<div><label for="datemin">Inserisci data promemoria:</label>
		<input type="date" id="datemin" name="data" min="<%= LocalDate.now() %>">
	 </div>		
		<div class="mb-3 my-5">
			<button type="submit" class="btn btn-primary form-control">Crea nuovo SOAP-it</button>
		</div>
	</form>
</div>

<%@ include file="footerinterno.jsp"%>
<%@ include file="footer.jsp"%>
