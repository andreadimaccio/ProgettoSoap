<%@ include file="header.jsp"%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
	crossorigin="anonymous">

<div class="dropdown-menu">
  <form class="px-4 py-3">
    <div class="mb-3">
      <label for="exampleDropdownFormEmail1" class="form-label">Email</label>
      <input type="email" class="form-control" id="exampleDropdownFormEmail1" placeholder="email@example.com">
    </div>
    <div class="mb-3">
      <label for="exampleDropdownFormPassword1" class="form-label">Password</label>
      <input type="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="Password">
    </div>
    <div class="mb-3">
      <div class="form-check">
        <input type="checkbox" class="form-check-input" id="dropdownCheck">
        <label class="form-check-label" for="dropdownCheck">
          Rimani connesso
        </label>
      </div>
    </div>
    <button type="submit" class="btn btn-primary">Accedi</button>
  </form>
  <div class="dropdown-divider"></div>
  <a class="dropdown-item" href="#">Sei nuovo qui? Iscriviti</a>
  <a class="dropdown-item" href="#">Password dimenticata?</a>
</div>


<%@ include file="infofooter.jsp"%>
<%@ include file="footer.jsp"%>
