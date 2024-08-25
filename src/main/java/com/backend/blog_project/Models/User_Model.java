package com.backend.blog_project.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_db")
public class User_Model {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(unique = true)
    private String username;

    @NotBlank(message = "User can not have empty First name")
    @NotNull(message = "User must have First name")
    @Pattern(regexp = "[a-zA-Z]*", message = "Name can only have letters")
    private String firstName;

    @NotBlank(message = "User can not have empty Last name")
    @NotNull(message = "User must have Last name")
    @Pattern(regexp = "[a-zA-Z]*", message = "Name can only have letters")
    private String lastName;

    @Email(message = "Email address invalid")
    private String email;

    @NotNull
    private String password;

    private Integer numberOfBlogs = 0;

    @Pattern(regexp = "[0-9]*",message = "Phone number not valid")
    @Size(min = 10, max = 10)
    private String phone_number;

    private Date jwt_logOut_Time;

}
