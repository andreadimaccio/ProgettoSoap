<%@page import="java.util.ArrayList"%>
<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>
<%@ page import = "model.Utenti" %>
<%@ page import = "model.Postit" %>
<% Utenti u = (Utenti)request.getSession().getAttribute("utenteLogin"); %>
<% ArrayList<Postit> lista = (ArrayList<Postit>) request.getAttribute("postitOggi"); %>

<div class="container my-3">
	<div class="d-grid gap-2 d-md-flex justify-content-md-end"></div>
	<thead>
		<ul class="list-group">
			<h2>
				<li class="list-group-item" aria-current="true"
					style="background-color: #FDA65D;">Il mio profilo</li>
			</h2>
			<label>Nome</label><li class="list-group-item"><%= u.getNomeUtente() %></li>
			<label>Cognome</label><li class="list-group-item"><%= u.getCognomeUtente() %></li>
			<label>Email</label><li class="list-group-item"><%= u.getEmailUtente() %></li>
			<label>Telefono</label><li class="list-group-item"><%= u.getTelefonoUtente() %></li>
		</ul>
		<div class="d-grid gap-2 d-md-flex justify-content-md-end ">
			<a href="dispatcherutente?action=edit"><button class="btn btn me-md-2 my-2" type="button"
				style="background-color: #FDA65D;">Modifica profilo</button></a>
		</div>
	</thead>
	<br> <br> <br> <br>
	<h2 class="list-group-item" aria-current="true"
		style="background-color: #FDA65D;">Soap-it del giorno</h2>
	
	<div class="container mt-5">
	
		<div class="grid ">
			
			<% for (Postit elemento : lista) { %>
				<div class="card text-dark mb-3 soapit overflow-auto mx-4 my-2 g-col-3 ">
					<div class="card-header sticky-top <%= elemento.getCategorie().getColoreCategoria() %>">
						<div class="titolo_cliccabile">
							<div class="btn-group">
								  <button type="button" class="btn btn-sm dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
								  	<span class="visually-hidden">Toggle Dropdown</span>
								  </button>
								  <ul class="dropdown-menu">
								  	<li><a href="dispatchersoap?edit<%= elemento.getIdPostit() %>" class="btn btn-success btn-sm mx-1" role="button"><i class="bi bi-pencil"></i> </a> Modifica </li>
								  	<li><a href="dispatcher?remove<%= elemento.getIdPostit()%>"class="btn btn-danger btn-sm mx-1" role="button"><i class="bi bi-trash"></i> </a> Elimina</li>
								  </ul>
							</div>
							<p role="button" data-bs-toggle="modal" data-bs-target="#modalsoapit<%= elemento.getIdPostit() %>" style ="display: inline">
								<%= elemento.getTitoloPostit() %>
							</p>
						</div>		 
					</div>
					<div class="card-body <%= elemento.getCategorie().getColoreCategoria() %> bg-opacity-50">
						<h5 class="card-title">
							<%=  elemento.getDataInserimento() %>
						</h5>
						<p class="card-text">
							<%= elemento.getTestoPostit() %>
						</p>
					</div>
					
					<!-- Modal -->
					<div class="modal fade" id="modalsoapit<%= elemento.getIdPostit() %>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog">
					    <div class="modal-content">
					      <div class="modal-header <%= elemento.getCategorie().getColoreCategoria() %>">
					        <h5 class="modal-title" id="exampleModalLabel">
								<%= elemento.getTitoloPostit() %>
							</h5>
					        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					      </div>
					      <div class="modal-body <%= elemento.getCategorie().getColoreCategoria() %> bg-opacity-50">
					      	<h5 class="card-title">
								<%= elemento.getDataInserimento() %>
							</h5>
					        <%= elemento.getTestoPostit() %>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Chiudi</button>
					        <a class="btn btn-warning d-block" href="dispatchersoap?edit<%= elemento.getIdPostit() %>" role="button">Modifica Soap-it</a>
					        <a class="btn btn-danger d-block" href="dispatcher?remove<%= elemento.getIdPostit()%> role="button">Elimina Soap-it</a>
					      </div>
					    </div>
					  </div>
					</div>
				</div>
			<% } %>
	
		</div>
		
	</div>
	
</div>
	
<%@ include file="footer.jsp"%>
	
	
	<div class=" text-center gap-2 mx-auto mb-5">
		<a href="dispatchersoap?action=aggiungisoap" class="btn" style="background-color: #FDA65D;">Nuovo Soap-it</a>
	</div>
	
	<div class="container mt-5">
	
		<div class="grid ">
			
			<% for (Postit elemento : lista) { %>
				<div class="card text-dark mb-3 soapit overflow-auto mx-4 my-2 g-col-3 ">
					<div class="card-header sticky-top <%= elemento.getCategorie() %>">
						<div class="titolo_cliccabile">
							<div class="btn-group">
								  <button type="button" class="btn btn-sm dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
								  	<span class="visually-hidden">Toggle Dropdown</span>
								  </button>
								  <ul class="dropdown-menu">
								  	<li><a class="btn btn-success btn-sm mx-1" role="button"><i class="bi bi-pencil"></i> </a> Modifica </li>
								  	<li><a class="btn btn-danger btn-sm mx-1" role="button"><i class="bi bi-trash"></i> </a> Elimina</li>
								  </ul>
							</div>
							<p role="button" data-bs-toggle="modal" data-bs-target="#modalsoapit<%= elemento.getIdPostit() %>" style ="display: inline">
								<%= elemento.getTitoloPostit() %>
							</p>
						</div>		 
					</div>
					<div class="card-body <%= elemento.getCategorie() %> bg-opacity-50">
						<h5 class="card-title">
							<%=  elemento.getDataInserimento() %>
						</h5>
						<p class="card-text">
							<%= elemento.getTestoPostit() %>
						</p>
					</div>
					
					<!-- Modal -->
					<div class="modal fade" id="modalsoapit<%= elemento.getIdPostit() %>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog">
					    <div class="modal-content">
					      <div class="modal-header <%= elemento.getCategorie() %>">
					        <h5 class="modal-title" id="exampleModalLabel">
								<%= elemento.getTitoloPostit() %>
							</h5>
					        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					      </div>
					      <div class="modal-body <%= elemento.getCategorie() %> bg-opacity-50">
					      	<h5 class="card-title">
								<%= elemento.getDataInserimento() %>
							</h5>
					        <%= elemento.getTestoPostit() %>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Chiudi</button>
					        <a class="btn btn-warning d-block" href="dispatcher?action=modifica" role="button">Modifica Soap-it</a>
					        <a class="btn btn-danger d-block" href="dispatcher?action=elimina" role="button">Elimina Soap-it</a>
					      </div>
					    </div>
					  </div>
					</div>
				</div>
			<% } %>
	
	<%@ include file="footer.jsp"%>
