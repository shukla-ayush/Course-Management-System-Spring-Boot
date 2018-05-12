(function() {
    $(init);

    var $username
    var $email;
    var $phone;
    var $dob;
    var $updateBtn;
    var userService = new UserServiceClient();

    function init() {
    	$username = $("#username");
        $email = $("#email");
        $phone = $("#phone");
        $dob = $("#dob");
        
        $updateBtn = $("#updateBtn")
            .click(updateUser);

        findUserById(2);
    }

    function updateUser() {
        var user = {
            phone = $phone.val();
            email = $email.val();
        	dob = $dob.val();
        };

        userService
            .updateUser(12, user)
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