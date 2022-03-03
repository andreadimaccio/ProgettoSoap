<%@page import="java.time.LocalDate"%>
<%@page import="model.Categorie"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>



<h1 class="text-center" style="margin-top: 100px;">Nuovo SOAP-it</h1>
<div class="container" style="width: 300px; margin-top: 20px;">
	<form action="/GestioneSoap" method="POST">
		<div class="mb-3">
			<label class="form-label">Titolo</label> <input type="text"
				class="form-control" name="titolo_post" id="titolo_postit"
				required="required">
		</div>
		<div class="mb-3">
			<label for="categoria" class="form-label">Categoria</label> 
			<select class="form-select" name="categoria" id="categoria" required="required">

					<option selected class="bianco" value="bianco">Nessuna categoria</option>
	    			<option class="rosso" value= "rosso">Lavoro</option>
	   				<option class="rosa" value= "rosa">Relazione</option>
	   				<option class="azzurro" value= "azzurro">Salute</option>
	   				<option class="arancione" value="arancione">Sport</option>
			<option class="verde" value="verde">Svago</option>
	   				<option class="giallo" value="giallo">Varie</option>
	   				
   				</select>
		</div>
		
		<div class="mb-3"> <label class="form-label">Note</label> <input type="text"
				class="form-control" name="testo_postit" id="testo_postit"
				required="required">
		</div>
		
		
		<div><label for="data_promemoria">Inserisci una data:</label>
		<input type="date" id="data_promemoria" name="data_promemoria" min="<%= LocalDate.now() %>">
	 </div>
	 
	
	 
	 
	 
		
<!--  		<div class="mb-3">
			<label class="form-label">Giorno</label> <input type="number"
				class="form-control" name="giorno" id="giorno" required="required" >
		</div>
		<div class="mb-3">
			<label class="form-label">Mese</label> <input type="number"
				class="form-control" name="mese" id="mese" required="required">
		</div>
		<div class="mb-3">
			<label class="form-label">Anno</label> <input type="number"
				class="form-control" name="anno" id="anno" required="required">
		</div>
-->		

		<div class="mb-3 my-5">
			<button type="submit" class="btn btn-primary form-control">Crea nuovo SOAP-it</button>
		</div>




	</form>
</div>


<%@ include file="footer.jsp"%>
