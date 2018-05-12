(function() {
    $(init);

    var $username
    var $email;
    var $firstName;
    var $lastName;
    var $phone;
    var $password;
    var $dob;
    var $updateBtn;
    var userService = new UserServiceClient();

    function init() {
    	$username = $("#username");
        $email = $("#email");
        $firstName = $("#firstName");
        $lastName = $("#lastName");
        $phone = $("#phone");
        $password = $("password");
        $dob = $("#dob");
        
        $updateBtn = $("#updateBtn")
            .click(updateUser);

        findUserById(2);
    }

    function updateUser() {
        var user = {
            firstName: $firstName.val(),
            lastName: $lastName.val()
            phone = $phone.val();
        	password = $password.val();
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
        $firstName.val(user.firstName);
        $lastName.val(user.lasteName);
        $phone.val(user.phone);
        $password.val(user.password);
        $dob.val(user.dob);
    }
})();