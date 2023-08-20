package com.quizza.api.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="categories")
public class Categories {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
         @JsonIgnore

        private int id;

        private String name;



        @JsonIgnore
        @ManyToMany(mappedBy = "categories")
        private List<Question> questions;

}
