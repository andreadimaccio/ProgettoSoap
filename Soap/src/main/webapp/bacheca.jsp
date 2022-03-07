<%@page import="java.util.ArrayList"%>
<%@page import="model.Postit"%>
<%@ page import="java.util.Date"%>

<% ArrayList<Postit> lista = (ArrayList<Postit>) request.getSession().getAttribute("allPostit"); %>

<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>

<div class="container">
	
	<div class="container">
		<div class="grid gap-1 mt-3">
			<div class="row">
				<div class="col position-relative">
					<div class="border  w-75 position-absolute start-0">
						<form action="dispatcherricerca=cercatitolo" method="">
							<button type="submit" class="btn my-2 form-control text-center" style="background-color: #FDA65D;">Cerca per titolo</button>
						 	<input type="text" name="titolo_cercato" class="form-control" placeholder="Inserisci il titolo da cercare..." required="required"> 
						</form>
					</div>
				</div>
				
				<div class="col postition-relative">
					<a href="creasoap.jsp" class="btn position-absolute my-5 start-50 translate-middle" style="background-color: #FDA65D;"><h4>Nuovo Soap-it</h4></a>
				</div>
				
				<div class="col position-relative">
					<div class="border  w-75 position-absolute end-0">
						<form action="dispatcherricerca=cercadata" method="">
							<button type="submit" class="btn my-2 float-end form-control text-center" style="background-color: #FDA65D;">Cerca per data di inserimento</button>
							<input type="date" name="data_cercata" class="form-control" required="required"> 
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<br><br><br><br><br><br>
	
	<div class="container">
		<div class="grid">
			<div class="row row-cols-4">
				<% for (Postit elemento : lista) { %>
					<div class="card text-dark mb-3 soapit overflow-auto col">
						<div class="card-header sticky-top <%= elemento.getCategorie().getColoreCategoria() %>">
							<div class="titolo_cliccabile">
								<div class="btn-group">
									  <button type="button" class="btn btn-sm dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
									  	<span class="visually-hidden">Toggle Dropdown</span>
									  </button>
									  <ul class="dropdown-menu">
									  	<li><a href="dispatchereditremove?edit=<%= elemento.getIdPostit() %>" class="btn btn-success btn-sm mx-1" role="button"><i class="bi bi-pencil"></i> </a> Modifica </li>
									  	<li><a href="dispatchereditremove?remove=<%= elemento.getIdPostit()%>"class="btn btn-danger btn-sm mx-1" role="button"><i class="bi bi-trash"></i> </a> Elimina</li>
									  </ul>
								</div>
								<p role="button" data-bs-toggle="modal" data-bs-target="#modalsoapit<%= elemento.getIdPostit() %>" style ="display: inline">
									<%= elemento.getTitoloPostit() %>
								</p>
							</div>		 
						</div>
						<div class="card-body <%= elemento.getCategorie().getColoreCategoria() %>_chiaro" style="min-height: 260px;">
							<h5 class="card-title">
								<%=  elemento.getDataInserimento() %>
							</h5>
							<p class="card-text" >
								<%= elemento.getTestoPostit() %>
							</p>
						</div>
						
						<!-- Modal -->
						<div class="modal fade" id="modalsoapit<%= elemento.getIdPostit() %>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <div class="modal-header <%= elemento.getCategorie().getColoreCategoria() %> ">
						        <h5 class="modal-title" id="exampleModalLabel">
									<%= elemento.getTitoloPostit() %>
								</h5>
						        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						      </div>
						      <div class="modal-body <%= elemento.getCategorie().getColoreCategoria() %>_chiaro ">
						      	<h5 class="card-title">
									<%= elemento.getDataInserimento() %>
								</h5>
						        <%= elemento.getTestoPostit() %>
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Chiudi</button>
						        <a class="btn btn-warning d-block" href="dispatchereditremove?edit=<%= elemento.getIdPostit() %>" role="button">Modifica Soap-it</a>
						        <a class="btn btn-danger d-block" href="dispatchereditremove?remove=<%= elemento.getIdPostit()%>" role="button">Elimina Soap-it</a>
						      </div>
						    </div>
						  </div>
						</div>
					</div>
				<% } %>
			</div>
		</div>
	</div>
		
	
</div>
	
<%@ include file="footer.jsp"%>
