Blogging Website Backend

Welcome to the Blogging Website Backend repository! This project is built with Spring Boot and aims to provide the backend infrastructure for a blogging platform. Currently, the user model has been implemented along with its corresponding controller to handle user-related operations.

Project Overview
This backend project provides the foundation for a blogging platform, focusing on managing users. 

The current implementation includes:

User Model: Defines user attributes.
User Controller: Manages endpoints for user-related operations.

Features
User Registration: Allows new users to sign up.
User Authentication: Handles user login and secure authentication.
Profile Management: Users can view and update their profile information.



User Model and Controller:-

User Model
The User entity includes:

Username: Unique identifier for the user.
Email: User's email address.
Password: Securely stored password.

User Controller
The UserController provides endpoints for:

Fetching all users : /user/fetchAll
Deleting a user : /user/delete/{id}
Updating a user : /user/update/{id}
Adding a user : /user/add