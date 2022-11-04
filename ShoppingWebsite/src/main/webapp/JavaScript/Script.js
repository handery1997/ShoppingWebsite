/**
 * Add check empty function to login form
 */
 document.querySelector("#login-btn").addEventListener("click", function(){
	let inputUsername= document.querySelector("#username").value;
	let inputPassword= document.querySelector("#password").value;
	
	if(inputUsername == "" || inputPassword==""){
		alert("Username or password is empty please fill the form!");
	}
}
);