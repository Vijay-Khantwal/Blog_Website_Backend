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

Fetching all users : /user/fetchAll
Deleting a user : /user/delete/{id}
Updating a user : /user/update/{id}
Adding a user : /user/add

Blog Model and Controller:-

Blog Model includes properties like :-
Id :- Unique id for Blog
User_id :- Id of user who uploaded a particular Blog
Title :- Title of the Blog
Content :- Main content/description of the Blog
DateTime :- Time of upload of Blog.

Blog Controller

Get all blogs  : /blog/fetchAll
Get Blog by Id  : /blog/{id}
Get Blog by username : /blog/user/{id}
Add Blog : /blog/addBlog
Delete Blog by id : /blog/delete/{id}
Update Blog :/blog/update/{id}
Search Blog by title : /blog/searchTitle/{match}
Search Blog by Description : /blog/searchDes/{match}


💡 Spring Boot Annotations I Worked With:

@RestController: Defines a class as a controller where every method returns a domain object instead of a view, making it a REST API.
@Autowired: Allows Spring to automatically resolve and inject dependencies where needed.
@Configuration: Indicates that a class has @Bean definition methods and is a source of bean definitions.
@Bean: Marks a method as a bean producer within a configuration class, managed by Spring's IoC container.
@Component: Marks a class as a Spring-managed bean, making it discoverable during component scanning.
@Service: Marks a class as a service, indicating that it holds business logic.
@Repository: Identifies a class as a data access object (DAO), handling database operations.
@Table: Used to specify the name of the database table that this entity maps to.
@RequestMapping: Maps HTTP requests to handler methods of MVC and REST controllers.
@GetMapping, @PostMapping, @PutMapping, @DeleteMapping: Simplifies the HTTP method mapping for GET, POST, PUT, and DELETE requests respectively.
@PathVariable: Binds URI template variables to method parameters.
@Required: Ensures that a particular bean property must be configured.
@RequestParam: Extracts query parameters from the request URL.
@RequestBody: Binds the body of a web request to a method parameter.
