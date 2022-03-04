<%@ page import="java.util.Date"%>
<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>

<% ArrayList<Postit> lista = (ArrayList<Postit>) request.getAttribute(lista?); %>

<div class=" text-center gap-2 col-6 mx-auto my-3">
	<a href="dispatchersoap?action=aggiungisoap"><button class="btn btn" type="button" style="background-color: #FDA65D;">Nuovo Soap-it</button></a>
	<button class="btn btn" type="button" style="background-color: #FDA65D;"  href="dispatchercategoria?action=aggiungicategoria">Nuova Categoria</button>
</div>


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
	
</div>
	
<%@ include file="footer.jsp"%>
