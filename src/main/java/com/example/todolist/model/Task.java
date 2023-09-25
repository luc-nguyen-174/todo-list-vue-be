package com.example.todolist.model;

import jakarta.persistence.*;

import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String title;

    private boolean isDone = false;
}
