(function () {
	
	var $username;
	var $password;
	var $verifypassword;
	var $firstname;
	var $lastname;
	var $role;
    var $registerBtn;
    var userService = new UserServiceClient();
    $(main);

    function main() {
    	$username = $('#usernameFld');
        $password = $('#passwordFld');
        $verifypassword = $('#verifypasswordFld');
        $firstname = $('#firstNameFld');
        $lastname = $('#lastNameFld');
        $role = $('#roleFld');
    	
        $registerBtn = $("#registerBtn")
        				  .click(register);    				
    }
    
    
    function register(event) {
    	
		var username = $('#usernameFld').val();
		var password = $('#passwordFld').val();
		var verifypassword = $('#verifypasswordFld').val();
		var firstname = $('#firstNameFld').val();
		var lastname = $('#lastNameFld').val();
		var role = $('#roleFld').val();
		
    	if(password === verifypassword){
    		
    		var user = {
    			username: username,
    			password: password,
    			firstname: firstname,
    			lastname: lastname,
    			role: role
    		}
    		
    		userService
					.register(user)
					.then(function (response){
		    			return response.json();
		    		})
		    		.then(success, error);  
    	}
    	
    	else{
    		alert("Passwords do not match.")
    	}	
    }
    
    
    function error(){
    	alert("Registration unsuccessful/ Username exists");
    }
    
    
    function success() {
        alert("Registration successul");
    }
    
    
})();
