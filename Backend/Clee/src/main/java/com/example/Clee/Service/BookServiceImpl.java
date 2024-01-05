package com.example.Clee.Service;

import com.example.Clee.Entity.Book;
import com.example.Clee.Repository.BookRepository;
import com.example.Clee.exception.BookNotFoundException;
import com.example.Clee.exception.BookSaveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * File: BookServiceImpl.java
 * Author: Lochana Tennakoon
 * Created on: January 4, 2024.
 * Description: Implementation of the BookService interface.
 */

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll(Sort.by(Sort.Order.asc("id")));
        return books;
    }

    @Override
    public Book getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()){
            return optionalBook.get();
        }
        else {
            throw new BookNotFoundException("Book not found with ID: "+ id);
        }

    }

    @Override
    public Book saveBook(Book book) {
        try {
            Book saveBook = bookRepository.save(book);
            return saveBook;
        }
        catch (BookSaveException e){
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public void deleteBook(Long id) {
        try{
            bookRepository.deleteById(id);

        }catch (Exception e){
            throw new RuntimeException("Book not found with ID: " +id, e);

        }
    }
}
