package com.example.Clee.Repository;

import com.example.Clee.Entity.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

//    List<Book> findAll(Sort sort);
}
