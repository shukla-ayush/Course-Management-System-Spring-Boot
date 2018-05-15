function User(username, password, firstName, lastName, role, email, dob, phone) {
  this.username = username;
  this.password = password;
  this.firstName = firstName;
  this.lastName = lastName;
  this.role = role;
  this.phone = phone;
  this.dob = dob;
  this.email = email;

  this.setUsername = setUsername;
  this.getUsername = getUsername;
  this.setPassword = setPassword;
  this.getPassword = getPassword;
  this.setFirstName = setFirstName;
  this.getFirstName = getFirstName;
  this.setLastName = setLastName;
  this.getLastName = getLastName;
  this.setRole = setRole;
  this.getRole = getRole;
  this.setEmail = setEmail;
  this.getEmail = getEmail;
  this.setDob = setDob;
  this.getDob = getDob;
  this.setPhone = setPhone;
  this.getPhone = getPhone;
  
  function setUsername(username) {
    this.username = username;
  }
  function getUsername() {
    return this.username;
  }
  function setPassword(password) {
	this.password = password;
  }
  function getPassword() {
    return this.password;
  }
  function getFirstName(firstName) {
	this.firstName = firstName;
  }
  function getFirstName() {
	return this.firstName;
  }
  function setLastName(lastName) {
	this.lastName = lastName;
  }
  function getLastName() {
	return this.lastName;
  }
  function setRole(role) {
	this.role = role;
  }
  function getRole() {
	return this.role;
  }
  function setEmail(email) {
	this.email = email;
  }
  function getEmail() {
	return this.email;
  }
  function setDob(dob) {
	this.dob = dob;
  }
  function getDob() {
	return this.dob;
  }
  function setPhone(phone) {
	this.phone = phone;
  }
  function getPhone() {
	return this.phone;
  }   
}
