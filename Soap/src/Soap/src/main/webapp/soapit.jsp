
<div class="card text-dark mb-3 soapit overflow-auto mx-4 my-2 g-col-3 ">
		<div class="card-header sticky-top bg-warning">
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
				<p role="button" data-bs-toggle="modal" data-bs-target="#modalsoapit<%= elemento.id %>" style ="display: inline">
					<%= elemento.titolo_postit %>
				</p>
			</div>		 
		</div>
		<div class="card-body bg-warning bg-opacity-50">
			<h5 class="card-title">
				<%= elemento.data %>
			</h5>
			<p class="card-text">
				<%= elemento.testo_postit %>
			</p>
		</div>
		
		<!-- Modal -->
		<div class="modal fade" id="modalsoapit<%= elemento.id %>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header bg-warning">
		        <h5 class="modal-title" id="exampleModalLabel">
					<%= elemento.titolo_postit %>
				</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body bg-warning bg-opacity-50">
		      	<h5 class="card-title">
					<%= elemento.data %>
				</h5>
		        <%= elemento.testo_postit %>
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