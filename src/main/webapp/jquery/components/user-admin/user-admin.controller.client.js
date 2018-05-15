(function () {

    jQuery(main);

    var tbody;
    var template;
    var userService = new UserServiceClient()

    function main() {
        tbody = $('tbody');
        template = $('.template');
        $('#createUser').click(createUser);

        findAllUsers();
    }
    
    function findAllUsers() {
        userService
            .findAllUsers()
            .then(renderUsers);
    }

    function createUser() {
        console.log('createUser');

        var username = $('#usernameFld').val();
        var password = $('#passwordFld').val();
        var firstname = $('#firstNameFld').val();
        var lastname = $('#lastNameFld').val();
        var role = $('#role').val();

        var user = {
            username: username,
            password: password,
            firstname: firstname,
            lastname: lastname,
            role: role
        };

        userService
            .createUser(user)
            .then(findAllUsers);
    }

    function renderUsers(users) {
        tbody.empty();
        for(var i=0; i<users.length; i++) {
            var user = users[i];
            var clone = template.clone();

            clone.attr('id', user.id);

            clone.find('.delete').click(deleteUser);
            clone.find('.edit').click(editUser);

            clone.find('.username')
                .html(user.username);
            clone.find('.fname')
            	.html(user.firstname);
            clone.find('.lname')
            	.html(user.lastname);
            clone.find('.rolename')
            	.html(user.role);
            tbody.append(clone);
        }
    }

    function deleteUser(event){
        var deleteBtn = $(event.currentTarget);
        var userId = deleteBtn
            			.parent()
            			.parent()
            			.attr('id');

        userService
            .deleteUser(userId)
            .then(findAllUsers);
    }    

    function editUser(event){ 
    	var editBtn = $(event.currentTarget);
    	var userId = editBtn
    					.parent()
    					.parent()
    					.attr('id');
    	
    	userService
    		.findUserById(userId)
    		.then(renderUser);
    	
    	var user = userService
    				.findUserById(userId);
    	
    	$('#updateUser').click(userId, updateUser);
    }
    
    function updateUser(event){
    	
    	var username = $('#usernameFld').val();
        var password = $('#passwordFld').val();
        var firstname = $('#firstNameFld').val();
        var lastname = $('#lastNameFld').val();
        var role = $('#role').val();

        var user = {
            username: username,
            password: password,
            firstname: firstname,
            lastname: lastname,
            role: role
        };
    	
    	userService
    		.updateUser(event.data, user)
    		.then(function (response){
    			return response.json();
    		})
    		.then(findAllUsers, error);
    }
    
    function renderUser(user){
    	var $username = $('#usernameFld');
        var $password = $('#passwordFld');
        var $firstname = $('#firstNameFld');
        var $lastname = $('#lastNameFld');
        var $role = $('#role');
        $username.val(user.username);
        $password.val(user.password);
        $firstname.val(user.firstname);
        $lastname.val(user.lastname);
        $role.val(user.role);
    }
    
    function error(){
    	alert("Could not update user.");
    }


})();