package com.example.Clee.Service;

import com.example.Clee.Entity.Book;

import java.util.List;

/**
 * File: BookService.java
 * Author: Lochana Tennakoon
 * Created on: January 04, 2024.
 * Description: Service interface for Book-related operations.
 */
public interface BookService {


    List<Book> getAllBooks();
    Book  getBookById(Long id);
    Book saveBook(Book book);
    void deleteBook(Long id);




}
