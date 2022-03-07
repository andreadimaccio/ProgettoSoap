<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.Query"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Postit"%>
<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>

<%
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Soap");

	EntityManager em = emf.createEntityManager();
	String PostitDaModificare = request.getParameter("edit");
	Query q = em.createQuery("SELECT p FROM Postit p WHERE p.idPostit = :param");
	q.setParameter("param", Integer.parseInt(request.getParameter("edit")));
	Postit soap = (Postit) q.getSingleResult();
%>

<div class="container" style="width: 300px; margin-top: 20px;">
	<form
		action="dispatchereditremove?editpostit=<%=PostitDaModificare%>"
		method="POST">
		<div class="mb-3">
			<label for="nome" class="form-label">Inserire nuovo titolo per
				il SOAP-it</label> <input type="text" name="titolo_postit"
				class="form-control" id="titolo_postit" value = "<%= soap.getTitoloPostit() %>">
		</div>
		<div class="mb-3">
			<label for="categoria" class="form-label">Categoria</label> <select
				class="form-select" name="categoria" id="categoria"
				required="required">

				<option selected class="bianco" value="7">Nessunacategoria</option>
				<option class="rosso" value="1">Lavoro</option>
				<option class="rosa" value="2">Relazione</option>
				<option class="azzurro" value="3">Salute</option>
				<option class="verde" value="5">Svago</option>
				<option class="giallo" value="6">Varie</option>
				<option class="arancione" value="4">Sport</option>

			</select>
		</div>
		<div class="mb-3">
			<label for="note" class="form-label">Note</label> 
			<textarea class="form-control" name="testo_postit" id="testo_postit" rows="3"></textarea>

		</div>
		<div class="mb-3">
			<label for="data_promemoria">Inserisci una data :</label> <input
				type="date" id="data_promemoria" name="data_promemoria"
				min="<%=LocalDate.now()%>" value = " <%= soap.getDataPromemoria()%>">
		</div>


		<div class="mb-3">
			<button type="submit" class="btn btn-primary form-control">Modifica
				Soap-it</button>
		</div>

	</form>
</div>

<%@ include file="footer.jsp"%>
