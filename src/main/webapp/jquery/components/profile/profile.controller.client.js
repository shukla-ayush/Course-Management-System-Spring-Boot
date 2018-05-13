(function() {

	 var $updateBtn;
	 var userService = new UserServiceClient();
	 $(init);
    
    function init() {
    	var $username = $("#username");
        var $email = $("#email");
        var $phone = $("#phone");
        var $dob = $("#dob");
        var $role = $("#role");
        
        var user = {
        	username: $username,
        	email: $email,
        	phone: $phone,
        	dob: $dob,
        	role: $role
        }
        
        $updateBtn = $("#updateBtn")
            .click(user, updateProfile);

        //findUserById(2);
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
            .then(success);
    }

    function success(response) {
        if(response === null) {
            alert('unable to update')
        } else {
            alert('success');
        }
    }

    function findUserById(userId) {
        userService
            .findUserById(userId)
            .then(renderUser);
    }
    
    function renderUser(user) {
    	$username.val(user.username);
    	$email.val(user.email);
        $phone.val(user.phone);
        $dob.val(user.dob);
    }
    
})();