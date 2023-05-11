package com.crud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "blog_tbl")
public class Blog implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int blogId;
    private String blogTitle;
    private String blogCreation;
    private int yearOfPost;

}
