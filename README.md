Blogging Website Backend

Welcome to the Blogging Website Backend repository! This project is built with Spring Boot and aims to provide the backend infrastructure for a blogging platform. Currently, the user model has been implemented along with its corresponding controller to handle user-related operations.

Project Overview
This backend project provides the foundation for a blogging platform, focusing on managing users. 

The current implementation includes:

User Model: Defines user attributes.
User Controller: Manages endpoints for user-related operations.

🔑 Key Features:

Developed endpoints for posting new blogs, fetching user profiles, and updating them with ease.
Implemented JWT token authentication to handle secure login and logout sessions.
Built-in pagination and sorting for effective data management, ensuring users can quickly navigate and sort through content.
Validated user inputs to ensure the integrity and security of user data.


User Model and Controller:-

User Model
The User entity includes:

Username: Unique identifier for the user.
Email: User's email address.
Password: Securely stored password.

User Controller
The UserController provides endpoints for:

Fetching all users : /user/fetchAll<br>
Deleting a user : /user/delete/{id}<br>
Updating a user : /user/update/{id}<br>
Adding a user : /user/add<br>

Blog Model and Controller:-

Blog Model includes properties like :-<br>
Id :- Unique id for Blog<br>
User_id :- Id of user who uploaded a particular Blog<br>
Title :- Title of the Blog<br>
Content :- Main content/description of the Blog<br>
DateTime :- Time of upload of Blog.<br>

Blog Controller

Get all blogs  : /blog/fetchAll<br>
Get Blog by Id  : /blog/{id}<br>
Get Blog by username : /blog/user/{id}<br>
Add Blog : /blog/addBlog<br>
Delete Blog by id : /blog/delete/{id}<br>
Update Blog :/blog/update/{id}<br>
Search Blog by title : /blog/searchTitle/{match}<br>
Search Blog by Description : /blog/searchDes/{match}<br>


💡 Spring Boot Annotations I Worked With:

@RestController: Defines a class as a controller where every method returns a domain object instead of a view, making it a REST API.<br>
@Autowired: Allows Spring to automatically resolve and inject dependencies where needed.<br>
@Configuration: Indicates that a class has @Bean definition methods and is a source of bean definitions.<br>
@Bean: Marks a method as a bean producer within a configuration class, managed by Spring's IoC container.<br>
@Component: Marks a class as a Spring-managed bean, making it discoverable during component scanning.<br>
@Service: Marks a class as a service, indicating that it holds business logic.<br>
@Repository: Identifies a class as a data access object (DAO), handling database operations.<br>
@Table: Used to specify the name of the database table that this entity maps to.<br>
@RequestMapping: Maps HTTP requests to handler methods of MVC and REST controllers.<br>
@GetMapping, @PostMapping, @PutMapping, @DeleteMapping: Simplifies the HTTP method mapping for GET, POST, PUT, and DELETE requests respectively.<br>
@PathVariable: Binds URI template variables to method parameters.<br>
@Required: Ensures that a particular bean property must be configured.<br>
@RequestParam: Extracts query parameters from the request URL.<br>
@RequestBody: Binds the body of a web request to a method parameter.<br>
