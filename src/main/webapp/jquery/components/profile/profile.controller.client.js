(function() {

	 var $updateBtn;
	 var userService = new UserServiceClient();
	 $(init);
    
    function init() {
    	
    	var link = window.location.href;
    	var uname = link.split("?")[1];
    	console.log(uname);
    	var $username = $("#username");
    	$username.val(uname);
    	var $email = $("#email");
        var $phone = $("#phone");
        var $dob = $("#dob");
        var $role = $("#role");
    	
        
        userService
        	.findUserIdByUsername(uname)
        	.then(findUserById)
        	.then(renderUser)
        			
        $updateBtn = $("#updateBtn")
            .click(user, updateProfile);

    }

    function updateProfile(event) {
    	
    	username = event.data.username.val();
    	phone = event.data.phone.val();
    	email = event.data.email.val();
    	dob = event.data.dob.val();
    	role = event.data.role.val();
    	
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
        alert("Profile update successfully.")
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