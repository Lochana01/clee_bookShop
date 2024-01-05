package com.example.Clee.Entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * File: Book.Java
 * Author: Lochana Tennakoon
 * Created on: January 4 , 2024.
 * Description: Entity class representing a Book in library
 */

@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String image;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private boolean isAvailable = true;

    @Column(nullable = false)
    private Long stock;
}
