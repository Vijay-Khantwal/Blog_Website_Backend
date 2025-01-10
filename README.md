# Blogging Website Backend

Welcome to the **Blogging Website Backend** repository! 🚀 This project is built with **Spring Boot** and aims to provide a robust backend infrastructure for a blogging platform. The current implementation includes comprehensive user and blog management functionalities with secure and efficient operations.

---

## **Project Overview** 📖

This backend project serves as the foundation for a blogging platform, focusing on the following aspects:

- **User Management**: Handle user-related operations such as registration, updates, and deletion. 👥
- **Blog Management**: Manage blogs with features like creation, deletion, and search. ✍️
- **Security**: Implements secure login/logout sessions using **JWT token authentication**. 🔒
- **Efficiency**: Built-in pagination and sorting for seamless data navigation. 📊
- **Validation**: Ensures data integrity and security by validating user inputs. ✅

---

## **Key Features** 🌟

| Feature                  | Description                                            |
| ------------------------ | ------------------------------------------------------ |
| **User Management**      | Endpoints to manage user profiles. 👤                  |
| **Blog Management**      | CRUD operations and search functionality for blogs. 📝 |
| **JWT Authentication**   | Secure login and logout sessions. 🔐                   |
| **Pagination & Sorting** | Enhances data accessibility and organization. 🗂️      |
| **Data Validation**      | Ensures data accuracy and security. 🔍                 |

---

## **User Model and Controller** 👤

### **User Model**

The **User** entity includes the following attributes:

| Attribute    | Description                     |
| ------------ | ------------------------------- |
| **Username** | Unique identifier for the user. |
| **Email**    | User's email address.           |
| **Password** | Securely stored password.       |

### **User Controller**

The **UserController** provides the following endpoints:

| Endpoint            | Description          |
| ------------------- | -------------------- |
| `/user/fetchAll`    | Fetch all users.     |
| `/user/delete/{id}` | Delete a user by ID. |
| `/user/update/{id}` | Update a user by ID. |
| `/user/add`         | Add a new user.      |

---

## **Blog Model and Controller** 📝

### **Blog Model**

The **Blog** entity includes the following attributes:

| Attribute    | Description                              |
| ------------ | ---------------------------------------- |
| **Id**       | Unique ID for the blog.                  |
| **User\_id** | ID of the user who created the blog.     |
| **Title**    | Title of the blog.                       |
| **Content**  | Main content or description of the blog. |
| **DateTime** | Time of upload for the blog.             |

### **Blog Controller**

The **BlogController** provides the following endpoints:

| Endpoint                    | Description                     |
| --------------------------- | ------------------------------- |
| `/blog/fetchAll`            | Get all blogs. 📚               |
| `/blog/{id}`                | Get a blog by ID. 🆔            |
| `/blog/user/{id}`           | Get blogs by user ID. 👤        |
| `/blog/addBlog`             | Add a new blog. ✍️              |
| `/blog/delete/{id}`         | Delete a blog by ID. 🗑️        |
| `/blog/update/{id}`         | Update a blog by ID. 🔄         |
| `/blog/searchTitle/{match}` | Search blogs by title. 🔍       |
| `/blog/searchDes/{match}`   | Search blogs by description. 🔎 |

---

## **Spring Boot Annotations** 🛠️

This project utilizes various Spring Boot annotations to ensure smooth functionality and maintainable code. Here are the key annotations:

| Annotation        | Description                                                   |
| ----------------- | ------------------------------------------------------------- |
| `@RestController` | Defines a class as a REST API controller.                     |
| `@Autowired`      | Injects dependencies automatically. 💉                        |
| `@Configuration`  | Indicates a class contains bean definitions. 🏗️              |
| `@Bean`           | Marks a method as a bean producer for the IoC container. 🫘   |
| `@Component`      | Registers a class as a Spring-managed bean. 🏷️               |
| `@Service`        | Indicates a service layer class containing business logic. ⚙️ |
| `@Repository`     | Identifies a DAO class for database operations. 🗃️           |
| `@Table`          | Specifies the database table for an entity. 📋                |
| `@RequestMapping` | Maps HTTP requests to handler methods. 📡                     |
| `@GetMapping`     | Maps GET requests to handler methods.                         |
| `@PostMapping`    | Maps POST requests to handler methods. ✉️                     |
| `@PutMapping`     | Maps PUT requests to handler methods. 🔧                      |
| `@DeleteMapping`  | Maps DELETE requests to handler methods. 🗑️                  |
| `@PathVariable`   | Binds URI template variables to method parameters.            |
| `@RequestParam`   | Extracts query parameters from the URL.                       |
| `@RequestBody`    | Binds the request body to a method parameter.                 |
| `@Required`       | Ensures a bean property is configured.                        |

---

## **Future Enhancements** 🚀

- Add comment functionality for blogs. 💬
- Implement user roles and permissions. 🛡️
- Enhance search capabilities with advanced filtering. 🔎



