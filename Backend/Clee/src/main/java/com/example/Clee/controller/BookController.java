package com.example.Clee.controller;

import com.example.Clee.Entity.Book;
import com.example.Clee.Service.BookService;
import com.example.Clee.exception.BookNotFoundException;
import com.example.Clee.exception.BookSaveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:8081/")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>>getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Book book = bookService.getBookById(id);

        if (book != null){
            return ResponseEntity.ok(book);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        try {
            Book savedBook = bookService.saveBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
        }catch (BookSaveException e){
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping
    public ResponseEntity<Void> deleteBook(@PathVariable Long  id){
        try{
            bookService.deleteBook(id);
            return ResponseEntity.noContent().build();
        }catch (BookNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }


}
