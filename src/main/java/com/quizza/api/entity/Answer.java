package com.quizza.api.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "questionId", referencedColumnName = "id")
    private Question question;

    @Column(name = "is_correct")
    private Boolean isCorrect;

    private String content;

}
