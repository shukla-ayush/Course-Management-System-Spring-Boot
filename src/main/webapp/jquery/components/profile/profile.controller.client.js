(function() {

	 var $username;
	 var $email;
	 var $phone;
	 var $dob;
	 var $role;
	 var $updateBtn;
	 var userService = new UserServiceClient();
	 $(init);
    
    function init() {
    	
    	var link = window.location.href;
    	var uname = link.split("?")[1];
    	$username = $("#username");
    	$username.val(uname);
    	$email = $("#email");
        $phone = $("#phone");
        $dob = $("#dob");
        $role = $("#role");
        
        userService
        	.findUserIdByUsername(uname)
        	.then(findUserById)
        	.then(renderUser)
        			
        $updateBtn = $("#updateBtn")
            .click(updateProfile);

    }

    function updateProfile() {
    	
    	var username = $("#username").val();
    	var phone = $("#phone").val();
    	var email = $("#email").val();
    	var dob = $("#dob").val();
    	var role = $("#role").val();
    	
        var user = {
        	username: username,	
            phone: phone,
            email: email,
        	dob: dob,
        	role: role
        };

        userService
            .updateProfile(user)
            .then(function (response){
            	return response.json();
            }).then(success, error);
    }

    function success() {
        alert("Profile updated successfully.")
    }
    
    function error(){
    	alert("Unable to update profile.")
    }

    function findUserById(userId) {
        userService
            .findUserById(userId)
            .then(renderUser);
    }
    
    function renderUser(user) {
    	var $email = $("#email");
        var $phone = $("#phone");
        var $dob = $("#dob");
        var $role = $("#role");
    	$email.val(user.email);
        $phone.val(user.phone);
        $dob.val(user.dob);
        $role.val(user.role);
    }
    
})();