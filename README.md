# Course-Management-System-Spring-Boot

This is a course management application for students and instructors. This version of the application is based on Spring Boot. The current release has the features of login, register, profile update, password-reset and user-admin.

- user-admin allows the admin to register/add a user (student/faculty) to the database.
- register/sign-up allows the users to add themselves to the database.
- login allows the user to access his/her profile.
- profile allows the user to update his/her email/date of birth/phone.
- password-reset allows the user to reset his/her password using the username.

The application is also deployed on Heroku and the links to access the application are - 

Landing page for the application - 
https://fathomless-brook-39975.herokuapp.com

Register - 
https://fathomless-brook-39975.herokuapp.com/jquery/components/register/register.template.client.html

Login - 
https://fathomless-brook-39975.herokuapp.com/jquery/components/login/login.template.client.html

User-admin - 
https://fathomless-brook-39975.herokuapp.com/jquery/components/user-admin/user-admin.template.client.html

The profile page can be accessed by logging in the application(using Login page). 

Forgot-password? -
https://fathomless-brook-39975.herokuapp.com/jquery/components/password-reset/password-reset.template.client.html

Password reset prompts the user to enter his existing username and then set new password and verify the new password as well.

The Faculty features of creating and deleting courses, modules, lessons and topics have been implemented. The client side of which can be found in the react repository by the name - Course Management System React.

The faculty is now provided with widget creation and deletion options. The widget can be of different types and can also be previewed and rearranged.

The link for Client side repository is - 

https://github.com/shukla-ayush/Course-Management-System-React

The faculty is now provided with Exam and Assignment creation features. The JPA inheritance has been followed to create Questions. In order to maintain previous code, all the new changes have been done only in an external branch - "exam-assignments-widgets". The current repository is for server side. There are services for all different type of questions and model representing those questions as well in the code.

The link to the react native client side repository is - 

https://github.com/shukla-ayush/Course-Management-System-ReactNative
