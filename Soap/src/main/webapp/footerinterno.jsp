<div class="vw-100" style="backgroud-color: #FFD384;">

	<script type="text/javascript">
		let mybutton = document.getElementById("btn-back-to-top");

		window.onscroll = function() {
			scrollFunction();
		};

		function scrollFunction() {
			if (document.body.scrollTop > 20
					|| document.documentElement.scrollTop > 20) {
				mybutton.style.display = "block";
			} else {
				mybutton.style.display = "none";
			}
		}

		mybutton.addEventListener("click", backToTop);

		function backToTop() {
			document.body.scrollTop = 0;
			document.documentElement.scrollTop = 0;
		}
	</script>
	
	<button type="button" class="btn btn-danger btn-floating btn-lg"
		id="btn-back-to-top">
		<i class="fas fa-arrow-up"></i>
	</button>

	<footer class="py-3 my-4">
	

		<p class="text-center text-muted">© 2022 Soap-it_Company, Inc</p>







	</footer>





</div>