(function () {
	
	
    var $loginBtn;
    var userService = new UserServiceClient();
    
    $(main);
    
    function main() {
    	
    	var $username = $('#usernameFld');
        var $password = $('#passwordFld');

        var userdata = {
            username: $username,
            password: $password
        };
    	
        $loginBtn = $("#loginBtn")
                .click(userdata, login);
    }
    
    function login(event) {
    	
    	var username = event.data.username.val();
    	var password = event.data.password.val();
        
    	userService
    		.login(username, password)
    		.then();
    }
})();
