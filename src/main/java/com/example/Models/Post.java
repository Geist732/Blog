package com.example.Models;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Nick on 1/5/17.
 */
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotBlank(message = "Posts must have a title.")
    @Size(min = 3, message = "A title must be at least 3 characters long.")
    private String title;

    @Column(nullable = false)
    @NotBlank(message = "Posts must have a description.")
    private String description;


    public Post(int id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Post(){}

    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


}
