package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


@SequenceGenerator(name = "quize-seq",sequenceName = "quize-seq",allocationSize = 1)
@Entity(name = "quize")
@Table(name = "quize")
public class Quize {
    @Id
    @GeneratedValue(generator = "quize-seq")
    private Long id;
    private String title;


    @ManyToMany
    private List<Question> questions;
}
