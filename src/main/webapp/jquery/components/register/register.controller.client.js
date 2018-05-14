(function () {
    var $registerBtn;
    var userService = new UserServiceClient();
    $(main);

    function main() {
    	var $username = $('#usernameFld');
        var $password = $('#passwordFld');
        var $verifypassword = $('#verifypasswordFld');
        var $firstname = $('#firstNameFld');
        var $lastname = $('#lastNameFld');
        var $role = $('#roleFld');

        var userdata = {
        		username: $username,
        		password: $password,
        		verifypassword: $verifypassword,
        		firstname: $firstname,
        		lastname: $lastname,
        		role: $role
        }
    	
        $registerBtn = $("#registerBtn")
        				.click(userdata, register);

    }
    
    function register(event) {
    	
		username = event.data.username.val();
		password = event.data.password.val();
		verifypassword = event.data.verifypassword.val();
		firstname = event.data.firstname.val();
		lastname = event.data.lastname.val();
		role = event.data.role.val();
		
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
					.then(success);   		
    		
    	}
    	else{
    		alert("Password field do not match!")
    	}
    	
    }
    
    function success(response) {
        if(response === null) {
            alert('unable to register/username exists')
        } else {
            alert('success');
        }
    }
    
    
})();
