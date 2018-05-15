function UserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.updateProfile = updateProfile;
    this.register = register;
    this.login = login;
    this.findUserIdByUsername = findUserIdByUsername;
//    this.url = 'http://localhost:8085/api/user';
//    this.signin = 'http://localhost:8085/api/signin';
//    this.reg = 'http://localhost:8085/api/reg';
//    this.profile = 'http://localhost:8085/api/profile';
    var self = this;	
    this.url = 'https://fathomless-brook-39975.herokuapp.com/api/user';
    this.signin = 'https://fathomless-brook-39975.herokuapp.com/api/signin';
    this.reg = 'https://fathomless-brook-39975.herokuapp.com/api/reg';
    this.profile = 'https://fathomless-brook-39975.herokuapp.com/api/profile';
    

    function createUser(user) {
        return fetch(self.url, {
            method: 'post',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        });
    }
    
    
    function deleteUser(userId) {
        return fetch(self.url + '/' + userId, {
            method: 'delete'
        })
    }
    
    
    function updateUser(userId, user) {
        return fetch(self.url + '/' + userId, {
            method: 'put',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        })
         .then(function(response){
        	 return response;
         });
    }
    
    
    function findUserById(userId) {
        return fetch(self.url + '/' + userId)
            .then(function(response){
                return response.json();
            });
    }
    
    
    function findAllUsers() {
        return fetch(self.url)
            .then(function (response) {
                return response.json();
            });
    }
    
    
    function findUserIdByUsername(uname){
    	return fetch(self.profile + '/' + uname)
        .then(function(response){
            return response.json();
        });
    }
    
    
    function login(username,password) {
        return fetch(self.signin, {
            method: 'post',
            body: JSON.stringify({username:username, password: password}),
            headers: {
                'content-type': 'application/json'
            }
        })
        .then(function (response) {
            return response;
        });
    }
    
    
    function register(user){
    	 return fetch(self.reg, {
             method: 'post',
             body: JSON.stringify(user),
             headers: {
                 'content-type': 'application/json'
             }
         })
         .then(function(response){
        	 return response;
         });
    }	 
    
    
    function updateProfile(user){
    	return fetch(self.profile, {
            method: 'put',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        })
        .then(function(response){
            return response;
        });
    }
    
}