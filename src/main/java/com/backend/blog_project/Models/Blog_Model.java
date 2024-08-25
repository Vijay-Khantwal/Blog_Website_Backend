package com.backend.blog_project.Models;


import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog_Model {
    private Integer id;
    private Integer user_id;

    @Size(min=3,message = "Title too Short")
    @Size(max= 100 , message = "Title too Big")
    private String title;

    @Size(max = 2000,message = "Size limit exceeded")
    private String content;

    private LocalDateTime dateTime;
}
