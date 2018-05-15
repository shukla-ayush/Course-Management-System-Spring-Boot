(function () {
	
	var $username;
	var $password;
    var $loginBtn;
    var userService = new UserServiceClient();
    
    $(main);
    
    function main() {
    	
    	var $username = $('#usernameFld');
        var $password = $('#passwordFld');
    	
        $loginBtn = $("#loginBtn")
        		.click(login);
    }
    
    function login() {
    	
    	var username = $('#usernameFld').val();
    	var password = $('#passwordFld').val();
        
    	userService
    		.login(username, password)
    		.then(function (response){
    			return response.json();
    		})
    		.then(showProfile,error);
    }
   
    function error(){
    	alert("Invalid Credentials!");
    }
    
    function showProfile(response){
    	var userdata = response;
    	location.href = "http://localhost:8085/jquery/components/profile/profile.template.client.html?"+userdata.username;
    }
    
})();
