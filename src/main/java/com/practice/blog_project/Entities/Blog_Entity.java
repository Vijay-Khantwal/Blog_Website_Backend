package com.practice.blog_project.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "blog_db")
public class Blog_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer user_id;

    @Size(min=3,message = "Title too Short")
    @Size(max= 100 , message = "Title too Big")
    private String title;

    @Size(max = 2000,message = "Size limit exceeded")
    private String content;

    private LocalDateTime dateTime;
}
