function login() {
	console.log("Login is calling");
	
	let userLogin = document.getElementById('user_id').value;
	
	let passLogin = document.getElementById('pass_id').value;
	
	let loginObj = {
		username: userLogin,
		password: passLogin
	};
	
	console.log(`User: ${loginObj}`);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			console.log("Success Logging...");
			
			sessionStorage.setItem('currentUser', this.responseText);
			
			let userSt = sessionStorage.getItem('currentUser');
			
			console.log(userSt);
			
			let currentUser = JSON.parse(userSt);

			let role = currentUser.role;
			
			if (role === 2) {
				window.location = 'http://localhost:8080/reimbursement/manager.html';
			} else {
				window.location = 'http://localhost:8080/reimbursement/company.html';
			}
			
		
		}
		
		if (this.readyState === 4 && this.status === 204) {
			console.log("Not user found...");
	
			let warnLogin = document.createElement('h2');
			warnLogin.innerHTML = "User not found, try again";
			document.body.appendChild(warnLogin);
			
		}
		
		console.log("End of readyonstatechange function.")
	}
	console.log("Redirecciona a login servlet...");
	
	// Redirecciona a login servlet
	xhr.open("POST", 'http://localhost:8080/reimbursement/login');
	
	// Envia en formato json
	xhr.send(JSON.stringify(loginObj));
	
}