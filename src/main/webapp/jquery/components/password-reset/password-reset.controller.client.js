(function () {
	
	var $username;
	var $newpassword;
    var $verifypassword;
    var $passwordBtn;
    var userService = new UserServiceClient();
    $(init);
    
    function init() {
    	
    	$username = $('#usernameFld');
        $newpassword = $('#passwordFld');
        $verifypassword = $('#verifypasswordFld');
    	
        $passwordBtn = $("#passwordBtn")
        		.click(resetpassword);
    }
    
    function resetpassword() {
    	
    	var username = $('#usernameFld').val();
    	var newpassword = $('#passwordFld').val();
    	var verifypassword = $('#verifypasswordFld').val();
        
    	
    	if(newpassword === verifypassword){
    		userService
    		.findUserIdByUsername(username)
        	.then(function (response){
        		if(response === null){
        			alert("No such UserId.")
        		}
        		else{
        			findId(response, newpassword);
        		}
        	});
    	}
    	else{
    		alert("Passwords do not match.")
    	}
    	
    }
   
    function findId(response, newpassword){
    	userService
    		.findUserById(response)
    		.then(function (resp){
    			if(resp === null){
    				alert("No such User.")
    			}
    			else{
    				updatePassword(resp, response, newpassword);
    			}
    		})
    }
    
    function updatePassword(resp, userid, newpassword){
    	var user = {
    		username: resp.username,
    		password: newpassword,
    		firstname: resp.firstname,
    		lastname: resp.lastname,
    		phone: resp.phone,
    		email: resp.email,
    		role: resp.role,
    		dob: resp.dob
    	}
    	
    	userService
    		.updateUser(userid, user)
    		.then(function (response){
    			return response.json();
    		})
    		.then(success, error);
    	
    }
    
    function success(){
    	alert("Password updated successfully.")
    }
    
    function error(){
    	alert("Password not updated.");
    }
    
    
})();
